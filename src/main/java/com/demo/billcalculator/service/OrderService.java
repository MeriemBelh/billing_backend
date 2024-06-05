package com.demo.billcalculator.service;

import com.demo.billcalculator.model.MenuItem;
import com.demo.billcalculator.model.Order;
import com.demo.billcalculator.model.OrderDTO;
import com.demo.billcalculator.repository.MenuItemRepository;
import com.demo.billcalculator.repository.OrderRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(OrderDTO orderDTO) {
        Order order = convertToEntity(orderDTO);
        return orderRepository.save(order);
    }

    public Order convertToEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomer(orderDTO.getCustomer());
        order.setOrderItems(orderDTO.getItems());
        return order;
    }
    public Double getTotal(Map<Integer, String> orderItems) {


        double total = 0d;


        for (Map.Entry<Integer, String> entry : orderItems.entrySet()) {
            Integer itemId = entry.getKey();
            Integer quantity = Integer.valueOf(entry.getValue());

            MenuItem menuItem = menuItemRepository.findById(itemId)
                    .orElseThrow(() -> new RuntimeException("Item not found with id: " + itemId));

            total += menuItem.getPrice() * quantity;
        }
        return total;
    }
    public Map<Integer, String> getOrderItemsById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            return order.getOrderItems();
        } else {
            // Handle case when order is not found
            throw new RuntimeException("Order not found for id: " + orderId);
        }
    }

    public Optional<Order> getOrder(Long id){
        return orderRepository.findById(id);
    }

    public Long getTableSize(){
        return orderRepository.count();
    }

    public Optional<Order> getLastOrderByCustomer(String customer) {

        Optional<Order> order = orderRepository.findTopByCustomerOrderByIdDesc(customer);
        if (order == null ){
            return null;
        }
        return order;

    }
}
