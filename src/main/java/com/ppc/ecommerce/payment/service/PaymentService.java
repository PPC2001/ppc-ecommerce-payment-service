package com.ppc.ecommerce.payment.service;

import com.ppc.ecommerce.sdk.dto.PaymentDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final List<PaymentDto> payments = new ArrayList<>(List.of(
            PaymentDto.builder()
                    .transactionId("TXN-9001")
                    .orderId("ORD-1001")
                    .customerId("CUST-501")
                    .amount(new BigDecimal("289.98"))
                    .paymentMethod("CREDIT_CARD")
                    .status("SUCCESS")
                    .timestamp(LocalDateTime.now().minusDays(1))
                    .build()
    ));

    public List<PaymentDto> getAllPayments() {
        return payments;
    }

    public PaymentDto getPaymentByTransactionId(String transactionId) {
        return payments.stream()
                .filter(p -> p.getTransactionId().equalsIgnoreCase(transactionId))
                .findFirst()
                .orElse(null);
    }

    public PaymentDto processPayment(PaymentDto payment) {
        if (payment.getTransactionId() == null) {
            payment.setTransactionId("TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        payment.setStatus("SUCCESS");
        payment.setTimestamp(LocalDateTime.now());
        payments.add(payment);
        return payment;
    }
}
