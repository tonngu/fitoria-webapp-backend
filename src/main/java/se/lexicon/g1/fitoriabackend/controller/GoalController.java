package se.lexicon.g1.fitoriabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g1.fitoriabackend.domain.entity.Goal;
import se.lexicon.g1.fitoriabackend.service.GoalService;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;


    @GetMapping("/user/{userId}/upcoming")
    public ResponseEntity<List<Goal>> getUpcomingGoals(@PathVariable Long userId) {
        List<Goal> upcomingGoals = goalService.getUpcomingGoals(userId);
        return ResponseEntity.ok(upcomingGoals);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Goal> createGoal(@PathVariable Long userId, @RequestBody Goal goal) {
        Goal savedGoal = goalService.saveGoal(userId, goal);
        return ResponseEntity.ok(savedGoal);

    }

    @DeleteMapping("/{goalId}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long goalId) {
        goalService.deleteGoal(goalId);
        return ResponseEntity.noContent().build();
    }
}
