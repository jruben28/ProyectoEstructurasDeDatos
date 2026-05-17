/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author joser
 */
public class ParPromedioEstudiante implements Comparable<ParPromedioEstudiante>{
    Estudiante estudiante;
    float promedio;

    public ParPromedioEstudiante(Estudiante estudiante, float promedio) {
        this.estudiante = estudiante;
        this.promedio = promedio;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    
    
    @Override
    public int compareTo(ParPromedioEstudiante otro) {
        if (this.promedio < otro.promedio) {
            return -1;
            
        }else if (this.promedio > otro.promedio) {
            return 1;
            
        }
        return this.estudiante.getMatricula().compareTo(otro.estudiante.getMatricula());
    }
    

}
