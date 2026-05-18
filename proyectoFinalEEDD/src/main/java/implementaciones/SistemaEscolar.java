/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import implementaciones.ArrayListQueue;
import objetos.Accion;
import objetos.Curso;
import objetos.Estudiante;
import objetos.Inscripcion;
import objetos.ParPromedioEstudiante;
import objetos.SolicitudCalificacion;

/**
 *
 * @author Jorge
 */
public class SistemaEscolar {

    //arbol binario de busqueda de estudiantes
    private EstudiantesBST estudiantes;
    //catalogo de cursos
    private CatalogoCursos cursos;
    //cola de solicitudes de calificaciones
    private ArrayListQueue<SolicitudCalificacion> solicitudes;
    //pila de acciones
    private Acciones acciones;
    //arbol AVL de promedios
    private PromedioEstudiante promedios;

    public SistemaEscolar() {
        //inicializamos el arbol de estudiantes
        estudiantes = new EstudiantesBST();
        //inicializamos el catalogo de cursos
        cursos = new CatalogoCursos();
        //inicializamos la cola de solicitudes
        solicitudes = new ArrayListQueue<>(SolicitudCalificacion.class, 50);
        //inicializamos las acciones
        acciones = new Acciones();
        //inicializamos promedios 
        promedios = new PromedioEstudiante();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        //validamos si la lista esta vacia 
        if (estudiante == null) {
            //si la lista esta vacia mostramos este mensaje y terminamos este proceso 
            System.out.println("El estudiante no pede ser nulo");
            return;
        }
        //agregamos el estudiante 
        estudiantes.insertarEstudiante(estudiante);
        //registramos la accion realizada 
        acciones.agregarAccion(new Accion("REGISTRO_ESTUDIANTE", estudiante));
        //mostramos el estudiantw
        System.out.println("Estudiante agregado correctamente");
    }

    public void registrarCurso(Curso curso) {
        //validamos si el curso es nulo 
        if (curso == null) {
            //si es nulo, mostramos el mensaje 
            System.out.println("el curso no puede estar nulo");
            return;
        }
        //agregamos el curso 
        cursos.agregarCurso(curso);
        //registamos la accion
        acciones.agregarAccion(new Accion("REGISTRO_CURSO", curso));
        System.out.println("Curso agregado correctamente");
    }

    public Estudiante buscarEstudiante(String matricula) {
        //validamos si la matricula es nulaa
        if (matricula == null) {
            //mostramos el mensaje si es nula
            System.out.println("La matricula no puede ser nula");
            //regresamos nulo y terminamos el proceso
            return null;
        }
        //obtenermos el estudiante y lo almacenamos temporalmente 
        Estudiante estudiante = estudiantes.busquedaPorMatricula(matricula);
        //validamos que el estudiante no este nulo 
        if (estudiante == null) {
            //si es nulo mostramos este mensaje 
            System.out.println("El estudiante no esta registrado");
            //regresamos nulo y terminamos el preoceso 
            return null;
        }
        //mostramos el mensaje de encontrado 
        System.out.println("Estudiante encontrado");
        //regresamos el estudiante 
        return estudiante;
    }

    public void inscribirEstudianteCurso(String matricula, String claveCurso) {
        //buscamos el estudiante mediante su matricula
        Estudiante estudiante = buscarEstudiante(matricula);
        //validamos si el estudiante es nulo 
        if (estudiante == null) {
            return;
        }
        //buscamos el curso mediante su clave
        Curso curso = cursos.buscarCurso(claveCurso);
        //validamos que el curso exista
        if (curso == null) {
            System.out.println("El curso no existe");
            return;
        }
        //inscribimos el estudiante en el curso
        curso.inscribirEstudiante(estudiante);
        //registramos la accion
        acciones.agregarAccion(new Accion("INSCRIPCION", new Inscripcion(estudiante, curso)));
        //mostramos el mensaje de exito 
        System.out.println("Inscripcion realizada correctamente");
    }

