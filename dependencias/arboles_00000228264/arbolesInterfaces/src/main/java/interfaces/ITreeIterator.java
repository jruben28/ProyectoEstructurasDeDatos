/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Iterator;

/**
 * ITreeIterator.java
 * Esta interfaz generica establece los métodos para recorrer
 * un arbol binario
 * @param <T> Parámetro de tipo para los objetos a almacenarse
 * en el arbol
 * @author joser
 */
public interface ITreeIterator<T> {
    /**
     * Obtiene un iterador para recorrer el arbol en orden
     *
     * @return Un iterador para recorrer el arbol en orden
     */
    public Iterator<T> getInorderIterator();

    /**
     * Obtiene un iterador para recorrer el arbol en preorden
     * @return Un iterador para recorrer el arbol en preorden
     */
    public Iterator<T> getPreorderIterator();

    /**
     * Obtiene un iterador para recorrer el arbol en postorden
     *
     * @return Un iterador para recorrer el arbol en postorden
     */
    public Iterator<T> getPostorderIterator();
}
