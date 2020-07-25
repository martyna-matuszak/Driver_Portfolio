package pl.coderslab.driver.service;

import org.springframework.stereotype.Service;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.entity.Quiz;
import pl.coderslab.driver.repository.AdviceRepository;
import pl.coderslab.driver.repository.AnswerRepository;
import pl.coderslab.driver.repository.FileRepository;
import pl.coderslab.driver.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final FileRepository fileRepository;
    private final AnswerRepository answerRepository;
    private final QuizRepository quizRepository;
    private final AdviceRepository adviceRepository;

    public QuizService(FileRepository fileRepository, AnswerRepository answerRepository, QuizRepository quizRepository, AdviceRepository adviceRepository) {
        this.fileRepository = fileRepository;
        this.answerRepository = answerRepository;
        this.quizRepository = quizRepository;
        this.adviceRepository = adviceRepository;
    }

    public Quiz createQuiz(Quiz quiz, String question, Long[] answersIds, Long fileId, Long adviceId){
        quiz.setQuestion(question);
        fileRepository.findById(fileId).ifPresent(quiz::setFile);
        adviceRepository.findById(adviceId).ifPresent(quiz::setAdvice);
        quiz.setAnswers(getAnswers(answersIds));
        return quiz;
    }


    public List<Answer> getAnswers(Long[] answersIds){
        List<Answer> answers = new ArrayList<>();
        for(Long id: answersIds){
            answerRepository.findById(id).ifPresent(answers::add);
        }
        return answers;
    }
}
