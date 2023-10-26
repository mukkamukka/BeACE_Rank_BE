package com.example.realmanclub.beacerank_be.ranking;

import com.example.realmanclub.beacerank_be.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class RankingController {

    @Autowired
    private RankingService rankingService;
    @GetMapping("/allRanking")
    public ResponseEntity<List<UserRating>> getAllRanking() {
        List<UserRating> userList = rankingService.findAllRanking();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/gradeRanking")
    public ResponseEntity<List<UserRating>> getGradeRanking(@RequestParam int grade) {
        List<UserRating> userRatingList = rankingService.findAllRankingGrade(grade);
        return ResponseEntity.ok(userRatingList);
    }

    @GetMapping("/awardRanking")
    public ResponseEntity<List<UserRating>> getAwardRanking() {
        List<UserRating> userRatingList = rankingService.findAwardRanking();
        return ResponseEntity.ok(userRatingList);
    }
}
