package com.gmail.slshukevitch.project.DAO.Database;

import com.gmail.slshukevitch.project.DAO.Model.OrderItem;

import java.util.List;

public interface OrderItemDao {

    OrderItem readOrderItem(int id);
    OrderItem createOrderItem(OrderItem orderItem);
    List<OrderItem> readAllOrderItem();
}
