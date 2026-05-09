/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author joser
 */
public class LinkedListTest {
    
    public LinkedListTest() {
    }
    //nota: en la documentación tuve que quitar las <> en la declaracion de clase
    //de LinkedList, dado que al generar el JavaDoc lo detectaba como declaraciones
    //HTML y daba error al querer generarlo.
    
    /**
     * Prueba del metodo append(), de la clase
     * LinkedList
     */
    @Test
    public void testAppend_Integer() {
        System.out.println("Prueba del metodo append(), de la clase LinkedList<Integer>");
        Integer o;
        int i;
        Integer expResult;
        Integer result;
        LinkedList<Integer> intList = new LinkedList<>();

        // Prueba en una lista vacía
        o = 10;
        i = 0;
        intList.append(o);
        expResult = 10;
        result = intList.get(i);
        assertEquals(expResult, result);

        // Prueba en una lista no vacía
        o = 20;
        i = 1;
        intList.append(o);
        expResult = 20;
        result = intList.get(i);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo insert(), de la clase
     * LinkedList.
     */
    @Test
    public void testInsert_Integer() {
        System.out.println("Prueba del metodo insert(), de la clase LinkedList<Integer>");
        Integer o;
        int i;
        Integer expResult;
        Integer result;
        LinkedList<Integer> intList = new LinkedList<>();
        intList.append(10);
        intList.append(30);

        // Prueba insertando un elemento en medio de la lista
        o = 20;
        i = 1;
        intList.insert(o, i);
        expResult = 20;
        result = intList.get(i);
        assertEquals(expResult, result);

        // Prueba insertando un elemento al inicio de la lista
        o = 0;
        i = 0;
        intList.insert(o, i);
        expResult = 0;
        result = intList.get(i);
        assertEquals(expResult, result);

        // Prueba insertando un elemento al final de la lista
        o = 40;
        i = 4;
        intList.insert(o, i);
        expResult = 40;
        result = intList.get(i);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo get(), de la clase
     * LinkedList.
     */
    @Test
    public void testGet_Integer() {
        System.out.println("Prueba del metodo get(), de la clase LinkedList<Integer>");
        int i;
        Integer expResult;
        Integer result;
        LinkedList<Integer> intList = new LinkedList<>();
        intList.append(10);
        intList.append(20);
        intList.append(30);

        // Prueba obteniendo el primer elemento de la lista
        i = 0;
        expResult = 10;
        result = intList.get(i);
        assertEquals(expResult, result);

        // Prueba obteniendo el ultimo elemento de la lista
        i = 2;
        expResult = 30;
        result = intList.get(i);
        assertEquals(expResult, result);

        // Prueba obteniendo un elemento en medio de la lista
        i = 1;
        expResult = 20;
        result = intList.get(i);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo remove(), de la clase
     * LinkedList.
     */
    @Test
    public void testRemove_Integer() {
        System.out.println("Prueba del metodo remove(), de la clase LinkedList<Integer>");
        int i;
        Integer expResult;
        Integer result;
        LinkedList<Integer> intList = new LinkedList<>();
        intList.append(10);
        intList.append(20);
        intList.append(30);

        // Prueba removiendo un elemento en medio de la lista
        i = 1;
        expResult = 20;
        result = intList.remove(i);
        assertEquals(expResult, result);
        expResult = 30;
        result = intList.get(i);
        assertEquals(expResult, result);
        
        // Prueba removiendo el primer elemento de la lista
        i = 0;
        expResult = 10;
        result = intList.remove(i);
        assertEquals(expResult, result);

        // Prueba removiendo el ultimo elemento de la lista
        i = 0;
        expResult = 30;
        result = intList.remove(i);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo empty(), de la clase
     * LinkedList.
     */
    @Test
    public void testEmpty_Integer() {
        System.out.println("Prueba del metodo empty(), de la clase LinkedList<Integer>");
        boolean expResult;
        boolean result;
        LinkedList<Integer> intList = new LinkedList<>();

        // Prueba con una lista vacia
        expResult = true;
        result = intList.empty();
        assertEquals(expResult, result);

        // Prueba con una lista no vacia
        intList.append(10);
        expResult = false;
        result = intList.empty();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo size(), de la clase
     * LinkedList.
     */
    @Test
    public void testSize_Integer() {
        System.out.println("Prueba del metodo size(), de la clase LinkedList<Integer>");
        int expResult;
        int result;
        LinkedList<Integer> intList = new LinkedList<>();

        // Prueba con una lista vacia
        expResult = 0;
        result = intList.size();
        assertEquals(expResult, result);

        // Prueba con una lista no vacia
        intList.append(10);
        expResult = 1;
        result = intList.size();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo iterator(), de la clase
     * LinkedList.
     */
    @Test
    public void testIterator_Integer() {
        System.out.println("Prueba del metodo iterator(), de la clase LinkedList<Integer>");
        LinkedList<Integer> intList = new LinkedList<>();
        Iterator result = intList.iterator();
        assertNotNull(result);
    }

    /**
     * Prueba del metodo toString(), de la clase
     * LinkedList.
     */
    @Test
    public void testToString_Integer() {
        System.out.println("Prueba del metodo toString(), de la clase LinkedList<Integer>");
        String expResult;
        String result;
        LinkedList<Integer> intList = new LinkedList<>();

        // Prueba con una lista vacia
        expResult = "[]";
        result = intList.toString();
        assertEquals(expResult, result);

        // Prueba con una lista con un elemento
        intList.append(10);
        expResult = "[10]";
        result = intList.toString();
        assertEquals(expResult, result);

        // Prueba con una lista con varios elementos
        intList.append(20);
        intList.append(30);
        expResult = "[10, 20, 30]";
        result = intList.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Prueba para el método set(int i, T o) de tipo void.
     */
    @Test
    public void testSet_void() {
        System.out.println("Prueba del metodo set(int, T)");
        LinkedList<String> lista = new LinkedList<>();
        lista.append("A");
        lista.append("B");
        lista.append("C");
        
        lista.set("Z", 1);
        
        assertEquals(3, lista.size());
        assertEquals("A", lista.get(0));
        assertEquals("Z", lista.get(1));
        assertEquals("C", lista.get(2));
    }

    /**
     * Prueba para el método remove(T o).
     */
    @Test
    public void testRemove_Object() {
        System.out.println("Prueba del metodo remove(T)");
        LinkedList<String> lista = new LinkedList<>();
        lista.append("A");
        lista.append("B");
        lista.append("C");
        
        assertTrue(lista.remove("B"));
        assertEquals(2, lista.size());
        assertEquals("[A, C]", lista.toString());
        assertFalse(lista.remove("Z"));
        assertEquals(2, lista.size());
        assertTrue(lista.remove("A"));
        assertEquals(1, lista.size());
        assertEquals("[C]", lista.toString());
        assertTrue(lista.remove("C"));
        assertEquals(0, lista.size());
        assertTrue(lista.empty());
    }

    /**
     * Prueba para el método indexOf(T o).
     */
    @Test
    public void testIndexOf() {
        System.out.println("Prueba del metodo indexOf(T)");
        LinkedList<String> lista = new LinkedList<>();
        lista.append("A");
        lista.append("B");
        lista.append("C");
        lista.append("B"); // Elemento duplicado

        assertEquals(0, lista.indexOf("A"));
        assertEquals(2, lista.indexOf("C"));
        assertEquals(1, lista.indexOf("B"));
    }

    /**
     * Prueba para el método clear().
     */
    @Test
    public void testClear() {
        System.out.println("Prueba del metodo clear()");
        LinkedList<Integer> lista = new LinkedList<>();
        lista.append(100);
        lista.append(200);
        
        assertFalse(lista.empty());
        
        lista.clear();
        assertTrue(lista.empty());
        assertEquals(0, lista.size());
    }
}
