package com.gmail.slshukevitch.project.DAO.Database;

import com.gmail.slshukevitch.project.DAO.Model.Order;

import java.util.List;

public interface OrderDao {

        Order readOrder(int id);
        List<Order> readAllOrder();
        Order createOrder(Order order);
}
