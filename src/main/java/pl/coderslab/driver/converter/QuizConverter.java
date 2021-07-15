package pl.coderslab.driver.converter;

import org.springframework.stereotype.Component;
import pl.coderslab.driver.dto.QuizDto;
import pl.coderslab.driver.entity.Quiz;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuizConverter {

    private final FileConverter fileConverter;
    private final AnswerConverter answerConverter;

    public QuizConverter(FileConverter fileConverter, AnswerConverter answerConverter) {
        this.fileConverter = fileConverter;
        this.answerConverter = answerConverter;
    }

    public QuizDto quizToDto(Quiz quiz) {
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setQuestion(quiz.getQuestion());
        quiz.fileOptional().ifPresent(file -> quizDto.setFileDto(fileConverter.fileToDto(file)));
        quizDto.setAnswerDtos(answerConverter.answersToDtos(quiz.getAnswers()));
        return quizDto;
    }

    public Quiz dtoToQuiz(QuizDto quizDto){
        Quiz quiz = new Quiz();
        quiz.setId(quizDto.getId());
        quiz.setQuestion(quizDto.getQuestion());
        quizDto.fileDtoOptional().ifPresent(fileDto -> quiz.setFile(fileConverter.dtoToFile(fileDto)));
        quiz.setAnswers(answerConverter.dtosToAnswers(quizDto.getAnswerDtos()));
        return quiz;
    }

    public List<QuizDto> quizzesToDtos(List<Quiz> quizzes){
        List<QuizDto> quizDtos = new ArrayList<>();
        quizzes.forEach(quiz -> quizDtos.add(quizToDto(quiz)));
        return quizDtos;
    }

    public List<Quiz> dtosToQuizzes(List<QuizDto> quizDtos){
        List<Quiz> quizzes = new ArrayList<>();
        quizDtos.forEach(quizDto -> quizzes.add(dtoToQuiz(quizDto)));
        return quizzes;
    }
}
