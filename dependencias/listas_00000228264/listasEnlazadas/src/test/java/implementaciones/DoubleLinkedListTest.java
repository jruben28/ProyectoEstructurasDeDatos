/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba de metodos de lista doblemente enlazada.
 * @author joser
 */
public class DoubleLinkedListTest {
    
     public DoubleLinkedListTest() {
    }

    /**
     * Prueba del metodo append(), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testAppend_Integer() {
        System.out.println("Prueba del metodo append(), de la clase DoubleLinkedList<Integer>");

        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        intList.append(10);
        intList.append(20);
        intList.append(30);

        String expResult = "[10, 20, 30]";
        String result = intList.toString();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo insert(), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testInsert_Integer() throws Exception {
        System.out.println("Prueba del metodo insert(), de la clase DoubleLinkedList<Integer>");

        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();

        // Prueba de insercion en una lista vacia
        intList.insert(10, 0);
        String expResult = "[10]";
        String result = intList.toString();
        assertEquals(expResult, result);

        // Prueba de insercion al inicio de una lista no vacia
        intList.insert(5, 0);
        expResult = "[5, 10]";
        result = intList.toString();
        assertEquals(expResult, result);

        // Prueba de insercion al final de una lista no vacia
        intList.insert(20, 2);
        expResult = "[5, 10, 20]";
        result = intList.toString();
        assertEquals(expResult, result);

        // Prueba de insercion en medio de una lista no vacia
        intList.insert(15, 2);
        expResult = "[5, 10, 15, 20]";
        result = intList.toString();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo get(), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testGet_Integer() throws Exception {
        System.out.println("Prueba del metodo get(), de la clase DoubleLinkedList<Integer>");

        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        intList.append(10);
        intList.append(20);
        intList.append(30);

        // Prueba de obtencion del primer elemento
        Integer expResult = 10;
        Integer result = intList.get(0);
        assertEquals(expResult, result);

        // Prueba de obtencion del ultimo elemento
        expResult = 30;
        result = intList.get(2);
        assertEquals(expResult, result);

        // Prueba de obtencion de un elemento del medio
        expResult = 20;
        result = intList.get(1);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo remove(), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testRemove_Integer() throws Exception {
        System.out.println("Prueba del metodo remove(), de la clase DoubleLinkedList<Integer>");
        Integer expResult;
        Integer result;
        String expStringResult;
        String stringResult;

        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        intList.append(10);
        intList.append(20);
        intList.append(30);
        intList.append(40);

        // Prueba de eliminacion del primer elemento
        expResult = 10;
        result = intList.remove(0);
        assertEquals(expResult, result);
        expStringResult = "[20, 30, 40]";
        stringResult = intList.toString();
        assertEquals(expStringResult, stringResult);

        // Prueba de eliminacion del ultimo elemento
        expResult = 40;
        result = intList.remove(2);
        assertEquals(expResult, result);
        expStringResult = "[20, 30]";
        stringResult = intList.toString();
        assertEquals(expStringResult, stringResult);

        // Prueba de eliminacion de un elemento del medio
        intList.append(40);
        expResult = 30;
        result = intList.remove(1);
        assertEquals(expResult, result);
        expStringResult = "[20, 40]";
        stringResult = intList.toString();
        assertEquals(expStringResult, stringResult);
    }

    /**
     * Prueba del metodo empty(), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testEmpty_Integer() {
        System.out.println("Prueba del metodo empty(), de la clase DoubleLinkedList<Integer>");
        boolean expResult;
        boolean result;

        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();

        // Prueba con una lista vacia
        result = intList.empty();
        assertTrue(result);

        // Prueba con una lista no vacia
        intList.append(10);
        result = intList.empty();
        assertFalse(result);
    }

    /**
     * Prueba del metodo size(), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testSize_Integer() {
        System.out.println("Prueba del metodo size(), de la clase DoubleLinkedList<Integer>");
        int expResult;
        int result;

        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();

        // Prueba con una lista vacia
        result = intList.size();
        expResult = 0;
        assertEquals(expResult, result);

        // Prueba con una lista no vacia
        intList.append(10);
        result = intList.size();
        expResult = 1;
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo iterator(), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testIterator_Integer() {
        System.out.println("Prueba del metodo iterator(), de la clase DoubleLinkedList<Integer>");

        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();

        Iterator result = intList.iterator();
        assertNotNull(result);
    }

    /**
     * Prueba del metodo toString(), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testToString_Integer() {
        System.out.println("Prueba del metodo toString(), de la clase DoubleLinkedList<Integer>");
        String expResult;
        String result;

        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();

        // Prueba con una lista vacia
        expResult = "[]";
        result = intList.toString();
        assertEquals(expResult, result);

        // Prueba con una lista con un elemento
        intList.append(10);
        expResult = "[10]";
        result = intList.toString();
        assertEquals(expResult, result);

        // Prueba con una lista con mas de un elemento
        intList.append(20);
        intList.append(30);
        expResult = "[10, 20, 30]";
        result = intList.toString();
        assertEquals(expResult, result);
    }
    
    // -------------------------------------------------------------------
    // Pruebas con una lista de cadenas
    // -------------------------------------------------------------------

    /**
     * Prueba del metodo append(), de la clase DoubleLinkedList<String>.
     */
    @Test
    public void testAppend_String() {
        System.out.println("Prueba del metodo append(), de la clase DoubleLinkedList<String>");

        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        strList.append("Hola");
        strList.append("a");
        strList.append("todos");

        String expResult = "[Hola, a, todos]";
        String result = strList.toString();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo insert(), de la clase DoubleLinkedList<String>.
     */
    @Test
    public void testInsert_String() throws Exception {
        System.out.println("Prueba del metodo insert(), de la clase DoubleLinkedList<String>");

        DoubleLinkedList<String> strList = new DoubleLinkedList<>();

        // Prueba de insercion en una lista vacia
        strList.insert("b", 0);
        String expResult = "[b]";
        String result = strList.toString();
        assertEquals(expResult, result);

        // Prueba de insercion al inicio de una lista no vacia
        strList.insert("a", 0);
        expResult = "[a, b]";
        result = strList.toString();
        assertEquals(expResult, result);

        // Prueba de insercion al final de una lista no vacia
        strList.insert("d", 2);
        expResult = "[a, b, d]";
        result = strList.toString();
        assertEquals(expResult, result);

        // Prueba de insercion en medio de una lista no vacia
        strList.insert("c", 2);
        expResult = "[a, b, c, d]";
        result = strList.toString();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo get(), de la clase DoubleLinkedList<String>.
     */
    @Test
    public void testGet_String() throws Exception {
        System.out.println("Prueba del metodo get(), de la clase DoubleLinkedList<String>");

        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        strList.append("Juan");
        strList.append("Pedro");
        strList.append("Maria");

        // Prueba de obtencion del primer elemento
        String expResult = "Juan";
        String result = strList.get(0);
        assertEquals(expResult, result);

        // Prueba de obtencion del ultimo elemento
        expResult = "Maria";
        result = strList.get(2);
        assertEquals(expResult, result);

        // Prueba de obtencion de un elemento del medio
        expResult = "Pedro";
        result = strList.get(1);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo remove(), de la clase DoubleLinkedList<String>.
     */
    @Test
    public void testRemove_String() throws Exception {
        System.out.println("Prueba del metodo remove(), de la clase DoubleLinkedList<String>");
        String expResult;
        String result;
        String expStringResult;
        String stringResult;

        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        strList.append("Juan");
        strList.append("Pedro");
        strList.append("Maria");
        strList.append("Jose");

        // Prueba de eliminacion del primer elemento
        expResult = "Juan";
        result = strList.remove(0);
        assertEquals(expResult, result);
        expStringResult = "[Pedro, Maria, Jose]";
        stringResult = strList.toString();
        assertEquals(expStringResult, stringResult);

        // Prueba de eliminacion del ultimo elemento
        expResult = "Jose";
        result = strList.remove(2);
        assertEquals(expResult, result);
        expStringResult = "[Pedro, Maria]";
        stringResult = strList.toString();
        assertEquals(expStringResult, stringResult);

        // Prueba de eliminacion de un elemento del medio
        strList.append("Jose");
        expResult = "Maria";
        result = strList.remove(1);
        assertEquals(expResult, result);
        expStringResult = "[Pedro, Jose]";
        stringResult = strList.toString();
        assertEquals(expStringResult, stringResult);
    }
    
    /**
     * Prueba del metodo empty(), de la clase DoubleLinkedList<String>.
     */
    @Test
    public void testEmpty_String() {
        System.out.println("Prueba del metodo empty(), de la clase DoubleLinkedList<String>");
        boolean expResult;
        boolean result;

        DoubleLinkedList<String> strList = new DoubleLinkedList<>();

        // Prueba con una lista vacia
        result = strList.empty();
        assertTrue(result);

        // Prueba con una lista no vacia
        strList.append("Alma");
        result = strList.empty();
        assertFalse(result);
    }

    /**
     * Prueba del metodo size(), de la clase DoubleLinkedList<String>.
     */
    @Test
    public void testSize_String() {
        System.out.println("Prueba del metodo size(), de la clase DoubleLinkedList<String>");
        int expResult;
        int result;
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();

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
     * Prueba del metodo iterator(), de la clase
     * DoubleLinkedList<String>.
     */
    @Test
    public void testIterator_String() {
        System.out.println("Prueba del metodo iterator(), de la clase DoubleLinkedList<String>");

        DoubleLinkedList<String> strList = new DoubleLinkedList<>();

        Iterator result = strList.iterator();
        assertNotNull(result);
    }

    /**
     * Prueba del metodo toString(), de la clase
     * DoubleLinkedList<String>.
     */
    @Test
    public void testToString_String() {
        System.out.println("Prueba del metodo toString(), de la clase DoubleLinkedList<String>");
        String expResult;
        String result;

        DoubleLinkedList<String> strList = new DoubleLinkedList<>();

        // Prueba con una lista vacia
        expResult = "[]";
        result = strList.toString();
        assertEquals(expResult, result);
    }
    
    
    
    //
    
    
    
    /**
     * Prueba del metodo removeLast(), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testRemoveLast_Integer() {
        System.out.println("Prueba del metodo removeLast(), de la clase DoubleLinkedList<Integer>");
        
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        intList.append(10);
        intList.append(20);
        intList.append(30);
        intList.append(20); // Elemento duplicado
        intList.append(40);
        
        boolean result = intList.removeLast(20);
        assertTrue(result);
        String expResult = "[10, 20, 30, 40]";
        assertEquals(expResult, intList.toString());
        assertEquals(4, intList.size());

        result = intList.removeLast(30);
        assertTrue(result);
        expResult = "[10, 20, 40]";
        assertEquals(expResult, intList.toString());


        result = intList.removeLast(40);
        assertTrue(result);
        expResult = "[10, 20]";
        assertEquals(expResult, intList.toString());


        result = intList.removeLast(10);
        assertTrue(result);
        expResult = "[20]";
        assertEquals(expResult, intList.toString());

        
        
        result = intList.removeLast(20);
        assertTrue(result);
        assertTrue(intList.empty());
    }
    
    
        /**
     * Prueba del metodo removeLast(), de la clase DoubleLinkedList<String>.
     */
    @Test
    public void testRemoveLast_String() {
        System.out.println("Prueba del metodo removeLast(), de la clase DoubleLinkedList<String>");
        
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        strList.append("Ana");
        strList.append("Luis");
        strList.append("Beto");
        strList.append("Luis"); // Elemento duplicado
        strList.append("Carlos");


        boolean result = strList.removeLast("Luis");
        assertTrue(result);
        String expResult = "[Ana, Luis, Beto, Carlos]";
        assertEquals(expResult, strList.toString());
        assertEquals(4, strList.size());


        result = strList.removeLast("Carlos");
        assertTrue(result);
        expResult = "[Ana, Luis, Beto]";
        assertEquals(expResult, strList.toString());


        result = strList.removeLast("Ana");
        assertTrue(result);
        expResult = "[Luis, Beto]";
        assertEquals(expResult, strList.toString());


        result = strList.removeLast("Zoe");
        assertFalse(result);
        expResult = "[Luis, Beto]";
        assertEquals(expResult, strList.toString());
    }
    
    /**
     * Prueba del metodo remove(T o), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testRemove_Object_Integer() throws Exception {
        System.out.println("Prueba del metodo remove(Object), de la clase DoubleLinkedList<Integer>");
        
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        intList.append(10);
        intList.append(20);
        intList.append(30);
        intList.append(20); // Elemento duplicado para probar que solo elimina el primero
        intList.append(40);


        boolean result = intList.remove(Integer.valueOf(20));
        assertTrue(result);
        String expResult = "[10, 30, 20, 40]";
        assertEquals(expResult, intList.toString());
        assertEquals(4, intList.size());


        result = intList.remove(Integer.valueOf(10));
        assertTrue(result);
        expResult = "[30, 20, 40]";
        assertEquals(expResult, intList.toString());


        result = intList.remove(Integer.valueOf(40));
        assertTrue(result);
        expResult = "[30, 20]";
        assertEquals(expResult, intList.toString());

       
        intList.remove(Integer.valueOf(30)); // Queda [20]
        result = intList.remove(Integer.valueOf(20)); // Queda []
        assertTrue(result);
        assertTrue(intList.empty());

        
    }
    
     /**
     * Prueba del metodo remove(T o), de la clase DoubleLinkedList<String>.
     */
    @Test
    public void testRemove_Object_String() throws Exception {
        System.out.println("Prueba del metodo remove(Object), de la clase DoubleLinkedList<String>");
        
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        strList.append("Ana");
        strList.append("Luis");
        strList.append("Beto");
        strList.append("Luis"); 
        strList.append("Carlos");


        boolean result = strList.remove("Luis");
        assertTrue(result);
        String expResult = "[Ana, Beto, Luis, Carlos]";
        assertEquals(expResult, strList.toString());
        assertEquals(4, strList.size());


        result = strList.remove("Beto");
        assertTrue(result);
        expResult = "[Ana, Luis, Carlos]";
        assertEquals(expResult, strList.toString());


        result = strList.remove("Ana");
        assertTrue(result);
        expResult = "[Luis, Carlos]";
        assertEquals(expResult, strList.toString());

        
        result = strList.remove("Zoe");
        assertFalse(result);
        expResult = "[Luis, Carlos]";
        assertEquals(expResult, strList.toString());
    }
    
     /**
     * Prueba del metodo indexOf(T o), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testIndexOf_Integer() {
        System.out.println("Prueba del metodo indexOf(Object), de la clase DoubleLinkedList<Integer>");
        
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        intList.append(10);
        intList.append(20);
        intList.append(30);
        intList.append(20); 
        intList.append(40);

        int expResult = 1;
        int result = intList.indexOf(Integer.valueOf(20));
        assertEquals(expResult, result);


        expResult = 0;
        result = intList.indexOf(Integer.valueOf(10));
        assertEquals(expResult, result);


        expResult = 4;
        result = intList.indexOf(Integer.valueOf(40));
        assertEquals(expResult, result);
        
        expResult = 2;
        result = intList.indexOf(Integer.valueOf(30));
        assertEquals(expResult, result);

        expResult = -1;
        result = intList.indexOf(Integer.valueOf(99));
        assertEquals(expResult, result);
        

        DoubleLinkedList<Integer> emptyList = new DoubleLinkedList<>();
        expResult = -1;
        result = emptyList.indexOf(Integer.valueOf(5));
        assertEquals(expResult, result);
    }
    
    /**
     * Prueba del metodo indexOf(T o), de la clase DoubleLinkedList<String>.
     */
    @Test
    public void testIndexOf_String() {
        System.out.println("Prueba del metodo indexOf(Object), de la clase DoubleLinkedList<String>");
        
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        strList.append("Ana");
        strList.append("Luis");
        strList.append("Beto");
        strList.append("Luis"); 
        strList.append(null); 
        strList.append("Carlos");

        int expResult = 1;
        int result = strList.indexOf("Luis");
        assertEquals(expResult, result);

        expResult = 0;
        result = strList.indexOf("Ana");
        assertEquals(expResult, result);
        
        expResult = 5;
        result = strList.indexOf("Carlos");
        assertEquals(expResult, result);
        
        expResult = -1;
        result = strList.indexOf("Zoe");
        assertEquals(expResult, result);

        expResult = 4;
        result = strList.indexOf(null);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Prueba del metodo clear(), de la clase DoubleLinkedList<Integer>.
     */
    @Test
    public void testClear_Integer() {
        System.out.println("Prueba del metodo clear(), de la clase DoubleLinkedList<Integer>");
        
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        intList.append(10);
        intList.append(20);
        intList.append(30);


        assertFalse(intList.empty());
        assertEquals(3, intList.size());
        

        intList.clear();
        

        assertTrue(intList.empty());
        assertEquals(0, intList.size());
        assertEquals("[]", intList.toString());
        

        intList.clear();
        assertTrue(intList.empty());
        assertEquals(0, intList.size());
    }
    
    /**
     * Prueba del metodo clear(), de la clase DoubleLinkedList<String>.
     */
    @Test
    public void testClear_String() {
        System.out.println("Prueba del metodo clear(), de la clase DoubleLinkedList<String>");
        
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        strList.append("A");
        strList.append("B");
        strList.append("C");


        assertFalse(strList.empty());
        assertEquals(3, strList.size());

        strList.clear();

        assertTrue(strList.empty());
        assertEquals(0, strList.size());
        assertEquals("[]", strList.toString());
        

        strList.clear();
        assertTrue(strList.empty());
        assertEquals(0, strList.size());
    }
}
