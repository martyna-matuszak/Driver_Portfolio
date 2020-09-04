package pl.coderslab.driver.dto;

import java.util.List;
import java.util.Optional;

public class QuizDto {

    private Long id;
    private String question;
    private FileDto fileDto;
    private List<AnswerDto> answerDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public FileDto getFileDto() {
        return fileDto;
    }

    public void setFileDto(FileDto fileDto) {
        this.fileDto = fileDto;
    }

    public Optional<FileDto> fileDtoOptional(){
        return Optional.ofNullable(fileDto);
    }

    public List<AnswerDto> getAnswerDtos() {
        return answerDtos;
    }

    public void setAnswerDtos(List<AnswerDto> answerDtos) {
        this.answerDtos = answerDtos;
    }
}
