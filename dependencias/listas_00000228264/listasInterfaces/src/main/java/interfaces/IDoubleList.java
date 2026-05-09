/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.ListException;

/**
 * Esta intefaz implelemta los metodos de una lista doblemente enlazada, 
 * extenidiendo los metodos de IList
 * @author joser
 */
public interface IDoubleList<T> extends IList<T> {
    /**
    * Regresa el indice de la ultima ocurrencia del elemento del
    * parametro, en la lista o 1 si el elemento no existe.
    *
    *
    @param o Elemento a buscar en la lista
    *
    @return Regresa el indice de la ultima ocurrencia del elemento
    * del parámetro en la lista o 1 si el elemento no existe.
    */
    int lastIndexOf(T o);
    /**
    * Elimina la ultima ocurrencia del elemento del parametron, si
    * existe.
    *
    *
    @param o Elemento a eliminar
    @return true si el elemento existe en la lista, false en caso
    * contrario.
    * @throws ListException Si la lista esta vacia
    */
    boolean removeLast (T o)throws ListException;
}
