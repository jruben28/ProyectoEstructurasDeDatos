/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.QueueException;

/**
 * Esta clase implementa la excepción lanzada por los metodos de las
 * clases que implementan la interfaz IQueue.
 * @author joser
 * @param <T> tipo de objeto
 */
public interface IQueue<T> {
    
    /**
     * Agrega un elemento al final de la cola
     * @param o elemento a agregar
     */
    public void enqueue(T o) throws QueueException;
    
    /**
     * Extrae el elemento al incio de la cola, lo saca de ella
     * @return elemento al incio de la cola
     */
    public T dequeue() throws QueueException;
    
    /**
     * Inspecciona el elemento del inicio de la cola,
     * pero sin extraerlo
     * @return elemento del incio de la cola
     */
    public T peek() throws QueueException;
    
    /**
     * Determina si la cola esta vacia
     * @return regresa True si está vacia, false de lo contrario
     */
    public boolean empty();
    
}
