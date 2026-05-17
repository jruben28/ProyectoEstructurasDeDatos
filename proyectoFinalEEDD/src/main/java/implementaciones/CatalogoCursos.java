/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import objetos.Curso;

/**
 *
 * @author joser
 */
public class CatalogoCursos {

    private HashDictionary<String, Curso> catalogoCursos;

    public CatalogoCursos() {
        catalogoCursos=new HashDictionary<>(50);
    }
    
    public void agregarCurso(Curso curso){
        //validamos si el curso en nulo 
        if(curso==null){
            //si es nulo, mostramos un mensaje y terminamos el proceso
            System.out.println("El curso no puede ser nulo");
            return;
        }
        //validamos que el curso no exista 
        if(catalogoCursos.contains(curso.getClave())){
            //si existe mostramos este menasaje y terminamos el proceso 
            System.out.println("El curso ya existe en el catalogo");
            return; 
        }
        //si pasa todas las validacionas agregamos el curso 
        catalogoCursos.put(curso.getClave(), curso);
        System.out.println("Curso agregado correctamente");
    }
    
    public Curso buscarCurso(String clave){
        //validamos que la clave no este vacia
        if(clave==null || clave.isEmpty()){
            //si esta vacia mostramos este mensaje
            System.out.println("clave invalida");
            //regresamos nulo
            return null;
        }
        //regresamos el curso consultado
        return catalogoCursos.get(clave);
    }
    
    public Curso eliminarCurso(String clave){
        //validamos la clave esta vacia 
        if(clave==null || clave.isBlank()){
            //imprimimos si la imagen esta invalida
            System.out.println("clave invalida");
            //regresamos nulo
            return null;
        }
        //validamos si existe en catalogo de cursos 
        if (!catalogoCursos.contains(clave)){
            //si no existe mostramos un mensaje
            System.out.println("El curso no existe");
            return null;
        }
        //eliminamos el curso con esta clave 
        return catalogoCursos.remove(clave);
    }
    
    public LinkedList<Curso> mostrarCursos(){
        //validamos si esta vacio el diccionario de cursos 
        if(catalogoCursos.empty()){
            //si esta vacia mostramos el mensaje y regresamos la lista vacia 
            System.out.println("la lista de cursos esta vacia");
            return new LinkedList<>();
        }
        //si pasa las validaciones regresamos la lista 
        return catalogoCursos.values();
    }
    
}
