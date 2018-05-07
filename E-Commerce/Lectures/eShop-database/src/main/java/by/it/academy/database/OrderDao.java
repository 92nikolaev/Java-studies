package by.it.academy.database;

import by.it.academy.model.Order;

import java.util.List;

public interface OrderDao {

        Order readOrder(int id);
        List<Order> readAllOrder();
        Order createOrder(Order order);
}