    public void deshacerUltimaAccion() {
        //obtenemos la ultima accion realizada
        Accion accion = acciones.deshacerAccion();
        //validamos si la accion existe
        if (accion == null) {
            return;
        }
        //guardamos el tipo de accion
        String tipoAccion = accion.getTipo();
        //evaluamos el tipo de accion
        switch (tipoAccion) {
            case "REGISTRO_ESTUDIANTE":
                //obtenemos el estudiante registrado
                Estudiante estudiante = (Estudiante) accion.getDato();
                //eliminamos el estudiante del BST
                estudiantes.eliminarEstudiante(estudiante);
                //mostramos mensaje
                System.out.println("Se deshizo el registro de estudiante");
                break;

            case "REGISTRO_CURSO":
                //obtenemos el curso registrado
                Curso curso = (Curso) accion.getDato();
                //eliminamos el curso
                cursos.eliminarCurso(curso.getClave());
                //mostramos mensaje
                System.out.println("Se deshizo el registro del curso");
                break;
            case "INSCRIPCION":
                //obtenemos la inscripcion
                Inscripcion inscripcion = (Inscripcion) accion.getDato();
                //obtenemos el curso
                Curso curso2 = inscripcion.getCurso();
                //obtenemos el estudiantew
                Estudiante estudiante2 = inscripcion.getEstudiante();
                //eliminamos el estudiante del curso
                curso2.eliminarEstudiante(estudiante2);
                //mostramos mensaje
                System.out.println("Se deshizo la inscripcion");
                break;
            case "CALIFICACION":
                //obtenemos la solicitiud
                SolicitudCalificacion solicitud = (SolicitudCalificacion) accion.getDato();
                //obtenemos el estudiante
                Estudiante estudiante3 = solicitud.getEstudiante();
                //validamos si tiene calificaciones
                if (!estudiante3.getCalificaciones().empty()) {
                    //eliminamos la ultima calificacion agregada
                    estudiante3.getCalificaciones().remove(estudiante3.getCalificaciones().size() - 1);
                }
                //mostramos mensaje
                System.out.println("Se deshizo la calificacion");
                break;
            default:
                //mostramos mensaje si el tipo no existe
                System.out.println("Tipo de accion no reconocido");
        }
    }

    public void deshacerTodasAcciones() {
        //validamos si existen acciones
        if (acciones.getAcciones().empty()) {
            System.out.println("No hay acciones para deshacer");
            return;
        }
        //deshacemos todas las acciones
        while (!acciones.getAcciones().empty()) {
            deshacerUltimaAccion();
        }
        System.out.println("Todas las acciones fueron deshechas");
    }

    public LinkedList<Estudiante> mostrarEstudiantesCurso(String claveCurso) {
        //buscamos el curso mediante su clave
        Curso curso = cursos.buscarCurso(claveCurso);
        //validamos que el curso exista
        if (curso == null) {
            //si no existe regresamos una lista vacia
            return new LinkedList<>();
        }
        //regresamos la lista de estudiantes del curso
        return curso.mostrarEstudiantes();
    }

    public Estudiante rotarRolCurso(String claveCurso) {
        //obtenemos el curso 
        Curso curso = cursos.buscarCurso(claveCurso);
        //validamos que el curso consultado no este nulo
        if (curso == null) {
            //si es nulo termina el proceso 
            return null;
        }
        //regresamos el estudiante del curso rotado
        return curso.rotarRol();
    }

    public DoubleCircularLinkedList<Estudiante> mostrarListaEsperaCurso(String claveCurso) {
        //obtenemos el curso 
        Curso curso = cursos.buscarCurso(claveCurso);
        //validamos que el curso consultado no este nulo
        if (curso == null) {
            //si es nulo termina el proceso 
            return null;
        }
        //regresamos la lista de espera del curso 
        return curso.mostrarListaEspera();
    }

    public LinkedList<Estudiante> mostrarNPrimerosEspera(String claveCurso, int n) {
        // obtenemos el curso 
        Curso curso = cursos.buscarCurso(claveCurso);
        //validamos que el curso consultado no este nulo
        if (curso == null) {
            //si es nulo termina el proceso 
            return new LinkedList<>();
        }
        //regresamos los primeros de la lista de espera 
        return curso.mostrarNPrimeros(n);
    }

