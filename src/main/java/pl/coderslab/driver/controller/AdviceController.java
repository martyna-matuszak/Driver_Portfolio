package pl.coderslab.driver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.converter.AdviceConverter;
import pl.coderslab.driver.dto.AdviceDto;
import pl.coderslab.driver.dto.QuizDto;
import pl.coderslab.driver.entity.Advice;
import pl.coderslab.driver.repository.AdviceRepository;
import pl.coderslab.driver.service.AdviceService;

@RestController
@RequestMapping("/advice")
public class AdviceController {

    private final AdviceService adviceService;
    private final AdviceConverter adviceConverter;

    public AdviceController(AdviceService adviceService, AdviceConverter adviceConverter) {
        this.adviceService = adviceService;
        this.adviceConverter = adviceConverter;
    }

    @GetMapping("/{id}")
    public AdviceDto getAdvice(@PathVariable Long id) throws Exception{
        return adviceConverter.adviceToDto(adviceService.getAdvice(id));
    }

    @PostMapping("")
    public AdviceDto addAdvice(@RequestBody AdviceDto adviceDto){
        Advice advice = adviceService.save(adviceConverter.dtoToAdvice(adviceDto));
        return adviceConverter.adviceToDto(advice);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAdvice(@RequestBody AdviceDto adviceDto) throws Exception{
        Advice advice = adviceService.update(adviceConverter.dtoToAdvice(adviceDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAdvice(@PathVariable Long id) throws Exception {
        adviceService.deleteAdvice(id);
    }

}
