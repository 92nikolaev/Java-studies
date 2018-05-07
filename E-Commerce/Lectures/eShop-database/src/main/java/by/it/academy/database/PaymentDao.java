package by.it.academy.database;

import by.it.academy.model.Payment;

import java.util.List;

public interface PaymentDao {

    Payment readPayment(int id);
    Payment createPayment(Payment payment);
    List<Payment> readAllPayment();
}
