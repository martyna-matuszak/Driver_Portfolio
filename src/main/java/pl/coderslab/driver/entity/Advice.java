package pl.coderslab.driver.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "DD-MM-yyyy")
    private LocalDate created;

    @PrePersist
    public void prePersist(){
        setCreated(LocalDate.now());
    }

    @NotBlank
    private String title;

    @ManyToOne
    private File file = null;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    //=========================================================================

    public Advice(){

    }

    public Advice(@NotBlank String title, File file) {
        this.title = title;
        this.file = file;
    }


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

    public Optional<File> getFileOpt() {
        return Optional.of(file);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
