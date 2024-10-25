package se.lexicon.g1.fitoriabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g1.fitoriabackend.domain.entity.Workout;
import se.lexicon.g1.fitoriabackend.service.WorkoutService;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    // Register a new workout for a user
    @PostMapping("/user/{userId}")
    public ResponseEntity<Workout> registerWorkout(
            @PathVariable Long userId,
            @RequestBody Workout workout) {
        Workout savedWorkout = workoutService.saveWorkout(userId, workout);  // Pass the userId
        return ResponseEntity.ok(savedWorkout);
    }

    // Get workouts from the past 3 weeks for a specific exercise
    @GetMapping("/user/{userId}/exercise/{exercise}/past-three-weeks")
    public ResponseEntity<List<Workout>> getWorkoutsFromPastThreeWeeks(
            @PathVariable Long userId,
            @PathVariable String exercise) {
        List<Workout> workouts = workoutService.getWorkoutsFromPastThreeWeeks(userId, exercise);
        return ResponseEntity.ok(workouts);
    }

    // Get workouts from the past 2 months for a specific exercise
    @GetMapping("/user/{userId}/exercise/{exercise}/past-two-months")
    public ResponseEntity<List<Workout>> getWorkoutsFromPastTwoMonths(
            @PathVariable Long userId,
            @PathVariable String exercise) {
        List<Workout> workouts = workoutService.getWorkoutsFromPastTwoMonths(userId, exercise);
        return ResponseEntity.ok(workouts);
    }

    // Get workouts from the past 6 months for a specific exercise
    @GetMapping("/user/{userId}/exercise/{exercise}/past-six-months")
    public ResponseEntity<List<Workout>> getWorkoutsFromPastSixMonths(
            @PathVariable Long userId,
            @PathVariable String exercise) {
        List<Workout> workouts = workoutService.getWorkoutsFromPastSixMonths(userId, exercise);
        return ResponseEntity.ok(workouts);
    }

    // Get workouts from the past year for a specific exercise
    @GetMapping("/user/{userId}/exercise/{exercise}/past-year")
    public ResponseEntity<List<Workout>> getWorkoutsFromPastYear(
            @PathVariable Long userId,
            @PathVariable String exercise) {
        List<Workout> workouts = workoutService.getWorkoutsFromPastYear(userId, exercise);
        return ResponseEntity.ok(workouts);
    }

    // Get all workouts from the past 3 weeks for a specific user
    @GetMapping("/user/{userId}/past-three-weeks")
    public ResponseEntity<List<Workout>> getAllWorkoutsFromPastThreeWeeks(@PathVariable Long userId) {
        List<Workout> workouts = workoutService.getAllWorkoutsFromPastThreeWeeks(userId);
        return ResponseEntity.ok(workouts);
    }
}