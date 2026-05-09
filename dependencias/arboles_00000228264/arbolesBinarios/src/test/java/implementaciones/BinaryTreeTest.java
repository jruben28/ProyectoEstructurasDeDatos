/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import excepciones.TreeException;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba de la clase BinaryTree
 * @author joser
 */
public class BinaryTreeTest {
    
    public BinaryTreeTest() {
    }

    /**
     * Prueba del metodo getRootData() de la clase BinaryTree.
     */
    @Test
    public void testGetRootData() {
        System.out.println("Prueba del metodo getRootData() de la clase BinaryTree");
        Integer expResult;
        Integer result;
        
        // Caso de un arbol vacio
        BinaryTree<Integer> intTree0 = new BinaryTree<>();
        Exception e = assertThrows(TreeException.class,
                () -> intTree0.getRootData());
        
        // Caso de un arbol con un nodo raiz
        BinaryTree<Integer> intTree1 = new BinaryTree<>(1);
        expResult = 1;
        result = intTree1.getRootData();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárbol izquierdo
        BinaryTree<Integer> intTree2 = new BinaryTree<>(2, intTree1,
                null);
        expResult = 2;
        result = intTree2.getRootData();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárbol derecho
        BinaryTree<Integer> intTree3 = new BinaryTree<>(3, null,
                intTree2);
        expResult = 3;
        result = intTree3.getRootData();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárboles izquierdo y derecho
        BinaryTree<Integer> intTree4 = new BinaryTree<>(4, intTree2,
                intTree3);
        expResult = 4;
        result = intTree4.getRootData();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo getHeight() de la clase BinaryTree.
     */
    @Test
    public void testGetHeight() {
        System.out.println("Prueba del metodo getHeight() de la clase BinaryTree");
        Integer expResult;
        Integer result;
        
        // Caso de un arbol vacio
        BinaryTree<Integer> intTree0 = new BinaryTree<>();
        expResult = 0;
        result = intTree0.getHeight();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz
        BinaryTree<Integer> intTree1 = new BinaryTree<>(1);
        expResult = 1;
        result = intTree1.getHeight();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárbol izquierdo
        BinaryTree<Integer> intTree2 = new BinaryTree<>(2, intTree1,
                null);
        expResult = 2;
        result = intTree2.getHeight();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárbol derecho
        BinaryTree<Integer> intTree3 = new BinaryTree<>(3, null,
                intTree2);
        expResult = 3;
        result = intTree3.getHeight();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárboles izquierdo y derecho
        BinaryTree<Integer> intTree4 = new BinaryTree<>(4, intTree2,
                intTree3);
        expResult = 4;
        result = intTree4.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo getNumberNodes() de la clase BinaryTree.
     */
    @Test
    public void testGetNumberNodes() {
        System.out.println("Prueba del metodo getNumberNodes() de la clase BinaryTree");
        Integer expResult;
        Integer result;
        
        // Caso de un arbol vacio
        BinaryTree<Integer> intTree0 = new BinaryTree<>();
        expResult = 0;
        result = intTree0.getNumberNodes();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz
        BinaryTree<Integer> intTree1 = new BinaryTree<>(1);
        expResult = 1;
        result = intTree1.getNumberNodes();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárbol izquierdo
        BinaryTree<Integer> intTree2 = new BinaryTree<>(2, intTree1,
                null);
        expResult = 2;
        result = intTree2.getNumberNodes();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárbol derecho
        BinaryTree<Integer> intTree3 = new BinaryTree<>(3, null,
                intTree2);
        expResult = 3;
        result = intTree3.getNumberNodes();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárboles izquierdo y derecho
        BinaryTree<Integer> intTree4 = new BinaryTree<>(4, intTree2,
                intTree3);
        expResult = 6;
        result = intTree4.getNumberNodes();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo empty() de la clase BinaryTree.
     */
    @Test
    public void testEmpty() {
        System.out.println("Prueba del metodo empty() de la clase BinaryTree");
        boolean result;
        
        // Caso de un arbol vacio
        BinaryTree<Integer> intTree0 = new BinaryTree<>();
        result = intTree0.empty();
        assertTrue(result);
        
        // Caso de un arbol con un nodo raiz
        BinaryTree<Integer> intTree1 = new BinaryTree<>(1);
        result = intTree1.empty();
        assertFalse(result);
    }

    /**
     * Prueba del metodo clear() de la clase BinaryTree.
     */
    @Test
    public void testClear() {
        System.out.println("Prueba del metodo clear() de la clase BinaryTree");
        boolean result;
        
        // Caso de un arbol vacio
        BinaryTree<Integer> intTree0 = new BinaryTree<>();
        intTree0.clear();
        result = intTree0.empty();
        assertTrue(result);
        
        // Caso de un arbol con un nodo raiz
        BinaryTree<Integer> intTree1 = new BinaryTree<>(1);
        intTree1.clear();
        result = intTree1.empty();
        assertTrue(result);
    }

    /**
     * Prueba del metodo getInorderIterator() de la clase
     * BinaryTree.
     */
    @Test
    public void testGetInorderIterator() {
        System.out.println("Prueba del metodo getInorderIterator() de la clase BinaryTree");
        BinaryTree<Integer> intTree = new BinaryTree<>();
        Iterator<Integer> result = intTree.getInorderIterator();
        assertNotNull(result);
    }

    /**
     * Prueba del metodo getToStringInOrder() de la clase
     * BinaryTree.
     */
    @Test
    public void testToStringInOrder() {
        System.out.println("Prueba del metodo getToStringInOrder() de la clase BinaryTree");
        String expResult;
        String result;
        
        // Caso de un arbol vacio
        BinaryTree<Integer> intTree0 = new BinaryTree<>();
        expResult = "[]";
        result = intTree0.toStringInOrder();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz
        BinaryTree<Integer> intTree1 = new BinaryTree<>(1);
        expResult = "[1]";
        result = intTree1.toStringInOrder();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárbol izquierdo
        BinaryTree<Integer> intTree2 = new BinaryTree<>(2, intTree1,
                null);
        expResult = "[1, 2]";
        result = intTree2.toStringInOrder();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárbol derecho
        BinaryTree<Integer> intTree3 = new BinaryTree<>(3, null,
                intTree2);
        expResult = "[3, 1, 2]";
        result = intTree3.toStringInOrder();
        assertEquals(expResult, result);
        
        // Caso de un arbol con un nodo raiz y subárboles izquierdo y derecho
        BinaryTree<Integer> intTree4 = new BinaryTree<>(4, intTree2,
                intTree3);
        expResult = "[1, 2, 4, 3, 1, 2]";
        result = intTree4.toStringInOrder();
        assertEquals(expResult, result);
    }
    
    /**
     * Prueba del metodo getPreorderIterator() de la clase
     * BinaryTree.
     */
    @Test
    public void testGetPreorderIterator() {
        System.out.println("Prueba del metodo getPreorderIterator() de la clase BinaryTree");
        BinaryTree<Integer> intTree = new BinaryTree<>();
        Iterator<Integer> result = intTree.getPreorderIterator();
        assertNotNull(result);
    }

    /**
     * Prueba del metodo getPostorderIterator() de la clase
     * BinaryTree.
     */
    @Test
    public void testGetPostorderIterator() {
        System.out.println("Prueba del metodo getPostorderIterator() de la clase BinaryTree");
        BinaryTree<Integer> intTree = new BinaryTree<>();
        Iterator<Integer> result = intTree.getPostorderIterator();
        assertNotNull(result);
    }

    /**
     * Prueba del recorrido Preorden usando el iterador.
     */
    @Test
    public void testToStringPreOrder() {
        System.out.println("Prueba del recorrido Preorden con iterador");
        String expResult;
        String result;
        
        BinaryTree<Integer> intTree1 = new BinaryTree<>(1);
        BinaryTree<Integer> intTree2 = new BinaryTree<>(2, intTree1, null);
        BinaryTree<Integer> intTree3 = new BinaryTree<>(3, null, intTree2);
        BinaryTree<Integer> intTree4 = new BinaryTree<>(4, intTree2, intTree3);

        BinaryTree<Integer> intTree0 = new BinaryTree<>();
        expResult = "[]";
        result = toStringFromIterator(intTree0.getPreorderIterator());
        assertEquals(expResult, result);
        
        expResult = "[1]";
        result = toStringFromIterator(intTree1.getPreorderIterator());
        assertEquals(expResult, result);
        
        expResult = "[4, 2, 1, 3, 2, 1]";
        result = toStringFromIterator(intTree4.getPreorderIterator());
        assertEquals(expResult, result);
    }

    /**
     * Prueba del recorrido Postorden usando el iterador.
     */
    @Test
    public void testToStringPostOrder() {
        System.out.println("Prueba del recorrido Postorden con iterador");
        String expResult;
        String result;
        
        BinaryTree<Integer> intTree1 = new BinaryTree<>(1);
        BinaryTree<Integer> intTree2 = new BinaryTree<>(2, intTree1, null);
        BinaryTree<Integer> intTree3 = new BinaryTree<>(3, null, intTree2);
        BinaryTree<Integer> intTree4 = new BinaryTree<>(4, intTree2, intTree3);

        BinaryTree<Integer> intTree0 = new BinaryTree<>();
        expResult = "[]";
        result = toStringFromIterator(intTree0.getPostorderIterator());
        assertEquals(expResult, result);
        
        expResult = "[1]";
        result = toStringFromIterator(intTree1.getPostorderIterator());
        assertEquals(expResult, result);
        
        expResult = "[1, 2, 1, 2, 3, 4]";
        result = toStringFromIterator(intTree4.getPostorderIterator());
        assertEquals(expResult, result);
    }

    /**
     * Método de utilidad (helper) para convertir un iterador en un String
     * con formato [e1, e2, e3].
     */
    private <T> String toStringFromIterator(Iterator<T> iter) {
        String s = "[";
        if (iter.hasNext()) {
            s += iter.next();
        }
        while (iter.hasNext()) {
            s += ", " + iter.next();
        }
        s += "]";
        return s;
    }
    
}
