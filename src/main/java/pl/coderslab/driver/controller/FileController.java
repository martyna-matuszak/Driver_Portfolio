package pl.coderslab.driver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.driver.entity.File;
import pl.coderslab.driver.service.FileStorageService;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileStorageService fileStorageService;

    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/{id}")
    public File getFile(@PathVariable Long id){
        return fileStorageService.getFile(id);
    }

    @PostMapping
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        for (MultipartFile file : files){
            fileStorageService.storeFile(file);
        }
        return "Files added";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFile(@PathVariable Long id){
        fileStorageService.delete(id);
    }
}
