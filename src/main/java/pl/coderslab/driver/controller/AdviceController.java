package pl.coderslab.driver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.entity.Advice;
import pl.coderslab.driver.entity.File;
import pl.coderslab.driver.entity.Tag;
import pl.coderslab.driver.repository.AdviceRepository;
import pl.coderslab.driver.repository.FileRepository;
import pl.coderslab.driver.repository.TagRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/advice")
public class AdviceController {

    private final FileRepository fileRepository;
    private final AdviceRepository adviceRepository;
    private final TagRepository tagRepository;

    public AdviceController(FileRepository fileRepository, AdviceRepository adviceRepository, TagRepository tagRepository) {
        this.fileRepository = fileRepository;
        this.adviceRepository = adviceRepository;
        this.tagRepository = tagRepository;
    }


    @PostMapping("/add")
    @ResponseBody
    public String addAdvice(@RequestParam String title, @RequestParam Long fileId, @RequestParam String[] tags){
        Advice advice = new Advice();
        advice.setTitle(title);
        fileRepository.findById(fileId).ifPresent(advice::setFile);
        List<Tag> tagList = new ArrayList<>();
        for (String name : tags){
            Tag tag = tagRepository.findByName(name).orElse(new Tag(name));
            tagRepository.save(tag);
            tagList.add(tag);
        }
        advice.setTags(tagList);
        adviceRepository.save(advice);
        return advice.getTitle() + "    utworzono!!!";
    }

}
