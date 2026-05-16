/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IDictionary;
import java.util.Iterator;

/**
 * Esta clase implementa un diccionario sobre un árbol AVL
 * @param <K> Parámetro de tipo de la llave del diccionario
 * @param <V> Parámetro de tipo del valor del diccionario
 * @author Manuel Domitsu Kono
 */
public class TreeDictionary<K extends Comparable<K>, V> implements IDictionary<K, V> {
    
    private final AVLTree<Entrada<K, V>> entradas;
    private int nEntradas;


    /**
     * Esta clase miembro representa un nodo de un diccionario simple
     */
    private class Entrada<K extends Comparable<K>, V> implements Comparable<Entrada<K, V>> {
        private final K llave;
        private final V valor;

        public Entrada(K llave, V valor) {
            this.llave = llave;
            this.valor = valor;
        }

        @Override
        public int compareTo(Entrada<K, V> entrada) {
            return llave.compareTo(entrada.llave);
        }

        @Override
        public String toString() {
            return llave + ": " + valor;
        }
    }

    /**
     * Constructor por defecto
     */
    public TreeDictionary() {
        entradas = new AVLTree<>();
        nEntradas = 0;
    }

    /**
     * Agrega una pareja llave valor al diccionario, si la llave no existe.
     * Si la llave ya existe, reemplaza el valor actual.
     *
     * @param llave Llave de búsqueda
     * @param valor Valor asociado a la llave de búsqueda
     * @return El valor asociado a la llave de búsqueda o null si la entrada no existía previamente
     */
    @Override
    public V put(K llave, V valor) {
        Entrada<K, V> entrada = entradas.get(new Entrada<>(llave, valor));
        
        // Si la entrada ya existe
        if (entrada != null) {
            // Sustituye el valor actual por el nuevo
            // Nota: Para actualizar, primero removemos la vieja y agregamos la nueva
            entradas.remove(entrada);
            entradas.insert(new Entrada<>(llave, valor));
            return entrada.valor;
        }
        
        // Si la entrada no está en el diccionario, agrégala
        entradas.insert(new Entrada<>(llave, valor));
        nEntradas++;
        return null;
    }

    /**
     * Elimina del diccionario una entrada asociada a una llave dada
     *
     * @param llave Llave de búsqueda
     * @return El valor asociado a la llave de búsqueda o null si la entrada no existe
     */
    @Override
    public V remove(K llave) {
        // Creamos una entrada dummy solo con la llave para buscar
        Entrada<K, V> entrada = entradas.get(new Entrada<>(llave, null));
        
        // Si la entrada no existe
        if (entrada == null) {
            return null;
        }
        
        // Si la entrada existe en el diccionario
        entradas.remove(entrada);
        nEntradas--;
        return entrada.valor;
    }

    /**
     * Determina el número de entradas (parejas llave valor) en el diccionario
     * @return Número de entradas en el diccionario
     */
    @Override
    public int size() {
        return nEntradas;
    }

    /**
     * Determina si el diccionario está vacío
     * @return true si el diccionario está vacío, false en caso contrario
     */
    @Override
    public boolean empty() {
        return nEntradas == 0;
    }

    /**
     * Regresa una cadena con las entradas, llave: valor del diccionario
     * @return La cadena con las entradas del diccionario
     */
    @Override
    public String toString() {
        Iterator<Entrada<K, V>> it = entradas.getInorderIterator();
        StringBuilder s = new StringBuilder("{");
        
        while (it.hasNext()) {
            s.append(it.next()).append(", ");
        }
        
        s.append("}");
        return s.toString();
    }
    
    
    /**
     * Regresa el valor asociado con la llave dada o null si la entrada no existe.
     * @param llave La llave a buscar
     * @return El valor asociado o null
     */
    @Override
    public V get(K llave) {
        Iterator<Entrada<K, V>> it = entradas.getInorderIterator();

        while (it.hasNext()) {
            Entrada<K, V> actual = it.next();
            if (actual.llave.compareTo(llave) == 0) {
                return actual.valor;
            }
        }

        return null;
    }

    /**
     * Regresa true si el diccionario contiene una entrada asociada a una llave dada.
     * @param llave La llave a verificar
     * @return true si existe, false en caso contrario
     */
    @Override
    public boolean contains(K llave) {
        return get(llave) != null;
    }

    /**
     * Elimina todas las entradas del diccionario.
     */
    @Override
    public void clear() {
        entradas.clear(); 
        nEntradas = 0;
    }

    /**
     * Regresa una lista enlazada con las llaves de búsqueda del diccionario.
     * @return LinkedList con las llaves
     */
    @Override
    public LinkedList<K> keys() {
        LinkedList<K> listaLlaves = new LinkedList<>();
        Iterator<Entrada<K, V>> it = entradas.getInorderIterator();
        
        while (it.hasNext()) {
            listaLlaves.append(it.next().llave);
        }
        
        return listaLlaves;
    }

    /**
     * Regresa una lista enlazada con los valores del diccionario.
     * @return LinkedList con los valores
     */
    @Override
    public LinkedList<V> values() {
        LinkedList<V> listaValores = new LinkedList<>();
        Iterator<Entrada<K, V>> it = entradas.getInorderIterator();
        
        while (it.hasNext()) {
            listaValores.append(it.next().valor);
        }
        
        return listaValores;
    }
}