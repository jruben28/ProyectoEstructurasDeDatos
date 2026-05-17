/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.ListException;

/**
 *
 * @author Jorge
 */
public class CircularLinkedList<T> {

    private Nodo<T> inicio;

    public Nodo<T> getInicio() {
        return inicio;
    }
    
    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public void clear() {
        inicio = null;
    }

    public boolean empty() {
        return inicio == null;
    }

    public T peek() {
        if (empty()) {
            throw new ListException("Error: la lista esta vacia");
        }
        return inicio.getDato();
    }

    public void addFirst(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (empty()) {
            inicio = nuevo;
            inicio.setSiguiente(inicio);
            return;
        }
        Nodo<T> aux = inicio;
        while (aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
        }
        nuevo.setSiguiente(inicio);
        aux.setSiguiente(nuevo);
        inicio = nuevo;
    }

    public void addLast(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (empty()) {
            inicio = nuevo;
            inicio.setSiguiente(inicio);
            return;
        }
        Nodo<T> aux = inicio;
        while (aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(nuevo);
        nuevo.setSiguiente(inicio);
    }

    public void addPos(T dato, int pos) {
        if (pos < 0) {
            throw new ListException("Error: posicion invalida");
        }
        if (pos == 0) {
            addFirst(dato);
            return;
        }
        Nodo<T> aux = inicio;
        int i = 0;
        while (i < pos - 1 && aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
            i++;
        }
        if (i != pos - 1) {
            throw new ListException("Error: posicion fuera de rango");
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(aux.getSiguiente());
        aux.setSiguiente(nuevo);
    }

    public void removeFirst() {
        if (empty()) {
            throw new ListException("Error: la lista esta vacia");
        }
        if (inicio.getSiguiente() == inicio) {
            inicio = null;
            return;
        }
        Nodo<T> aux = inicio;
        while (aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
        }
        inicio = inicio.getSiguiente();
        aux.setSiguiente(inicio);
    }

    public void removeLast() {
        if (empty()) {
            throw new ListException("Error: la lista esta vacia.");
        }
        if (inicio.getSiguiente() == inicio) {
            inicio = null;
            return;
        }
        Nodo<T> aux = inicio;
        while (aux.getSiguiente().getSiguiente() != inicio) {
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(inicio);
    }

    public void removePos(int pos) {
        if (empty()) {
            throw new ListException("Error: la lista esta vacia");
        }
        if (pos < 0) {
            throw new ListException("Error: posicion invalida");
        }
        if (pos == 0) {
            removeFirst();
            return;
        }
        Nodo<T> aux = inicio;
        int i = 0;
        while (i < pos - 1 && aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
            i++;
        }
        if (aux.getSiguiente() == inicio || i != pos - 1) {
            throw new ListException("Error: posicion fuera de rango");
        }
        aux.setSiguiente(aux.getSiguiente().getSiguiente());
    }

    public void updateFirst(T dato) {
        if (empty()) {
            throw new ListException("Error: la lista esta vacia");
        }
        inicio.setDato(dato);
    }

    public void updateLast(T dato) {
        if (empty()) {
            throw new ListException("Error: la lista esta vacia");
        }
        Nodo<T> aux = inicio;
        while (aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
        }
        aux.setDato(dato);
    }

    public void updatePos(T dato, int pos) {
        if (empty()) {
            throw new ListException("Error: la lista esta vacia");
        }
        if (pos < 0) {
            throw new ListException("Error: posicion invalida");
        }
        Nodo<T> aux = inicio;
        int i = 0;
        while (i < pos && aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
            i++;
        }
        if (i != pos) {
            throw new ListException("Error: posicion fuera de rango");
        }
        aux.setDato(dato);
    }

}
