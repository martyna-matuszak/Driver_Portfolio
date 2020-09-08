package pl.coderslab.driver.service;

import org.springframework.stereotype.Service;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.entity.Quiz;
import pl.coderslab.driver.repository.AnswerRepository;
import pl.coderslab.driver.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final AnswerRepository answerRepository;

    public QuizService(QuizRepository quizRepository, AnswerRepository answerRepository) {
        this.quizRepository = quizRepository;
        this.answerRepository = answerRepository;
    }

    public Quiz getQuiz(Long id) throws Exception {
        return quizRepository.findById(id).orElseThrow(() -> new Exception("Quiz with id: "+ id + " - not found"));
    }

    public Quiz save(Quiz quiz){
        quiz.setAnswers(quizAnswers(quiz.getAnswers()));
        return quizRepository.save(quiz);
    }

    public Quiz update(Quiz quiz) throws Exception {
        getQuiz(quiz.getId());
        quiz.setAnswers(quizAnswers(quiz.getAnswers()));
        return quizRepository.save(quiz);
    }

    public List<Answer> quizAnswers(List<Answer> answersFromUser){
        List<Answer> quizAnswers = new ArrayList<>();
        answersFromUser.forEach(answer -> {
            quizAnswers.add(answerRepository.findById(answer.getId()).orElseGet(() -> answerRepository.save(answer)));
        });
        return quizAnswers;
    }

    public void deleteQuiz(Long id) throws Exception {
        quizRepository.delete(getQuiz(id));
    }
}
