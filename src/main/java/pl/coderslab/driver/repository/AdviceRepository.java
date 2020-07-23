package pl.coderslab.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.driver.entity.Advice;

public interface AdviceRepository extends JpaRepository<Advice, Long> {
}
