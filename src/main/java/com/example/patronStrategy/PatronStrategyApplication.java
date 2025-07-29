package com.example.patronStrategy;

import com.example.patronStrategy.context.DynamicPaymentProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PatronStrategyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatronStrategyApplication.class, args);
	}

	/**
	 * Un bean CommandLineRunner se ejecuta una vez que la aplicación Spring Boot ha arrancado.
	 * Lo usamos aquí para demostrar el uso del DynamicPaymentProcessor.
	 * @param context El contexto de la aplicación Spring, para obtener beans.
	 */
	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			// Obtenemos una instancia de nuestro DynamicPaymentProcessor del contexto de Spring.
			DynamicPaymentProcessor dynamicProcessor = context.getBean(DynamicPaymentProcessor.class);

			System.out.println("\n--- Procesando pago con Tarjeta de Crédito ---");
			// Llamamos al procesador, especificando qué estrategia usar por su nombre de bean.
			dynamicProcessor.processPayment("creditCardPayment", 100.0);

			System.out.println("\n--- Procesando pago con PayPal ---");
			dynamicProcessor.processPayment("payPalPayment", 50.0);

			System.out.println("\n--- Procesando pago con Transferencia Bancaria ---");
			dynamicProcessor.processPayment("bankTransferPayment", 200.0);

			// Intentando usar un método de pago que no existe.
			try {
				System.out.println("\n--- Procesando pago con Bitcoin (no soportado) ---");
				dynamicProcessor.processPayment("bitcoinPayment", 300.0);
			} catch (IllegalArgumentException e) {
				System.out.println("Error esperado: " + e.getMessage());
			}
		};
	}
}
