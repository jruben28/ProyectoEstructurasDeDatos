/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Esta clase implementa la excepción lanzada por los metodos de las
 * clases que implementan la interfaz IStack.
 * @author joser
 */
public class StackException extends RuntimeException{
    /**
    * Constructor por omision
    */
    public StackException() {
    super();
    }
    /**
    * Constructor que establece un mensaje en la excepcion
    * @param msj Mensaje para la excepcion
    */
    public StackException(String msj) {
    super(msj);
    }
}
