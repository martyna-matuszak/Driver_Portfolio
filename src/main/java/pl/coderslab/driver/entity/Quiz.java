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

    private Long correctAnswerId;

    @ManyToOne
    private File file;

    //===================================================================


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

    public Optional<File> getFileOpt() {
        return Optional.of(file);
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

    public Long getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(Long correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }
}
