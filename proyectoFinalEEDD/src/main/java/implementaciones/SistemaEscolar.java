/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import implementaciones.ArrayListQueue;
import objetos.Curso;
import objetos.Estudiante;
import objetos.ParPromedioEstudiante;

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
    private ArrayListQueue solicitudes;
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
        solicitudes = null;
        //inicializamos las acciones
        acciones = new Acciones();
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
        System.out.println("Curso agregado correctamente");
    }

    public Estudiante buscarEstudiante(String matricula) {
        //validamos si la matricula es nula 
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
        //mostramos el mensaje de exito 
        System.out.println("Inscripcion realizada correctamente");
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

    public ArrayListQueue getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayListQueue solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Acciones getAcciones() {
        return acciones;
    }

    public void setAcciones(Acciones acciones) {
        this.acciones = acciones;
    }

}
