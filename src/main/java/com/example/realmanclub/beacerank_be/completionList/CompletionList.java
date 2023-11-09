package com.example.realmanclub.beacerank_be.completionList;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompletionList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_id")
    @JoinColumn(name = "student_id")
    private int studentId;

    @Column(name = "beaceprogram_code")
    private String beACECode;

    @Column(name = "beaceprogram_point")
    private int beACEPoint;
}
