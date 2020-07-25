package pl.coderslab.driver.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @OneToMany
    private List<Answer> answers;

    @ManyToOne
    private File file;

    @ManyToOne
    private Advice advice;

    //===================================================================

    public Quiz(){

    }

    public Quiz(String question, List<Answer> answers, File file, Advice advice) {
        this.question = question;
        this.answers = answers;
        this.file = file;
        this.advice = advice;
    }

    //===================================================================

    public Optional<File> getFileOpt() {
        return Optional.of(file);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(question + "\n");
        for (Answer answer : answers) {
            sb.append(answer.toString() + "\n");
        }
        return sb.toString();
    }
}
