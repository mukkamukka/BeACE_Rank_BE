package com.example.realmanclub.beacerank_be.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    private int id;
    private String name;
    private String deptId;
    private int score;
    private int grade;
    private float deviation;
}
