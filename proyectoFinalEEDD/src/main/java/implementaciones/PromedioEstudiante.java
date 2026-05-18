/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import implementaciones.AVLTree;
import java.util.Iterator;
import objetos.ParPromedioEstudiante;

/**
 *
 * @author joser
 */
public class PromedioEstudiante {
    AVLTree<ParPromedioEstudiante> parPromedioEstudiante;

    public PromedioEstudiante() {
        this.parPromedioEstudiante = new AVLTree<>();
    }

    /**
     * Agrega al arbol AVL el par promedio de estudiante.
     * @param estudiante 
     */
    public void agregarParPromedioEstudiante(ParPromedioEstudiante estudiante) {
        if (estudiante != null) {
            this.parPromedioEstudiante.insert(estudiante);
            
        }

    }

    public AVLTree<ParPromedioEstudiante> getParPromedioEstudiante() {
        return parPromedioEstudiante;
    }

    public void setParPromedioEstudiante(AVLTree<ParPromedioEstudiante> parPromedioEstudiante) {
        this.parPromedioEstudiante = parPromedioEstudiante;
    }

    
    
    
    
    /**
     * Imprime el listado del promedio de estudiantes en orden ascendente.
     */
    public void imprimirListado(){
        if (parPromedioEstudiante.empty()) {
            System.out.println("No hay promedio registrado.");
            return;
        }
        Iterator<ParPromedioEstudiante> iterator = parPromedioEstudiante.getInorderIterator();
        while (iterator.hasNext()) {
            ParPromedioEstudiante par = iterator.next();
            System.out.println("Promedio: " + par.getPromedio()
                    + " | Matricula: " + par.getEstudiante().getMatricula()
                    + " | Nombre: " + par.getEstudiante().getNombreCompleto());
        }
    
    }
    
   
}
