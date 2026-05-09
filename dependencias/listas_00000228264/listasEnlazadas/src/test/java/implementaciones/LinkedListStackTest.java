/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import excepciones.StackException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba de la clase LinkedListStack
 * @author joser
 */
public class LinkedListStackTest {
    
    public LinkedListStackTest() {
    }

    /**
     * Prueba del metodo push(), de la clase
     * LinkedListStack< Integer >.
     */
    @Test
    public void testPush_Integer() {
        System.out.println("Prueba del metodo push(), de la clase LinkedListStack< Integer >");
        Integer expResult;
        Integer result;
        LinkedListStack<Integer> intStack = new LinkedListStack<>();
        // Prueba que se agrega a la pila
        intStack.push(0);
        expResult = 0;
        result = intStack.peek();
        assertEquals (expResult, result);
        intStack.push(1);
        expResult = 1;
        result = intStack.peek();
        assertEquals (expResult, result);
        // Llena la pila
        intStack.push(2);
        intStack.push (3);
        intStack.push(4);
        expResult = 4;
        result = intStack.peek();
        assertEquals (expResult, result);
    }

    /**
     * Prueba del metodo pop(), de la clase
     * LinkedListStack< Integer >.
     */
    @Test
    public void testPop_Integer() {
        System.out.println("Prueba del metodo pop(), de la clase LinkedListStack< Integer >");
        Integer expResult;
        Integer result;
        LinkedListStack<Integer> intStack = new LinkedListStack<>();
        // Prueba que lanza una excepción si la pila esta vacia
        Exception e = assertThrows (StackException.class,
        () -> intStack.pop());
        // Prueba que se extrajo de la pila
        intStack.push(0);
        expResult = 0;
        result = intStack.pop();
        assertEquals (expResult, result);
        intStack.push (1);
        expResult = 1;
        result = intStack.pop();
        assertEquals (expResult, result);
        // Llena la pila
        intStack.push(2);
        intStack.push (3);
        intStack.push(4);
        expResult = 4;
        result = intStack.pop();
        assertEquals (expResult, result);
    }

    /**
     * Prueba del metodo peek(), de la clase
     * LinkedListStack< Integer >.
     */
    @Test
    public void testPeek_Integer() {
        System.out.println("Prueba del metodo peek(), de la clase LinkedListStack< Integer >");
        Integer expResult;
        Integer result;
        LinkedListStack<Integer> intStack = new LinkedListStack<>();
        // Prueba que lanza una excepción si la pila esta vacia
        Exception e = assertThrows(StackException.class,
        () -> intStack.peek());
        // Prueba que se inspecciono el tope de la pila
        intStack.push(0);
        expResult = 0;
        result = intStack.peek();
        assertEquals(expResult, result);
        intStack.push(1);
        expResult = 1;
        result = intStack.peek();
        assertEquals(expResult, result);
        // Llena la pila
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        expResult = 4;
        result = intStack.peek();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo push(), de la clase
     * LinkedListStack< String >.
     */
    @Test
    public void testPush_String() {
        System.out.println("Prueba del metodo push(), de la clase LinkedListStack< String >");
        String expResult;
        String result;
        LinkedListStack<String> strStack = new LinkedListStack<>();
        // Prueba que se agrega a la pila
        strStack.push("Alma");
        expResult = "Alma";
        result = strStack.peek();
        assertEquals(expResult, result);
        strStack.push("Bernardo");
        expResult = "Bernardo";
        result = strStack.peek();
        assertEquals(expResult, result);
        // Llena la pila
        strStack.push("Clara");
        strStack.push("David");
        strStack.push("Eva");
        expResult = "Eva";
        result = strStack.peek();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo pop(), de la clase
     * LinkedListStack< String >.
     */
    @Test
    public void testPop_String() {
        System.out.println("Prueba del metodo pop(), de la clase LinkedListStack< String >");
        String expResult;
        String result;
        LinkedListStack<String> strStack = new LinkedListStack<>();
        // Prueba que lanza una excepción si la pila esta vacia
        Exception e = assertThrows(StackException.class,
        () -> strStack.pop());
        // Prueba que se extrajo de la pila
        strStack.push("Alma");
        expResult = "Alma";
        result = strStack.pop();
        assertEquals(expResult, result);
        strStack.push("Bernardo");
        expResult = "Bernardo";
        result = strStack.pop();
        assertEquals(expResult, result);
        // Llena la pila
        strStack.push("Clara");
        strStack.push("David");
        strStack.push("Eva");
        expResult = "Eva";
        result = strStack.pop();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo peek(), de la clase
     * LinkedListStack< String >.
     */
    @Test
    public void testPeek_String() {
        System.out.println("Prueba del metodo peek(), de la clase LinkedListStack< String >");
        String expResult;
        String result;
        LinkedListStack<String> strStack = new LinkedListStack<>();
        // Prueba que lanza una excepción si la pila esta vacia
        Exception e = assertThrows(StackException.class,
        () -> strStack.peek());
        // Prueba que se inspecciono el tope de la pila
        strStack.push("Alma");
        expResult = "Alma";
        result = strStack.peek();
        assertEquals(expResult, result);
        strStack.push("Bernardo");
        expResult = "Bernardo";
        result = strStack.peek();
        assertEquals(expResult, result);
        // Llena la pila
        strStack.push("Clara");
        strStack.push("David");
        strStack.push("Eva");
        expResult = "Eva";
        result = strStack.peek();
        assertEquals(expResult, result);
    }
    
}
