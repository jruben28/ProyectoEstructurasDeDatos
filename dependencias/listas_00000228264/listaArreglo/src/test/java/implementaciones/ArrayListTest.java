/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import excepciones.ListException;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author joser
 */
public class ArrayListTest {
    
    public ArrayListTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Prueba del metodo append(), de la clase ArrayList
     */
    @Test
    public void testAppend_Integer() {
        System.out.println("Prueba del metodo append(), de la clase ArrayList<Integer>");
        ArrayList<Integer> intList = new ArrayList<>(Integer.class, 5);
        try {
            // Prueba de insercion de un dato
            intList.append(10);
            assertEquals("[10]", intList.toString());
            // Prueba de insercion de un segundo dato
            intList.append(20);
            assertEquals("[10, 20]", intList.toString());
        } catch (ListException e) {
            fail("Fallo la prueba: " + e.getMessage());
        }
    }
    
    /**
     * Prueba del metodo insert(), de la clase ArrayList.
     */
    @Test
    public void testInsert_Integer() {
        System.out.println("Prueba del metodo insert(), de la clase ArrayList<Integer>");
        ArrayList<Integer> intList = new ArrayList<>(Integer.class, 5);
        try {
            // Prueba de insercion de un dato al principio
            intList.insert(10, 0);
            assertEquals("[10]", intList.toString());
            // Prueba de insercion de un segundo dato al principio
            intList.insert(20, 0);
            assertEquals("[20, 10]", intList.toString());
            // Prueba de insercion de un dato al final
            intList.insert(30, 2);
            assertEquals("[20, 10, 30]", intList.toString());
            // Prueba de insercion de un dato en medio
            intList.insert(40, 1);
            assertEquals("[20, 40, 10, 30]", intList.toString());
        } catch (ListException e) {
            fail("Fallo la prueba: " + e.getMessage());
        }
    }

    /**
     * Prueba del metodo get(), de la clase ArrayList.
     */
    @Test
    public void testGet_Integer() {
        System.out.println("Prueba del metodo get(), de la clase ArrayList<Integer>");
        Integer expResult;
        Integer result;
        ArrayList<Integer> intList = new ArrayList<>(Integer.class, 5);
        try {
            intList.append(10);
            intList.append(20);
            // Prueba de obtener el primer dato
            expResult = 10;
            result = intList.get(0);
            assertEquals(expResult, result);
            // Prueba de obtener el ultimo dato
            expResult = 20;
            result = intList.get(1);
            assertEquals(expResult, result);
        } catch (ListException e) {
            fail("Fallo la prueba: " + e.getMessage());
        }
    }
    
    /**
     * Prueba del metodo remove(), de la clase ArrayList.
     */
    @Test
    public void testRemove_Integer() {
        System.out.println("Prueba del metodo remove(), de la clase ArrayList<Integer>");
        ArrayList<Integer> intList = new ArrayList<>(Integer.class, 5);
        try {
            intList.append(10);
            intList.append(20);
            intList.append(30);
            intList.append(40);
            // Prueba de eliminar el del final
            intList.remove(3);
            assertEquals("[10, 20, 30]", intList.toString());
            // Prueba de eliminar el primero
            intList.remove(0);
            assertEquals("[20, 30]", intList.toString());
            // Prueba de eliminar el de en medio
            intList.append(40);
            intList.remove(1);
            assertEquals("[20, 40]", intList.toString());
        } catch (ListException e) {
            fail("Fallo la prueba: " + e.getMessage());
        }
    }
    
    /**
     * Prueba del metodo empty(), de la clase ArrayList.
     */
    @Test
    public void testEmpty_String() {
        System.out.println("Prueba del metodo empty(), de la clase ArrayList<String>");
        boolean expResult;
        boolean result;
        ArrayList<String> strList = new ArrayList<>(String.class, 5);
        // Prueba con una lista vacia
        result = strList.empty();
        expResult = true;
        assertEquals(expResult, result);
        // Prueba con una lista no vacia
        strList.append("Alma");
        result = strList.empty();
        expResult = false;
        assertEquals(expResult, result);
    }
    
    /**
     * Prueba del metodo size(), de la clase ArrayList.
     */
    @Test
    public void testSize_String() {
        System.out.println("Prueba del metodo size(), de la clase ArrayList<String>");
        int expResult;
        int result;
        ArrayList<String> strList = new ArrayList<>(String.class, 5);
        // Prueba con una lista vacia
        result = strList.size();
        expResult = 0;
        assertEquals(expResult, result);
        // Prueba con una lista no vacia
        strList.append("Alma");
        result = strList.size();
        expResult = 1;
        assertEquals(expResult, result);
    }
    
    /**
     * Prueba del metodo iterator(), de la clase ArrayListString.
     */
    @Test
    public void testIterator_String() {
        System.out.println("Prueba del metodo iterator(), de la clase ArrayList<String>");
        ArrayList<String> strList = new ArrayList<>(String.class, 5);
        Iterator result = strList.iterator();
        assertNotNull(result);
    }
    
    /**
     * Prueba del metodo toString(), de la clase ArrayList<String.
     */
    @Test
    public void testToString_String() {
        System.out.println("Prueba del metodo toString(), de la clase ArrayList<String>");
        String expResult;
        String result;
        ArrayList<String> strList = new ArrayList<>(String.class, 5);
        // Prueba con una lista vacia
        expResult = "[]";
        result = strList.toString();
        assertEquals(expResult, result);
        // Prueba con una lista con un dato
        strList.append("A");
        expResult = "[A]";
        result = strList.toString();
        assertEquals(expResult, result);
        // Prueba con una lista con dos datos
        strList.append("B");
        expResult = "[A, B]";
        result = strList.toString();
        assertEquals(expResult, result);
    }
    
