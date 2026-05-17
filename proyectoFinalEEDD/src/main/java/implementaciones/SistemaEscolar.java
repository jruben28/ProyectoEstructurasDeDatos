/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import implementaciones.ArrayListQueue;

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

    public SistemaEscolar() {
        estudiantes=new EstudiantesBST();
        cursos=new CatalogoCursos();
    }
    
    
    
}
