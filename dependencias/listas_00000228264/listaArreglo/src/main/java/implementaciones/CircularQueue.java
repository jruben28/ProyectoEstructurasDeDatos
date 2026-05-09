/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.QueueException;
import interfaces.IQueue;

/**
 *
 * @author joser
 */
public class CircularQueue<T> implements IQueue<T> {
    
    private T[] queue;

    private int inicio;

    private int fin;

    private int tamCola;

    /**
     * Constructor que crea una cola circular vacía con una capacidad específica.
     * En una cola vacía, tanto 'inicio' como 'fin' se inicializan en -1. 
     *
     * @param tamCola El tamaño máximo del arreglo.
     */
    public CircularQueue(int tamCola) {
        this.tamCola = tamCola;
        this.queue = (T[]) new Object[this.tamCola];
        this.inicio = -1;
        this.fin = -1;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param o elemento a agregar.
     * @throws QueueException si la cola está llena.
     */
    @Override
    public void enqueue(T o) throws QueueException {
        if (full()) {
            throw new QueueException("La cola está llena");
        }

        if (empty()) {
            inicio = 0;
        }

        fin = (fin + 1) % tamCola;
        queue[fin] = o;
    }

    /**
     * Extrae el elemento al inicio de la cola y lo elimina de ella.
     *
     * @return El elemento al inicio de la cola.
     * @throws QueueException si la cola está vacía.
     */
    @Override
    public T dequeue() throws QueueException {
        if (empty()) {
            throw new QueueException("La cola está vacía");
        }
        T elemento = queue[inicio];

        if (inicio == fin) {
            inicio = -1;
            fin = -1;
        } else {
            
            inicio = (inicio + 1) % tamCola;
        }
        return elemento;
    }

    /**
     * Inspecciona el elemento del inicio de la cola, pero sin extraerlo.
     *
     * @return El elemento del inicio de la cola.
     * @throws QueueException si la cola está vacía.
     */
    @Override
    public T peek() throws QueueException {
        if (empty()) {
            throw new QueueException("La cola está vacía.");
        }
        return queue[inicio];
    }

    /**
     * Determina si la cola está vacía.
     *
     * @return true si está vacía, false de lo contrario.
     */
    @Override
    public boolean empty() {
        return inicio == -1;
    }

    /**
     * Método auxiliar privado que determina si la cola está llena.
     * Una cola está llena si el siguiente índice de 'fin' es igual a 'inicio'.
     *
     * @return verdadero si la cola está llena, falso en caso contrario.
     */
    private boolean full() {
        return (fin + 1) % tamCola == inicio;
    }

    /**
     * Devuelve una representación en String de los elementos en la cola.
     *
     * @return Un String con la lista de los objetos guardados en la cola circular.
     */
    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int i = inicio;
        while (true) {
            sb.append(queue[i]);
            if (i == fin) {
                break;
            }
            sb.append(", ");
            i = (i + 1) % tamCola;
        }

        sb.append("]");
        return sb.toString();
    }
    
}
