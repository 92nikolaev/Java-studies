package com.gmail.slshukevitch.project.DAO.Database;

import com.gmail.slshukevitch.project.DAO.Model.Payment;


import java.util.List;

public interface PaymentDao {

    Payment readPayment(int id);
    Payment createPayment(Payment payment);
    List<Payment> readAllPayment();
}
