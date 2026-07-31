package com.ppc.ecommerce.payment.controller;

import com.ppc.ecommerce.payment.service.PaymentService;
import com.ppc.ecommerce.sdk.dto.ApiResponse;
import com.ppc.ecommerce.sdk.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<PaymentDto>>> getAllPayments() {
        List<PaymentDto> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(ApiResponse.success(payments, "Fetched all payments successfully"));
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<ApiResponse<PaymentDto>> getPaymentByTransactionId(@PathVariable String transactionId) {
        PaymentDto payment = paymentService.getPaymentByTransactionId(transactionId);
        if (payment == null) {
            return ResponseEntity.status(404).body(ApiResponse.error("Payment transaction not found with ID: " + transactionId));
        }
        return ResponseEntity.ok(ApiResponse.success(payment, "Payment details retrieved"));
    }

    @PostMapping("/process")
    public ResponseEntity<ApiResponse<PaymentDto>> processPayment(@RequestBody PaymentDto payment) {
        PaymentDto processed = paymentService.processPayment(payment);
        return ResponseEntity.status(201).body(ApiResponse.success(processed, "Payment processed successfully"));
    }
}
