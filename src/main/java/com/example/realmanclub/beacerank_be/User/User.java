package com.example.realmanclub.beacerank_be.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "student_id")
    private String id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "department_id")
    private int deptId;
    @Column(name = "beace_total_score")
    private int score;
    private int grade;
    @Column(name = "standard_deviation")
    private float deviation;
    private String password;
    private Timestamp created_at;
}
