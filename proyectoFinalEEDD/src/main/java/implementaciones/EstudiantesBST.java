/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import implementaciones.BinarySearchTree;
import java.util.Iterator;
import objetos.Estudiante;

/**
 *
 * @author joser
 */
public class EstudiantesBST {

    BinarySearchTree<Estudiante> estudiantes;

    public EstudiantesBST() {
        this.estudiantes = new BinarySearchTree<>();
    }

    /**
     * Inserta un estudiante en el arbol binario de busqueda.
     *
     * @param estudiante. Estudiante a insertar.
     */
    public void insertarEstudiante(Estudiante estudiante) {
        estudiantes.insert(estudiante);
    }

    /**
     * Regresa el estudiante que encuentre con la misma matricula.
     *
     * @param matricula
     * @return
     */
    public Estudiante busquedaPorMatricula(String matricula) {
        Iterator<Estudiante> iterator = estudiantes.getInorderIterator();
        while (iterator.hasNext()) {
            Estudiante estudiante = iterator.next();
            if (estudiante.getMatricula().equals(matricula)) {
                return estudiante;
            }
        }
        return null;
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }

    public void imprimirPrimero() {
        System.out.println(estudiantes.firstEntry().toString());
    }

}
