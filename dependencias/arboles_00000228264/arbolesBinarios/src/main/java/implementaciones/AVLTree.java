/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

/**
 * AVLTree.java
 * Esta clase implementa un arbol AVL generico
 * @param <T> Parámetro de tipo para los objetos a almacenarse en el arbol
 * @author joser
 */
public class AVLTree<T extends Comparable<T>>
extends BinarySearchTree<T>{
    public AVLTree() {
        super();
    }

    /**
     * Driver para el metodo recursivo para agregar un nodo a un arbol AVL
     * @param dato Dato del nodo a agregar al arbol
     */
    @Override
    public void insert(T dato) {
        raiz = insert(raiz, dato);
    }

    /**
     * Metodo recursivo para agregar un nodo a un arbol AVL
     * @param nodo Subarbol al que se le agrega recursivamente el nodo
     * @param dato Dato del nodo a agregar al subarbol
     * @return Subarbol al que se le agrego recursivamente el nodo
     */
    private NodoArbolBinario<T> insert(NodoArbolBinario<T> nodo, T dato) {
        // Caso base: Si el subarbol es vacio, regresa el nodo a agregar
        if (nodo == null) {
            return new NodoArbolBinario<>(dato);
        }

        // Casos recursivos: Se determina a que subarbol se agregara el nodo
        if (dato.compareTo(nodo.dato) < 0) {
            nodo.hijoIzq = insert(nodo.hijoIzq, dato);
        } else {
            nodo.hijoDer = insert(nodo.hijoDer, dato);
        }

        return rebalance(nodo);
    }

    /**
     * Este metodo balancea un arbol AVL que se desbalancea al agregar o eliminar un nodo 
     * mediante una rotacion a la derecha, izquierda, doble RL o doble LR.
     * @param nodo raiz del subarbol en el que se detecta el desbalance.
     * @return El nodo raiz del subarbol una vez balanceado
     */
    private NodoArbolBinario<T> rebalance(NodoArbolBinario<T> nodo) {
        int factorBalance = balanceFactor(nodo);

        if (factorBalance < -1) {
            if (balanceFactor(nodo.hijoIzq) < 0) {
                nodo = rotateRight(nodo);
            } else {
                nodo = rotateLeftRight(nodo);
            }
        } else if (factorBalance > 1) {
            if (balanceFactor(nodo.hijoDer) > 0) {
                nodo = rotateLeft(nodo);
            } else {
                nodo = rotateRightLeft(nodo);
            }
        }
        // El nodo esta balanceado
        return nodo;
    }

    /**
     * Obtiene el factor de balance de un nodo de un arbol AVL,
     * la altura del nodo hijo derecho menos altura del nodo hijo izquierdo.
     * @param nodo Nodo del que se desea el factor de balance
     * @return El factor de balance del nodo
     */
    private int balanceFactor(NodoArbolBinario<T> nodo) {
        if (nodo == null) return 0;
        return getHeight(nodo.hijoDer) - getHeight(nodo.hijoIzq);
    }

    /**
     * Balancea el subarbol con el nodo del parametro como raiz mediante una rotacion a la derecha
     * @param nodo Nodo raiz del subarbol a balancear
     * @return El nodo raiz del subarbol balanceado
     */
    private NodoArbolBinario<T> rotateRight(NodoArbolBinario<T> nodo) {
        NodoArbolBinario<T> nodoT = nodo.hijoIzq;
        nodo.hijoIzq = nodoT.hijoDer;
        nodoT.hijoDer = nodo;
        return nodoT;
    }

    /**
     * Balancea el subarbol con el nodo del parametro como raiz mediante una rotacion a la izquierda
     * @param nodo Nodo raiz del subarbol a balancear
     * @return El nodo raiz del subarbol balanceado
     */
    private NodoArbolBinario<T> rotateLeft(NodoArbolBinario<T> nodo) {
        NodoArbolBinario<T> nodoT = nodo.hijoDer;
        nodo.hijoDer = nodoT.hijoIzq;
        nodoT.hijoIzq = nodo;
        return nodoT;
    }

    /**
     * Balancea el subarbol con el nodo del parametro como raiz mediante una doble rotacion LR
     * @param nodo Nodo raiz del subarbol a balancear
     * @return El nodo raiz del subarbol balanceado
     */
    private NodoArbolBinario<T> rotateLeftRight(NodoArbolBinario<T> nodo) {
        NodoArbolBinario<T> nodoT = nodo.hijoIzq;
        nodo.hijoIzq = rotateLeft(nodoT);
        return rotateRight(nodo);
    }

    /**
     * Balancea el subarbol con el nodo del parametro como raiz mediante una doble rotacion RL
     * @param nodo Nodo raiz del subarbol a balancear
     * @return El nodo raiz del subarbol balanceado
     */
    private NodoArbolBinario<T> rotateRightLeft(NodoArbolBinario<T> nodo) {
        NodoArbolBinario<T> nodoT = nodo.hijoDer;
        nodo.hijoDer = rotateRight(nodoT);
        return rotateLeft(nodo);
    }

    /**
     * Este metodo regresa una cadena con los datos y las alturas de los nodos del arbol en orden
     * formato: (dato, altura, factor de balance)
     * @return La cadena con los datos y las alturas de los nodos del arbol en orden
     */
    @Override
    public String toString() {
        String s = "[";
        s += toStringInOrder(raiz);
        s += "]";
        return s;
    }

    /**
     * Este metodo recursivo regresa una cadena con los datos y las alturas de los nodos 
     * del arbol en orden, en el formato: (dato, altura, factor de balance)
     * @return La cadena con los datos y las alturas de los nodos del arbol en orden
     */
    private String toStringInOrder(NodoArbolBinario<T> nodo) {
        String s = "";
        if (nodo == null) return s;
        
        // Recorre el subarbol izquierdo en orden
        s += toStringInOrder(nodo.hijoIzq);
        
        // Visita el nodo
        s += "(" + nodo.dato + ", "
           + String.valueOf(getHeight(nodo)) + ", "
           + String.valueOf(balanceFactor(nodo)) + "), ";
           
        // Recorre el subarbol derecho en orden
        s += toStringInOrder(nodo.hijoDer);
        return s;
    }
    
    
    
    
    /**
     * Elimina el nodo que contiene el dato del parámetro del árbol AVL.
     * @param dato Dato a eliminar del árbol.
     */
    public void remove(T dato) {
        raiz = remove(raiz, dato);
    }

    /**
     * Elimina recursivamente el nodo que contiene el dato del parámetro en el
     * árbol cuya raíz está dada por el nodo del parámetro
     * @param nodo Raíz del subárbol donde se buscará el dato.
     * @param dato Dato del nodo a eliminar.
     * @return La nueva raíz del subárbol una vez eliminado el nodo y balanceado.
     */
    private NodoArbolBinario<T> remove(NodoArbolBinario<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        int comparacion = dato.compareTo(nodo.dato);

        if (comparacion < 0) {
            nodo.hijoIzq = remove(nodo.hijoIzq, dato);
        } else if (comparacion > 0) {
            nodo.hijoDer = remove(nodo.hijoDer, dato);
        } else {
            
            if (nodo.hijoIzq != null && nodo.hijoDer != null) {
                NodoArbolBinario<T> sucesor = findMin(nodo.hijoDer);
                nodo.dato = sucesor.dato;
                nodo.hijoDer = remove(nodo.hijoDer, sucesor.dato);
            } 

            else {
                nodo = (nodo.hijoIzq != null) ? nodo.hijoIzq : nodo.hijoDer;
            }
        }

        if (nodo == null) {
            return null;
        }

        return rebalance(nodo);
    }

    /**
     * Método auxiliar para encontrar el nodo con el valor mínimo en un subárbol
     * @param nodo Raíz del subárbol.
     * @return El nodo con el valor mínimo.
     */
    private NodoArbolBinario<T> findMin(NodoArbolBinario<T> nodo) {
        if (nodo == null) {
            return null;
        } else if (nodo.hijoIzq == null) {
            return nodo;
        }
        return findMin(nodo.hijoIzq);
    }
}
