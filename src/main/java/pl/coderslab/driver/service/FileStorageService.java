package pl.coderslab.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.driver.entity.File;
import pl.coderslab.driver.exception.FileStorageException;
import pl.coderslab.driver.exception.MyFileNotFoundException;
import pl.coderslab.driver.repository.FileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileStorageService {

    @Autowired
    private FileRepository fileRepository;

    private final List<String> forbiddenCharacters = Arrays.asList("/", "<", ">", ":", "\"", "\\", "|", "?", "*", "..");

    public File storeFile(MultipartFile mpFile){
        String fileName = StringUtils.cleanPath(mpFile.getOriginalFilename());
        try{
            forbiddenCharacters.forEach(character -> {
                if (fileName.contains(character)){
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }
            });

            File file = new File(fileName, mpFile.getContentType(), mpFile.getBytes());
            return fileRepository.save(file);

        } catch (IOException exception) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", exception);
        }
    }

    public File getFile(Long fileId){
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }

    public List<File> getFiles(){
        return fileRepository.findAll();
    }

}

