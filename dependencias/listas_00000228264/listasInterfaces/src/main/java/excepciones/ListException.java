/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Esta clase implementa la excepción lanzada por los metodos de las
 * clases que implementan la interfaz IList.
 * @author joser
 */
public class ListException extends RuntimeException{
    /**
    * Constructor por omision
    */
    public ListException() {
    super();
    }
    /**
    * Constructor que establece un mensaje en la excepción
    *
    * @param msj Mensaje para la excepcion
    */
    public ListException(String msj) {
        super(msj);
    }
}
