package com.example.patronStrategy.strategy.impl;

import com.example.patronStrategy.strategy.PaymentStrategy;
import org.springframework.stereotype.Component;

/**
 * Estrategia Concreta: Implementa el algoritmo de pago por transferencia bancaria.
 * Registrada como un bean de Spring con el nombre por defecto "bankTransferPayment".
 */
@Component("bankTransferPayment")
public class BankTransferPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Pagando " + amount + " usando transferencia bancaria.");
        // Aquí iría la lógica real para generar instrucciones de transferencia.
    }
}
