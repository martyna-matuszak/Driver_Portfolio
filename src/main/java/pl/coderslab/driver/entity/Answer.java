package pl.coderslab.driver.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String text;

    @ManyToOne
    private File file = null;

    //==============================================================================


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Optional<File> getFileOpt() {
        return Optional.of(file);
    }

    public void setFile(File file) {
        this.file = file;
    }
}
