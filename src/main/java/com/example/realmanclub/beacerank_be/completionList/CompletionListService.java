package com.example.realmanclub.beacerank_be.completionList;

import com.example.realmanclub.beacerank_be.beaceProgram.BeACEProgram;
import com.example.realmanclub.beacerank_be.beaceProgram.BeACEProgramRepository;
import com.example.realmanclub.beacerank_be.completionList.dto.UserCompleteProgram;
import com.example.realmanclub.beacerank_be.user.User;
import com.example.realmanclub.beacerank_be.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompletionListService {

    private final UserRepository userRepository;
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

    public boolean validateBeACECode(String code) {
        return beACEProgramRepository.existsById(code);
    }

    public void updateUserTotalScore(List<CompletionList> completionLists, int studentId) {
        User user = userRepository.findById(studentId).get();
        int updateScore = user.getScore();

        for (CompletionList completionList : completionLists) {
            updateScore += completionList.getBeACEPoint();
        }

        user.setScore(updateScore);
        userRepository.save(user);
    }
}
