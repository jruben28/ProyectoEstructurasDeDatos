/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import excepciones.QueueException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author joser
 */
public class CircularQueueTest {
    
   private CircularQueue<Integer> integerQueue;
    private CircularQueue<String> stringQueue;
    private final int CAPACIDAD = 5;

    /**
     * Prepara nuevas instancias de la cola circular antes de cada prueba
     * para asegurar la independencia entre los tests.
     */
    @BeforeEach
    void setUp() {
        integerQueue = new CircularQueue<>(CAPACIDAD);
        stringQueue = new CircularQueue<>(CAPACIDAD);
    }


    /**
     * Prueba que una cola recién creada esté vacía.
     */
    @Test
    void testIntegerNuevaColaEstaVacia() {
        assertTrue(integerQueue.empty(), "Una cola nueva debería estar vacía.");
        assertEquals("[]", integerQueue.toString(), "El toString de una cola vacía debe ser [].");
    }

    /**
     * Prueba que se lance una QueueException al intentar hacer dequeue en una cola vacía.
     */
    @Test
    void testIntegerDequeueEnColaVaciaLanzaExcepcion() {
        assertThrows(QueueException.class, () -> {
            integerQueue.dequeue();
        }, "Hacer dequeue en una cola vacía debería lanzar una QueueException.");
    }

    /**
     * Prueba que se lance una QueueException al intentar hacer peek en una cola vacía.
     */
    @Test
    void testIntegerPeekEnColaVaciaLanzaExcepcion() {
        assertThrows(QueueException.class, () -> {
            integerQueue.peek();
        }, "Hacer peek en una cola vacía debería lanzar una QueueException.");
    }

    /**
     * Prueba las operaciones básicas de encolar y consultar (peek).
     */
    @Test
    void testIntegerEnqueueYPeek() throws QueueException {
        integerQueue.enqueue(10);
        assertFalse(integerQueue.empty(), "La cola no debería estar vacía después de encolar.");
        assertEquals(10, integerQueue.peek(), "Peek debería retornar el primer elemento encolado.");

        integerQueue.enqueue(20);
        assertEquals(10, integerQueue.peek(), "Peek debería seguir retornando el primer elemento (10).");
    }

    /**
     * Prueba la secuencia de encolar y desencolar para verificar el orden FIFO.
     */
    @Test
    void testIntegerDequeueOrdenCorrecto() throws QueueException {
        integerQueue.enqueue(10);
        integerQueue.enqueue(20);
        integerQueue.enqueue(30);

        assertEquals(10, integerQueue.dequeue(), "El primer dequeue debe ser el primer elemento encolado.");
        assertEquals(20, integerQueue.dequeue(), "El segundo dequeue debe ser el segundo elemento encolado.");
        assertEquals(30, integerQueue.peek(), "Peek ahora debe apuntar al tercer elemento (30).");
        assertEquals(30, integerQueue.dequeue(), "El tercer dequeue debe ser el tercer elemento.");
        assertTrue(integerQueue.empty(), "La cola debe estar vacía después de desencolar todos los elementos.");
    }

    /**
     * Prueba que se lance una QueueException al intentar encolar en una cola llena.
     */
    @Test
    void testIntegerEnqueueEnColaLlenaLanzaExcepcion() throws QueueException {
        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);
        integerQueue.enqueue(4);
        integerQueue.enqueue(5);

        assertThrows(QueueException.class, () -> {
            integerQueue.enqueue(6);
        }, "Encolar en una cola llena debería lanzar una QueueException.");
    }

    /**
     * Prueba el comportamiento circular de la cola.
     * Se llena la cola, se vacían algunas posiciones y se vuelven a llenar,
     * verificando que se reutilicen los espacios al inicio del arreglo.
     */
    @Test
    void testIntegerComportamientoCircular() throws QueueException {
        for (int i = 1; i <= 5; i++) {
            integerQueue.enqueue(i * 10);
        }

        assertEquals(10, integerQueue.dequeue());
        assertEquals(20, integerQueue.dequeue());
        assertEquals(30, integerQueue.peek());
        
        integerQueue.enqueue(60);
        integerQueue.enqueue(70);

        assertEquals(30, integerQueue.peek(), "El frente no debe cambiar después de encolar al final.");
        
        assertEquals("[30, 40, 50, 60, 70]", integerQueue.toString());

        assertEquals(30, integerQueue.dequeue());
        assertEquals(40, integerQueue.dequeue());
        assertEquals(50, integerQueue.dequeue());
        assertEquals(60, integerQueue.dequeue());
        assertEquals(70, integerQueue.dequeue());
        assertTrue(integerQueue.empty(), "La cola debe estar vacía al final.");
    }
    
    /**
     * Prueba el método toString en diferentes estados de la cola.
     */
    @Test
    void testIntegerToString() throws QueueException {
        assertEquals("[]", integerQueue.toString(), "toString de cola vacía.");
        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        assertEquals("[1, 2]", integerQueue.toString(), "toString de cola con elementos.");
        integerQueue.dequeue();
        integerQueue.enqueue(3);
        assertEquals("[2, 3]", integerQueue.toString(), "toString después de dequeue y enqueue.");
    }


    /**
     * Prueba que una cola de Strings recién creada esté vacía.
     */
    @Test
    void testStringNuevaColaEstaVacia() {
        assertTrue(stringQueue.empty(), "Una cola nueva de String debería estar vacía.");
    }

    /**
     * Prueba que se lance una QueueException al intentar hacer dequeue en una cola de Strings vacía.
     */
    @Test
    void testStringDequeueEnColaVaciaLanzaExcepcion() {
        assertThrows(QueueException.class, () -> {
            stringQueue.dequeue();
        }, "Dequeue en cola de String vacía debería lanzar QueueException.");
    }

    /**
     * Prueba la secuencia de encolar y desencolar para verificar el orden FIFO con Strings.
     */
    @Test
    void testStringEnqueueYDequeue() throws QueueException {
        stringQueue.enqueue("Hola");
        stringQueue.enqueue("Mundo");

        assertEquals("Hola", stringQueue.peek(), "Peek debería retornar 'Hola'.");
        assertEquals("Hola", stringQueue.dequeue(), "El primer dequeue debe ser 'Hola'.");
        assertEquals("Mundo", stringQueue.dequeue(), "El segundo dequeue debe ser 'Mundo'.");
        assertTrue(stringQueue.empty(), "La cola de String debe quedar vacía.");
    }

    /**
     * Prueba el comportamiento circular con una cola de Strings.
     */
    @Test
    void testStringComportamientoCircular() throws QueueException {
        stringQueue.enqueue("A");
        stringQueue.enqueue("B");
        stringQueue.enqueue("C");
        stringQueue.enqueue("D");
        stringQueue.enqueue("E");

        assertEquals("A", stringQueue.dequeue());
        assertEquals("B", stringQueue.dequeue());
        
        stringQueue.enqueue("F");
        stringQueue.enqueue("G");

        assertEquals("[C, D, E, F, G]", stringQueue.toString(), "El estado de la cola circular debe ser correcto.");
        assertEquals("C", stringQueue.peek(), "El frente debe ser 'C'.");
    }
    
}
