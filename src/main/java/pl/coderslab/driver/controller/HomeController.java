package pl.coderslab.driver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.driver.converter.AdviceConverter;
import pl.coderslab.driver.dto.AdviceDto;
import pl.coderslab.driver.service.AdviceService;

@RestController
@RequestMapping("")
public class HomeController {

    private final AdviceService adviceService;
    private final AdviceConverter adviceConverter;

    public HomeController(AdviceService adviceService, AdviceConverter adviceConverter) {
        this.adviceService = adviceService;
        this.adviceConverter = adviceConverter;
    }

    @GetMapping("/")
    public AdviceDto homePage(){
        return adviceConverter.adviceToDto(adviceService.adviceOfTheWeek());
    }
}
