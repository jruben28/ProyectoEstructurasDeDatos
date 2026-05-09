/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.ListException;
import java.util.Iterator;

/**
 * Esta interfaz generica establece los métodos a implementar   
 * por una clase que modele una lista
 * @author joser
 * @param <T> Parametro de tipo para los objetos a almacenarse en la lista
 */
public interface IList<T> {
    
    /**
    * Inserta un elemento al final de la lista
    *
    * @param o Elemento a insertar al final de la lista
    * @throws ListException Si la lista esta llena
    */
    public void append(T o) throws ListException;
    
    /**
    * Inserta un elemento en la posición i de la lista
    *
    * @param o Elemento a insertar en la posición i de la lista
    * @param i Posición i de la lista donde se inserta el elemento
    * @throws ListException Si la lista esta llena o i menor que 0 o i mayor que size().
    */
    public void insert(T o, int i) throws ListException;
    
    /**
    * inspecciona el elemento en la posición i de la lista sin
    * extraerlo
    *
    * @param i Posición i de la lista del elemento a inspeccionar
    * @return El elemento en la posición i de la lista
    * @throws ListException Si la lista esta vacia o i menor que 0 o i mayor o igual a size()
    */
    public T get(int i) throws ListException;
    
    /**
    * Extrae el elemento de la posición i de la lista
    *
    * @param i Posición i de la lista del elemento a remover
    * @return El elemento de la posición i de la lista
    * @throws ListException Si la lista esta vacia o i menor que 0 o mayor o igual a size()
    */
    public T remove(int i) throws ListException;
    
    /**
    * Determina si la lista se encuentra vacía
    *
    * @return true si la lista se encuentra vacia,
    * false en caso contrario.
    */
    public boolean empty();
    
    /**
    * Regresa el numero de elementos en la lista
    *
    * @return El numero de elementos en la lista
    */
    public int size();
    
    /**
    * Regresa un iterador para esta lista
    *
    * @return Un iterador para esta lista
    */
    public Iterator<T> iterator();
    
    /**
     * Establece un elemento en el indice dado dentro de la lista
     * 
     * @param o Elemento a insertar en la lista
     * @param i Indice de la lista en el cual se pretende insertar el elemento
     * @throws ListException Si la lista está vacia o el indice se encuentra fuera
     * de los parametros
     */
    public void set(T o, int i) throws ListException;
    
    /**
     * Elimina cierto elemento dentro de la lista
     * 
     * @param o objeto que se pretende eliminar de la lista
     * @return regresa true si el elemento existe dentro de la lista
     * false si no existe.
     * @throws ListException Si la lista está vacia
     */
    public boolean remove(T o) throws ListException;
    
    /**
     * Regresa el indice de dado elemento dentro de la lista
     * 
     * @param o elemento del cual pretendemos obtener el indice dentro de la lista
     * @return  el indice del elemento, -1 en caso de no existir dentro de ella
     */
    public int indexOf(T o);
    
    /**
     * elimina todos los elementos de la lista
     */
    public void clear();
    
    
    /**
     * Determina si el elemento dado existe en la lista.
     * @param o Elemento a buscar
     * @return true si el elemento existe, false en caso contrario
     */
    public boolean contains(T o);
}
