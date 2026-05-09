/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.ListException;
import interfaces.IList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Esta clase generica implementa una lista sobre un arreglo
 * @author joser
 * @param <T> Tipo de dato
 */
public class ArrayList<T> implements IList<T>, Iterable<T>{
    protected int nElementos;
    private final int tamLista;
    private final T lista[];

    @Override
    public boolean contains(T o) {
        for (int i = 0; i < nElementos; i++) {
            
            // Caso 1: El elemento buscado es null
            if (o == null) {
                if (lista[i] == null) {
                    return true;
                }
            } 
            // Caso 2: El elemento buscado no es null (Usamos equals)
            else {
                if (o.equals(lista[i])) {
                    return true;
                }
            }
        }
        
        // Si terminamos el ciclo y no lo encontramos
        return false;
    }

    /**
     * Esta clase miembro representa un iterador para esta lista
     */
    private class ListIterator<T> implements Iterator<T> {
        private int actual = 0;

        /**
         * Determina si el iterador tiene otro elemento que regresar
         *
         * @return true si el iterador tiene otro elemento que
         * regresar, false en caso contrario.
         */
        @Override
        public boolean hasNext() {
            return actual < nElementos;
        }

        /**
         * Regresa una referencia al siguiente elemento de la
         * colección y avanza el iterador a la siguiente posición.
         *
         * @return Una referencia al siguiente elemento de la
         * colección
         * @throws Una excepción del tipo NoSuchElementException si
         * ya no hay elementos que regresar
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) lista[actual++];
        }
    }

    /**
     * Constructor de la clase. Crea el arreglo sobre el que se
     * implementa la lista e inicializa nElementos a cero para
     * indicar que la lista inicialmente esta vacia.
     * @param tipoDato Tipo de los elementos que se almacenaran en
     * la lista
     * @param tamLista Tamaño del arreglo sobre el que se implementa
     * la lista
     */
    public ArrayList(Class<T> tipoDato, int tamLista) {
        this.tamLista = tamLista;
        nElementos = 0;
        lista = (T[]) java.lang.reflect.Array.newInstance(tipoDato, tamLista);
    }

    /**
     * Inserta un elemento al final de la lista
     * @param o Elemento a insertar al final de la lista
     * @throws ListException Si la lista esta llena
     */
    @Override
    public void append(T o) throws ListException {
        // Si la lista esta llena, lanza una excepcion
        if (nElementos >= tamLista)
            throw new ListException("Lista llena");
        // Inserta el dato en el nElementos de la lista
        lista[nElementos] = o;
        nElementos++;
    }

    /**
     * Inserta un elemento en la posición i de la lista
     * @param o Elemento a insertar en la posición i de la lista
     * @param i Posición i de la lista donde se inserta el elemento
     * @throws ListException Si la lista esta llena o i menor que 0 o i mayor o igual a size()
     */
    @Override
    public void insert(T o, int i) throws ListException {
        // Si la lista esta llena, lanza una excepcion
        if (nElementos >= tamLista)
            throw new ListException("Lista llena");
        // Si el indice i esta fuera de los limites de los datos
        if (i < 0 || i > nElementos)
            throw new ListException("Indice fuera de limites");
        for (int j = nElementos; j > i; j--)
            lista[j] = lista[j - 1];
        lista[i] = o;
        nElementos++;
    }

    /**
     * Inspecciona el elemento en la posición i de la lista sin
     * extraerlo
     * @param i Posición i de la lista del elemento a inspeccionar
     * @return El elemento en la posición i de la lista
     * @throws ListException Si la lista esta vacia o i menor que 0 o i mayor o igual a size()
     */
    @Override
    public T get(int i) throws ListException {
        // Si la lista esta vacia lanza una excepcion
        if (empty())
            throw new ListException("Lista vacia");
        // Si el indice i esta fuera de los limites de los datos
        if (i < 0 || i >= nElementos)
            throw new ListException("Indice fuera de limites");
        return lista[i];
    }

    /**
     * Extrae el elemento de la posición i de la lista
     * @param i Posición i de la lista del elemento a remover
     * @return El elemento de la posición i de la lista
     * @throws ListException Si la lista esta vacia o i menor que 0 o i mayor o igual a size()
     */
    @Override
    public T remove(int i) throws ListException {
        T o = get(i);
        for (int j = i; j < nElementos - 1; j++)
            lista[j] = lista[j + 1];
        nElementos--;
        return o;
    }

    /**
     * Determina si la lista se encuentra vacía
     * @return true si la lista se encuentra vacia,
     * false en caso contrario.
     */
    @Override
    public boolean empty() {
        return nElementos == 0;
    }

    /**
     * Regresa el numero de elementos en la lista
     * @return El numero de elementos en la lista
     */
    @Override
    public int size() {
        return nElementos;
    }

    /**
     * Regresa un iterador para esta lista
     * @return Un iterador para esta lista
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    /**
     * Genera una cadena con los valores de los elementos de la
     * lista
     * @return La cadena con los valores de los elementos de la
     * lista
     */
    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < nElementos; i++) {
            s += lista[i];
            if (i < nElementos - 1)
                s += ", ";
        }
        s += "]";
        return s;
    }
   
    /**
     * Establece el elemento dado en el indice dado
     * @param o elemento a establecer
     * @param i indice de la lista
     * @throws ListException en caso de que la lista esté vacia o si el indice esta fuera de rago
     */
    @Override
    public void set(T o, int i) throws ListException {
        //El método lanza una excepción del tipo ListException si la lista está vacía
        //o el indice i esta fuera de los límites de los datos.
        if(nElementos == 0){
            throw new ListException("Error: la lista se encuentra vacia");
        }
        
        if(i >= nElementos || i < 0){
            throw new ListException("Error: el indice se encuentra fuera de los limites");
        }
        
        lista[i] = o;
        
    }

    /**
     * Remueve la primera ocurrencia del elemento de la lista
     * @param o objeto a eliminar
     * @return regresa true si se elimina, false si no se encuentra en ella
     */
    @Override
    public boolean remove(T o){
        int indice = indexOf(o);
        if(indice != -1){
            remove(indice);
            return true;
        }
        return false;
    }

    /**
     * Regresa el indice del elemento
     * @param o elemento de tipo
     * @return el indice del elemento, -1 en caso de que no exista
     */
    @Override
    public int indexOf(T o) {
        //en caso de que o sea null
        if (o == null) {
            for (int j = 0; j < nElementos; j++) {
                if (lista[j] == null) {
                    return j; 
                }
            }
        }
        else{
            for (int j = 0; j < nElementos; j++) {
                if (o.equals(lista[j])) {
                    return j;
                }
            }
        }
        
        return -1;
    }

    /**
     * limpia nuestra lista, borra todos los elementos
     */
    @Override
    public void clear() {
        nElementos = 0;
    }
    
}
