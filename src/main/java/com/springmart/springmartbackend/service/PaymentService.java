package com.springmart.springmartbackend.service;

import org.springframework.stereotype.Service;

import com.stripe.Stripe;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class PaymentService {

    private final String stripeSecretKey;

    public PaymentService(Dotenv dotenv) {
        this.stripeSecretKey = dotenv.get("STRIPE_SECRET_KEY");
        Stripe.apiKey = this.stripeSecretKey;
    }

}
