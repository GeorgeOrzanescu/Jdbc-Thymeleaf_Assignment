package com.assignment.SpringBootAssignment.datalayer;

import com.assignment.SpringBootAssignment.models.Payment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentRowMapper implements RowMapper<Payment> {

    @Override
    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Payment payment = new Payment();
        payment.setCustomerId(rs.getInt("customer_id"));
        payment.setPaymentDate(rs.getString("payment_date"));
        payment.setAmount(rs.getDouble("amount"));

        return payment;
    }
}
