/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import implementaciones.LinkedList;

/**
 *
 * @author joser
 */
/**
 * IDictionary.java
 * Esta interfaz generica establece los métodos a implementar
 * por una clase que implemente un diccionario
 * @param <K> Parámetro de tipo para las llaves del diccionario
 * @param <V> Parámetro de tipo para los valores del diccionario
 * @author mdomitsu
 */
public interface IDictionary<K, V> {

    /**
     * Agrega una pareja llave valor al diccionario, si la
     * llave no existe en el diccionario. Si la llave ya existe,
     * reemplaza el valor actual con el valor del parametro
     * @param llave Llave de búsqueda
     * @param valor Valor asociado a la llave de búsqueda
     * @return El valor asociado a la llave de búsqueda o null
     * si la entrada no existia previamente
     */
    public V put(K llave, V valor);

    /**
     * Elimina del diccionario una entrada asociada a una llave dada
     * @param llave Llave de búsqueda
     * @return El valor asociado a la llave de búsqueda o null si la
     * entrada no existe
     */
    public V remove(K llave);

    /**
     * Obtiene del diccionario un valor asociado a una llave dada
     * @param llave Llave de búsqueda
     * @return El valor asociado a la llave de búsqueda o null si la
     * entrada no existe
     */
    public V get(K llave);

    /**
     * Determina si el diccionario contiene una entrada asociada
     * a una llave dada
     * @param llave Llave de búsqueda
     * @return true si el diccionario contiene una entrada asociada
     * a una llave dada, false en caso contrario
     */
    public boolean contains(K llave);

    /**
     * Determina el número de entradas (parejas llave valor)
     * en el diccionario
     * @return Número de entradas en el diccionario
     */
    public int size();

    /**
     * Determina si el diccionario esta vacio
     * @return true si el diccionario esta vacio, false en caso
     * contrario
     */
    public boolean empty();

    /**
     * Elimina todas las entradas del diccionario
     */
    public void clear();

    /**
     * Regresa una lista enlazada con las llaves de búsqueda del
     * diccionario
     * @return La lista enlazada con las llaves de búsqueda del
     * diccionario
     */
    public LinkedList<K> keys();

    /**
     * Regresa una lista enlazada con los valores del diccionario
     * @return El iterador para acceder secuencialmente a los
     * valores del diccionario
     */
    public LinkedList<V> values();
}