    public Estudiante recorrerListaEsperaAdelante(String claveCurso) {
        //obtenemos el curso 
        Curso curso = cursos.buscarCurso(claveCurso);
        //validamos que el curso consultado no este nulo
        if (curso == null) {
            //si es nulo termina el proceso 
            return null;
        }
        return curso.recorrerAdelanteListaEspera();
    }

    public Estudiante recorrerAtrasListaEspera(String claveCurso) {
        //obtenemos el curso 
        Curso curso = cursos.buscarCurso(claveCurso);
        //validamos que el curso consultado no este nulo
        if (curso == null) {
            //si es nulo termina el proceso 
            return null;
        }
        return curso.recorrerAtrasListaEspera();
    }

    public void registrarPromedioEstudiante(String matricula) {
        //buscamos el estudiante mediante la matricula
        Estudiante estudiante = buscarEstudiante(matricula);
        //validamos que el estudiante exista
        if (estudiante == null) {
            return;
        }
        //calculamos el promedio del estudiante
        float promedio = estudiante.calcularPromedio();
        //creamos el par promedio-estudiante
        ParPromedioEstudiante par = new ParPromedioEstudiante(estudiante, promedio);

        //agregamos el par al arbol AVL
        promedios.agregarParPromedioEstudiante(par);
        //mostramos mensaje de exito
        System.out.println("Promedio registrado correctamente");
    }

    public void enviarSolicitudCalificacion(String matricula, String claveCurso, double calificacion) {
        //buscamos el estudiante
        Estudiante estudiante = buscarEstudiante(matricula);
        //validamos que exista
        if (estudiante == null) {
            return;
        }
        //buscamos el estudiante
        Curso curso = cursos.buscarCurso(claveCurso);
        //validamos el curso
        if (curso == null) {
            return;
        }
        //creamos la solicitud
        SolicitudCalificacion solicitud = new SolicitudCalificacion(estudiante, curso, calificacion);
        //guardamos la solicitud
        solicitudes.enqueue(solicitud);
        System.out.println("Solicitud enviada");
    }

    public void procesarSiguienteSolicitud() {
        //validamos si la cola esta vacia
        if (solicitudes.empty()) {
            System.out.println("No hay solicitudes pendientes");
            return;
        }
        //obtenemos la siguiente solicitud
        SolicitudCalificacion solicitud= solicitudes.dequeue();
        //obtenemos el estudiante
        Estudiante estudiante= solicitud.getEstudiante();
        //obtenemos la calificacion
        double calificacion= solicitud.getCalificacion();
        //agregamos la calificacion al arreglo
        estudiante.getCalificaciones().append(calificacion);
        //registramos la accion en la pila
        acciones.agregarAccion(new Accion("CALIFICACION",solicitud));
        //actualizamos el AVL de promedios
        registrarPromedioEstudiante(estudiante.getMatricula());
        //mostramos mensaje
        System.out.println("Solicitud procesada correctamente");
    }

    public void eliminarCurso(String claveCurso) {
        if (claveCurso == null || claveCurso.isBlank()) {
            return;
        }
        cursos.eliminarCurso(claveCurso);
    }

    public void mostrarPromediosEstudiantes() {
        //mostramos el listado de promedios
        promedios.imprimirListado();
    }

    public LinkedList<Curso> mostrarCursos() {
        return cursos.mostrarCursos();
    }

    public EstudiantesBST getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(EstudiantesBST estudiantes) {
        this.estudiantes = estudiantes;
    }

    public CatalogoCursos getCursos() {
        return cursos;
    }

    public void setCursos(CatalogoCursos cursos) {
        this.cursos = cursos;
    }

    public ArrayListQueue<SolicitudCalificacion> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayListQueue<SolicitudCalificacion> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Acciones getAcciones() {
        return acciones;
    }

    public void setAcciones(Acciones acciones) {
        this.acciones = acciones;
    }

    public PromedioEstudiante getPromedios() {
        return promedios;
    }

    public void setPromedios(PromedioEstudiante promedios) {
        this.promedios = promedios;
    }

}
