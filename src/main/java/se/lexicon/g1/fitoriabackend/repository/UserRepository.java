package se.lexicon.g1.fitoriabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g1.fitoriabackend.domain.entity.User;
import se.lexicon.g1.fitoriabackend.domain.entity.Workout;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
