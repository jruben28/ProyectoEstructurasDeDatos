/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IDictionary;

/**
 * HashDictionary.java
 * Esta clase implementa un diccionario sobre una tabla Hash
 * @param <K> Parámetro de tipo de la llave del diccionario
 * @param <V> Parámetro de tipo del valor del diccionario
 * @author Manuel Domitsu Kono
 */
public class HashDictionary<K, V> implements IDictionary<K, V> {
    
    private final LinkedList<Entrada<K, V>>[] tablaHash;
    private int nEntradas;
    private final int tamTablaHash;

    /**
     * Esta clase miembro representa un nodo de un diccionario simple
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
            return llave + ":" + valor;
        }
    }

    @SuppressWarnings("unchecked")
    public HashDictionary(int tamTablaHash) {
        this.tamTablaHash = tamTablaHash;
        LinkedList<Entrada<K, V>>[] tablaHashTemp = 
            (LinkedList<Entrada<K, V>>[]) new LinkedList[tamTablaHash];
        this.tablaHash = tablaHashTemp;
        this.nEntradas = 0;
    }

    /**
     * Agrega una pareja llave valor al diccionario, si la
     * llave no existe en el diccionario. Si la llave ya existe,
     * reemplaza el valor actual con el valor del parametro
     * @param llave Llave de búsqueda
     * @param valor Valor asociado a la llave de búsqueda
     * @return El valor asociado a la llave de búsqueda o null
     * si la entrada no existia previamente
     */
    @Override
    public V put(K llave, V valor) {
        // Obtiene el indice de la entrada en la tabla hash
        int indiceTablaHash = getIndexHashTable(llave);
        
        // Si hay un balde en el que puede estar la entrada
        if (tablaHash[indiceTablaHash] != null) {
            // Obtiene el balde
            LinkedList<Entrada<K, V>> balde = tablaHash[indiceTablaHash];
            
            // Recorre el balde
            for (Entrada<K, V> entrada : balde) {
                // Si hay una entrada con la llave buscada
                if (llave.equals(entrada.llave)) {
                    V valorActual = entrada.valor;
                    // Sustituye el valor actual por el nuevo
                    entrada.valor = valor;
                    // Regresa su valor
                    return valorActual;
                }
            }
            // Si la entrada no esta en el balde, agregala
            balde.append(new Entrada<>(llave, valor));
            nEntradas++;
            return null;
        }
        
        // Si no hay un balde para la entrada, crealo
        tablaHash[indiceTablaHash] = new LinkedList<Entrada<K, V>>();
        tablaHash[indiceTablaHash].append(new Entrada<K, V>(llave, valor));
        nEntradas++;
        return null;
    }

    private int getIndexHashTable(K llave) {
        return Math.abs(llave.hashCode()) % tamTablaHash;
    }

    /**
     * Elimina del diccionario una entrada asociada a una llave dada
     * @param llave Llave de búsqueda
     * @return El valor asociado a la llave de búsqueda o null si la
     * entrada no existe
     */
    @Override
    public V remove(K llave) {
        // Obtiene el indice de la entrada en la tabla hash
        int indiceTablaHash = getIndexHashTable(llave);
        
        // Si hay un balde en el que puede estar la entrada
        if (tablaHash[indiceTablaHash] != null) {
            // Obtiene el balde
            LinkedList<Entrada<K, V>> balde = tablaHash[indiceTablaHash];
            
            // Recorre el balde
            for (Entrada<K, V> entrada : balde) {
                // Si hay una entrada con la llave buscada
                if (llave.equals(entrada.llave)) {
                    balde.remove(entrada);
                    nEntradas--;
                    return entrada.valor;
                }
            }
        }
        // Si no hay un balde en el que puede estar la entrada
        return null;
    }

    /**
     * Determina el número de entradas (parejas llave valor)
     * en el diccionario
     * @return Número de entradas en el diccionario
     */
    @Override
    public int size() {
        return nEntradas;
    }

    /**
     * Determina si el diccionario esta vacio
     * @return true si el diccionario esta vacio, false en caso
     * contrario
     */
    @Override
    public boolean empty() {
        return nEntradas == 0;
    }

    /**
     * Regresa una cadena con las entradas, llave: valor del
     * diccionario
     * @return La cadena con las entradas, llave: valor del
     * diccionario
     */
    @Override
    public String toString() {
        String s = "{";
        for (LinkedList<Entrada<K, V>> balde : tablaHash) {
            if (balde != null) {
                for (Entrada<K, V> entrada : balde) {
                    s += entrada + ", ";
                }
            }
        }
        return s + "}";
    }
    
    
    
    
    /**
     * Obtiene del diccionario un valor asociado a una llave dada
     * @param llave Llave de búsqueda
     * @return El valor asociado a la llave de búsqueda o null si la
     * entrada no existe
     */
    @Override
    public V get(K llave) {
        int indiceTablaHash = getIndexHashTable(llave);
        if (tablaHash[indiceTablaHash] != null) {
            LinkedList<Entrada<K, V>> balde = tablaHash[indiceTablaHash];
            for (Entrada<K, V> entrada : balde) {
                if (llave.equals(entrada.llave)) {
                    return entrada.valor;
                }
            }
        }
        return null;
    }

    /**
     * Determina si el diccionario contiene una entrada asociada
     * a una llave dada
     * @param llave Llave de búsqueda
     * @return true si el diccionario contiene una entrada asociada
     * a una llave dada, false en caso contrario
     */
    @Override
    public boolean contains(K llave) {
        int indiceTablaHash = getIndexHashTable(llave);
        if (tablaHash[indiceTablaHash] != null) {
            LinkedList<Entrada<K, V>> balde = tablaHash[indiceTablaHash];
            for (Entrada<K, V> entrada : balde) {
                if (llave.equals(entrada.llave)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Elimina todas las entradas del diccionario
     */
    @Override
    public void clear() {
        for (int i = 0; i < tablaHash.length; i++) {
            tablaHash[i] = null;
        }
        nEntradas = 0;
    }

    /**
     * Regresa una lista enlazada con las llaves de búsqueda del
     * diccionario
     * @return La lista enlazada con las llaves de búsqueda del
     * diccionario
     */
    @Override
    public LinkedList<K> keys() {
        LinkedList<K> listaLlaves = new LinkedList<>();
        for (LinkedList<Entrada<K, V>> balde : tablaHash) {
            if (balde != null) {
                for (Entrada<K, V> entrada : balde) {
                    listaLlaves.append(entrada.llave);
                }
            }
        }
        return listaLlaves;
    }

    /**
     * Regresa una lista enlazada con los valores del diccionario
     * @return La lista enlazada con los valores del diccionario
     */
    @Override
    public LinkedList<V> values() {
        LinkedList<V> listaValores = new LinkedList<>();
        for (LinkedList<Entrada<K, V>> balde : tablaHash) {
            if (balde != null) {
                for (Entrada<K, V> entrada : balde) {
                    listaValores.append(entrada.valor);
                }
            }
        }
        return listaValores;
    }
    
    
}
