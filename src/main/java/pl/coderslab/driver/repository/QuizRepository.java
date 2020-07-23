package pl.coderslab.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.driver.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
