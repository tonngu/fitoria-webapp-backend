package se.lexicon.g1.fitoriabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g1.fitoriabackend.domain.entity.BodyInfo;
import se.lexicon.g1.fitoriabackend.domain.entity.User;
import se.lexicon.g1.fitoriabackend.domain.entity.Workout;
import se.lexicon.g1.fitoriabackend.repository.BodyInfoRepository;
import se.lexicon.g1.fitoriabackend.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BodyInfoService {
    @Autowired
    BodyInfoRepository bodyInfoRepository;

    @Autowired
    UserRepository userRepository;

    // Save or update a user's bodyInfo
    public BodyInfo saveBodyInfo(Long userId, BodyInfo bodyInfo) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        bodyInfo.setUser(user);  // Associate the workout with the correct user
        return bodyInfoRepository.save(bodyInfo);
    }

    // Get a specific bodyInfo by ID
    public Optional<BodyInfo> getBodyInfoById(Long id) {
        return bodyInfoRepository.findById(id);
    }

    // Delete a bodyInfo by ID
    public void deleteBodyInfo(Long id) {
        bodyInfoRepository.deleteById(id);
    }

    // Get bodyInfos from the past 3 weeks
    public List<BodyInfo> getBodyInfosFromPastThreeWeeks(Long userId) {
        LocalDate threeWeeksAgo = LocalDate.now().minusWeeks(3);
        return bodyInfoRepository.findByUser_IdAndDateAfter(userId, threeWeeksAgo);
    }

    // Get bodyInfos from the past 2 months
    public List<BodyInfo> getBodyInfosFromPastTwoMonths(Long userId) {
        LocalDate twoMonthsAgo = LocalDate.now().minusMonths(2);
        return bodyInfoRepository.findByUser_IdAndDateAfter(userId, twoMonthsAgo);
    }

    // Get bodyInfos from the past 6 months
    public List<BodyInfo> getBodyInfosFromPastSixMonths(Long userId) {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        return bodyInfoRepository.findByUser_IdAndDateAfter(userId, sixMonthsAgo);
    }

    // Get bodyInfos from the past year
    public List<BodyInfo> getBodyInfosFromPastYear(Long userId) {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        return bodyInfoRepository.findByUser_IdAndDateAfter(userId, oneYearAgo);
    }
}
