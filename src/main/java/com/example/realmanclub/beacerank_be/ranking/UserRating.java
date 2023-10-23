package com.example.realmanclub.beacerank_be.ranking;

import com.example.realmanclub.beacerank_be.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static java.lang.Integer.parseInt;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {
    private String id;
    private String name;
    private int deptId;
    private int score;
    private int grade;
    private float deviation;
    private int rating;


    public static UserRating fromUser(User user) {
        return new UserRating(
                user.getId(),
                user.getName(),
                user.getDeptId(),
                user.getScore(),
                user.getGrade(),
                user.getDeviation(),
                (int) (user.getScore() * 7 * (user.getDeviation() + 0.5))
                // rating 값을 설정하거나 계산
        );
    }
}
