package pl.coderslab.driver.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.driver.service.FileStorageService;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileStorageService fileStorageService;

    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/uploadFiles")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        for (MultipartFile file : files){
            fileStorageService.storeFile(file);
        }
        return "File added";
    }
}
