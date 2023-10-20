package com.example.realmanclub.beacerank_be.ranking;

import com.example.realmanclub.beacerank_be.user.User;
import com.example.realmanclub.beacerank_be.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RankingService {
    @Autowired
    private final RankingRepository rankingRepository;

    public List<UserRating> findAllRanking() {
        List<User> userList = rankingRepository.findUserByOrderByScoreDesc();
        List<UserRating> userRatingList = userList.stream()
                .map(UserRating::fromUser).toList();

        return userRatingList;
    }

    public List<UserRating> findAllRankingGrade(int grade) {
        List <User> userList = rankingRepository.findUserByGradeOrderByScoreDesc(grade);
        List<UserRating> userRatingList = userList.stream().map(UserRating::fromUser).toList();
        return userRatingList;
    }
}
