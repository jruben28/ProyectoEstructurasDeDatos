/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.ListException;
import interfaces.IDoubleList;
import java.util.Iterator;

/**
 * Clase lista doblemente enlazda
 * @author joser
 * @param <T> Tipo generico para los datos en la lista
 */
public class DoubleLinkedList<T> implements IDoubleList<T>, Iterable<T> {
        
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    private int nElementos;

    @Override
    public boolean contains(T o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    /**
     * Esta clase miembro representa un nodo de una lista
     * doblemente enlazada
     */
    private class NodoDoble<T> {
        private T dato;
        private NodoDoble<T> ant;
        private NodoDoble<T> sig;

        /**
         * Inicializa el atributo dato al valor de su parametro
         * @param dato Dato a almacenar en el nodo
         */
        private NodoDoble(T dato) {
            this.dato = dato;
        }
    }

    /**
     * Esta clase miembro representa un iterador para esta lista
     */
    private class ListIterator<T> implements Iterator<T> {
        private NodoDoble<T> nodoActual;

        public ListIterator(NodoDoble<T> inicio) {
            nodoActual = inicio;
        }

        /**
         * Determina si el iterador tiene otro elemento que regresar
         * @return true si el iterador tiene otro elemento que
         * regresar, false en caso contrario.
         */
        @Override
        public boolean hasNext() {
            return nodoActual != null;
        }

        /**
         * Regresa una referencia al siguiente elemento de la
         * colección y avanza el iterador a la siguiente posición.
         * @return Una referencia al siguiente elemento de la
         * colección
         * @throws Una excepción del tipo NoSuchElementException si
         * ya no hay elementos que regresar
         */
        @Override
        public T next() {
            T dato = nodoActual.dato;
            nodoActual = nodoActual.sig;
            return dato;
        }
    }

    /**
     * Inicializa las referencias al inicio y al final de la lista y
     * el contador de elementos de la lista
     */
    public DoubleLinkedList() {
        inicio = null;
        fin = null;
        nElementos = 0;
    }

    /**
     * Inserta un elemento al final de la lista
     * @param o Elemento a insertar
     */
    @Override
    public void append(T o) {
        NodoDoble<T> nodoNuevo = new NodoDoble<>(o);
        if (inicio == null) {
            // Si la lista está vacía
            inicio = nodoNuevo;
            fin = nodoNuevo;
        } else {
            // Si no, agrega el nuevo nodo al final de la lista
            fin.sig = nodoNuevo;
            nodoNuevo.ant = fin;
            fin = nodoNuevo;
        }
        nElementos++;
    }

    /**
     * Inserta un elemento en la posición i de la lista
     * @param o Elemento a insertar en la posición i de la lista
     * @param i Posición i de la lista donde se inserta el elemento
     * @throws ListException Si i menor que 0 o i mayor que size()
     */
    @Override
    public void insert(T o, int i) throws ListException {
        if (i < 0 || i > nElementos) {
            throw new ListException("Indice fuera de limites");
        }
        NodoDoble<T> nodoNuevo = new NodoDoble<>(o);
        if (i == 0) {
            // Si se va a insertar el elemento al inicio de la lista
            if (inicio == null) {
                // Si la lista esta vacia
                fin = nodoNuevo;
            } else {
                // Si no, conecta la lista al nodo nuevo
                nodoNuevo.sig = inicio;
                inicio.ant = nodoNuevo;
            }
            // Haz el nodo nuevo el primero de la lista
            inicio = nodoNuevo;
        } else {
            // Si se va a insertar el elemento en la posición i de
            // la lista
            NodoDoble<T> nodo = inicio;
            // Haz que nodo apunte al nodo anterior al punto de
            // insercion
            for (int j = 0; j < i - 1; j++) {
                nodo = nodo.sig;
            }
            // Agrega la lista a la derecha del punto de inserción
            // al nodo nuevo
            nodoNuevo.sig = nodo.sig;
            if (nodoNuevo.sig != null) {
                // Si el nodo insertado no es el ultimo
                nodoNuevo.sig.ant = nodoNuevo;
            } else {
                // Si el nodo insertado es el ultimo
                fin = nodoNuevo;
            }
            // Agrega el nodo nuevo a la lista a la izquierda del
            // punto de inserción
            nodoNuevo.ant = nodo;
            nodo.sig = nodoNuevo;
        }
        nElementos++;
    }

    /**
     * inspecciona el elemento en la posición i de la lista sin
     * extraerlo
     * @param i Posición i de la lista del elemento a inspeccionar
     * @return El elemento en la posición i de la lista
     * @throws ListException Si la lista esta vacia menor que 0 o i menor o igual a size()
     */
    @Override
    public T get(int i) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }
        if (i < 0 || i >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }
        NodoDoble<T> nodo = inicio;
        // Haz que nodo apunte al nodo a modificar
        for (int j = 0; j < i; j++) {
            nodo = nodo.sig;
        }
        // Regresa el dato en la posición i de la lista
        return nodo.dato;
    }

    /**
     * Extrae el elemento de la posición i de la lista
     * @param i Posición i de la lista del elemento a remover
     * @return El elemento de la posición i de la lista
     * @throws ListException Si la lista esta vacia o menor que i o i menor o igual a size()
     */
    @Override
    public T remove(int i) throws ListException {
        T o;
        if (empty()) {
            throw new ListException("Lista vacia");
        }
        if (i < 0 || i >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }
        if (i == 0) {
            // Si el nodo a eliminar es el primero, obten el dato
            // a eliminar
            o = inicio.dato;
            // Quita el elemento al inicio de la lista
            inicio = inicio.sig;
            if (inicio != null) {
                // Si la lista no esta vacia
                inicio.ant = null;
            } else {
                // Si la lista esta vacia
                fin = null;
            }
        } else {
            // Si el nodo a eliminar esta en la posición i de la
            // lista
            NodoDoble<T> nodo = inicio;
            // Haz que nodo apunte al nodo anterior al nodo a
            // eliminar
            for (int j = 0; j < i - 1; j++) {
                nodo = nodo.sig;
            }
            // Obten el dato a eliminar
            o = nodo.sig.dato;
            // Quita el elemento a eliminar de la lista
            nodo.sig = nodo.sig.sig;
            if (nodo.sig != null) {
                // Si no es el ultimo nodo de la lista
                nodo.sig.ant = nodo;
            } else {
                // Si es el ultimo nodo de la lista
                fin = nodo;
            }
        }
        nElementos--;
        // Regresa el dato
        return o;
    }

    /**
     * Determina si la lista se encuentra vacia
     * @return true si la lista se encuentra vacia, false en caso
     * contrario.
     */
    @Override
    public boolean empty() {
        return inicio == null;
    }

    /**
     * Regresa el numero de elementos en la lista
     * @return El numero de elementos en la lista
     */
    @Override
    public int size() {
        return nElementos;
    }

    /**
     * Regresa un iterador para esta lista
     * @return Un iterador para esta lista
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedList.ListIterator(inicio);
    }

    /**
     * Genera una cadena con los valores de los elementos de la
     * lista
     * @return La cadena con los valores de los elementos de la
     * lista
     */
    @Override
    public String toString() {
        String s = "[";
        NodoDoble<T> nodo = inicio;
        
        while (nodo != null) {
            s += nodo.dato;
            
            if (nodo.sig != null) {
                s += ", ";
            }
            
            nodo = nodo.sig;
            
        }
        
        s += "]";
        return s;
    }
    
    /**
     * Regresa el ultimo indice del elemento ingresado como parametro
     * @param o elmento a buscar
     * @return regresa el indice de la ultima ocurrencia del elemento, -1 en caso de no ser encontrado.
     */
    @Override
    public int lastIndexOf(T o) {
        int indice = nElementos - 1;
        
        NodoDoble<T> actual = fin;
        
        while(actual != o){
            if (java.util.Objects.equals(actual.dato, o)) {
                return indice;
            }
            
            if (actual.dato == null) {
                return -1;
            }
            
            actual = actual.ant;
            indice--;
        }
        
        return -1;
    }

    
    //  
    
    /**
     * Remueve la ultima ocurrencia del elemento ingresado como parametro
     * @param o elemento a buscar
     * @return regresa true si fue eliminado, false en caso contrario
     * @throws ListException si la lista se encuentra vacia
     */
    @Override
    public boolean removeLast(T o) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }
        NodoDoble<T> actual = fin;
        while(actual != null){
            if (java.util.Objects.equals(actual.dato, o)) {
                if (size() == 1) {
                    inicio = null;
                    fin = null;
                    nElementos--;
                    return true;
                }
                if (inicio == actual) {
                    inicio = inicio.sig;
                    inicio.ant = null;
                    nElementos--;
                    return true;
                }
                if (fin == actual) {
                    fin = fin.ant;
                    fin.sig = null;
                    nElementos--;
                    return true;
                    
                }
                
                actual.ant.sig = actual.sig;
                actual.sig.ant = actual.ant;
                nElementos--;
                return true;
            }
            
            actual = actual.ant;
        }
        
        return false;
            
    }

    /**
     * Establece el dato en el indice dado
     * @param o dato a insertar
     * @param i indice en donde insertar
     * @throws ListException en caso de que el indice este fuera de los parametros, o la lista se encuentre vacia
     */
    @Override
    public void set(T o, int i) throws ListException {
        
        if(i < 0 || i > nElementos){
            throw new ListException("El indice esta fuera de los parametros.");
        }
        
        if(empty()){
            throw new ListException("La lista se encuentra vacia");
        }
        
        NodoDoble<T> actual = inicio;
        
        for (int j = 0; j < i; j++) {
            actual = actual.sig;
        }
        
        actual.dato = o;
        
    }

    /**
     * Elimina el dato ingresado como parametro de la lista
     * @param o dato a eliminar
     * @return regresa true si fue eliminado correctamente, false en caso contrario
     * @throws ListException en caso de que la lista se encuentre vacia
     */
    @Override
    public boolean remove(T o) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }
        NodoDoble<T> actual = inicio;
        while(actual != null){
            if (java.util.Objects.equals(actual.dato, o)) {
                if (size() == 1) {
                    inicio = null;
                    fin = null;
                    nElementos--;
                    return true;
                }
                if (inicio == actual) {
                    inicio = inicio.sig;
                    inicio.ant = null;
                    nElementos--;
                    return true;
                }
                if (fin == actual) {
                    fin = fin.ant;
                    fin.sig = null;
                    nElementos--;
                    return true;
                    
                }
                
                actual.ant.sig = actual.sig;
                actual.sig.ant = actual.ant;
                nElementos--;
                return true;
            }
            
            actual = actual.sig;
        }
        
        return false;
    }
    
    /**
     * Regresa el indice de la primera incurrencia del elemento dado
     * @param o elemento a buscar
     * @return indice del elemento, -1 en caso de no ser encontrado
     */
    @Override
    public int indexOf(T o) {
        NodoDoble<T> actual = inicio;
        for (int i = 0; i < nElementos; i++) {
            if(java.util.Objects.equals(actual.dato, o)){
                return i;
            }
            actual = actual.sig;
        }
        
        return -1;
    }
    
    /**
     * Elimina todos los elementos de la lista
     */
    @Override
    public void clear() {
        nElementos = 0;
        inicio = null;
        fin = null;
       
    }
    
}
