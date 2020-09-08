package pl.coderslab.driver.service;

import org.springframework.stereotype.Service;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.repository.AnswerRepository;
import pl.coderslab.driver.repository.FileRepository;

@Service
public class AnswerService {

    private final FileRepository fileRepository;
    private final AnswerRepository answerRepository;

    public AnswerService(FileRepository fileRepository, AnswerRepository answerRepository) {
        this.fileRepository = fileRepository;
        this.answerRepository = answerRepository;
    }

    public Answer save(Answer answer){
        return answerRepository.save(answer);
    }

    public Answer update(Answer answer) throws Exception {
        getAnswer(answer.getId());
        return answerRepository.save(answer);
    }

    public Answer getAnswer(Long id) throws Exception {
        return answerRepository.findById(id).orElseThrow(() -> new Exception("Answer with id: "+ id + " - not found"));
    }

    public void deleteAnswer(Long id) throws Exception {
       answerRepository.delete(getAnswer(id));
    }
}
