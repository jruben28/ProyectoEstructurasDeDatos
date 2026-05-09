/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.ListException;
import excepciones.QueueException;
import interfaces.IQueue;

/**
 * Clase que implementa una cola en linkedList
 * @author joser
 * @param <T> tipo de dato
 */
public class LinkedListQueue<T> extends LinkedList<T> implements IQueue<T> {

    /**
     * Agrega el elemento dado al final de la cola
     * @param o elemento a agregar
     * @throws QueueException en caso de que la cola esté llena
     */
    @Override
    public void enqueue(T o) throws QueueException {
        try{
            append(o);
        }
        catch(ListException le){
            throw new QueueException("Cola llena");
        }
    }

    /**
     * Saca de la lista el primer elemento de la cola, lo regresa
     * @return primer elemento de la lista
     * @throws QueueException en caso de que la cola este vacia
     */
    @Override
    public T dequeue() throws QueueException {
        T o;
        try{
            o = get(0);
            remove(0);
            return o;
            
        }
        catch(ListException le){
            throw new QueueException("Cola vacia");
        }
    }

    /**
     * Revisa el primer elemento de la cola, sin sacarlo
     * @return elemento de la primera posicion
     * @throws QueueException en caso de que la cola este vacia
     */
    @Override
    public T peek() throws QueueException {
        T o;
        try{
            o = get(0);
            return o;
        }
        catch(ListException le){
            throw new QueueException("Cola vacia");
        }
    }
    
}
