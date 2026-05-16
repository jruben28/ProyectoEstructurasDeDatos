/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IDictionary;

/**
 * Esta clase implementa un diccionario sobre una lista ligada
 *
 * @param <K> Parámetro de tipo de la llave del diccionario
 * @param <V> Parámetro de tipo del valor del diccionario
 *
 * @author joser
 */
public class LinkedListDictionary<K, V> implements IDictionary<K, V> {
    
    private final LinkedList<Entrada<K, V>> entradas;
    private int nEntradas;

    /**
     * constructor de clase
     */
    public LinkedListDictionary() {

        entradas = new LinkedList<>();
        nEntradas = 0;
    }

    /**
     Esta clase miembro representa un nodo de un diccionario
     * simple
     */
    private class Entrada<K, V> {
        private final K llave;
        private V valor;

        public Entrada(K llave, V valor) {
            this.llave = llave;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return llave + ": " + valor;
        }
    }

    /**
     * Agrega una pareja llave valor al diccionario, si la
     *
     llave no existe en el diccionario. Si la llave ya existe,
     reemplaza el valor actual con el valor del parametro
     * @param llave Llave de búsqueda
     * @param valor Valor asociado a la llave de búsqueda
     *
     @return El valor asociado a la llave de búsqueda o null
     * si la entrada no existia previamente
     */
    @Override
    public V put(K llave, V valor) {
        for (Entrada<K, V> entrada : entradas) {
            // Si hay una entrada con la llave buscada
            if (llave.equals(entrada.llave)) {
                V valorActual = entrada.valor;
                // Sustituye el valor actual por el nuevo
                entrada.valor = valor;
                // Regresa su valor
                return valorActual;
            }
        }
        // Si la entrada no esta en diccionario, agregala
        entradas.append(new Entrada<>(llave, valor));
        nEntradas++;
        return null;
    }

    /**
     * Elimina del diccionario una entrada asociada a una llave dada
     * @param llave Llave de búsqueda
     * @return El valor asociado a la llave de búsqueda o null si la
     *
     entrada no existe
     */
    @Override
    public V remove(K llave) {
        for (Entrada<K, V> entrada : entradas) {
            // Si hay una entrada con la llave buscada
            if (llave.equals(entrada.llave)) {
                entradas.remove(entrada);
                nEntradas--;
                return entrada.valor;
            }
        }
        // Si no hay una entrada
        return null;
    }

    /**
     * Determina el número de entradas (parejas llave valor)
     *
     en el diccionario
     *
     * @return Número de entradas en el diccionario
     */
    @Override
    public int size() {
        return nEntradas;
    }

    /**
     * Determina si el diccionario esta vacio
     *
     * @return true si el diccionario esta vacio, false en caso
     * contrario
     */
    @Override
    public boolean empty() {
        return nEntradas == 0;
    }

    /**
     Regresa una cadena con las entradas, llave: valor del
     *
     * diccionario
     *
     * @return La cadena con las entradas, llave: valor del
     * diccionario
     */
    @Override
    public String toString() {
        String s = "{";
        for (Entrada<K, V> entrada : entradas)
            s += entrada + ", ";
        s += "}";
        return s;
    }
    
    
    /**
     * Regresa el valor asociado con la llave dada o null si la entrada no existe.
     * @param llave Llave de búsqueda
     * @return El valor asociado o null
     */
    public V get(K llave) {
        for (Entrada<K, V> entrada : entradas) {
            if (llave.equals(entrada.llave)) {
                return entrada.valor;
            }
        }
        return null;
    }

    /**
     * Regresa true si el diccionario contiene una entrada asociada a una llave dada,
     * false en caso contrario.
     * @param llave Llave de búsqueda
     * @return true si existe, false si no
     */
    public boolean contains(K llave) {
        for (Entrada<K, V> entrada : entradas) {
            if (llave.equals(entrada.llave)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina todas las entradas del diccionario.
     */
    public void clear() {
        if (nEntradas > 0) {
            entradas.clear(); 
            nEntradas = 0;
        }
    }

    /**
     * Regresa una lista enlazada con las llaves de búsqueda del diccionario.
     * @return Lista de llaves
     */
    public LinkedList<K> keys() {
        LinkedList<K> listaLlaves = new LinkedList<>();
        for (Entrada<K, V> entrada : entradas) {
            listaLlaves.append(entrada.llave);
        }
        return listaLlaves;
    }

    /**
     * Regresa una lista enlazada con los valores del diccionario.
     * @return Lista de valores
     */
    public LinkedList<V> values() {
        LinkedList<V> listaValores = new LinkedList<>();
        for (Entrada<K, V> entrada : entradas) {
            listaValores.append(entrada.valor);
        }
        return listaValores;
    }
}