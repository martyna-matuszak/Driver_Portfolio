package pl.coderslab.driver.controller;

import org.springframework.stereotype.Controller;

@Controller
public class NavigationController {
//
//    private final NavigationService navigationService;
//
//    public NavigationController(NavigationService navigationService) {
//        this.navigationService = navigationService;
//    }


//
//    @GetMapping("/advice/{id}/quiz")
//    public String quiz(@PathVariable Long id, Model model){
//        model.addAttribute("quizDtos", navigationService.getQuizForAdvice(id));
//        return "quizzes";
//    }
//
//    @GetMapping("/tag/{name}")
//    public String tag(@PathVariable String name, Model model) throws Exception {
//        model.addAttribute("adviceDtos", navigationService.advicesWithTags(name));
//        return "advices";
//    }

//    @GetMapping("/addAdmin")
//    @ResponseBody
//    public String addAdmin(){
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("admin");
//        user.setEmail("martyna.matuszak96@gmail.com");
//        return user.toString();
//    }

}

/*
package pl.coderslab.driver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.driver.converter.FileConverter;
import pl.coderslab.driver.dto.FileDto;
import pl.coderslab.driver.entity.File;
import pl.coderslab.driver.service.FileStorageService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileStorageService fileStorageService;
    private final FileConverter fileConverter;

    public FileController(FileStorageService fileStorageService, FileConverter fileConverter) {
        this.fileStorageService = fileStorageService;
        this.fileConverter = fileConverter;
    }

    @GetMapping("/{id}")
    public File getFile(@PathVariable Long id){
        return fileStorageService.getFile(id);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public List<String> uploadMultipleFiles(@RequestParam MultipartFile[] mpFiles){
//        List<File> files = new ArrayList<>();
        List<String> message = new ArrayList<>();
        for (MultipartFile mpFile : mpFiles){
            File temp = fileStorageService.storeFile(mpFile);
//            files.add(temp);
            message.add(temp.getFileName());
        }
//        return fileConverter.filesToDtos(files);
        return message;
    }

    //Edytowanie plików - czy konieczne? Raczej nie bardzo ma to sens chyba ;)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFile(@PathVariable Long id){
        fileStorageService.delete(id);
    }

}

 */
