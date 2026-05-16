/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba de los metodos de LinkedListDictionary
 * @author joser
 */
public class LinkedListDictionaryTest {
    public LinkedListDictionaryTest() {
    }

    /**
     * Prueba del metodo put(), de la clase LinkedListDictionary.
     */
    @Test
    public void testPut() {
        System.out.println("Prueba del metodo put(), de la clase LinkedListDictionary");
        Integer expResult;
        Integer result;
        int resNumEntradas;
        int expNumEntradas;
        
        LinkedListDictionary<String, Integer> instance = new LinkedListDictionary<>();
        
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
     * Prueba del metodo remove(), de la clase LinkedListDictionary.
     */
    @Test
    public void testRemove() {
        System.out.println("Prueba del metodo remove(), de la clase LinkedListDictionary");
        Integer result;
        Integer expResult;
        int resNumEntradas;
        int expNumEntradas;
        
        LinkedListDictionary<String, Integer> instance = new LinkedListDictionary<>();
        
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
     * Prueba del metodo size(), de la clase LinkedListDictionary.
     */
    @Test
    public void testSize() {
        System.out.println("Prueba del metodo size(), de la clase LinkedListDictionary");
        int resNumEntradas;
        int expNumEntradas;
        
        LinkedListDictionary<String, Integer> instance = new LinkedListDictionary<>();
        
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
     * Prueba del metodo empty(), de la clase LinkedListDictionary.
     */
    @Test
    public void testEmpty() {
        System.out.println("Prueba del metodo empty(), de la clase LinkedListDictionary");
        boolean result;
        
        LinkedListDictionary<String, Integer> instance = new LinkedListDictionary<>();
        
        // Se prueba con un diccionario vacio
        result = instance.empty();
        assertTrue(result);
        
        // Se prueba con un diccionario con una entrada
        instance.put("Alma", 20);
        result = instance.empty();
        assertFalse(result);
    }

    /**
     * Prueba del metodo toString(), de la clase LinkedListDictionary.
     */
    @Test
    public void testToString() {
        System.out.println("Prueba del metodo toString(), de la clase LinkedListDictionary");
        String result;
        String expResult;
        
        LinkedListDictionary<String, Integer> instance = new LinkedListDictionary<>();
        
        // Se prueba con un diccionario vacio
        expResult = "{}";
        result = instance.toString();
        assertEquals(expResult, result);
        
        // Se prueba con un diccionario no vacio
        instance.put("Alma", 20);
        instance.put("Saul", 15);
        instance.put("Bernardo", 30);
        
        // Nota: El orden depende de cómo inserte tu lista ligada (al inicio o final)
        // El documento original mostraba esto, ajusta si tu lista inserta al revés
        expResult = "{Alma: 20, Saul: 15, Bernardo: 30, }"; 
        result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Prueba del método get(K llave).
     */
    @Test
    public void testGet() {
        System.out.println("Prueba del método get");
        LinkedListDictionary<String, Integer> instance = new LinkedListDictionary<>();
        
        assertNull(instance.get("Desconocido"));
        
        instance.put("Juan", 100);
        instance.put("Ana", 200);
        Integer resultado = instance.get("Juan");
        assertEquals(Integer.valueOf(100), resultado);

        assertNull(instance.get("Pedro"));
    }

    /**
     * Prueba del método contains(K llave).
     */
    @Test
    public void testContains() {
        System.out.println("Prueba del método contains");
        LinkedListDictionary<String, Integer> instance = new LinkedListDictionary<>();

        assertFalse(instance.contains("Hola"));

        instance.put("Manzana", 1);
        instance.put("Pera", 2);

        assertTrue(instance.contains("Manzana"));

        assertFalse(instance.contains("Uva"));
    }

    /**
     * Prueba del método clear().
     */
    @Test
    public void testClear() {
        System.out.println("Prueba del método clear");
        LinkedListDictionary<String, Integer> instance = new LinkedListDictionary<>();

        instance.put("A", 1);
        instance.put("B", 2);
        instance.put("C", 3);

        assertFalse(instance.empty());
        assertEquals(3, instance.size());

        instance.clear();

        assertTrue(instance.empty());
        
        assertEquals(0, instance.size());
        
        assertNull(instance.get("A"));
    }

    /**
     * Prueba del método keys().
     */
    @Test
    public void testKeys() {
        System.out.println("Prueba del método keys");
        LinkedListDictionary<String, Integer> instance = new LinkedListDictionary<>();

        instance.put("Rojo", 10);
        instance.put("Verde", 20);

        LinkedList<String> llaves = instance.keys();

        assertNotNull(llaves);

        String llavesString = llaves.toString(); 

        assertTrue(llavesString.contains("Rojo"));
        assertTrue(llavesString.contains("Verde"));
    }

    /**
     * Prueba del método values().
     */
    @Test
    public void testValues() {
        System.out.println("Prueba del método values");
        LinkedListDictionary<String, Integer> instance = new LinkedListDictionary<>();

        instance.put("Uno", 1);
        instance.put("Dos", 2);

        LinkedList<Integer> valores = instance.values();

        assertNotNull(valores);

        String valoresString = valores.toString();
        assertTrue(valoresString.contains("1"));
        assertTrue(valoresString.contains("2"));
    }
    
}
