package com.dagim.ecomm.repository;

import com.dagim.ecomm.model.ProductTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductTbl, String> {

}
