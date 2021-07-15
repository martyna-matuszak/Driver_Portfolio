package pl.coderslab.driver.converter;

import org.springframework.stereotype.Component;
import pl.coderslab.driver.dto.AdviceDto;
import pl.coderslab.driver.entity.Advice;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdviceConverter {

    private final FileConverter fileConverter;
    private final QuizConverter quizConverter;
    private final TagConverter tagConverter;

    public AdviceConverter(FileConverter fileConverter, QuizConverter quizConverter, TagConverter tagConverter) {
        this.fileConverter = fileConverter;
        this.quizConverter = quizConverter;
        this.tagConverter = tagConverter;
    }

    public AdviceDto adviceToDto(Advice advice){
        AdviceDto adviceDto = new AdviceDto();
        adviceDto.setId(advice.getId());
        adviceDto.setCreated(advice.getCreated());
        adviceDto.setTitle(advice.getTitle());
        adviceDto.setText(advice.getText());
        advice.fileOptional().ifPresent(file -> adviceDto.setFileDto(fileConverter.fileToDto(file)));
        if(advice.getQuizzes()!=null){
            adviceDto.setQuizDtos(quizConverter.quizzesToDtos(advice.getQuizzes()));
        }
        adviceDto.setTagDtos(tagConverter.tagsToDtos(advice.getTags()));
        return adviceDto;
    }

    public Advice dtoToAdvice(AdviceDto adviceDto){
        Advice advice = new Advice();
        advice.setId(adviceDto.getId());
        advice.setCreated(adviceDto.getCreated());
        advice.setTitle(adviceDto.getTitle());
        advice.setText(adviceDto.getText());
        adviceDto.fileDtoOptional().ifPresent(fileDto -> advice.setFile(fileConverter.dtoToFile(fileDto)));
        if(adviceDto.getQuizDtos()!=null){
            advice.setQuizzes(quizConverter.dtosToQuizzes(adviceDto.getQuizDtos()));
        }
        advice.setTags(tagConverter.dtosToTags(adviceDto.getTagDtos()));
        return advice;
    }

    public List<AdviceDto> advicesToDtos(List<Advice> advices){
        List<AdviceDto> adviceDtos = new ArrayList<>();
        advices.forEach(advice -> adviceDtos.add(adviceToDto(advice)));
        return adviceDtos;
    }

    public List<Advice> dtosToAdvices(List<AdviceDto> adviceDtos){
        List<Advice> advices = new ArrayList<>();
        adviceDtos.forEach(adviceDto -> advices.add(dtoToAdvice(adviceDto)));
        return advices;
    }
}
