package com.example.patronStrategy.strategy.impl;

import com.example.patronStrategy.strategy.PaymentStrategy;
import org.springframework.stereotype.Component;

/**
 * Estrategia Concreta: Implementa el algoritmo de pago con PayPal.
 * Registrada como un bean de Spring con el nombre por defecto "payPalPayment".
 */
@Component("payPalPayment")
public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagando " + amount + " usando PayPal.");
        // Aquí iría la lógica real para interactuar con la API de PayPal.
    }
}
