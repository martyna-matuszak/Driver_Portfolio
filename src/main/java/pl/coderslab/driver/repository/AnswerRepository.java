package pl.coderslab.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.driver.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
