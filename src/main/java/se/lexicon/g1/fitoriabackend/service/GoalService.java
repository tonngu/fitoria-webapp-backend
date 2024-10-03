package se.lexicon.g1.fitoriabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g1.fitoriabackend.domain.entity.Goal;
import se.lexicon.g1.fitoriabackend.domain.entity.User;
import se.lexicon.g1.fitoriabackend.repository.GoalRepository;
import se.lexicon.g1.fitoriabackend.repository.UserRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Goal> getUpcomingGoals(Long userId) {
        LocalDate today = LocalDate.now();
        LocalDate twoWeeksFromNow = LocalDate.now().plusWeeks(2);
        List<Goal> goals = goalRepository.findByUser_IdAndTargetDateBetween(userId, today, twoWeeksFromNow);
        return goals.stream()
                .sorted(Comparator.comparing(Goal::getTargetDate))
                .collect(Collectors.toList());
    }

    public Goal saveGoal(Long userId, Goal goal){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        goal.setUser(user);
        return goalRepository.save(goal);
    }

    public List<Goal> getAllGoals(Long userId){
        return goalRepository.findByUser_Id(userId);
    }

    public void deleteGoal(Long goalId) {
        goalRepository.deleteById(goalId);
    }


}
