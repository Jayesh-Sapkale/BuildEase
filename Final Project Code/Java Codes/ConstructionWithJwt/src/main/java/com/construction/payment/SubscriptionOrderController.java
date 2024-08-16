package com.construction.payment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/subscription") // Base URL for subscription API endpoints
public class SubscriptionOrderController {

    @Autowired
    private SubscriptionOrderService subscriptionOrderService;

    @PostMapping(value="/create-order", produces="application/json")
    public ResponseEntity<SubscriptionOrder> createOrder(@RequestBody SubscriptionOrder subscriptionOrder) {
        try {
            SubscriptionOrder createdOrder = subscriptionOrderService.createSubscriptionOrder(subscriptionOrder);
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle the exception appropriately
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

