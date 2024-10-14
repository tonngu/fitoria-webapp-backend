package se.lexicon.g1.fitoriabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g1.fitoriabackend.domain.entity.BodyInfo;
import se.lexicon.g1.fitoriabackend.service.BodyInfoService;

import java.util.List;

@RestController
@RequestMapping("/api/body-info")
public class BodyInfoController {

    @Autowired
    private BodyInfoService bodyInfoService;

    // Save or update a user's body info
    @PostMapping("/user/{userId}")
    public ResponseEntity<BodyInfo> saveBodyInfo(
            @PathVariable Long userId,
            @RequestBody BodyInfo bodyInfo) {
        BodyInfo savedBodyInfo = bodyInfoService.saveBodyInfo(userId, bodyInfo);
        return ResponseEntity.ok(savedBodyInfo);
    }

    // Get body info by ID
    @GetMapping("/{id}")
    public ResponseEntity<BodyInfo> getBodyInfoById(@PathVariable Long id) {
        return bodyInfoService.getBodyInfoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete body info by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBodyInfo(@PathVariable Long id) {
        bodyInfoService.deleteBodyInfo(id);
        return ResponseEntity.noContent().build();
    }

    // Get body info from the past 3 weeks for a specific user
    @GetMapping("/user/{userId}/past-three-weeks")
    public ResponseEntity<List<BodyInfo>> getBodyInfoFromPastThreeWeeks(
            @PathVariable Long userId) {
        List<BodyInfo> bodyInfoList = bodyInfoService.getBodyInfosFromPastThreeWeeks(userId);
        return ResponseEntity.ok(bodyInfoList);
    }

    // Get body info from the past 2 months for a specific user
    @GetMapping("/user/{userId}/past-two-months")
    public ResponseEntity<List<BodyInfo>> getBodyInfoFromPastTwoMonths(
            @PathVariable Long userId) {
        List<BodyInfo> bodyInfoList = bodyInfoService.getBodyInfosFromPastTwoMonths(userId);
        return ResponseEntity.ok(bodyInfoList);
    }

    // Get body info from the past 6 months for a specific user
    @GetMapping("/user/{userId}/past-six-months")
    public ResponseEntity<List<BodyInfo>> getBodyInfoFromPastSixMonths(
            @PathVariable Long userId) {
        List<BodyInfo> bodyInfoList = bodyInfoService.getBodyInfosFromPastSixMonths(userId);
        return ResponseEntity.ok(bodyInfoList);
    }

    // Get body info from the past year for a specific user
    @GetMapping("/user/{userId}/past-year")
    public ResponseEntity<List<BodyInfo>> getBodyInfoFromPastYear(
            @PathVariable Long userId) {
        List<BodyInfo> bodyInfoList = bodyInfoService.getBodyInfosFromPastYear(userId);
        return ResponseEntity.ok(bodyInfoList);
    }
}