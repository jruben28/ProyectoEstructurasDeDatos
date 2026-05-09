/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.ListException;
import excepciones.StackException;
import interfaces.IStack;

/**
 * Clase que implementa una pila sobre linked list
 * @author joser
 * @param <T> tipo de dato
 */
public class LinkedListStack<T> extends LinkedList<T> implements IStack<T> {
    /**
     * Inserta un elemento en el tope de la pila
     * @param o Elemento a insertar en el tope de la pila
     * @throws StackException Si la pila esta llena
     */
    @Override
    public void push(T o) throws StackException {
        try {
            append(o);
        } catch (ListException le) {
            throw new StackException("Pila llena");
        }
    }

    /**
     * Extrae el elemento en el tope de la pila
     * @return El elemento en el tope de la pila
     * @throws StackException Si la pila esta vacia
     */
    @Override
    public T pop() throws StackException {
        T o = null;
        try {
            o = remove(nElementos - 1);
        } catch (ListException le) {
            throw new StackException("Pila Vacia");
        }
        return o;
    }

    /**
     * Inspecciona el elemento en el tope de la pila
     * @return El elemento en el tope de la pila
     * @throws StackException Si la pila esta vacia
     */
    @Override
    public T peek() throws StackException {
        T o = null;
        try {
            o = get(nElementos - 1);
        } catch (ListException le) {
            throw new StackException("Pila Vacia");
        }
        return o;
    }
}
