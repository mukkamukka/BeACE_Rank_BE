package com.example.realmanclub.beacerank_be.beaceProgram;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeACEProgramService {

    private final BeACEProgramRepository beACEProgramRepository;

    public List<BeACEProgram> findAllRoadMap(){
        return beACEProgramRepository.findAll();
    }

    public List<BeACEProgram> findByMainCategory(String mainCategory){
        return beACEProgramRepository.findAllByMainCategory(mainCategory);
    }

    public Optional<BeACEProgram> findBeACEProgram(String id) {
        return beACEProgramRepository.findById(id);
    }
}
