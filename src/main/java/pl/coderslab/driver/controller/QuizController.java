package pl.coderslab.driver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.entity.Quiz;
import pl.coderslab.driver.repository.AnswerRepository;
import pl.coderslab.driver.repository.FileRepository;
import pl.coderslab.driver.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private final FileRepository fileRepository;
    private final AnswerRepository answerRepository;
    private final QuizRepository quizRepository;

    public QuizController(FileRepository fileRepository, AnswerRepository answerRepository, QuizRepository quizRepository) {
        this.fileRepository = fileRepository;
        this.answerRepository = answerRepository;
        this.quizRepository = quizRepository;
    }


    @PostMapping("/add")
    @ResponseBody
    public String addQuiz(@RequestParam String question, @RequestParam String[] answersText, @RequestParam Long fileId){
        Quiz quiz = new Quiz();
        quiz.setQuestion(question);
        fileRepository.findById(fileId).ifPresent(quiz::setFile);
        List<Answer> answers = new ArrayList<>();
        for (String text : answersText){
            Answer answer = new Answer();
            answer.setText(text);
            answerRepository.save(answer);
            answers.add(answer);
        }
        quiz.setAnswers(answers);
        quiz = quizRepository.save(quiz);
        return "Dodano: " + quiz.getQuestion() + " " + quiz.getId();
    }

}
