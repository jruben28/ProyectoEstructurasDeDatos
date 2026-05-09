/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;
import excepciones.ListException;
import interfaces.IList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Clase de arreglo con lista enlazada
 * @author joser
 * @param <T> tipo de dato generico
 */
public class LinkedList<T> implements IList<T>, Iterable<T>{
    protected NodoSimple<T> inicio;
    protected int nElementos;

    /**
     * Esta clase miembro representa un nodo de una lista enlazada
     * simple
     */
    private class NodoSimple<T> {
        private T dato;
        private NodoSimple<T> sig;

        /**
         * Inicializa el atributo dato al valor de su parametro
         * @param dato Dato a almacenar en el nodo
         */
        public NodoSimple(T dato) {
            this.dato = dato;
        }
    }

    /**
     * Esta clase miembro representa un iterador para esta lista
     */
    private class ListIterator<T> implements Iterator<T> {
        private NodoSimple<T> nodoActual;

        public ListIterator(NodoSimple<T> inicio) {
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
         * @return Una referencia al siguiente elemento de la colección
         * @throws Una excepción del tipo NoSuchElementException si
         * ya no hay elementos que regresar
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T dato = nodoActual.dato;
            nodoActual = nodoActual.sig;
            return dato;
        }
    }

    /**
     * Inicializa la referencia al inicio de la lista
     * y el contador de elementos de la lista
     */
    public LinkedList() {
        inicio = null;
        nElementos = 0;
    }

    /**
     * Inserta un elemento al final de la lista
     * @param o Elemento a insertar
     */
    @Override
    public void append(T o) {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
        if (inicio == null) {
            // Si la lista está vacía
            inicio = nodoNuevo;
        } else {
            // Si la lista no esta vacia, haz que nodo
            // apunte al ultimo elemento de la lista
            NodoSimple<T> nodo = inicio;
            while (nodo.sig != null) {
                nodo = nodo.sig;
            }
            // agrega el nuevo nodo al final de la lista
            nodo.sig = nodoNuevo;
        }
        nElementos++;
    }

    /**
     * Inserta un elemento en la posición i de la lista
     * @param o Elemento a insertar en la posición i de la lista
     * @param i Posición i de la lista donde se inserta el elemento
     * @throws ListException si i menor que 0 o i mayor que size()
     */
    @Override
    public void insert(T o, int i) throws ListException {
        if (i < 0 || i > nElementos) {
            throw new ListException("Indice fuera de limites");
        }
        
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);

        if (i == 0) {
            // Inserta el elemento al inicio de la lista
            nodoNuevo.sig = inicio;
            inicio = nodoNuevo;
        } else {
            // Inserta el elemento en la posición i de la lista
            NodoSimple<T> nodo = inicio;
            // Haz que nodo apunte al nodo
            // anterior al punto de insercion
            for (int j = 0; j < i - 1; j++) {
                nodo = nodo.sig;
            }
            // Agrega la lista a la derecha del punto
            // de inserción al nodo nuevo
            nodoNuevo.sig = nodo.sig;
            // Agrega el nodo nuevo a la lista a la
            // izquierda del punto de inserción
            nodo.sig = nodoNuevo;
        }
        nElementos++;
    }

    /**
     * Inspecciona el elemento en la posición i de la lista sin
     * extraerlo
     * @param i Posición i de la lista del elemento a inspeccionar
     * @return El elemento en la posición i de la lista
     * @throws ListException Si la lista esta vacia o i menor que 0 o i mayor o igual que size()
     */
    @Override
    public T get(int i) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }
        if (i < 0 || i >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }
        
        NodoSimple<T> nodo = inicio;
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
     * @throws ListException Si la lista esta vacia o i menor que 0 o i mayor o igual que size()
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
            // Si el nodo a eliminar esta al inicio de la lista
            o = inicio.dato;
            inicio = inicio.sig;
        } else {
            // Si el nodo a eliminar esta en la posición i de la lista
            NodoSimple<T> nodo = inicio;
            // Haz que nodo apunte al nodo anterior al nodo a eliminar
            for (int j = 0; j < i - 1; j++) {
                nodo = nodo.sig;
            }
            // Obten el dato a eliminar
            o = nodo.sig.dato;
            // Quita el elemento a eliminar de la lista
            nodo.sig = nodo.sig.sig;
        }
        nElementos--;
        // Regresa el dato
        return o;
    }

    /**
     * Determina si la lista se encuentra vacia
     * @return true si la lista se encuentra vacia, false en caso contrario.
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
        return new ListIterator<>(inicio);
    }

    /**
     * Genera una cadena con los valores de los elementos de la lista
     * @return La cadena con los valores de los elementos de la lista
     */
    @Override
    public String toString() {
        String s = "[";
        NodoSimple<T> nodo = inicio;
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
     * Establece el elemento dado en el indice dado, recorriendo los nodos 
     * hasta encontrar el objetivo
     * @param o elemento a establecer
     * @param i indice a establecer
     * @throws ListException eb casi de que el indice este fuera de parametro o este vacia
     */
    @Override
    public void set(T o, int i) throws ListException {
        if (i < 0 || i > nElementos) {
            throw new ListException("Indice fuera de limites");
        }
        
        if(empty()){
            throw new ListException("La lista se encuentra vacia");
        }
        
        NodoSimple<T> nodo = inicio;
        
        for (int j = 0; j < i; j++) {
            nodo = nodo.sig;
        }

        nodo.dato = o;

    }

    /**
     * Remueve el elemento dado, recorre los nodos hasta encontrarlo, al hacerlo
     * asigna el correspondiente nodo siguiente al nodo anterior del objetivo
     * @param o elemento a eliminar
     * @return regresa true si se pudo eliminar, false si no se encontró
     */
    @Override
    public boolean remove(T o){
        
        if(empty()){
            return false;
        }
        
        if (inicio.dato.equals(o)) {
            inicio = inicio.sig;
            nElementos--;
            return true;
        }
        NodoSimple<T> anterior = inicio;
        NodoSimple<T> actual = inicio.sig;

        while (actual != null) {
            if (actual.dato.equals(o)) {
                anterior.sig = actual.sig; 
                nElementos--;
                return true;
            }
            
            anterior = actual;
            actual = actual.sig;
        }
        
        return false;
    
    }

    /**
     * Regresa el indice del elemento a buscar, recorre los nodos hasta
     * igualar el nodo objetivo y regresar su indice
     * @param o elemento a buscar
     * @return regresa el indice, -1 en caso de no encontrarlo
     */
    @Override
    public int indexOf(T o) {
        int indice = 0;
        
        NodoSimple<T> actual = inicio;
        
        while(actual != o){
            if (actual.dato.equals(o)) {
                return indice;
                
            }
            if(actual.dato == null){
                return -1;
            }
            actual = actual.sig;
            indice++;
            
        }
        
        return -1;
    }

    /**
     * Elimina todos los elementos de nuestra lista enlazada
     */
    @Override
    public void clear() {
        inicio = null;
        nElementos = 0;
    }
    
    
    
    /**
     * Determina si el elemento dado existe en la lista.
     * @param o Elemento a buscar
     * @return true si el elemento existe, false en caso contrario
     */
    public boolean contains(T o) {
        NodoSimple<T> actual = inicio;
        while (actual != null) {
            if (actual.dato != null && actual.dato.equals(o)) {
                return true;
            }
            actual = actual.sig;
        }
        return false;
    }
}
