package pl.coderslab.driver.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.driver.entity.Advice;

import java.util.Optional;

public interface AdviceRepository extends JpaRepository<Advice, Long> {
    Optional<Advice> findById(Long id);
    List<Advice> findAll();
    Advice findFirstByOrderByAdviceOfTheWeekAsc();
    Advice findFirstByOrderByAdviceOfTheWeekDesc();
}
