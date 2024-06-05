package com.demo.billcalculator.controller;

import com.demo.billcalculator.model.Order;
import com.demo.billcalculator.model.OrderDTO;
import com.demo.billcalculator.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;


    //@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {

            // Create the order
            Order savedOrder = orderService.createOrder(orderDTO);

            // Calculate the total
            //Double total = orderService.getTotal(savedOrder);

            // Construct the redirect URL
            //String redirectUrl = "http://localhost:8081/api/orderConfirmation?orderId=22&token="+token;

            // Perform the redirection


            return ResponseEntity.ok("good"); // 302 Found
            //return ResponseEntity.ok(total);
            //RedirectView redirectView = new RedirectView();
            //redirectView.setUrl("http://localhost:8081/api/orderConfirmation?orderId=22&token="+token);

            //return redirectView;

    }

    //@CrossOrigin(origins = "*")
    @PostMapping("/ping")
    public ResponseEntity<Double> ping(@RequestBody Map<String, Object> payload) {
        String customer = (String) payload.get("user");
        Optional<Order> savedOrder = null;
        try {
            savedOrder = orderService.getLastOrderByCustomer(customer);
            Order order = savedOrder.orElseThrow(() -> new Exception("Order not found for id"));

            Map<Integer, String> orderItems = orderService.getOrderItemsById(order.getId());
            Double total = orderService.getTotal(orderItems);


            return ResponseEntity.ok(total);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }




}


