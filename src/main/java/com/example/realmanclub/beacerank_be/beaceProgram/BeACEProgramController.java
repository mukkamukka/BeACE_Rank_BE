package com.example.realmanclub.beacerank_be.beaceProgram;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BeACEProgramController {

    private final BeACEProgramService beACEProgramService;

    @GetMapping("/allRoadMap")
    public ResponseEntity<List<BeACEProgram>> allRoadMap() {
        return ResponseEntity.ok(beACEProgramService.findAllRoadMap());
    }

    @GetMapping("/findMainCategory")
    public ResponseEntity<List<BeACEProgram>> findMainCategory(@RequestParam String mainCategory){
        return ResponseEntity.ok(beACEProgramService.findByMainCategory(mainCategory));
    }

    @GetMapping("/findBeACEProgram")
    public ResponseEntity<Optional<BeACEProgram>> findBeACEProgram(@RequestParam String id) {
        return ResponseEntity.ok(beACEProgramService.findBeACEProgram(id));
    }
}
