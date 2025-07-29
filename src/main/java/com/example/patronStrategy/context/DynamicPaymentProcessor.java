package com.example.patronStrategy.context;

import com.example.patronStrategy.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Contexto: Utiliza una PaymentStrategy para procesar un pago.
 * La anotación @Service la registra como un bean de Spring en la capa de servicio.
 * Spring inyecta automáticamente un Map con todas las implementaciones de PaymentStrategy.
 */
@Service
public class DynamicPaymentProcessor {

    // Spring inyecta un mapa donde las claves son los nombres de los beans (@Component("nombre"))
    // y los valores son las instancias de las estrategias concretas.
    private final Map<String, PaymentStrategy> paymentStrategies;

    /**
     * Constructor para inyección de dependencias. Spring detecta este constructor
     * y le inyecta automáticamente el mapa de PaymentStrategy beans.
     * @param paymentStrategies Mapa de nombres de estrategia a instancias de estrategia.
     */
    public DynamicPaymentProcessor(Map<String, PaymentStrategy> paymentStrategies) {
        this.paymentStrategies = paymentStrategies;
    }

    /**
     * Procesa un pago seleccionando la estrategia adecuada en tiempo de ejecución.
     * @param paymentMethod El nombre de la estrategia de pago (ej. "creditCardPayment").
     * @param amount El monto a pagar.
     */
    public void processPayment(String paymentMethod, double amount) {
        // Obtenemos la estrategia específica del mapa usando el nombre del método de pago.
        PaymentStrategy strategy = paymentStrategies.get(paymentMethod);

        if (strategy == null) {
            throw new IllegalArgumentException("Método de pago no soportado: " + paymentMethod);
        }

        System.out.println("Iniciando procesamiento de pago con método: " + paymentMethod);
        strategy.pay(amount); // Delegamos la ejecución del algoritmo a la estrategia seleccionada.
        System.out.println("Procesamiento de pago finalizado.");
    }
}
