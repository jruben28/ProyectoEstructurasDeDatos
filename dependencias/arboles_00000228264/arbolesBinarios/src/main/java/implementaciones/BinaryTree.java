/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.ITree;
import interfaces.ITreeIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author joser
 */
public class BinaryTree<T> extends BinaryTreeComun<T> implements ITreeIterator<T>{
    /**
     * Esta clase miembro implementa un iterador para recorrer
     * un arbol binario en orden
     *
     * @param <T> Parámetro de tipo para los objetos a almacenarse
     *
     * en el arbol
     */
    class InorderIterator implements Iterator<T> {

        private LinkedListStack<NodoArbolBinario<T>> pilaNodos;
        private NodoArbolBinario<T> nodoActual;

        /**
         * Inicializa los atributos de la clase
         */
        public InorderIterator() {
            // Pila para almacenar los nodos izquierdos
            pilaNodos = new LinkedListStack<>();
            nodoActual = raiz;
            // Inserta en la pila el subarbol izquierdo de la raiz
            pushSubArbolIzquierdo(nodoActual);
        }

        /**
         *
         * Inserta en la pila pilaNodos los nodos del subarbol
         * izquierdo
         * @param nodoActual Raiz del subarbol izquierdo
         */
        private void pushSubArbolIzquierdo(NodoArbolBinario<T>
                nodoActual) {
            while (nodoActual != null) {
                pilaNodos.push(nodoActual);
                nodoActual = nodoActual.hijoIzq;
            }
        }

        /**
         * Determina si aun hay nodos del arbol binario sin recorrer
         *
         *
         * @return true si aun hay nodos del arbol binario sin
         *
         * recorrer, false en caso contrario.
         */
        @Override
        public boolean hasNext() {
            // Si aun hay nodos en la pila
            return !pilaNodos.empty();
        }

