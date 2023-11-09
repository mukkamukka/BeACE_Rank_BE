package com.example.realmanclub.beacerank_be.beaceProgram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeACEProgramRepository extends JpaRepository<BeACEProgram, String> {
    List<BeACEProgram> findAllByMainCategory(String mainCategory);
}
