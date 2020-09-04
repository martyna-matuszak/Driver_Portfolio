package pl.coderslab.driver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.converter.QuizConverter;
import pl.coderslab.driver.dto.QuizDto;
import pl.coderslab.driver.entity.Quiz;
import pl.coderslab.driver.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private final QuizConverter quizConverter;

    public QuizController(QuizService quizService, QuizConverter quizConverter) {
        this.quizService = quizService;
        this.quizConverter = quizConverter;
    }

    @GetMapping("/{id}")
    public QuizDto getQuiz(@PathVariable Long id) throws Exception {
        return quizConverter.quizToDto(quizService.getQuiz(id));
    }

    @PostMapping("")
    public QuizDto addQuiz(@RequestBody QuizDto quizDto){
        Quiz quiz = quizService.save(quizConverter.dtoToQuiz(quizDto));
        return quizConverter.quizToDto(quiz);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateQuiz(@RequestBody QuizDto quizDto) {
        Quiz quiz = quizService.update(quizConverter.dtoToQuiz(quizDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteQuiz(@PathVariable Long id) throws Exception {
        quizService.deleteQuiz(id);
    }

}
