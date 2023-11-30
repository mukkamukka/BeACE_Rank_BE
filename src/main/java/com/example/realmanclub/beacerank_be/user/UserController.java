package com.example.realmanclub.beacerank_be.user;

import com.example.realmanclub.beacerank_be.Message;
import com.example.realmanclub.beacerank_be.StatusEnum;
import com.example.realmanclub.beacerank_be.completionList.CompletionList;
import com.example.realmanclub.beacerank_be.user.dto.UserInfoDTO;
import com.example.realmanclub.beacerank_be.user.dto.UserSignInDTO;
import com.example.realmanclub.beacerank_be.user.dto.UserSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @GetMapping("/userList")
    public ResponseEntity<List<User>> getUserList() {
        List<User> userList = userService.findAllUserInfo();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/signUp")
    public ResponseEntity<Message> signUp(@RequestBody UserSignUpDTO userSignUpDTO) {
        Message message = new Message();
        message.setStatusEnum(StatusEnum.BAD_REQUEST);

        if (userService.duplicateId(userSignUpDTO.getId())) {
            message.setMessage("중복되는 아이디입니다.");
            return ResponseEntity.ok(message);
        }
        if (!userSignUpDTO.getPassword().equals(userSignUpDTO.getConfirmPassword())) {
            message.setMessage("비밀번호가 다릅니다.");
            return ResponseEntity.ok(message);
        }

        User user = userService.signUpUser(userSignUpDTO);

        message.setStatusEnum(StatusEnum.OK);
        message.setMessage("로그인 성공");
        message.setData(user);

        return ResponseEntity.ok(message);
    }

    @PostMapping("/signIn")
    public ResponseEntity<Message> singIn(@RequestBody UserSignInDTO userSignInDTO) {
        Message message = new Message();

        if (!userService.signInUser(userSignInDTO)) {
            message.setMessage("로그인 실패");
            return ResponseEntity.ok(message);
        }

        message.setStatusEnum(StatusEnum.OK);
        message.setMessage("로그인 성공");
        message.setData(userSignInDTO);

        return ResponseEntity.ok(message);
    }

    @GetMapping("/findUserInfo")
    public ResponseEntity<UserInfoDTO> findUser(@RequestParam int userId) {
        return ResponseEntity.ok(userService.findUserInfo(userId));
    }

    @GetMapping("/findUserCompletionList")
    public ResponseEntity<List<CompletionList>> findUserCompleteList(@RequestParam int userId) {
        return ResponseEntity.ok(userService.findUserCompleteList(userId));
    }
}
