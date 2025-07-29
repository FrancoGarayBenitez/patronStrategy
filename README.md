# Patrón Strategy con Spring Boot: Procesamiento de Pagos

Este proyecto es un ejemplo práctico de cómo implementar el **Patrón Strategy** utilizando el framework **Spring Boot**. El objetivo principal es demostrar cómo gestionar de forma flexible y extensible diferentes **algoritmos de procesamiento de pagos**.

---

## ¿Qué es el Patrón Strategy?

El Patrón Strategy es un patrón de diseño de comportamiento que permite definir una **familia de algoritmos**, **encapsular** cada uno de ellos y hacerlos **intercambiables**. Esto significa que el algoritmo que un cliente utiliza puede variar independientemente del cliente mismo, promoviendo la flexibilidad y la facilidad de extensión.

---

## Conceptos Clave del Patrón Strategy

* **Familia de Algoritmos:** Un conjunto de algoritmos que resuelven una tarea similar o relacionada (ej. "procesar un pago"), pero cada uno con una implementación diferente (ej. "pago con tarjeta", "pago con PayPal").
* **Encapsulamiento:** Cada algoritmo específico se encapsula en su propia clase separada, facilitando su gestión y modificación aislada.
* **Intercambiables:** La posibilidad de cambiar el algoritmo en uso en tiempo de ejecución (o en tiempo de configuración) sin necesidad de modificar el código del cliente que lo utiliza.

---

## Lo Logrado con este Ejemplo Práctico

Este proyecto implementa el patrón Strategy para manejar distintos métodos de pago en una aplicación Spring Boot:

1.  **`PaymentStrategy` (Interfaz Strategy):** Define el contrato común (`pay(amount)`) que todas las formas de pago deben seguir.
2.  **Estrategias Concretas (`CreditCardPayment`, `PayPalPayment`, `BankTransferPayment`):** Cada clase implementa el algoritmo específico para un método de pago. Están anotadas con `@Component` para ser gestionadas como **beans** por el contenedor de Spring.
3.  **`DynamicPaymentProcessor` (Contexto):** Esta clase es el "cliente" que utiliza las estrategias. En lugar de tener una lógica `if/else` compleja, Spring le **inyecta** automáticamente un `Map` de todas las `PaymentStrategy` disponibles. Esto permite al procesador seleccionar dinámicamente la estrategia correcta en tiempo de ejecución basándose en el nombre del método de pago.

### Beneficios Demostrados:

* **Flexibilidad:** Se pueden añadir nuevos métodos de pago simplemente creando una nueva clase `PaymentStrategy` sin modificar el código existente del `DynamicPaymentProcessor`.
* **Mantenibilidad:** La lógica para cada método de pago está contenida en su propia clase, haciendo el código más limpio y fácil de mantener.
* **Reducción de Condicionales:** Evita grandes bloques `if/else` o `switch` para seleccionar el algoritmo, lo que simplifica el código del contexto.
* **Facilidad de Pruebas:** Cada estrategia puede ser probada de forma aislada.

---

## Cómo Ejecutar el Proyecto

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/spring-strategy-payments.git](https://github.com/tu-usuario/spring-strategy-payments.git)
    cd spring-strategy-payments
    ```
2.  **Abrir en IntelliJ IDEA:**
    * Abre IntelliJ IDEA y selecciona "Open" o "Import Project".
    * Navega hasta el directorio `spring-strategy-payments` que acabas de clonar y ábrelo como un proyecto Maven/Gradle.
3.  **Ejecutar la aplicación:**
    * Ejecuta la clase `Application.java` (botón derecho > `Run 'Application.main()'`).
    * Verás la salida en la consola demostrando cómo se procesan los pagos con diferentes estrategias.

---

## Dependencias (Generadas con Spring Initializr)

Este proyecto fue generado con Spring Initializr e incluye las siguientes dependencias básicas:

* **`spring-boot-starter-web`**: Para construir aplicaciones web y usar Spring MVC.
* **`lombok`**: Para reducir el boilerplate code (getters, setters, constructores, etc.).
* **`spring-boot-devtools`**: Para mejorar la experiencia de desarrollo (reinicio automático, recarga en caliente).

---

¡Explora el código y experimenta añadiendo nuevas estrategias de pago!
