/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * HashDictionaryTest.java
 * Clase de prueba de la clase HashDictionary
 * @author mdomitsu
 */
public class HashDictionaryTest {

    public HashDictionaryTest() {
    }

    /**
     * Prueba del metodo put() de la clase HashDictionary.
     */
    @Test
    public void testPut() {
        System.out.println("Prueba del metodo put() de la clase HashDictionary");
        Integer expResult;
        Integer result;
        int resNumEntradas;
        int expNumEntradas;
        
        HashDictionary<String, Integer> instance = new HashDictionary<>(5);
        
        // Se agrega una entrada en un diccionario vacio
        result = instance.put("Alma", 20);
        assertNull(result);
        
        // Verificamos inserción
        assertEquals(20, instance.get("Alma"));
        
        expNumEntradas = 1;
        resNumEntradas = instance.size();
        assertEquals(expNumEntradas, resNumEntradas);
        
        // Se agrega una entrada en un diccionario no vacio
        result = instance.put("Bernardo", 25);
        assertNull(result);
        
        assertEquals(25, instance.get("Bernardo"));
        
        expNumEntradas = 2;
        resNumEntradas = instance.size();
        assertEquals(expNumEntradas, resNumEntradas);
        
        // Se agrega una entrada con una llave existente
        expResult = 20; // Valor anterior
        result = instance.put("Alma", 30);
        assertEquals(expResult, result);
        
        assertEquals(30, instance.get("Alma")); // Valor nuevo
        
        expNumEntradas = 2;
        resNumEntradas = instance.size();
        assertEquals(expNumEntradas, resNumEntradas);
    }

