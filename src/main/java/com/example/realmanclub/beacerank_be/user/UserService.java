package com.example.realmanclub.beacerank_be.user;

import com.example.realmanclub.beacerank_be.user.dto.UserSignInDTO;
import com.example.realmanclub.beacerank_be.user.dto.UserSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public List<User> findAllUserInfo(){
        return userRepository.findAllByUser();
    }

    public User signUpUser(UserSignUpDTO userSignUpDTO){
        User user = new User();
        int deptId;
        switch (userSignUpDTO.getDeptName()){
            case "컴퓨터정보학부":
                deptId = 1;
                break;
            case "사회복지학과":
                deptId = 2;
                break;
            default:
                deptId = 0;
                break;
        }
        user.setId(userSignUpDTO.getId());
        user.setName(userSignUpDTO.getName());
        user.setDeptId(deptId);
        user.setScore(userSignUpDTO.getCurrentBeACEScore());
        user.setGrade(userSignUpDTO.getGrade());
        user.setDeviation(0);
        user.setPassword(userSignUpDTO.getPassword());
        user.setCreated_at(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    public boolean signInUser(UserSignInDTO userSignInDTO){
        User user = userRepository.findById(userSignInDTO.getId()).get();
        return user.getPassword().equals(userSignInDTO.getPassword());
    }
}
