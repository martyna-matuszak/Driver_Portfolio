package pl.coderslab.driver.converter;

import org.springframework.stereotype.Component;
import pl.coderslab.driver.dto.FileDto;
import pl.coderslab.driver.entity.File;
import pl.coderslab.driver.service.FileStorageService;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileConverter {

    private final FileStorageService fileStorageService;

    public FileConverter(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    public FileDto fileToDto(File file){
        FileDto fileDto = new FileDto();
        fileDto.setId(file.getId());
        fileDto.setUrl("/file/" + file.getId());
        fileDto.setFileName(file.getFileName());
        fileDto.setFileType(file.getFileType());
        return fileDto;
    }

    public File dtoToFile(FileDto fileDto){
        return fileStorageService.getFile(fileDto.getId());
    }

    public List<FileDto> filesToDtos(List<File> files){
        List<FileDto> fileDtos = new ArrayList<>();
        files.forEach(file -> fileDtos.add(fileToDto(file)));
        return fileDtos;
    }
}
