package com.example.capstone.repos;

import com.example.capstone.entity.Album;
import com.example.capstone.entity.Order;
import com.example.capstone.models.CartInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
//    Order findName(String id);



}
