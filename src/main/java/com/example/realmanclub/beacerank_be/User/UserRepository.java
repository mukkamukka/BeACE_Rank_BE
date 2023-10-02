package com.example.realmanclub.beacerank_be.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u")
    List<User> findAllByUser();
}
