/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.modelo;

/**
 *
 * @author Mónica Artavia
 */
public class Jugador {
    private String nombre;
    private String personajeElegido;
    private String nombrePersonaje;
    
    public static final String[] ETIQUETAS_JUGADOR = {"Nombre de usuario","Nombre del felino"};

    public Jugador(String nombre, String personajeElegido, String nombrePersonaje) {
        this.nombre = nombre;
        this.personajeElegido = personajeElegido;
        this.nombrePersonaje = nombrePersonaje;
    }

    public Jugador() {
    }

    public String getDatos(int indice){
        switch(indice){
            case 0:
                return nombre;
            case 1:
                return nombrePersonaje;
        }
        return null;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonajeElegido() {
        return personajeElegido;
    }

    public void setPersonajeElegido(String personajeElegido) {
        this.personajeElegido = personajeElegido;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", personajeElegido=" + personajeElegido + ", nombrePersonaje=" + nombrePersonaje + '}';
    }
}
