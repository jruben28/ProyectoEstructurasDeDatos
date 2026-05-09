/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.TreeException;

/**
 * Esta interfaz generica establece los métodos a implementar
 * por una clase que modele un arbol general
 * @param <T> Parámetro de tipo para los objetos a almacenarse
 * en el arbol
 * @author joser
 */
public interface ITree<T> {
    /**
     * Regresa el dato en la raiz del arbol
     *
     * @return El dato en la raiz del arbol
     * @throws TreeException Si el arbol esta vacio
     */
    public T getRootData() throws TreeException;

    /**
     * Regresa la altura del arbol
     *
     * @return La altura del arbol
     */
    public int getHeight();

    /**
     * Regresa el numero de nodos del arbol
     * @return El numero de nodos del arbol
     */
    public int getNumberNodes();

    /**
     * Determina si un arbol esta vacio
     * @return true si el arbol esta vacio, false en caso contrario
     */
    public boolean empty();

    /**
     * Vacia un arbol
     */
    public void clear();
}
