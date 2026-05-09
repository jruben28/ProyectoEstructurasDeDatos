/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * AVLTreeTest.java
 * Clase de prueba de la clase AVLTree
 * @author joser
 */
public class AVLTreeTest {
    
   public AVLTreeTest() {
    }

    /**
     * Prueba del metodo insert(), de la clase AVLTree.
     * (Código original del documento)
     */
    @Test
    public void testInsert() {
        System.out.println("Prueba del metodo insert(), de la clase AVLTree");
        String expResult;
        String result;
        AVLTree<Integer> instance = new AVLTree<>();

        // Prueba de insertar datos
        instance.insert(8);
        expResult = "[(8, 1, 0), ]";
        result = instance.toString();
        assertEquals(expResult, result);

        instance.insert(2);
        expResult = "[(2, 1, 0), (8, 2, -1), ]";
        result = instance.toString();
        assertEquals(expResult, result);

        // Prueba de balanceo por rotacion a la derecha al desbalancearse
        // al insertar un nodo en el subarbol izquierdo
        instance.insert(1);
        expResult = "[(1, 1, 0), (2, 2, 0), (8, 1, 0), ]";
        result = instance.toString();
        assertEquals(expResult, result);

        instance.clear();

        instance.insert(1);
        instance.insert(2);
        // Prueba de balanceo por rotacion a la izquierda al desbalancearse
        // al insertar un nodo en el subarbol derecho
        instance.insert(8);
        expResult = "[(1, 1, 0), (2, 2, 0), (8, 1, 0), ]";
        result = instance.toString();
        assertEquals(expResult, result);

        instance.clear();

        instance.insert(8);
        instance.insert(2);
        // Prueba de balanceo por doble rotacion LR al desbalancearse
        // al insertar un nodo en el subarbol derecho del hijo izquierdo
        instance.insert(4);
        expResult = "[(2, 1, 0), (4, 2, 0), (8, 1, 0), ]";
        result = instance.toString();
        assertEquals(expResult, result);

        instance.clear();

        instance.insert(2);
        instance.insert(8);
        // Prueba de balanceo por doble rotacion RL al desbalancearse
        // al insertar un nodo en el subarbol izquierdo del hijo derecho
        instance.insert(4);
        expResult = "[(2, 1, 0), (4, 2, 0), (8, 1, 0), ]";
        result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo toString(), de la clase AVLTree.
     * (Código original del documento)
     */
    @Test
    public void testToString() {
        System.out.println("Prueba del metodo toString(), de la clase AVLTree");
        String expResult;
        String result;
        AVLTree<Integer> instance = new AVLTree<>();

        // Prueba cuando el arbol AVL esta vacio
        expResult = "[]";
        result = instance.toString();
        assertEquals(expResult, result);

        // Prueba cuando el arbol AVL no esta vacio
        instance.insert(8);
        expResult = "[(8, 1, 0), ]";
        result = instance.toString();
        assertEquals(expResult, result);

        instance.insert(2);
        expResult = "[(2, 1, 0), (8, 2, -1), ]";
        result = instance.toString();
        assertEquals(expResult, result);

        instance.insert(11);
        expResult = "[(2, 1, 0), (8, 2, 0), (11, 1, 0), ]";
        result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo remove(), de la clase AVLTree.
     * (NUEVO: Agregado para la Asignación 13)
     */
    @Test
    public void testRemove() {
        System.out.println("Prueba del metodo remove(), de la clase AVLTree");
        String expResult;
        String result;
        AVLTree<Integer> instance = new AVLTree<>();

        instance.insert(10);
        instance.insert(5);
        instance.insert(20);
        instance.insert(15);
        instance.insert(25);
        
        instance.remove(5);

        expResult = "[(10, 1, 0), (15, 3, 1), (20, 2, 1), (25, 1, 0), ]";
        result = instance.toString();
        assertEquals(expResult, result);

        instance.clear();
        
        instance.insert(10);
        instance.insert(5);
        instance.insert(20);
        
        instance.remove(10); 
        
        expResult = "[(5, 1, 0), (20, 2, -1), ]";
        result = instance.toString();
        assertEquals(expResult, result);
    
        instance.remove(99);
        result = instance.toString();
        assertEquals(expResult, result);
    }
}
