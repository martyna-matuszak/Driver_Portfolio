package pl.coderslab.driver.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.entity.Quiz;
import pl.coderslab.driver.repository.QuizRepository;
import pl.coderslab.driver.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizRepository quizRepository;
    private final QuizService quizService;

    public QuizController(QuizRepository quizRepository, QuizService quizService) {
        this.quizRepository = quizRepository;
        this.quizService = quizService;
    }

    @GetMapping("/{id}")
    public String getQuiz(@PathVariable Long id) throws Exception {
        Quiz quiz = quizRepository.findById(id).orElseThrow(Exception::new);
        return quiz.toString();
    }

    @PostMapping("")
    public String addQuiz(@RequestParam String question, @RequestParam Long[] answersIds,
                          @RequestParam Long fileId, @RequestParam Long adviceId){
        Quiz quiz = quizService.createQuiz(new Quiz(),question,answersIds,fileId,adviceId);
        quiz = quizRepository.save(quiz);
        return "Added: \n" + quiz.toString();
    }

    @PutMapping("/{id}")
    public String updateQuiz(@PathVariable Long id, @RequestParam String question, @RequestParam Long[] answersIds,
                             @RequestParam Long fileId, @RequestParam Long adviceId) throws Exception {
        Quiz quiz = quizRepository.findById(id).orElseThrow(Exception::new);
        quiz = quizRepository.save(quizService.createQuiz(quiz,question,answersIds,fileId,adviceId));
        return "Updated: \n" + quiz.toString();
    }

    @DeleteMapping("/{id}")
    public String deleteQuiz(@PathVariable Long id) throws Exception {
        Quiz quiz = quizRepository.findById(id).orElseThrow(Exception::new);
        quizRepository.delete(quiz);
        return "Quiz deleted";
    }

}
