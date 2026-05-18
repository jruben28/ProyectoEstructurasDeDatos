/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Jorge
 */
public class SolicitudCalificacion {

    private Estudiante estudiante;
    private Curso curso;
    private float calificacion;

    public SolicitudCalificacion(Estudiante estudiante, Curso curso, float calificacion) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "SolicitudCalificacion{" + "estudiante=" + estudiante + ", curso=" + curso + ", calificacion=" + calificacion + '}';
    }
    
}
