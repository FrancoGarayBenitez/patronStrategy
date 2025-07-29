package com.example.patronStrategy.strategy.impl;

import com.example.patronStrategy.strategy.PaymentStrategy;
import org.springframework.stereotype.Component;
/**
 * Estrategia Concreta: Implementa el algoritmo de pago con tarjeta de crédito.
 * La anotación @Component la registra como un bean de Spring, con el nombre por defecto "creditCardPayment".
 */
@Component("creditCardPayment") // Damos un nombre específico al bean para fácil referencia.
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount){
        System.out.println("Pagando " + amount + " usando tarjeta de crédito.");
    }
}
