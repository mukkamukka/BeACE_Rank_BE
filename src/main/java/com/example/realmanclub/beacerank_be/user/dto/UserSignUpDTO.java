package com.example.realmanclub.beacerank_be.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpDTO {
    private int id;
    private String name;
    private String deptName;
    private int grade;
    private String password;
    private String confirmPassword;
}
