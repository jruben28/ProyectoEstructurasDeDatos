/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import implementaciones.ArrayList;
import implementaciones.ArrayListQueue;
import implementaciones.EstudiantesBST;

/**
 *
 * @author joser
 */
public class Estudiante implements Comparable<Estudiante>{
    String matricula;
    String nombreCompleto;
    String telefono;
    String correo;
    String calle;
    String numero;
    String colonia;
    String ciudad;
    ArrayList calificaciones;
    ArrayListQueue solicitudCalificaciones;

    /**
     * Constructor de estudiante, inicializa la lista de califiaciones vacia y la solicitud de lista de califiaciones.
     * @param matricula
     * @param nombreCompleto
     * @param telefono
     * @param correo
     * @param calle
     * @param numero
     * @param colonia
     * @param ciudad 
     */
    public Estudiante(String matricula, String nombreCompleto, String telefono, String correo, String calle, String numero, String colonia, String ciudad, EstudiantesBST arbolEstudiantes) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.calificaciones = new ArrayList(float.class, 30);
        this.solicitudCalificaciones = new ArrayListQueue(ArrayList.class, 30);
        agregarABST(arbolEstudiantes);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Calcula promedio del estudiante recursivamente.
     * @return promedio estudiante.
     */
    public float calcularPromedio() {
        if (calificaciones == null || calificaciones.empty()) {
            return 0.0f;
        }
        return sumarCalificacionesRecursivo(0) / calificaciones.size();
    }
    
    /**
     * Suma todas las calificaciones de forma recursiva.
     * @param indice Posicion inicial de arreglo de calificacion.
     * @return La suma acumulada de las calificaciones.
     */
    private float sumarCalificacionesRecursivo(int indice) {
        if (indice == calificaciones.size()) {
            return 0.0f;
        }
        return (float)calificaciones.get(indice) + sumarCalificacionesRecursivo(indice + 1);
        
    }
    
    /**
     * Agrega a la cola de solicitudes de calificacion una nueva
     * @param nuevaLista 
     */
    public void agregarSolicitudCalificaciones(ArrayList nuevaLista){
        if (nuevaLista != null) {
            solicitudCalificaciones.enqueue(nuevaLista);
            
        }
    }
    
    /**
     * Procesa la siguiente solicitud en la cola y la aplica.
     */
    public void procesarSiguienteSolicitud(){
        if (!solicitudCalificaciones.empty()) {
            this.calificaciones = (ArrayList) solicitudCalificaciones.dequeue();
            
        }
    
    }


    /**
     * Al crear un estudiante, lo agrega al arbol binario de busqueda.
     * @param arbolEstudiantes
     */
    public void agregarABST(EstudiantesBST arbolEstudiantes){
//        // Validamos que el arbol global exista
//        if (arbolEstudiantes == null) {
//            System.out.println("El árbol de estudiantes no está inicializado");
//            return;
//        }

        // Insertamos el estudiante actual en el arbol
        arbolEstudiantes.insertarEstudiante(this);

        // Confirmamos la operacion
        System.out.println("Estudiante con matricula " + this.matricula + " agregado al BST correctamente");
    }

    @Override
    public int compareTo(Estudiante otro) {
         return this.matricula.compareTo(otro.matricula);
    }
}
