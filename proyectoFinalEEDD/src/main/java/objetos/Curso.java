/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import implementaciones.CircularLinkedList;
import implementaciones.DoubleCircularLinkedList;
import implementaciones.LinkedList;
import implementaciones.Nodo;

/**
 *
 * @author joser
 */
public class Curso {

    private String clave;
    private String nombre;
    private Integer capacidadMaxima;
    private LinkedList<Estudiante> listadoEstudiantes;
    private DoubleCircularLinkedList<Estudiante> listaEspera;
    private CircularLinkedList<Estudiante> roles;
    private Estudiante tutorActual;

    /**
     * Constructor del curso. Inicializa las estructuras necesarias para el
     * manejo de estudiantes, lista de espera y rotación de roles.
     *
     * @param clave Clave única del curso.
     * @param nombre Nombre del curso.
     * @param capacidadMaxima Capacidad máxima permitida.
     */
    public Curso(String clave, String nombre, int capacidadMaxima) {
        this.clave = clave;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        // Lista de estudiantes inscritos
        this.listadoEstudiantes = new LinkedList<>();
        // Lista de espera circular doble
        this.listaEspera = new DoubleCircularLinkedList<>();
        // Lista circular para rotación de roles
        this.roles = new CircularLinkedList<>();
        // Inicialmente no hay tutor asignado
        this.tutorActual = null;
    }

    /**
     * Recorre la lista de espera adelante y regresa el siguiente estudiante
     *
     * @return
     */
    public Estudiante recorrerAdelanteListaEspera() {
        //validamos si la lista de espera esta vacia
        if (listaEspera.empty()) {
            //si esta vacia regresamos null
            return null;
        }
        //obtenemos el inicio de la lista de espera 
        Nodo<Estudiante> actual = listaEspera.getInicio();
        // Avanza el inicio al siguiente nodo
        listaEspera.setInicio(actual.getSiguiente());
        //regresamos el estudiante que fue recorrido
        return actual.getDato();
    }

    /**
     * Recorre la lista de espera atras y regresa el anterior estudiante
     *
     * @return
     */
    public Estudiante recorrerAtrasListaEspera() {
        //validar la lista de espera
        if (listaEspera.empty()) {
            //si esta vacia regresa null
            return null;
        }
        //obtenemos el inicio de la lista de espera
        Nodo<Estudiante> actual = listaEspera.getInicio();
        //retrocededemos el inicio al nodo anterior
        listaEspera.setInicio(actual.getAnterior());
        //regresamos el estudiante recorrido
        return actual.getDato();
    }

    /**
     * Regresa una lista de los primeros n estudiantes
     *
     * @param n
     * @return
     */
    public LinkedList<Estudiante> mostrarNPrimeros(int n) {
        //validamos el numero
        if (n <= 0) {
            System.out.println("El numero ingresado debe ser mayor a 0");
            return new LinkedList<>();
        }
        //creamos la lista que vamos a regresar 
        LinkedList<Estudiante> estudiantes = new LinkedList<>();
        //validamos la lista de espera de los estudiantes 
        if (listaEspera.empty()) {
            return estudiantes;
        }

        //creamos un aux 
        Nodo<Estudiante> aux = listaEspera.getInicio();
        //reccoremos la lista de espera 
        for (int i = 0; i < n; i++) {
            //agregamos el estudiante de la lista de espera a la lista de estudiantes
            estudiantes.append(aux.getDato());
            //avanza el apuntador
            aux = aux.getSiguiente();
            //validamos de que no haya llegado al inicio
            if (aux == listaEspera.getInicio()) {
                //si llego al inicio termina el ciclo
                System.out.println("Lista de espera recorrida");
                break;
            }
        }
        //regresamos la lista de estudiantes 
        return estudiantes;
    }

    /**
     * Regresa la lista completa de estudiantes en el curso
     *
     * @return
     */
    public LinkedList<Estudiante> mostrarEstudiantes() {
        return listadoEstudiantes;
    }

    public DoubleCircularLinkedList<Estudiante> mostrarListaEspera() {
        return listaEspera;
    }

    /**
     * Actualiza la lista de los roles según los estudiantes actuales del curso.
     */
    public void actualizarListaRoles() {
        //limpiamos la lista de roles
        roles.clear();
        //recorremos la lista de estudiantes inscritos
        for (int i = 0; i < listadoEstudiantes.size(); i++) {
            //obtenemos el estudiante actual
            Estudiante estudiantes = listadoEstudiantes.get(i);
            //agregamos el estudiante a la lista circular de roles
            roles.addLast(estudiantes);
        }
        //validamos que la lista de roles no este vacia
        if (!roles.empty()) {
            //asignamos el primer estudiante como tutor actual
            tutorActual = roles.peek();
        }
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        //validamos que el estudiante no este inscrito ya
        if (listadoEstudiantes.contains(estudiante)) {
            //si el estudiante esta inscrito mostrara este mensaje
            System.out.println("El estudiante ya esta inscrito en el curso");
            return;
        }
        //validamos que el estudiante no este ya en la lista de espera
        if (listaEspera.contains(estudiante)) {
            //si el estudiante esta en la lista de espera mostrara este mensaje
            System.out.println("El estudiante ya esta en lista de espera");
            return;
        }
        //revisamos si el curso ya alcanzo su capacidad maxima
        if (listadoEstudiantes.size() >= capacidadMaxima) {
            //si alcanzo su capacidad maxima mostramos un mensaje y lo agregamos a la lista de espera
            System.out.println("El curso esta lleno, se agrego a lista de espera");
            listaEspera.addLast(estudiante);
            return;
        }
        //si no esta lleno el curso agregamos el estudiante
        listadoEstudiantes.append(estudiante);
        System.out.println("Estudiante agregado correctamente");
        //actualizamos la lista de roles
        actualizarListaRoles();
    }

    public Estudiante rotarRol() {
        //validamos si la lista de roles esta vacia
        if (roles.empty()) {
            //si esta vacia mostramos un mensaje y regresamos null
            System.out.println("La lista de roles esta vacia");
            return null;
        }
        //obtenemos el inicio actual de la lista de roles
        Nodo<Estudiante> actual = roles.getInicio();
        //movemos el inicio al siguiente estudiante
        roles.setInicio(actual.getSiguiente());
        //actualizamos el tutor actual y lo regresamos
        return tutorActual = roles.getInicio().getDato();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public LinkedList<Estudiante> getListadoEstudiantes() {
        return listadoEstudiantes;
    }

    public void setListadoEstudiantes(LinkedList<Estudiante> listadoEstudiantes) {
        this.listadoEstudiantes = listadoEstudiantes;
    }

    public DoubleCircularLinkedList<Estudiante> getListaEspera() {
        return listaEspera;
    }

    public void setListaEspera(DoubleCircularLinkedList<Estudiante> listaEspera) {
        this.listaEspera = listaEspera;
    }

    public CircularLinkedList<Estudiante> getRoles() {
        return roles;
    }

    public void setRoles(CircularLinkedList<Estudiante> roles) {
        this.roles = roles;
    }

    public Estudiante getTutorActual() {
        return tutorActual;
    }

    public void setTutorActual(Estudiante tutorActual) {
        this.tutorActual = tutorActual;
    }

}
