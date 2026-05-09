/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.ListException;
import excepciones.QueueException;
import interfaces.IQueue;

/**
 * Clase que implemente ArrayList implelmentando Interfaz de stack
 * para formar pila
 * @author joser
 * @param <T> tipo de dato
 */
public class ArrayListQueue<T> extends ArrayList<T> implements IQueue<T> {
    /**
     * Constructor de la clase.
     * @param tipoDato Tipo de los elementos que se almacenaran en la
     * cola
     * @param tamPila Tamaño de la lista sobre la que se implementa la
     * cola
     */
    public ArrayListQueue(Class<T> tipoDato, int tamPila) {
        super (tipoDato, tamPila);
    }
    
    /**
     * Agrega al final de la cola el elemento dado
     * @param o elemento a agregar
     * @throws QueueException en caso de que la cola este llena
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
     * Saca al primer elemento de la cola, y lo regresa
     * @return primer elemento
     * @throws QueueException en caso de que la cola esté vacia
     */
    @Override
    public T dequeue() throws QueueException {
        T o = null;
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
     * Revisa el primer elemento en la cola
     * @return regresa el primer elemento
     * @throws QueueException en caso de que esté vacia
     */
    @Override
    public T peek() throws QueueException {
        T o = null;
        try{
            o = get(0);
            return o;
        }
        catch(ListException le){
            throw new QueueException("Cola vacia"); 
        }
    }
}
