package com.example.realmanclub.beacerank_be.user;

import com.example.realmanclub.beacerank_be.completionList.CompletionList;
import com.example.realmanclub.beacerank_be.user.dto.UserInfoDTO;
import com.example.realmanclub.beacerank_be.user.dto.UserSignInDTO;
import com.example.realmanclub.beacerank_be.user.dto.UserSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public List<User> findAllUserInfo(){
        return userRepository.findAll();
    }

    public User signUpUser(UserSignUpDTO userSignUpDTO){
        User user = new User();
        user.setId(userSignUpDTO.getId());
        user.setName(userSignUpDTO.getName());
        user.setDeptId(userSignUpDTO.getDeptName());
        user.setGrade(userSignUpDTO.getGrade());
        user.setDeviation(1);
        user.setPassword(userSignUpDTO.getPassword());
        user.setCreated_at(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    public boolean signInUser(UserSignInDTO userSignInDTO){
        User user = userRepository.findById(userSignInDTO.getId()).get();
        return user.getPassword().equals(userSignInDTO.getPassword());
    }

    public UserInfoDTO findUserInfo(int userId){
        User user = userRepository.findById(userId).get();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setId(user.getId());
        userInfoDTO.setName(user.getName());
        userInfoDTO.setDeptId(user.getDeptId());
        userInfoDTO.setScore(user.getScore());
        userInfoDTO.setGrade(user.getGrade());
        userInfoDTO.setDeviation(user.getDeviation());
        return userInfoDTO;
    }

    public List<CompletionList> findUserCompleteList(int userId) {
        User user = userRepository.findById(userId).get();
        return user.getCompletionList();
    }

    public boolean duplicateId(int userId) {
        return userRepository.existsById(userId);
    }
}
