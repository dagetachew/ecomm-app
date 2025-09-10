package com.dagim.ecomm.service;

import com.dagim.ecomm.dto.UserDto;
import com.dagim.ecomm.model.UserEntity;
import com.dagim.ecomm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity createUserProfile(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        userRepository.save(userEntity);
        return userEntity;
    }

    public UserEntity findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
}
