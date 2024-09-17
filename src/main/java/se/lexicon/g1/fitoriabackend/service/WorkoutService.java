package se.lexicon.g1.fitoriabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g1.fitoriabackend.domain.entity.User;
import se.lexicon.g1.fitoriabackend.domain.entity.Workout;
import se.lexicon.g1.fitoriabackend.repository.UserRepository;
import se.lexicon.g1.fitoriabackend.repository.WorkoutRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;

    // Save or update a workout
    public Workout saveWorkout(Long userId, Workout workout) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        workout.setUser(user);  // Associate the workout with the correct user
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

    // Get workouts from the past 3 weeks
    public List<Workout> getWorkoutsFromPastThreeWeeks(Long userId, String exercise) {
        LocalDate threeWeeksAgo = LocalDate.now().minusWeeks(3);
        return workoutRepository.findByUser_IdAndDateAfterAndExercise(userId, threeWeeksAgo, exercise);
    }

    // Get workouts from the past 2 months
    public List<Workout> getWorkoutsFromPastTwoMonths(Long userId, String exercise) {
        LocalDate twoMonthsAgo = LocalDate.now().minusMonths(2);
        return workoutRepository.findByUser_IdAndDateAfterAndExercise(userId, twoMonthsAgo, exercise);
    }

    // Get workouts from the past 6 months
    public List<Workout> getWorkoutsFromPastSixMonths(Long userId, String exercise) {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        return workoutRepository.findByUser_IdAndDateAfterAndExercise(userId, sixMonthsAgo, exercise);
    }

    // Get workouts from the past year
    public List<Workout> getWorkoutsFromPastYear(Long userId, String exercise) {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        return workoutRepository.findByUser_IdAndDateAfterAndExercise(userId, oneYearAgo, exercise);
    }
}
