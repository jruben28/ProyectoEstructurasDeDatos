/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import implementaciones.LinkedList;

/**
 *
 * @author joser
 */
public class Curso {
    Float clave;
    String nombre;
    LinkedList<Estudiante> listadoEstudiantes;
    //CircularDoubleLinkedList<Estudiante> listaEspera;
    //CircularLinkedList<Estudiante> roles;
    Estudiante tutorActual;

    public Curso(Float clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
        this.listadoEstudiantes = new LinkedList<>();
        //this.listaEspera = new CircularDoubleLinkedList<>();
        //this.roles = new CircularLinkedList<>();
    }
    
    /**
     * Recorre la lista de espera adelante y regresa el siguiente estudiante
     * @return 
     */
    public Estudiante recorrerAdelanteListaEspera(){
        return null;
    }
    
    /**
     * Recorre la lista de espera atras y regresa el anterior estudiante
     * @return 
     */
    public Estudiante recorrerAtrasListaEspera(){
        return null;
    }
    
    /**
     * Regresa una lista de los primeros n estudiantes
     * @param n
     * @return 
     */
    public LinkedList<Estudiante> mostrarNPrimeros(int n){
        return null;
    }
    
    /**
     * Regresa la lista completa de estudiantes en el curso
     * @return 
     */
    public LinkedList<Estudiante> mostrarEstudiantes(){
        return null;
    }
    
    //public CircularDoubleLinkedList<Estudiante> mostrarListaEspera()
    /**
     * Actualiza la lista de los roles según los estudiantes actuales del curso.
     */
    public void actualizarListaRoles(){
    
    }

    public Float getClave() {
        return clave;
    }

    public void setClave(Float clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
