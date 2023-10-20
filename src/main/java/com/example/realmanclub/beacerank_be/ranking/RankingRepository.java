package com.example.realmanclub.beacerank_be.ranking;

import com.example.realmanclub.beacerank_be.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<User, String> {
    List<User> findUserByOrderByScoreDesc();

    List<User> findUserByGradeOrderByScoreDesc(int grade);

}
