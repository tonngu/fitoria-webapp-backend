package se.lexicon.g1.fitoriabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g1.fitoriabackend.domain.entity.Workout;
import se.lexicon.g1.fitoriabackend.repository.UserRepository;
import se.lexicon.g1.fitoriabackend.repository.WorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;

    // Save or update a workout
    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    // Get all workouts for a specific user
    public List<Workout> getWorkoutsByUserId(Long userId) {
        return workoutRepository.findByUser_Id(userId);
    }

    // Get a specific workout by ID
    public Optional<Workout> getWorkoutById(Long id) {
        return workoutRepository.findById(id);
    }

    // Delete a workout by ID
    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}
