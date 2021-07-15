package pl.coderslab.driver.service;

import org.springframework.stereotype.Service;
import pl.coderslab.driver.entity.Advice;
import pl.coderslab.driver.repository.AdviceRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class AdviceService {

    private final AdviceRepository adviceRepository;
    private final TagService tagService;

    public AdviceService(AdviceRepository adviceRepository, TagService tagService) {
        this.adviceRepository = adviceRepository;
        this.tagService = tagService;
    }

    public Advice getAdvice(Long id) throws Exception{
        return adviceRepository.findById(id).orElseThrow(() -> new Exception("Advice with id: " + id + " - not found"));
    }

    public Advice save(Advice advice){
        advice.setTags(tagService.saveTags(advice.getTags()));
        advice.setCreated(LocalDate.now());
        advice.setId(null);
        return adviceRepository.save(advice);
    }

    public Advice update(Advice advice) throws Exception {
        Advice previousAdvice = getAdvice(advice.getId()); //to check if advice with this id exists before saving
        advice.setAdviceOfTheWeek(previousAdvice.getAdviceOfTheWeek());
        advice.setCreated(previousAdvice.getCreated());
        advice.setTags(tagService.saveTags(advice.getTags()));
        return adviceRepository.save(advice);
    }

    public void deleteAdvice(Long id) throws Exception{
        adviceRepository.delete(getAdvice(id));
    }

    public Advice adviceOfTheWeek(){
        Advice currentAdviceOfTheWeek = adviceRepository.findFirstByOrderByAdviceOfTheWeekDesc();
        LocalDateTime weekAgo = LocalDateTime.now().minusDays(7);
        if (currentAdviceOfTheWeek.getAdviceOfTheWeek() == null){
            currentAdviceOfTheWeek = getRandomAdvice();
        } else if(currentAdviceOfTheWeek.getAdviceOfTheWeek().isBefore(weekAgo)){
            currentAdviceOfTheWeek = adviceRepository.findFirstByOrderByAdviceOfTheWeekAsc();
        }
        currentAdviceOfTheWeek.setAdviceOfTheWeek(LocalDateTime.now());
        adviceRepository.save(currentAdviceOfTheWeek);
        return currentAdviceOfTheWeek;
    }

    public Advice getRandomAdvice(){
        List<Advice> adviceList = adviceRepository.findAll();
        int length = adviceList.size();
        Random r = new Random();
        int random = r.nextInt(length);
        return adviceList.get(random);
    }

//    public List<AdviceDto> advicesWithTags(String tagName) throws Exception {
//        Tag tag = tagRepository.findByName(tagName).orElseThrow(Exception::new);
//        List<Advice> adviceList = adviceRepository.findAll();
//        List<AdviceDto> adviceDtos = new ArrayList<>();
//        adviceList.forEach(advice -> {
//            if (advice.getTags().contains(tag)){
//                adviceDtos.add(convertToDto(advice));
//            }
//        });
//        return adviceDtos;
//    }

    //    public List<QuizDto> getQuizForAdvice(Long adviceId){
////        List<Quiz> quizzes = quizRepository.findAllByAdviceId(adviceId);
//        List<QuizDto> quizDtos = new ArrayList<>();
//        quizzes.forEach(quiz -> quizDtos.add(quizService.convertToDto(quiz)));
//        return quizDtos;
//    }
/*

    public List<Tag> getTags(String[] tags){
        List<Tag> tagList = new ArrayList<>();
        for (String name : tags){
            Tag tag = tagRepository.findByName(name).orElse(new Tag(name));
            tagRepository.save(tag);
            tagList.add(tag);
        }
        return tagList;
    }

*/
}
