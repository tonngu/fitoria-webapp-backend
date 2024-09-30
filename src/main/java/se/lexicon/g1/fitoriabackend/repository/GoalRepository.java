package se.lexicon.g1.fitoriabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g1.fitoriabackend.domain.entity.Goal;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUser_IdAndTargetDateBetween(Long userId, LocalDate today, LocalDate twoWeeksFromNow);
    List<Goal> findByUser_Id(Long userId);
}
