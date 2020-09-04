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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Optional<File> fileOptional(){
        return Optional.ofNullable(file);
    }
}
