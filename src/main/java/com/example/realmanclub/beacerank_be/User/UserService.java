package com.example.realmanclub.beacerank_be.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> userList() {
        return userRepository.findAllByUser();
    }
}
