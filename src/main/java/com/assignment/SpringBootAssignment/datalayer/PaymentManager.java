package com.assignment.SpringBootAssignment.datalayer;

import com.assignment.SpringBootAssignment.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.Date;


@Repository
public class PaymentManager {
    JdbcTemplate template;

    @Autowired
    public PaymentManager(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public void registerPayment(Payment payment){
        String query = "INSERT INTO payments(customer_id,payment_date,amount) VALUES (?,?,?)";
        Date sqlDate = new Date(System.currentTimeMillis());
        template.update(query,payment.getCustomerId(),sqlDate,payment.getAmount());
    }
}
