/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import excepciones.QueueException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author joser
 */
public class ArrayListQueueTest {
    
   public ArrayListQueueTest() {
    }

    /**
     * Prueba del metodo enqueue(), de la clase
     * ArrayListQueue<Integer>.
     */
    @Test
    public void testEnqueue_Integer() {
        System.out.println("Prueba del metodo enqueue(), de la clase ArrayListQueue<Integer>");
        ArrayListQueue<Integer> intQueue = new ArrayListQueue<>(Integer.class, 5);
        
        // Prueba que se agrega a la cola
        intQueue.enqueue(0);
        assertEquals(0, intQueue.peek());
        
        intQueue.enqueue(1);
        // El primer elemento debe seguir siendo 0
        assertEquals(0, intQueue.peek());

        // Llena la cola
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        
        // Prueba que el primer elemento sigue siendo 0
        assertEquals(0, intQueue.peek());

        // Prueba que lanza una excepción si la cola esta llena
        Exception e = assertThrows(QueueException.class, () -> {
            intQueue.enqueue(5);
        });
        assertEquals("Cola llena", e.getMessage());
    }

    /**
     * Prueba del metodo dequeue(), de la clase
     * ArrayListQueue<Integer>.
     */
    @Test
    public void testDequeue_Integer() {
        System.out.println("Prueba del metodo dequeue(), de la clase ArrayListQueue<Integer>");
        ArrayListQueue<Integer> intQueue = new ArrayListQueue<>(Integer.class, 5);

        // Prueba que lanza una excepción si la cola esta vacia
        Exception e = assertThrows(QueueException.class, () -> {
            intQueue.dequeue();
        });
         assertEquals("Cola vacia", e.getMessage());

        // Prueba que se extrajo de la cola en el orden correcto
        intQueue.enqueue(0);
        intQueue.enqueue(1);
        intQueue.enqueue(2);

        assertEquals(0, intQueue.dequeue());
        assertEquals(1, intQueue.dequeue());
        assertEquals(2, intQueue.dequeue());
    }

    /**
     * Prueba del metodo peek(), de la clase
     * ArrayListQueue<Integer>.
     */
    @Test
    public void testPeek_Integer() {
        System.out.println("Prueba del metodo peek(), de la clase ArrayListQueue<Integer>");
        ArrayListQueue<Integer> intQueue = new ArrayListQueue<>(Integer.class, 5);

        // Prueba que lanza una excepción si la cola esta vacia
        Exception e = assertThrows(QueueException.class, () -> {
            intQueue.peek();
        });
         assertEquals("Cola vacia", e.getMessage());

        // Prueba que se inspecciono el frente de la cola
        intQueue.enqueue(0);
        assertEquals(0, intQueue.peek());
        
        intQueue.enqueue(1);
        // El frente no debe cambiar
        assertEquals(0, intQueue.peek());

        // Saca un elemento y prueba el nuevo frente
        intQueue.dequeue();
        assertEquals(1, intQueue.peek());
    }

    /**
     * Prueba del metodo enqueue(), de la clase
     * ArrayListQueue<String>.
     */
    @Test
    public void testEnqueue_String() {
        System.out.println("Prueba del metodo enqueue(), de la clase ArrayListQueue<String>");
        ArrayListQueue<String> strQueue = new ArrayListQueue<>(String.class, 5);

        // Prueba que se agrega a la cola
        strQueue.enqueue("Alma");
        assertEquals("Alma", strQueue.peek());
        
        strQueue.enqueue("Bernardo");
        assertEquals("Alma", strQueue.peek());

        // Llena la cola
        strQueue.enqueue("Clara");
        strQueue.enqueue("David");
        strQueue.enqueue("Eva");
        
        assertEquals("Alma", strQueue.peek());

        // Prueba que lanza una excepción si la cola esta llena
        Exception e = assertThrows(QueueException.class, () -> {
            strQueue.enqueue("Felipe");
        });
        assertEquals("Cola llena", e.getMessage());
    }

    /**
     * Prueba del metodo dequeue(), de la clase
     * ArrayListQueue<String>.
     */
    @Test
    public void testDequeue_String() {
        System.out.println("Prueba del metodo dequeue(), de la clase ArrayListQueue<String>");
        ArrayListQueue<String> strQueue = new ArrayListQueue<>(String.class, 5);
        
        // Prueba que lanza una excepción si la cola esta vacia
        Exception e = assertThrows(QueueException.class, () -> {
            strQueue.dequeue();
        });
        assertEquals("Cola vacia", e.getMessage());

        // Prueba que se extrajo de la cola en el orden correcto
        strQueue.enqueue("Alma");
        strQueue.enqueue("Bernardo");
        strQueue.enqueue("Clara");

        assertEquals("Alma", strQueue.dequeue());
        assertEquals("Bernardo", strQueue.dequeue());
        assertEquals("Clara", strQueue.dequeue());
    }

    /**
     * Prueba del metodo peek(), de la clase
     * ArrayListQueue<String>.
     */
    @Test
    public void testPeek_String() {
        System.out.println("Prueba del metodo peek(), de la clase ArrayListQueue<String>");
        ArrayListQueue<String> strQueue = new ArrayListQueue<>(String.class, 5);
        
        // Prueba que lanza una excepción si la cola esta vacia
        Exception e = assertThrows(QueueException.class, () -> {
            strQueue.peek();
        });
        assertEquals("Cola vacia", e.getMessage());

        // Prueba que se inspecciono el frente de la cola
        strQueue.enqueue("Alma");
        assertEquals("Alma", strQueue.peek());
        
        strQueue.enqueue("Bernardo");
        assertEquals("Alma", strQueue.peek());

        // Saca un elemento y prueba el nuevo frente
        strQueue.dequeue();
        assertEquals("Bernardo", strQueue.peek());
    }
    
}
