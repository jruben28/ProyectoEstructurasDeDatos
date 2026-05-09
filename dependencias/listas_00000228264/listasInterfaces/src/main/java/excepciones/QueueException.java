/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author joser
 */
public class QueueException extends RuntimeException {
    /**
    * Constructor por omision
    */
    public QueueException() {
    super();
    }
    /**
    * Constructor que establece un mensaje en la excepcion
    * @param msj Mensaje para la excepcion
    */
    public QueueException(String msj) {
    super(msj);
    }
}
