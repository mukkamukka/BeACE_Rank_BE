package com.example.realmanclub.beacerank_be.beaceProgram;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeACEProgram {

    @Id
    @Column(name = "beaceprogram_code")
    public String id;
    @Column(name = "beaceprogram_name")
    public String name;
    @Column(name = "beaceprogram_point")
    public int point;
    @Column(name = "beaceprogram_contents")
    public String contents;
    @Column
    public String mainCategory;
    @Column
    public String middleCategory;
    @Column
    public String host;
}
