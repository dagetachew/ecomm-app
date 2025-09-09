package com.dagim.ecomm.repository;

import com.dagim.ecomm.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
