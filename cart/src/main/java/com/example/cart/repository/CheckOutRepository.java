package com.example.cart.repository;

import com.example.cart.entity.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  CheckOutRepository extends JpaRepository<CheckOut, Long> {


    void deleteByUserId(Long userId);

    List<CheckOut> findByUserId(Long userId);
}
