package se.lexicon.g1.fitoriabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g1.fitoriabackend.domain.entity.BodyInfo;
import se.lexicon.g1.fitoriabackend.domain.entity.Workout;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BodyInfoRepository extends JpaRepository<BodyInfo, Long> {
    List<BodyInfo> findByUser_Id(Long id);
    List<BodyInfo> findByUser_IdAndDateAfter(Long userId, LocalDate date);
}