        @Override
        public T next() {
            NodoArbolBinario<T> nodoSig = null;
            // Obten de la pila el nodo mas a la izquierda
            // luego ve a su nodo derecho
            if (!pilaNodos.empty()) {
                nodoSig = pilaNodos.pop();
                pushSubArbolIzquierdo(nodoSig.hijoDer);
            } else {
                throw new NoSuchElementException();
            }
            return nodoSig.dato;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Crea un arbol binario vacio
     */
    public BinaryTree() {
        raiz = null;
    }

    /**
     * Crea un arbo binario con un solo nodo con el dato
     * del nodo raiz dado por el parametro datoRaiz
     *
     *
     * @param datoRaiz Dato a guardar en el nodo raiz
     */
    public BinaryTree(T datoRaiz) {
        raiz = new NodoArbolBinario(datoRaiz);
    }

    /**
     * Crea un arbol binario con el dato del nodo raiz y
     * los subarboles izquierdo y derecho dados por los
     *
     *
     * parametros
     *
     * @param datoRaiz Dato a guardar en el nodo raiz
     *
     * @param arbolIzq Subarbol izquierdo
     * @param arbolDer Subarbol derecho
     */
    public BinaryTree(T datoRaiz, BinaryTree<T> arbolIzq,
            BinaryTree<T> arbolDer) {
        setTree(datoRaiz, arbolIzq, arbolDer);
    }

    /**
     * Establece un arbol binario con el dato del nodo raiz y
     * los subarboles izquierdo y derecho dados por los
     * parametros
     *
     * @param datoRaiz Dato a guardar en el nodo raiz
     * @param arbolIzq Subarbol izquierdo
     * @param arbolDer Subarbol derecho
     */
    private void setTree(T datoRaiz, BinaryTree<T> arbolIzq,
            BinaryTree<T> arbolDer) {
        raiz = new NodoArbolBinario(datoRaiz);
        if ((arbolIzq != null) && !arbolIzq.empty()) {
            raiz.hijoIzq = copy(arbolIzq.raiz);
        }
        if ((arbolDer != null) && !arbolDer.empty()) {
            raiz.hijoDer = copy(arbolDer.raiz);
        }
    }

    /**
     *
     * Regresa un subarbol del nodo del parametro
     *
     * @param nodo Nodo del que se obtendra el subarbol
     * @return Un subarbol del nodo del parametro
     */
    private NodoArbolBinario<T> copy(NodoArbolBinario<T> nodo) {
        NodoArbolBinario<T> nuevoNodo = new NodoArbolBinario<>(nodo.dato);
        if (nodo.hijoIzq != null) {
            nuevoNodo.hijoIzq = copy(nodo.hijoIzq);
        }
        if (nodo.hijoDer != null) {
            nuevoNodo.hijoDer = copy(nodo.hijoDer);
        }
        return nuevoNodo;
    }

    /**
     * Obtiene un iterador para recorrer el arbol en orden
     *
     * @return Un iterador para recorrer el arbol en orden
     */
    @Override
    public Iterator<T> getInorderIterator() {
        return new InorderIterator();
    }

    /**
     * Obtiene un iterador para recorrer el arbol en preorden
     *
     * @return Un iterador para recorrer el arbol en preorden
     */
    @Override
    public Iterator<T> getPreorderIterator() {
        return new PreorderIterator();
    }

    /**
     * Obtiene un iterador para recorrer el arbol en postorden
     *
     * @return Un iterador para recorrer el arbol en postorden
     */
    @Override
    public Iterator<T> getPostorderIterator() {
        // La implementación de PostorderIterator no está en el documento.
        return new PostorderIterator();
    }

    /**
     * Regresa una cadena con la información de un arbol general
     *
     * @return Una cadena con la información de un arbol general
     */
    public String toStringInOrder() {
        Iterator<T> iter = getInorderIterator();
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
    

    /**
     * Clase anidada para implementar los metodos de iterator preorder
     */
    class PreorderIterator implements Iterator<T> {
        private LinkedListStack<NodoArbolBinario<T>> pilaNodos;

        /**
         * Inicializa los atributos de la clase
         */
        public PreorderIterator() {
            pilaNodos = new LinkedListStack<>();
            if (raiz != null) {
                pilaNodos.push(raiz);
            }
        }

        /**
         * Determina si aun hay nodos del arbol binario sin recorrer
         *
         * @return true si aun hay nodos del arbol binario sin
         * recorrer, false en caso contrario.
         */
        @Override
        public boolean hasNext() {
            return !pilaNodos.empty();
        }

        /**
         * Regresa el siguiente elemento en el recorrido preorden
         *
         * @return El siguiente elemento
         * @throws NoSuchElementException si no hay más elementos
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            NodoArbolBinario<T> nodoActual = pilaNodos.pop();

            if (nodoActual.hijoDer != null) {
                pilaNodos.push(nodoActual.hijoDer);
            }

            if (nodoActual.hijoIzq != null) {
                pilaNodos.push(nodoActual.hijoIzq);
            }

            return nodoActual.dato;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    /**
     * Clase anidada para implementar metodos de Iterator
     */
    class PostorderIterator implements Iterator<T> {
        private LinkedListStack<NodoArbolBinario<T>> pilaProcesamiento;     
        private LinkedListStack<NodoArbolBinario<T>> pilaSalida;

        /**
         * Inicializa los atributos de la clase.
         * Esta implementación utiliza dos pilas para construir
         * el orden Postorden.
         */
        public PostorderIterator() {
            pilaProcesamiento = new LinkedListStack<>();
            pilaSalida = new LinkedListStack<>();

            if (raiz != null) {
                pilaProcesamiento.push(raiz);
            }

            while (!pilaProcesamiento.empty()) {

                NodoArbolBinario<T> nodo = pilaProcesamiento.pop();

                pilaSalida.push(nodo);

                if (nodo.hijoIzq != null) {
                    pilaProcesamiento.push(nodo.hijoIzq);
                }
                if (nodo.hijoDer != null) {
                    pilaProcesamiento.push(nodo.hijoDer);
                }
            }
        }

        /**
         * Determina si aun hay nodos del arbol binario sin recorrer
         *
         * @return true si aun hay nodos del arbol binario sin
         * recorrer, false en caso contrario.
         */
        @Override
        public boolean hasNext() {
            // Simplemente revisamos si la pila de salida tiene elementos
            return !pilaSalida.empty();
        }

        /**
         * Regresa el siguiente elemento en el recorrido postorden
         *
         * @return El siguiente elemento
         * @throws NoSuchElementException si no hay más elementos
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            NodoArbolBinario<T> nodo = pilaSalida.pop();
            return nodo.dato;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}   
