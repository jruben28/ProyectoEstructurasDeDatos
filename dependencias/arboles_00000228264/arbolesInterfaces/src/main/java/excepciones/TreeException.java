/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Esta clase implementa la excepción lanzada por los metodos de la
 * clase que implementa la interfaz ITree.
 * @author joser
 */
public class TreeException extends RuntimeException{
    /**
    * Constructor por omision
    */
    public TreeException() {
        super();
    }
    /**
    * Constructor que establece un mensaje en la excepcion
    * @param msj Mensaje para la excepcion
    */
    public TreeException(String msj) {
        super(msj);
    }
    
}
