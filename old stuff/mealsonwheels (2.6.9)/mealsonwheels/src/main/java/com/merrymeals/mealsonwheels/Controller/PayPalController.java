package com.merrymeals.mealsonwheels.Controller;

import com.merrymeals.mealsonwheels.Entity.PaymentRequest;
import com.paypal.api.payments.*;
import com.paypal.base.exception.PayPalException;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class PayPalController {

    private final String clientId = "AbPgKt26jKqlmXNV_LZkwyKbtdml0LR3e2YIVoOnoHbY0seQ4tZTMdP1L4wy4Tf4PM3kbX1i_B-MYRVy";
    private final String clientSecret = "EBgmUj7JXqk9hWo3hTLQB8j3J12Z8kEGov58qtOxfChcmkHbNAuRYRSZfLhWLkTyOVk2Mu3N5TOJy8Xm";
    private final String mode = "sandbox"; // Change to "live" for production environment

    @PostMapping(value="/create-payment")
    public Payment createPayment(@RequestBody PaymentRequest paymentRequest) throws PayPalRESTException {
        APIContext apiContext = new APIContext(clientId, clientSecret, mode);
        Payment payment = new Payment();
        payment.setIntent("sale");

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        payment.setPayer(payer);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setReturnUrl("http://localhost:8080/execute-payment");
        redirectUrls.setCancelUrl("http://localhost:8080/cancel-payment");
        payment.setRedirectUrls(redirectUrls);

        Transaction transaction = new Transaction();
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(paymentRequest.getAmount());
        transaction.setAmount(amount);
        transaction.setDescription(paymentRequest.getDescription());

        ItemList itemList = new ItemList();
        Item item = new Item();
        item.setName(paymentRequest.getItemName());
        item.setPrice(paymentRequest.getAmount());
        item.setCurrency("USD");
        item.setQuantity("1");
        itemList.setItems(Collections.singletonList(item));
        transaction.setItemList(itemList);

        payment.setTransactions(Collections.singletonList(transaction));

        Payment createdPayment = payment.create(apiContext);
        return createdPayment;
    }

    @PostMapping(value="/execute-payment")
    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(clientId, clientSecret, mode);
        Payment payment = new Payment();
        payment.setId(paymentId);

        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment executedPayment = payment.execute(apiContext, paymentExecution);
        return executedPayment;
    }

    @PostMapping(value="/cancel-payment")
    public String cancelPayment() {
        return "Payment cancelled.";
    }

}
