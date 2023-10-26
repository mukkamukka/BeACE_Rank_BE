package com.example.realmanclub.beacerank_be.beaceProgram;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BeACEProgramController {

    @Autowired
    private final BeACEProgramService beACEProgramService;

    @GetMapping("/allRoadMap")
    public ResponseEntity<List<BeACEProgram>> allRoadMap() {
        return ResponseEntity.ok(beACEProgramService.findAllRoadMap());
    }

    @GetMapping("/findMainCategory")
    public ResponseEntity<List<BeACEProgram>> findMainCategory(@RequestParam String mainCategory){
        return ResponseEntity.ok((beACEProgramService.findByMainCategory(mainCategory)));
    }
}
