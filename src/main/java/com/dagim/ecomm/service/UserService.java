package com.dagim.ecomm.service;

import com.dagim.ecomm.dto.UserDto;
import com.dagim.ecomm.dto.UserLoginDto;
import com.dagim.ecomm.model.UserEntity;
import com.dagim.ecomm.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@Slf4j
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

    public UserEntity findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public boolean validateUserCredential(UserLoginDto userLoginDto) {
        UserEntity userEntity = userRepository.findUserByEmail(userLoginDto.getEmail());
        if (userEntity == null)
            return false;
        else {
            String decodedPwrd = new String(Base64.getDecoder().decode(userEntity.getPassword()));
            return decodedPwrd.equals(userLoginDto.getPassword());
        }
    }


}
