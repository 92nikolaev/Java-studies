package by.it.academy.database;

import by.it.academy.model.OrderItem;

import java.util.List;

public interface OrderItemDao {

    OrderItem readOrderItem(int id);
    OrderItem createOrderItem(OrderItem orderItem);
    List<OrderItem> readAllOrderItem();
}
