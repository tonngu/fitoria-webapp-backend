package se.lexicon.g1.fitoriabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g1.fitoriabackend.domain.entity.Workout;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUser_Id(Long id);
    List<Workout> findByUser_IdAndDateAfter(Long userId, LocalDate date);
    List<Workout> findByUser_IdAndDateAfterAndExercise(Long userId, LocalDate date, String exercise);
}
