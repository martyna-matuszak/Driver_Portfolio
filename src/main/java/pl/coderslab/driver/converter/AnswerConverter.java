package pl.coderslab.driver.converter;

import org.springframework.stereotype.Component;
import pl.coderslab.driver.dto.AnswerDto;
import pl.coderslab.driver.dto.FileDto;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.entity.File;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class AnswerConverter {

    private final FileConverter fileConverter;

    public AnswerConverter(FileConverter fileConverter) {
        this.fileConverter = fileConverter;
    }

    public AnswerDto answerToDto(Answer answer){
        AnswerDto answerDto = new AnswerDto();
        answerDto.setId(answer.getId());
        answerDto.setCorrect(answer.isCorrect());
        answerDto.setText(answer.getText());
        answer.fileOptional().ifPresent(file -> answerDto.setFileDto(fileConverter.fileToDto(file)));
        return answerDto;
    }

    public Answer dtoToAnswer(AnswerDto answerDto){
        Answer answer = new Answer();
        answer.setId(answerDto.getId());
        answer.setText(answerDto.getText());
        answer.setCorrect(answerDto.isCorrect());
        answerDto.fileDtoOptional().ifPresent(fileDto -> answer.setFile(fileConverter.dtoToFile(fileDto)));
        return answer;
    }
}
