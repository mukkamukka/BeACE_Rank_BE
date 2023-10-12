package com.example.realmanclub.beacerank_be.user;

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

    @Autowired
    private final UserService userService;

    @GetMapping("/userList")
    public ResponseEntity<List<User>> getUserList() {
        List<User> userList = userService.findAllUserInfo();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/signUp")
    public ResponseEntity<User> signUp(@RequestBody UserSignUpDTO userSignUpDTO) {
        User user = userService.signUpUser(userSignUpDTO);
        if (!userSignUpDTO.getPassword().equals(userSignUpDTO.getConfirmPassword())){

        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/signIn")
    public ResponseEntity<String> singIn(@RequestBody UserSignInDTO userSignInDTO){
        if (userService.signInUser(userSignInDTO)){
            return ResponseEntity.ok("로그인 완료");
        } else {
            return ResponseEntity.ok("로그인 실패");
        }

    }
}
