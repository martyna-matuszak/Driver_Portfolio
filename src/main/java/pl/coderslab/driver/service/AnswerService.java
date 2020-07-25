package pl.coderslab.driver.service;

import org.springframework.stereotype.Service;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.repository.AnswerRepository;
import pl.coderslab.driver.repository.FileRepository;

@Service
public class AnswerService {

    private final FileRepository fileRepository;
    private final AnswerRepository answerRepository;

    public AnswerService(FileRepository fileRepository, AnswerRepository answerRepository) {
        this.fileRepository = fileRepository;
        this.answerRepository = answerRepository;
    }


    public Answer save(String text, Boolean correct, Long fileId){
        Answer answer = new Answer();
        answer.setText(text);
        answer.setCorrect(correct);
        fileRepository.findById(fileId).ifPresent(answer::setFile);
        return answerRepository.save(answer);
    }

    public Answer update(Answer answer, String text, Boolean correct, Long fileId){
        answer.setText(text);
        answer.setCorrect(correct);
        fileRepository.findById(fileId).ifPresent(answer::setFile);
        return answerRepository.save(answer);
    }
}
