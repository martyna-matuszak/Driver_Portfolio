package pl.coderslab.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.driver.entity.Advice;

import java.util.Optional;

public interface AdviceRepository extends JpaRepository<Advice, Long> {
    Optional<Advice> findById(Long id);
}
