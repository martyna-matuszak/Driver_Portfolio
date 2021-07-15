package pl.coderslab.driver.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "DD-MM-yyyy")
    private LocalDate created;

    @NotBlank
    private String title;

    @Column(columnDefinition = "text")
    private String text;

    @ManyToOne
    private File file = null;

    @ManyToMany
    private List<Quiz> quizzes;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    private LocalDateTime adviceOfTheWeek;

    //=========================================================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getAdviceOfTheWeek() {
        return adviceOfTheWeek;
    }

    public void setAdviceOfTheWeek(LocalDateTime adviceOfTheWeek) {
        this.adviceOfTheWeek = adviceOfTheWeek;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public Optional<File> fileOptional(){
        return Optional.ofNullable(file);
    }
}
