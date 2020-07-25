package pl.coderslab.driver.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.repository.AnswerRepository;
import pl.coderslab.driver.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerRepository answerRepository;
    private final AnswerService answerService;

    public AnswerController(AnswerRepository answerRepository, AnswerService answerService) {
        this.answerRepository = answerRepository;
        this.answerService = answerService;
    }

    @GetMapping("/{id}")
    public String getAnswer(@PathVariable Long id) throws Exception {
        Answer answer = answerRepository.findById(id).orElseThrow(Exception::new);
        return answer.getText();
    }

    @PostMapping
    public String addAnswer(@RequestParam String text, @RequestParam Boolean correct, @RequestParam Long fileId){
        Answer answer = answerService.save(text,correct,fileId);
        return answer.toString();
    }

    @PutMapping("/{id}")
    public String updateAnswer(@PathVariable Long id,@RequestParam String text, @RequestParam Boolean correct, @RequestParam Long fileId) throws Exception {
        Answer answer = answerRepository.findById(id).orElseThrow(Exception::new);
        answer = answerService.update(answer,text,correct,fileId);
        return answer.toString();
    }

    @DeleteMapping("/{id}")
    public String deleteAnswer(@PathVariable Long id) throws Exception {
        Answer answer = answerRepository.findById(id).orElseThrow(Exception::new);
        answerRepository.delete(answer);
        return "Answer deleted";
    }
}
