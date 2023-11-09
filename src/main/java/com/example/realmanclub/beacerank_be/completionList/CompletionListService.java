package com.example.realmanclub.beacerank_be.completionList;

import com.example.realmanclub.beacerank_be.beaceProgram.BeACEProgram;
import com.example.realmanclub.beacerank_be.beaceProgram.BeACEProgramRepository;
import com.example.realmanclub.beacerank_be.completionList.dto.UserCompleteProgram;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompletionListService {

    private final CompletionListRepository completionListRepository;
    private final BeACEProgramRepository beACEProgramRepository;

    public void userComplete(UserCompleteProgram userCompleteProgram){
        CompletionList completionList = new CompletionList();
        completionList.setStudentId(userCompleteProgram.getId());
        completionList.setBeACECode(userCompleteProgram.getCompleteCode());
        BeACEProgram beACEProgram  = beACEProgramRepository.findById(userCompleteProgram.getCompleteCode()).get();
        completionList.setBeACEPoint(beACEProgram.getPoint());
        completionListRepository.save(completionList);
    }

    public List<CompletionList> findAllCompletionList() {
        return completionListRepository.findAll();
    }
}
