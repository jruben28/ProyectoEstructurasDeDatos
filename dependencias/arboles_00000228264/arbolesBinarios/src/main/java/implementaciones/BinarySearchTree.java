/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.TreeException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author joser
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>>extends BinaryTreeComun<T>{
    /**
    * Esta clase miembro implementa un iterador para recorrer
    * un arbol binario en orden
    *
    * @param <T> Parámetro de tipo para los objetos a almacenarse
    * en el arbol
    */
    class InorderIterator implements Iterator<T>{
        private LinkedListStack<NodoArbolBinario<T>> pilaNodos;
        private NodoArbolBinario<T> nodoActual;
        /**
        * Inicializa los atributos de la clase
        */
        public InorderIterator() {
            // Pila para almacenar los nodos izquierdos
            pilaNodos = new LinkedListStack<>();
            nodoActual = raiz;
        }
        /**
        * Determina si aun hay nodos del arbol binario sin recorrer
        * @return true si aun hay nodos del arbol binario sin
        * recorrer, false en caso contrario.
        */
        @Override
        public boolean hasNext() {
        // Si aun hay nodos en la pila y el nodo actual no es
        // nulo
        return !pilaNodos.empty() || (nodoActual != null);
        }
        @Override
        public T next() {
        NodoArbolBinario<T> nodoSig = null;
        // Encuentra el nodo mas a la izquierda sin hijo
        // izquierdo
        while(nodoActual != null) {
            pilaNodos.push(nodoActual);
            nodoActual = nodoActual.hijoIzq;
        }
        // Obten el nodo mas a la izquierda
        // luego ve a su nodo derecho
        if(!pilaNodos.empty()) {
            nodoSig = pilaNodos.pop();
            nodoActual = nodoSig.hijoDer;
        }
        else throw new NoSuchElementException();
            return nodoSig.dato;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    /**
    * Crea un arbol binario de busqueda vacio.
    */
    public BinarySearchTree() {
        raiz = null;
    }
    /**
    * Driver para el metodo recursivo para agregar un nodo al arbol
    * @param dato Dato del nodo a agregar al arbol
    */
    public void insert(T dato) {
        raiz = insert(raiz, dato);
    }
    /**
    * Metodo recursivo para agregar un nodo al arbol
    * @param nodo Subarbol al que se le agrega recursivamente el
    * nodo
    * @param dato Dato del nodo a agregar al subarbol
    * @return Subarbol al que se le agrego recursivamente el nodo
    */
    private NodoArbolBinario<T> insert(NodoArbolBinario<T> nodo,
    T dato) {
    // Caso base
    // Si el subarbol es vacio, regresa el nodo a agregar
    if(nodo == null) {
        return new NodoArbolBinario(dato);
    }
    // Casos recursivos
    // Se determina a que subarbol se agregara el nodo
    if(dato.compareTo(nodo.dato) < 0) {
        nodo.hijoIzq = insert(nodo.hijoIzq, dato);
    }
    else {
        nodo.hijoDer = insert(nodo.hijoDer, dato);
    }
        return nodo;
    }
    /**
    * Driver para el metodo recursivo para eliminar un nodo
    * del arbol
    * @param dato Dato a eliminar del arbol
    */
    public void remove(T dato) {
        raiz = remove(raiz, dato);
    }
    /**
    * Metodo recursivo para eliminar un nodo del arbol
    * @param nodo Subarbol del que se elimina recursivamente el
    * nodo
    * @return Subarbol del que se elimino recursivamente el nodo
    */
    private NodoArbolBinario<T> remove(NodoArbolBinario<T> nodo,
    T dato) {
    // Caso base
    // Si el nodo a borrar no esta en el subarbol
    if(nodo == null) {
        return null;
    }
    // Si es el nodo a borrar
    if(dato.compareTo(nodo.dato) == 0) {
        // Si el nodo a borrar es una hoja. Solo elimina el nodo
        if(nodo.hijoIzq == null && nodo.hijoDer== null) {
            return null;
        }
        // Si el nodo a borrar solo tiene el hijo derecho
        // sustituye el nodo a borrar por el subarbol derecho
        if(nodo.hijoIzq == null) {
            return nodo.hijoDer;
        }
        // Si el nodo a borrar solo tiene el hijo izquierdo
        // sustituye el nodo a borrar por el subarbol izquierdo
        if(nodo.hijoDer == null) {
            return nodo.hijoIzq;
        }
        // Si el nodo a borrar tiene ambos hijos
        // Encuentra el nodo con el dato mas pequeño que sea
        // mayor al dato del nodo a borrar. Es el nodo mas
        // a la izquierda del subarbol derecho
        NodoArbolBinario<T> nodoMenor
        = findSmallestNode(nodo.hijoDer);
        // Reemplaza el contenido del nodo a borrar por el
        // contenido del nodo mas pequeño que sea mayor al
        // nodo a borrar.
        nodo.dato = nodoMenor.dato;
        // Elimina recursivamente el nodo con el dato mas
        // pequeño que sea mayor al dato del nodo a borrar.
        nodo.hijoDer = remove(nodo.hijoDer, nodoMenor.dato);
    }
    // Casos recursivos
    // Se determina de que subarbol se eliminara el nodo
    if(dato.compareTo(nodo.dato) < 0) {
        nodo.hijoIzq = remove(nodo.hijoIzq, dato);
    }
    else {
        nodo.hijoDer = remove(nodo.hijoDer, dato);
    }
        return nodo;
    }
    /**
    * Obtiene el nodo descendiente del nodo del parametro con el
    * dato mas pequeño. Es el nodo mas a la izquierda del nodo del
    * parametro
    * @param nodo Nodo del que se va buscar el nodo con el dato
    * mas pequeño
    * @return El nodo con el dato mas pequeño que el dato del
    * nodo del parametro.
    */
    protected NodoArbolBinario<T>
    findSmallestNode(NodoArbolBinario<T> nodo) {
        return nodo.hijoIzq == null? nodo:
        findSmallestNode(nodo.hijoIzq);
    }
    /**
    * Obtiene un iterador para recorrer el arbol en orden
    * @return Un iterador para recorrer el arbol en orden
    */
    public Iterator<T> getInorderIterator() {
        return new BinarySearchTree.InorderIterator();
    }
    /**
    * Regresa una cadena con los datos de los nodos del arbol
    * recorriendolo en orden
    *
    * @return Una cadena con los datos de los nodos del arbol
    * recorriendolo en orden
    */
    public String toStringInOrder() {
        Iterator<T> iter = getInorderIterator();
        String s = "[";
        if(iter.hasNext()) {
        s += iter.next();
        while(iter.hasNext())
        s += ", " +iter.next();
        }
        s += "]";
        return s;
    }
    
    //
    
    /**
     * Obtiene el nodo descendiente del nodo del parametro con el
     * dato mas grande.
     * Es el nodo mas a la derecha del nodo del
     * parametro
     *
     * @param nodo Nodo del que se va buscar el nodo con el dato
     * mas grande
     *
     * @return El nodo con el dato mas grande que el dato del
     * nodo del parametro.
     */
    private NodoArbolBinario<T>
        findBiggestNode(NodoArbolBinario<T> nodo) {
        return nodo.hijoDer == null ? nodo : findBiggestNode(nodo.hijoDer);
    }

    /**
     * Regresa el dato más pequeño del arbol binario de
     * búsqueda.
     *
     * @return El dato más pequeño del arbol.
     * @throws TreeException Si el arbol esta vacio.
     */
    public T firstEntry() {
        if (empty()) {
            throw new TreeException("Arbol vacio");
        }
        return findSmallestNode(raiz).dato;
    }

    /**
     * Regresa el dato más grande del arbol binario de
     * búsqueda.
     *
     * @return El dato más grande del arbol.
     * @throws TreeException Si el arbol esta vacio.
     */
    public T lastEntry() {
        if (empty()) {
            throw new TreeException("Arbol vacio");
        }
        return findBiggestNode(raiz).dato;
    }

    /**
     * Driver para el metodo recursivo que regresa el dato del
     * parámetro del árbol binario de búsqueda.
     *
     * @param dato Dato a buscar en el arbol.
     * @return El dato encontrado, o null si no se encuentra.
     */
    public T get(T dato) {
        return get(raiz, dato);
    }

    /**
     * Busca recursivamente el dato del parámetro en el árbol
     * del parámetro.
     *
     * @param nodo Subarbol en el que se busca.
     * @param dato Dato a buscar.
     * @return El dato encontrado, o null si no se encuentra.
     */
    private T get(NodoArbolBinario<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        int comparacion = dato.compareTo(nodo.dato);

        if (comparacion == 0) {
            return nodo.dato;
        }

        else if (comparacion < 0) {
            return get(nodo.hijoIzq, dato);
        }

        else {
            return get(nodo.hijoDer, dato);
        }
    }
    
    
}
