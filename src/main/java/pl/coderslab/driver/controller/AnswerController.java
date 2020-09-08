package pl.coderslab.driver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.converter.AnswerConverter;
import pl.coderslab.driver.dto.AnswerDto;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerConverter answerConverter;

    public AnswerController(AnswerService answerService, AnswerConverter answerConverter) {
        this.answerService = answerService;
        this.answerConverter = answerConverter;
    }

    @GetMapping("/{id}")
    public AnswerDto getAnswer(@PathVariable Long id) throws Exception {
        return answerConverter.answerToDto(answerService.getAnswer(id));
    }

    @PostMapping
    public AnswerDto addAnswer(@RequestBody AnswerDto answerDto){
        Answer answer = answerService.save(answerConverter.dtoToAnswer(answerDto));
        return answerConverter.answerToDto(answer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAnswer(@RequestBody AnswerDto answerDto) throws Exception {
        answerService.update(answerConverter.dtoToAnswer(answerDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnswer(@PathVariable Long id) throws Exception {
        answerService.deleteAnswer(id);
    }
}
