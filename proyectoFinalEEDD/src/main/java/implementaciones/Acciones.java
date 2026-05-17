/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import objetos.Accion;

/**
 *
 * @author joser
 */
public class Acciones {
    //pila de acciones realizadas
    private ArrayListStack<Accion> acciones;

    public Acciones() {
        //inicializamos la pila
        this.acciones = new ArrayListStack<>(Accion.class, 50);
    }

    public void agregarAccion(Accion accion) {
        //validamos si la accion existe
        if (accion == null) {
            System.out.println("Esa accion no existe");
            return;
        }
        //agregamos la accion a la pila
        acciones.push(accion);
        System.out.println("Accion agregada correctamente");
    }

    public Accion deshacerAccion() {
        //validamos si la pila esta vacia
        if (acciones.empty()) {
            System.out.println("La lista de acciones esta vacia");
            return null;
        }
        //eliminamos y regresamos la ultima accion
        return acciones.pop();
    }

    public Accion verUltimaAccion() {
        //validamos si la pila esta vacia
        if (acciones.empty()) {
            System.out.println("La lista de acciones esta vacia");
            return null;
        }
        //regresamos la ultima accion registrada
        return acciones.peek();
    }

    public ArrayListStack<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(ArrayListStack<Accion> acciones) {
        this.acciones = acciones;
    }
}
