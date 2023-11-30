package com.example.realmanclub.beacerank_be.completionList;

import com.example.realmanclub.beacerank_be.Message;
import com.example.realmanclub.beacerank_be.StatusEnum;
import com.example.realmanclub.beacerank_be.completionList.dto.UserCompleteProgram;
import com.example.realmanclub.beacerank_be.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompletionListController {

    private final UserService userService;
    private final CompletionListService completionListService;

    @PostMapping("/completeProgram")
    public ResponseEntity<Message> saveCompleteProgram(@RequestBody UserCompleteProgram userCompleteProgram) {
        Message message = new Message();
        message.setStatusEnum(StatusEnum.BAD_REQUEST);

        if (!userService.duplicateId(userCompleteProgram.getId())) {
            message.setMessage("등록되지 않은 아이디입니다.");
            return ResponseEntity.ok(message);
        }
        if (!completionListService.validateBeACECode(userCompleteProgram.getCompleteCode())) {
            message.setMessage("유효하지않는 BeACE코드입니다.");
            return ResponseEntity.ok(message);
        }

        completionListService.userComplete(userCompleteProgram);
        completionListService.updateUserTotalScore(userService.findUserCompleteList(userCompleteProgram.getId()), userCompleteProgram.getId());

        message.setStatusEnum(StatusEnum.OK);
        message.setMessage("이수 신청 완료");
        message.setData(userCompleteProgram);

        return ResponseEntity.ok(message);
    }

    @GetMapping("/findAllCompletionList")
    public ResponseEntity<List<CompletionList>> findAllCom() {
        return ResponseEntity.ok(completionListService.findAllCompletionList());
    }
}
