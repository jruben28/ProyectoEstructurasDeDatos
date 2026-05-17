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
public class DoubleCircularLinkedList<T> {

    private Nodo<T> inicio;

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
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

    public boolean contains(T dato) {
        if (inicio == null) {
            return false;
        }
        Nodo<T> aux = inicio;
        while (aux.getSiguiente() != inicio) {
            if (aux.getDato().equals(dato)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        if (aux.getDato().equals(dato)) {
            return true;
        }
        return false;
    }

    public void addFirst(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (empty()) {
            inicio = nuevo;
            inicio.setSiguiente(nuevo);
            inicio.setAnterior(nuevo);
            return;
        }

        Nodo<T> aux = inicio;
        while (aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
        }
        nuevo.setSiguiente(inicio);
        nuevo.setAnterior(aux);
        inicio.setAnterior(nuevo);
        aux.setSiguiente(nuevo);
        inicio = nuevo;
    }

    public void addLast(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (inicio == null) {
            inicio = nuevo;
            inicio.setSiguiente(inicio);
            inicio.setAnterior(inicio);
            return;
        }
        Nodo<T> aux = inicio.getAnterior();
        nuevo.setSiguiente(inicio);
        nuevo.setAnterior(aux);
        aux.setSiguiente(nuevo);
        inicio.setAnterior(nuevo);
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
        nuevo.setAnterior(aux);
        aux.getSiguiente().setAnterior(nuevo);
        aux.setSiguiente(nuevo);
    }

    public void removeFirst() {
        if (inicio == null) {
            throw new ListException("Error: la lista esta vacia");
        }
        if (inicio.getSiguiente() == inicio) {
            inicio = null;
            return;
        }
        Nodo<T> aux = inicio.getAnterior();
        inicio = inicio.getSiguiente();
        aux.setSiguiente(inicio);
        inicio.setAnterior(aux);
    }

    public void removeLast() {
        if (inicio == null) {
            throw new ListException("Error: la lista esta vacia");
        }
        if (inicio.getSiguiente() == inicio) {
            inicio = null;
            return;
        }

        Nodo<T> ultimo = inicio.getAnterior();
        Nodo<T> penultimo = ultimo.getAnterior();
        penultimo.setSiguiente(inicio);
        inicio.setAnterior(penultimo);
    }

    public void removePos(int pos) {
        if (inicio == null) {
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
        while (i < pos && aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
            i++;
        }
        if (i != pos) {
            throw new ListException("Error: posicion fuera de rango");
        }

        aux.getAnterior().setSiguiente(aux.getSiguiente());
        aux.getSiguiente().setAnterior(aux.getAnterior());
    }

    public void updateFirst(T dato) {
        if (inicio == null) {
            throw new ListException("Error: la lista esta vacia");
        }
        inicio.setDato(dato);
    }

    public void updateLast(T dato) {
        if (inicio == null) {
            throw new ListException("Error: la lista esta vacia");
        }
        inicio.getAnterior().setDato(dato);
    }

    public void updatePos(T dato, int pos) {
        if (inicio == null) {
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
