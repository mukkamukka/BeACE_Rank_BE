package com.example.realmanclub.beacerank_be.User;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/userList")
    public ResponseEntity<List<User>> getUserList() {
        List<User> userList = userService.userList();
        return ResponseEntity.ok(userList);
    }
}