    /**
     * Prueba del metodo remove() de la clase HashDictionary.
     */
    @Test
    public void testRemove() {
        System.out.println("Prueba del metodo remove() de la clase HashDictionary");
        Integer result;
        Integer expResult;
        int resNumEntradas;
        int expNumEntradas;
        
        HashDictionary<String, Integer> instance = new HashDictionary<>(5);
        
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
     * Prueba del metodo size() de la clase HashDictionary.
     */
    @Test
    public void testSize() {
        System.out.println("Prueba del metodo size() de la clase HashDictionary");
        int resNumEntradas;
        int expNumEntradas;
        
        HashDictionary<String, Integer> instance = new HashDictionary<>(5);
        
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
     * Prueba del metodo empty() de la clase HashDictionary.
     */
    @Test
    public void testEmpty() {
        System.out.println("Prueba del metodo empty() de la clase HashDictionary");
        boolean result;
        
        HashDictionary<String, Integer> instance = new HashDictionary<>(5);
        
        // Se prueba con un diccionario vacio
        result = instance.empty();
        assertTrue(result);
        
        // Se prueba con un diccionario con una entrada
        instance.put("Alma", 20);
        result = instance.empty();
        assertFalse(result);
    }

    /**
     * Prueba del metodo toString() de la clase HashDictionary.
     */
    @Test
    public void testToString() {
        System.out.println("Prueba del metodo toString() de la clase HashDictionary");
        String result;
        String expResult;
        
        HashDictionary<String, Integer> instance = new HashDictionary<>(5);
        
        // Se prueba con un diccionario vacio
        expResult = "{}";
        result = instance.toString();
        assertEquals(expResult, result);
        
        // Se prueba con un diccionario no vacio
        instance.put("Alma", 20);
        instance.put("Saul", 15);
        
        result = instance.toString();
        // Verificación flexible (el orden en hash puede variar)
        assertTrue(result.contains("Alma:20"));
        assertTrue(result.contains("Saul:15"));
    }



    /**
     * Prueba del metodo get() con tipos String e Integer.
     */
    @Test
    public void testGet() {
        System.out.println("Prueba del metodo get() con tipos variados");
        
        HashDictionary<String, Integer> instanceStrInt = new HashDictionary<>(5);
        instanceStrInt.put("X", 100);
        assertEquals(100, instanceStrInt.get("X"));
        assertNull(instanceStrInt.get("Y"));

        HashDictionary<Integer, String> instanceIntStr = new HashDictionary<>(5);
        instanceIntStr.put(1, "Uno");
        instanceIntStr.put(2, "Dos");
        
        assertEquals("Uno", instanceIntStr.get(1));
        assertEquals("Dos", instanceIntStr.get(2));
        assertNull(instanceIntStr.get(3));
    }

    /**
     * Prueba del metodo contains() con tipos String e Integer.
     */
    @Test
    public void testContains() {
        System.out.println("Prueba del metodo contains() con tipos variados");
        
        HashDictionary<String, Integer> instanceStr = new HashDictionary<>(5);
        instanceStr.put("Hola", 1);
        assertTrue(instanceStr.contains("Hola"));
        assertFalse(instanceStr.contains("Mundo"));

        HashDictionary<Integer, String> instanceInt = new HashDictionary<>(5);
        instanceInt.put(99, "Nintenta y nueve");
        assertTrue(instanceInt.contains(99));
        assertFalse(instanceInt.contains(100));
    }

    /**
     * Prueba del metodo clear() con tipos String e Integer.
     */
    @Test
    public void testClear() {
        System.out.println("Prueba del metodo clear() con tipos variados");
        
        HashDictionary<String, Integer> instance1 = new HashDictionary<>(5);
        instance1.put("A", 1);
        instance1.clear();
        assertTrue(instance1.empty());
        assertEquals(0, instance1.size());

        HashDictionary<Integer, String> instance2 = new HashDictionary<>(5);
        instance2.put(10, "Diez");
        instance2.put(20, "Veinte");
        instance2.clear();
        assertTrue(instance2.empty());
        assertNull(instance2.get(10));
    }

    /**
     * Prueba del metodo keys() con tipos String e Integer.
     */
    @Test
    public void testKeys() {
        System.out.println("Prueba del metodo keys() con tipos variados");
        
        HashDictionary<String, Integer> instanceStr = new HashDictionary<>(5);
        instanceStr.put("A", 1);
        instanceStr.put("B", 2);
        
        LinkedList<String> llavesStr = instanceStr.keys();
        int countStr = 0;
        for (String k : llavesStr) {
            assertTrue(k.equals("A") || k.equals("B"));
            countStr++;
        }
        assertEquals(2, countStr);
        
        HashDictionary<Integer, String> instanceInt = new HashDictionary<>(5);
        instanceInt.put(100, "Cien");
        instanceInt.put(200, "Doscientos");
        
        LinkedList<Integer> llavesInt = instanceInt.keys();
        int countInt = 0;
        for (Integer k : llavesInt) {
            assertTrue(k.equals(100) || k.equals(200));
            countInt++;
        }
        assertEquals(2, countInt);
    }

    /**
     * Prueba del metodo values() con tipos String e Integer.
     */
    @Test
    public void testValues() {
        System.out.println("Prueba del metodo values() con tipos variados");
        
        HashDictionary<String, Integer> instanceStr = new HashDictionary<>(5);
        instanceStr.put("A", 1);
        instanceStr.put("B", 2);
        
        LinkedList<Integer> valoresInt = instanceStr.values();
        int countValInt = 0;
        for (Integer v : valoresInt) {
            assertTrue(v.equals(1) || v.equals(2));
            countValInt++;
        }
        assertEquals(2, countValInt);

        HashDictionary<Integer, String> instanceInt = new HashDictionary<>(5);
        instanceInt.put(1, "Uno");
        instanceInt.put(2, "Dos");
        
        LinkedList<String> valoresStr = instanceInt.values();
        int countValStr = 0;
        for (String v : valoresStr) {
            assertTrue(v.equals("Uno") || v.equals("Dos"));
            countValStr++;
        }
        assertEquals(2, countValStr);
    }
}