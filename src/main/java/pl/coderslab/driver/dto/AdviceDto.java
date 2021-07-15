package pl.coderslab.driver.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AdviceDto {

    private Long id;
    private LocalDate created;
    private String title;
    private String text;
    private FileDto fileDto;
    private List<QuizDto> quizDtos;
    private List<TagDto> tagDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public FileDto getFileDto() {
        return fileDto;
    }

    public void setFileDto(FileDto fileDto) {
        this.fileDto = fileDto;
    }

    public List<QuizDto> getQuizDtos() {
        return quizDtos;
    }

    public void setQuizDtos(List<QuizDto> quizDtos) {
        this.quizDtos = quizDtos;
    }

    public List<TagDto> getTagDtos() {
        return tagDtos;
    }

    public void setTagDtos(List<TagDto> tagDtos) {
        this.tagDtos = tagDtos;
    }

    public Optional<FileDto> fileDtoOptional(){
        return Optional.ofNullable(fileDto);
    }
}
