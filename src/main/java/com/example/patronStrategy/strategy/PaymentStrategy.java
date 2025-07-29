package com.example.patronStrategy.strategy;
/**
 * Interfaz Strategy: Declara el método común para todos los algoritmos de pago.
 * Cualquier nueva forma de pago deberá implementar esta interfaz.
 */
public interface PaymentStrategy {
    void pay(double amount);
}
