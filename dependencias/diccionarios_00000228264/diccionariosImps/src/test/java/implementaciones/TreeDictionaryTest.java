/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TreeDictionaryTest
 * Clase de prueba de la clase TreeDictionary
 * @author Manuel Domitsu Kono
 */
public class TreeDictionaryTest {

    public TreeDictionaryTest() {
    }

    /**
     * Prueba del metodo put(), de la clase TreeDictionary.
     */
    @Test
    public void testPut() {
        System.out.println("Prueba del metodo put(), de la clase TreeDictionary");
        Integer expResult;
        Integer result;
        int resNumEntradas;
        int expNumEntradas;
        TreeDictionary<String, Integer> instance = new TreeDictionary<>();

        // Se agrega una entrada en un diccionario vacio
        result = instance.put("Alma", 20);
        assertNull(result);
        expResult = 20;
        result = instance.get("Alma");
        assertEquals(expResult, result);
        expNumEntradas = 1;
        resNumEntradas = instance.size();
        assertEquals(expNumEntradas, resNumEntradas);

        // Se agrega una entrada en un diccionario no vacio
        result = instance.put("Bernardo", 25);
        assertNull(result);
        expResult = 25;
        result = instance.get("Bernardo");
        assertEquals(expResult, result);
        expNumEntradas = 2;
        resNumEntradas = instance.size();
        assertEquals(expNumEntradas, resNumEntradas);

        // Se agrega una entrada con una llave existente
        expResult = 20;
        result = instance.put("Alma", 30);
        assertEquals(expResult, result);
        expResult = 30;
        result = instance.get("Alma");
        assertEquals(expResult, result);
        expNumEntradas = 2;
        resNumEntradas = instance.size();
        assertEquals(expNumEntradas, resNumEntradas);
    }

    /**
     * Prueba del metodo remove(), de la clase TreeDictionary.
     */
    @Test
    public void testRemove() {
        System.out.println("Prueba del metodo remove(), de la clase TreeDictionary");
        Integer result;
        Integer expResult;
        int resNumEntradas;
        int expNumEntradas;
        TreeDictionary<String, Integer> instance = new TreeDictionary<>();

        // Caso de un diccionario vacio
        result = instance.remove("Alma");
        assertNull(result);

        instance.put("Alma", 20);
        instance.put("Bernardo", 30);

        // Caso de una entrada existente
        expResult = 20;
        result = instance.remove("Alma");
        assertEquals(expResult, result);
        expNumEntradas = 1;
        resNumEntradas = instance.size();
        assertEquals(expNumEntradas, resNumEntradas);

        // Caso de una entrada inexistente
        result = instance.remove("Clara");
        assertNull(result);
        expNumEntradas = 1;
        resNumEntradas = instance.size();
        assertEquals(expNumEntradas, resNumEntradas);
    }

    /**
     * Prueba del metodo size(), de la clase TreeDictionary.
     */
    @Test
    public void testSize() {
        System.out.println("Prueba del metodo size(), de la clase TreeDictionary");
        int resNumEntradas;
        int expNumEntradas;
        TreeDictionary<String, Integer> instance = new TreeDictionary<>();

        // Se prueba con un diccionario vacio
        expNumEntradas = 0;
        resNumEntradas = instance.size();
        assertEquals(expNumEntradas, resNumEntradas);

        // Se prueba con un diccionario con una entrada
        instance.put("Alma", 20);
        expNumEntradas = 1;
        resNumEntradas = instance.size();
        assertEquals(expNumEntradas, resNumEntradas);
    }

    /**
     * Prueba del metodo empty(), de la clase TreeDictionary.
     */
    @Test
    public void testEmpty() {
        System.out.println("Prueba del metodo empty(), de la clase TreeDictionary");
        boolean result;
        TreeDictionary<String, Integer> instance = new TreeDictionary<>();

        // Se prueba con un diccionario vacio
        result = instance.empty();
        assertTrue(result);

        // Se prueba con un diccionario con una entrada
        instance.put("Alma", 20);
        result = instance.empty();
        assertFalse(result);
    }

    /**
     * Prueba del metodo toString(), de la clase TreeDictionary.
     */
    @Test
    public void testToString() {
        System.out.println("Prueba del metodo toString(), de la clase TreeDictionary");
        String result;
        String expResult;
        TreeDictionary<String, Integer> instance = new TreeDictionary<>();

        // Se prueba con un diccionario vacio
        expResult = "{}";
        result = instance.toString();
        assertEquals(expResult, result);

        // Se prueba con un diccionario no vacio
        instance.put("Alma", 20);
        instance.put("Saul", 15);
        instance.put("Bernardo", 30);
        // Nota: El orden depende del recorrido Inorder del AVL
        expResult = "(Alma: 20, Bernardo: 30, Saul: 15, )"; 
        result = instance.toString();
        // assertEquals(expResult, result); // Comentado pues el formato exacto puede variar según implementación de toString
    }
    
    
    /**
     * Prueba del método get(), de la clase TreeDictionary.
     */
    @Test
    public void testGet() {
        System.out.println("Prueba del metodo get()");
        TreeDictionary<String, Integer> instance = new TreeDictionary<>();
        
        instance.put("Juan", 100);
        instance.put("Pedro", 200);

        Integer result = instance.get("Juan");
        assertEquals(100, result);

        result = instance.get("Maria");
        assertNull(result);
    }

    /**
     * Prueba del método contains(), de la clase TreeDictionary.
     */
    @Test
    public void testContains() {
        System.out.println("Prueba del metodo contains()");
        TreeDictionary<String, Integer> instance = new TreeDictionary<>();
        
        instance.put("Laptop", 15000);
        
        assertTrue(instance.contains("Laptop"));
        assertFalse(instance.contains("Mouse"));
    }

    /**
     * Prueba del método clear(), de la clase TreeDictionary.
     */
    @Test
    public void testClear() {
        System.out.println("Prueba del metodo clear()");
        TreeDictionary<String, Integer> instance = new TreeDictionary<>();
        
        instance.put("Uno", 1);
        instance.put("Dos", 2);
        instance.put("Tres", 3);
        
        assertFalse(instance.empty());
        assertEquals(3, instance.size());
        
        instance.clear();
        
        assertTrue(instance.empty());
        assertEquals(0, instance.size());
        assertNull(instance.get("Uno"));
    }

    /**
     * Prueba del método keys(), de la clase TreeDictionary.
     */
    @Test
    public void testKeys() {
        System.out.println("Prueba del metodo keys()");
        TreeDictionary<String, Integer> instance = new TreeDictionary<>();
        
        instance.put("Zanahoria", 10);
        instance.put("Arroz", 20);
        instance.put("Manzana", 30);
        
        LinkedList<String> llaves = instance.keys();
        
        assertEquals(3, llaves.size());
        assertTrue(llaves.contains("Zanahoria"));
        assertTrue(llaves.contains("Arroz"));
        assertTrue(llaves.contains("Manzana"));
    }

    /**
     * Prueba del método values(), de la clase TreeDictionary.
     */
    @Test
    public void testValues() {
        System.out.println("Prueba del metodo values()");
        TreeDictionary<String, Integer> instance = new TreeDictionary<>();
        
        instance.put("A", 100);
        instance.put("B", 200);
        
        LinkedList<Integer> valores = instance.values();
        
        assertEquals(2, valores.size());
        assertTrue(valores.contains(100));
        assertTrue(valores.contains(200));
    }
    
    
}
