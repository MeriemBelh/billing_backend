package com.demo.billcalculator.repository;



import com.demo.billcalculator.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    long count();

    Optional<Order> findTopByCustomerOrderByIdDesc(String customer);
    //getOrderItemsByOrderId
}