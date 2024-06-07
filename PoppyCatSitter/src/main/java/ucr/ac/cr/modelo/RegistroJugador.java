/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Mónica Artavia
 */
public class RegistroJugador implements RegistroDatos{

    private ArrayList<Jugador> listaJugador;
    private boolean estadoJ;
    private File archivo;
    private JSONObject baseJSONJugador;

    public RegistroJugador() {
        listaJugador= new ArrayList<Jugador>();
        archivo = new File("jugador.json");
        leerJSON();
    }
    
    @Override
    public String agregar(Object object) {
        if (object!=null){
            Jugador jugador=(Jugador) object;
            if(buscar(jugador.getNombre())==null){ 
                listaJugador.add(jugador);
                escribirJSON();
                return "El jugador ha sido agregado";
            }else{
                return "error: Ya ha sido registrado el jugador anteriormente";
            }
        }
        return "No se pudo agregar el jugador";
    }
    
    public void escribirJSON() {
        JSONArray archJugador = new JSONArray();
        baseJSONJugador = new JSONObject();
        for (Jugador jugador : listaJugador) {
            JSONObject objJSONPartida = new JSONObject();
            objJSONPartida.put("nombre", jugador.getNombre());
            objJSONPartida.put("nombreP", jugador.getNombrePersonaje());
            objJSONPartida.put("personaje", jugador.getPersonajeElegido());
         
            archJugador.add(objJSONPartida);
        }
        baseJSONJugador.put("listaJugador", archJugador);

        try {
            FileWriter archivoEsc = new FileWriter(archivo);
            archivoEsc.write(baseJSONJugador.toJSONString());
            archivoEsc.flush();
            archivoEsc.close();
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    
    public void leerJSON() { 
        listaJugador = new ArrayList<>(); 
        JSONParser convertir = new JSONParser(); 
        try { 
            FileReader archivoLee = new FileReader(this.archivo); 
            Object objeto = convertir.parse(archivoLee); 
            baseJSONJugador = (JSONObject) objeto; 
 
            JSONArray arregloJSON = (JSONArray) baseJSONJugador.get("listaJugador"); 
            for (Object object : arregloJSON) { 
                JSONObject objPartida = (JSONObject) object; 
                Jugador jugador = new Jugador(); 
                jugador.setNombre(objPartida.get("nombre").toString()); 
                jugador.setNombrePersonaje(objPartida.get("nombreP").toString());
                jugador.setPersonajeElegido(objPartida.get("personaje").toString());
                listaJugador.add(jugador); 
                System.out.println("esta leyendo y lo agrego " +jugador + "" +listaJugador);
            }
 
        } catch (FileNotFoundException ex) { 
            System.err.println("Error al leer"); 
        } catch (IOException ex) { 
            System.err.println("Error al leer"); 
        }catch (org.json.simple.parser.ParseException ex) { 
            ex.printStackTrace(); 
        } 
    }
    
    public String [][] getDatosTabla(){
        String [][] datos= new String [listaJugador.size()][Jugador.ETIQUETAS_JUGADOR.length];
        for (int fila=0;fila<listaJugador.size();fila++){
            for (int columna=0;columna<datos[fila].length;columna++){
                datos[fila][columna]=listaJugador.get(fila).getDatos(columna);
            }
        }
        return datos;
    }
    
    public void estadoJuego(boolean estado){
        this.estadoJ = estado;
    }
    
    public boolean retornaJuego(){
        if(estadoJ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object buscar(String nombre) {
        for(int posicion=0;posicion<listaJugador.size();posicion++){
            if(listaJugador.get(posicion)!=null){
                if(listaJugador.get(posicion).getNombre().equalsIgnoreCase(nombre)){
                    return (Object) listaJugador.get(posicion);
                }
            }
        }
        return null;
    }
    
    public Object buscarE(String personaje) {
        for(int posicion=0;posicion<listaJugador.size();posicion++){
            if(listaJugador.get(posicion)!=null){
                if(listaJugador.get(posicion).getNombrePersonaje().equalsIgnoreCase(personaje)){
                    return (Object) listaJugador.get(posicion);
                }
            }
        }
        return null;
    }
    
    public String personajeElegido(){
        String dato="";
        for(int posicion=0;posicion<listaJugador.size();posicion++){
            if(listaJugador.get(posicion)!=null){
                dato = listaJugador.get(posicion).getPersonajeElegido();
            }
        }
        return dato;
    }
    
    public String nombreJugador(){
        for(int posicion=0;posicion<listaJugador.size();posicion++){
            if(listaJugador.get(posicion)!=null){
                return listaJugador.get(posicion).getNombre();
            }
        }
        return null;
    }
    
    public String cancelarRegistro(String nombreJ){
       Jugador jugador = (Jugador) buscar(nombreJ);
       System.out.println("este es el valor de jugador " +jugador + " nombre " + nombreJ);
       if(listaJugador.remove(jugador)){
           escribirJSON();
           System.out.println("El jugador ha sido eliminado");
           return "El jugador ha sido eliminado";
       }else{
           System.out.println("Error: no se pudo eliminar el jugador");
           return "Error: no se pudo eliminar el jugador";
       }
    }
    
    public String toString(){
        String datos="El jugador registrado es \n";
        for(int posicion=0;posicion<listaJugador.size();posicion++){
            if(listaJugador.get(posicion)!=null){
                datos+=listaJugador.get(posicion)+"\n";
            }
        }
        return datos;
    }
}