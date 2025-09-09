package com.dagim.ecomm.repository;

import com.dagim.ecomm.model.UserTbl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTbl, String> {

}
