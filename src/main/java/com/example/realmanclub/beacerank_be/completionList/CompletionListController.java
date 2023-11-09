package com.example.realmanclub.beacerank_be.completionList;

import com.example.realmanclub.beacerank_be.completionList.dto.UserCompleteProgram;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompletionListController {

    private final CompletionListService completionListService;

    @PostMapping("/completeProgram")
    public ResponseEntity<String> saveCompleteProgram(@RequestBody UserCompleteProgram userCompleteProgram) {
        completionListService.userComplete(userCompleteProgram);
        return ResponseEntity.ok("신청 완료");
    }

    @GetMapping("/findAllCompletionList")
    public ResponseEntity<List<CompletionList>> findAllCom() {
        return ResponseEntity.ok(completionListService.findAllCompletionList());
    }
}
