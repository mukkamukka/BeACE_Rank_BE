package com.example.realmanclub.beacerank_be.beaceProgram;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeACEProgramService {

    @Autowired
    private final BeACEProgramRepository beACEProgramRepository;

    public List<BeACEProgram> findAllRoadMap(){
        return beACEProgramRepository.findAll();
    }

    public List<BeACEProgram> findByMainCategory(String mainCategory){
        return beACEProgramRepository.findAllByMainCategory(mainCategory);
    }
}
