package com.demo.billcalculator.model;

import java.util.List;
import java.util.Map;

public class OrderDTO {

    private String customer;
    private Map<Integer, String> items;
    //private String customer;

    public Map<Integer, String> getItems() {
        return items;
    }

    public void setItems(Map<Integer, String> items) {
        this.items = items;
    }

    public String getCustomer() {
        return customer;
    }
}
