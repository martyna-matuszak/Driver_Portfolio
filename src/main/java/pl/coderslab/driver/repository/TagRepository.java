package pl.coderslab.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.driver.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