    //-----------------------------------------

    private ArrayList<String> listaNuevasPruebas;
    
    /**
     * Set up para las pruebas donde inicializamod una lista con tamaño para 5 elementos
     */
    @BeforeEach
    void setUpNuevasPruebas() {
        listaNuevasPruebas = new ArrayList<>(String.class, 5);
    }

    /**
     * prueba del metodo clear con una lista con elementos
     * @throws ListException 
     */
    @Test
    @DisplayName("clear() en lista poblada la deja vacía")
    void testClear_ConElementos() throws ListException {
        listaNuevasPruebas.append("A");
        listaNuevasPruebas.append("B");
        
        assertFalse(listaNuevasPruebas.empty()); // Nos aseguramos de que no está vacía
        
        listaNuevasPruebas.clear();
        
        assertEquals(0, listaNuevasPruebas.size(), "El tamaño debería ser 0 después de clear()");
        assertTrue(listaNuevasPruebas.empty(), "La lista debería estar vacía después de clear()");
    }

    /**
     * prueba para el metodo clear con una lista vacia
     */
    @Test
    @DisplayName("clear() en lista ya vacía no produce error")
    void testClear_ListaVacia() {
        assertTrue(listaNuevasPruebas.empty());
        
        listaNuevasPruebas.clear(); // No debería lanzar ninguna excepción
        
        assertEquals(0, listaNuevasPruebas.size());
        assertTrue(listaNuevasPruebas.empty());
    }

    /**
     * prueba del metodo indexOf en un elemento que si Existe
     * @throws ListException 
     */
    @Test
    @DisplayName("indexOf() encuentra el índice de un elemento existente")
    void testIndexOf_ElementoExistente() throws ListException {
        listaNuevasPruebas.append("Manzana");
        listaNuevasPruebas.append("Pera");
        listaNuevasPruebas.append("Naranja");
        
        assertEquals(1, listaNuevasPruebas.indexOf("Pera"), "Debería encontrar 'Pera' en el índice 1");
    }

    /**
     * prueba del metodo indexOf con un elemento no existente
     * @throws ListException 
     */
    @Test
    @DisplayName("indexOf() devuelve -1 para un elemento que no existe")
    void testIndexOf_ElementoNoExistente() throws ListException {
        listaNuevasPruebas.append("Manzana");
        listaNuevasPruebas.append("Pera");
        
        assertEquals(-1, listaNuevasPruebas.indexOf("Uva"), "No debería encontrar 'Uva'");
    }
    
    /**
     * prueba del metodo remove con elementos existentes
     * @throws ListException 
     */
    @Test
    @DisplayName("remove(T o) elimina un elemento existente y devuelve true")
    void testRemoveObject_ElementoExistente() throws ListException {
        listaNuevasPruebas.append("A");
        listaNuevasPruebas.append("B");
        listaNuevasPruebas.append("C");
        
        assertEquals(3, listaNuevasPruebas.size());
        assertTrue(listaNuevasPruebas.remove("B"), "Debería devolver true al eliminar 'B'");
        assertEquals(2, listaNuevasPruebas.size(), "El tamaño debería disminuir a 2");
        assertEquals(-1, listaNuevasPruebas.indexOf("B"), "'B' ya no debería estar en la lista");
        assertEquals("C", listaNuevasPruebas.get(1), "El elemento 'C' debería haberse movido a la posición 1");
    }

    /**
     * prueba del metodo remove con elementos no existentes
     * @throws ListException 
     */
    @Test
    @DisplayName("remove(T o) no hace nada y devuelve false si el elemento no existe")
    void testRemoveObject_ElementoNoExistente() throws ListException {
        listaNuevasPruebas.append("A");
        listaNuevasPruebas.append("B");

        assertFalse(listaNuevasPruebas.remove("C"), "Debería devolver false al intentar eliminar 'C'");
        assertEquals(2, listaNuevasPruebas.size(), "El tamaño de la lista no debería cambiar");
    }
    

    @Test
    @DisplayName("set() reemplaza correctamente un elemento en un índice válido")
    void testSet_IndiceValido() throws ListException {
        listaNuevasPruebas.append("Original");
        listaNuevasPruebas.append("Otro");
        
        listaNuevasPruebas.set("Reemplazado", 0);
        
        assertEquals("Reemplazado", listaNuevasPruebas.get(0), "El elemento en el índice 0 debería ser 'Reemplazado'");
        assertEquals(2, listaNuevasPruebas.size(), "El tamaño no debería cambiar después de set()");
    }
    
    @Test
    @DisplayName("set() lanza ListException para índice negativo")
    void testSet_IndiceNegativo() {
        listaNuevasPruebas.append("A");
        
        assertThrows(ListException.class, () -> {
            listaNuevasPruebas.set("B", -1);
        }, "Debería lanzar ListException para un índice negativo");
    }
    
    @Test
    @DisplayName("set() lanza ListException para índice igual al tamaño")
    void testSet_IndiceIgualAlTamano() {
        listaNuevasPruebas.append("A"); 
        
        assertThrows(ListException.class, () -> {
            listaNuevasPruebas.set("B", 1);
        }, "Debería lanzar ListException para un índice igual al tamaño");
    }
    
    @Test
    @DisplayName("set() lanza ListException en una lista vacía")
    void testSet_ListaVacia() {
         assertThrows(ListException.class, () -> {
            listaNuevasPruebas.set("A", 0);
        }, "Debería lanzar ListException al usar set() en una lista vacía");
    }
}
