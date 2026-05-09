/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.StackException;

/**
 * Esta clase implementa la excepción lanzada por los metodos de las
 * clases que implementan la interfaz IStack.
 * @author joser
 */
public interface IStack<T> {
    /**
     * Inserta un elemento en el tope de la pila
     * @param o Elemento a insertar en el tope de la pila
     * @throws StackException Si la pila esta llena
     */
    public void push (T o) throws StackException;

    /**
     * Extrae el elemento del tope de la pila
     * @return El elemento del tope de la pila
     * @throws StackException Si la pila esta vacia
     */
    public T pop() throws StackException;

    /**
     *
     * Inspecciona el elemento del tope de la pila sin extraerlo
     * @return El elemento del tope de la pila
     * @throws StackException Si la pila esta vacia
     */
    public T peek() throws StackException;

    /**
     * Determina si la pila se encuentra vacia
     * @return true si la pila se encuentra vacia,
     *
     * false en caso contrario.
     */
    public boolean empty();
}
