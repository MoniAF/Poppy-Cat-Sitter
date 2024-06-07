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
public class RegistroPartida{
    
    private ArrayList<Partida> listaPartida;
    private boolean estadoP, estadoD, estadoL;
    private File archivo;
    private JSONObject baseJSONPartida;
    int vez = 0, vez2 = 0, vez3 = 0, vez4 = 0, vez5 = 0, vez6 = 0, vez7 = 0, vez8 = 0, vez9 = 0, vez10 = 0, vez11 = 0, vez12 = 0, vez13 = 0, vez14 = 0, vez15 = 0, vez16 = 0, vez17 = 0, vez18 = 0;

    public RegistroPartida() {
        listaPartida= new ArrayList<Partida>();
        archivo = new File("partida.json");
        leerJSON();
    }
    
    public void escribirJSON() {
        JSONArray archPartida = new JSONArray();
        baseJSONPartida = new JSONObject();
        for (Partida partida : listaPartida) {
            JSONObject objJSONPartida = new JSONObject();
            objJSONPartida.put("hambre", partida.getHambre());
            objJSONPartida.put("limpieza", partida.getLimpieza());
            objJSONPartida.put("dormir", partida.getDormir());
            objJSONPartida.put("nivel", partida.getNivel());
            objJSONPartida.put("experiencia", partida.getExperiencia());
            objJSONPartida.put("salud", partida.getSalud());
            objJSONPartida.put("dinero", partida.getDinero());
            objJSONPartida.put("pollo", partida.getCantPollo());
            objJSONPartida.put("pescado", partida.getCantPescado());
            objJSONPartida.put("pastilla", partida.getCantPastilla());
            objJSONPartida.put("medicina", partida.getCantMedicina());
            objJSONPartida.put("leche", partida.getCantLeche());
            objJSONPartida.put("jabon", partida.getCantJabon());
            objJSONPartida.put("cerdo", partida.getCantCerdo());
            objJSONPartida.put("carne", partida.getCantCarne());
            objJSONPartida.put("agua", partida.getCantAgua());
            
            archPartida.add(objJSONPartida);
        }
        baseJSONPartida.put("listaPartida", archPartida);
            
        try {
            FileWriter archivoEsc = new FileWriter(archivo);
            archivoEsc.write(baseJSONPartida.toJSONString());
            archivoEsc.flush();
            archivoEsc.close();
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    
    public void leerJSON() { 
        listaPartida = new ArrayList<>(); 
        JSONParser convertir = new JSONParser(); 
        try { 
            FileReader archivoLee = new FileReader(this.archivo); 
            Object objeto = convertir.parse(archivoLee); 
            baseJSONPartida = (JSONObject) objeto; 
            
            JSONArray arregloJSON = (JSONArray) baseJSONPartida.get("listaPartida"); 
            for (Object object : arregloJSON) { 
                JSONObject objPartida = (JSONObject) object; 
                Partida partida = new Partida(); 
                partida.setHambre(Integer.parseInt(objPartida.get("hambre").toString())); 
                partida.setLimpieza(Integer.parseInt(objPartida.get("limpieza").toString()));
                partida.setDormir(Integer.parseInt(objPartida.get("dormir").toString())); 
                partida.setNivel(Integer.parseInt(objPartida.get("nivel").toString())); 
                partida.setExperiencia(Integer.parseInt(objPartida.get("experiencia").toString())); 
                partida.setSalud(Integer.parseInt(objPartida.get("salud").toString())); 
                partida.setDinero(Integer.parseInt(objPartida.get("dinero").toString())); 
                partida.setCantPollo(Integer.parseInt(objPartida.get("pollo").toString())); 
                partida.setCantPescado(Integer.parseInt(objPartida.get("pescado").toString())); 
                partida.setCantPastilla(Integer.parseInt(objPartida.get("pastilla").toString())); 
                partida.setCantMedicina(Integer.parseInt(objPartida.get("medicina").toString())); 
                partida.setCantLeche(Integer.parseInt(objPartida.get("leche").toString())); 
                partida.setCantJabon(Integer.parseInt(objPartida.get("jabon").toString())); 
                partida.setCantCerdo(Integer.parseInt(objPartida.get("cerdo").toString())); 
                partida.setCantCarne(Integer.parseInt(objPartida.get("carne").toString())); 
                partida.setCantAgua(Integer.parseInt(objPartida.get("agua").toString()));
                listaPartida.add(partida); 
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
        String [][] datos= new String [listaPartida.size()][Partida.ETIQUETAS_PARTIDA.length];
        for (int fila=0;fila<listaPartida.size();fila++){
            for (int columna=0;columna<datos[fila].length;columna++){
                datos[fila][columna]=listaPartida.get(fila).getDatos(columna);
            }
        }
        return datos;
    }
    
    public void agregar(Partida partida){
        if(listaPartida.add(partida)){
            escribirJSON();
            System.out.println("la partida ha sido agregada");  
        }else{
            System.out.println("la partida no ha sido agregada");
        }
    }
    
    public void estadoHiloP(boolean estado){
        this.estadoP = estado;
    }
    
    public boolean retornaEstadoHiloP(){
        if(estadoP){
            return true;
        }else{
            return false;
        }
    }
    
    public void estadoHiloD(boolean estado){
        this.estadoD = estado;
    }
    
    public boolean retornaEstadoHiloD(){
        if(estadoD){
            return true;
        }else{
            return false;
        }
    }
    
    public void estadoHiloL(boolean estado){
        this.estadoL = estado;
    }
    
    public boolean retornaEstadoHiloL(){
        if(estadoL){
            return true;
        }else{
            return false;
        }
    }
    
    public String aumentarHambre(int hambre){
        String envio="";
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getHambre()+hambre;
                if (suma>=100){
                    suma=100;
                    listaPartida.get(posicion).setHambre(suma);
                    envio=suma+"";
                }else{
                    listaPartida.get(posicion).setHambre(suma);
                    envio=suma+"";
                }
            }
        }
        return envio;
    }
    
    public int aumentarSalud(int salud){
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getSalud()+salud;
                if(suma>=100){
                    suma=100;
                    listaPartida.get(posicion).setSalud(suma);
                }else{
                    listaPartida.get(posicion).setSalud(suma);
                }
            }
        }
        return suma;
    }
    
    public int aumentarDescanso(){
        int aumentar=0, cDescanso=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            aumentar = listaPartida.get(posicion).getDormir()+1;
            if(aumentar==100){
                aumentar=100;
                listaPartida.get(posicion).setDormir(aumentar);
            }else{
                cDescanso++;
                listaPartida.get(posicion).setDormir(aumentar);
            }
        }
        return cDescanso;
    }
    
    public int aumentarLimpieza(int limpieza){
        int aumentar=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            aumentar = listaPartida.get(posicion).getLimpieza()+limpieza;
            if(aumentar>=100){
                aumentar=100;
                listaPartida.get(posicion).setLimpieza(aumentar);
            }else{
                listaPartida.get(posicion).setLimpieza(aumentar);
            }
        }
        return aumentar;
    }
    
    public int aumentarCantJabon(){
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getCantJabon()+1;
                listaPartida.get(posicion).setCantJabon(suma);
            }
        }
        return suma;
    }
    
    public int aumentarCantLeche(){
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getCantLeche()+1;
                listaPartida.get(posicion).setCantLeche(suma);
            }
        }
        return suma;
    }
    
    public int aumentarCantAgua(){
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getCantAgua()+1;
                listaPartida.get(posicion).setCantAgua(suma);
            }
        }
        return suma;
    }
    
    public int aumentarCantCerdo(){
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getCantCerdo()+1;
                listaPartida.get(posicion).setCantCerdo(suma);
            }
        }
        return suma;
    }
    
    public int aumentarCantCarne(){
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getCantCarne()+1;
                listaPartida.get(posicion).setCantCarne(suma);
            }
        }
        return suma;
    }
    
    public int aumentarCantPescado(){
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getCantPescado()+1;
                listaPartida.get(posicion).setCantPescado(suma);
            }
        }
        return suma;
    }
    
    public int aumentarCantPollo(){
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getCantPollo()+1;
                listaPartida.get(posicion).setCantPollo(suma);
            }
        }
        return suma;
    }
    
    public int aumentarPastilla(){
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getCantPastilla()+1;
                listaPartida.get(posicion).setCantPastilla(suma);
            }
        }
        return suma;
    }
    
    public int aumentarMedicina(){
        int suma=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma=listaPartida.get(posicion).getCantMedicina()+1;
                listaPartida.get(posicion).setCantMedicina(suma);
            }
        }
        return suma;
    }
    
    public int getHambre(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getHambre();
            }
        }
        return porcentaje;
    }
    
    public int getDormir(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getDormir();
            }
        }
        return porcentaje;
    }
    
    public int getNivel(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getNivel();
            }
        }
        return porcentaje;
    }
    
    public int getLimpieza(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getLimpieza();
            }
        }
        return porcentaje;
    }
    
    public int getSalud(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getSalud();
            }
        }
        return porcentaje;
    }
    
    public int getCantLeche(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getCantLeche();
            }
        }
        return porcentaje;
    }
    
    public int getCantAgua(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getCantAgua();
            }
        }
        return porcentaje;
    }
    
    public int getCantCerdo(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getCantCerdo();
            }
        }
        return porcentaje;
    }
    
    public int getCantCarne(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getCantCarne();
            }
        }
        return porcentaje;
    }
    
    public int getCantPescado(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getCantPescado();
            }
        }
        return porcentaje;
    }
    
    public int getCantPollo(){
        int porcentaje=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                porcentaje=listaPartida.get(posicion).getCantPollo();
            }
        }
        return porcentaje;
    }
    
    public int getCantJabon(){
        int cantidad=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                cantidad=listaPartida.get(posicion).getCantJabon();
            }
        }
        return cantidad;
    }
    
    public int getDinero(){
        int cantidad=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                cantidad=listaPartida.get(posicion).getDinero();
            }
        }
        return cantidad;
    }
    
    public int getExperiencia(){
        int cantidad=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                cantidad=listaPartida.get(posicion).getExperiencia();
            }
        }
        return cantidad;
    }
    
    public int getMedicina(){
        int cantidad=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                cantidad=listaPartida.get(posicion).getCantMedicina();
            }
        }
        return cantidad;
    }
    
    public int getPastilla(){
        int cantidad=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                cantidad=listaPartida.get(posicion).getCantPastilla();
            }
        }
        return cantidad;
    }
    
    public int disminuirCantMedicina(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getCantMedicina()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setCantMedicina(disminuir);
                }else{
                    listaPartida.get(posicion).setCantMedicina(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public int disminuirCantPastilla(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getCantPastilla()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setCantPastilla(disminuir);
                }else{
                    listaPartida.get(posicion).setCantPastilla(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public int disminuirCantJabon(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getCantJabon()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setCantJabon(disminuir);
                }else{
                    listaPartida.get(posicion).setCantJabon(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public int disminuirCantLeche(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getCantLeche()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setCantLeche(disminuir);
                }else{
                    listaPartida.get(posicion).setCantLeche(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public int disminuirCantAgua(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getCantAgua()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setCantAgua(disminuir);
                }else{
                    listaPartida.get(posicion).setCantAgua(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public int disminuirCantCerdo(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getCantCerdo()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setCantCerdo(disminuir);
                }else{
                    listaPartida.get(posicion).setCantCerdo(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public int disminuirCantCarne(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getCantCarne()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setCantCarne(disminuir);
                }else{
                    listaPartida.get(posicion).setCantCarne(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public int disminuirCantPescado(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getCantPescado()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setCantPescado(disminuir);
                }else{
                    listaPartida.get(posicion).setCantPescado(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public int disminuirCantPollo(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getCantPollo()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setCantPollo(disminuir);
                }else{
                    listaPartida.get(posicion).setCantPollo(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public int disminuirSalud(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion).getHambre()<=50){
                disminuir = listaPartida.get(posicion).getSalud()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setSalud(disminuir);
                }else{
                    listaPartida.get(posicion).setSalud(disminuir);
                }
            }else{
                if(listaPartida.get(posicion).getDormir()<=50){
                    disminuir = listaPartida.get(posicion).getSalud()-1;
                    if(disminuir<=0){
                        disminuir=0;
                        listaPartida.get(posicion).setSalud(disminuir);
                    }else{
                        listaPartida.get(posicion).setSalud(disminuir);
                    }
                }else{
                   if(listaPartida.get(posicion).getLimpieza()<=50){
                        disminuir = listaPartida.get(posicion).getSalud()-1;
                        if(disminuir<=0){
                            disminuir=0;
                            listaPartida.get(posicion).setSalud(disminuir);
                        }else{
                            listaPartida.get(posicion).setSalud(disminuir);
                        }
                    }else{
                       if(listaPartida.get(posicion).getLimpieza()<=50 && listaPartida.get(posicion).getDormir()<=50 && listaPartida.get(posicion).getHambre()<=50){
                            disminuir = listaPartida.get(posicion).getSalud()-1;
                            if(disminuir<=0){
                                disminuir=0;
                                listaPartida.get(posicion).setSalud(disminuir);
                            }else{
                                listaPartida.get(posicion).setSalud(disminuir);
                            }
                        }else{
                           if(listaPartida.get(posicion).getDormir()<=50 && listaPartida.get(posicion).getHambre()<=50){
                                disminuir = listaPartida.get(posicion).getSalud()-1;
                                if(disminuir<=0){
                                    disminuir=0;
                                    listaPartida.get(posicion).setSalud(disminuir);
                                }else{
                                    listaPartida.get(posicion).setSalud(disminuir);
                                }
                            }else{
                               if(listaPartida.get(posicion).getLimpieza()<=50 && listaPartida.get(posicion).getHambre()<=50){
                                    disminuir = listaPartida.get(posicion).getSalud()-1;
                                    if(disminuir<=0){
                                        disminuir=0;
                                        listaPartida.get(posicion).setSalud(disminuir);
                                    }else{
                                        listaPartida.get(posicion).setSalud(disminuir);
                                    }
                                }else{
                                   if(listaPartida.get(posicion).getLimpieza()<=50 && listaPartida.get(posicion).getDormir()<=50){
                                        disminuir = listaPartida.get(posicion).getSalud()-1;
                                        if(disminuir<=0){
                                            disminuir=0;
                                            listaPartida.get(posicion).setSalud(disminuir);
                                        }else{
                                            listaPartida.get(posicion).setSalud(disminuir);
                                        }
                                    }
                                }
                            }
                        }
                    } 
                }
            }
        }
        return disminuir;
    }
    
    public void disminuirHambre(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getHambre()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setHambre(disminuir);
                }else{
                    listaPartida.get(posicion).setHambre(disminuir);
                    System.out.println("lo lograste mamona");
                }
            }
        }
    }
    
    public void disminuirDescanso(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            disminuir = listaPartida.get(posicion).getDormir()-1;
            if(disminuir<=0){
                disminuir=0;
                listaPartida.get(posicion).setDormir(disminuir);
            }else{
                listaPartida.get(posicion).setDormir(disminuir);
                System.out.println("lo lograste mija");
            }
        }
    }
    
    public int disminuirLimpieza(){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getLimpieza()-1;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setLimpieza(disminuir);
                }else{
                    listaPartida.get(posicion).setLimpieza(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public int disminuirDinero(int valor){
        int disminuir=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                disminuir = listaPartida.get(posicion).getDinero()-valor;
                if(disminuir<=0){
                    disminuir=0;
                    listaPartida.get(posicion).setDinero(disminuir);
                }else{
                    listaPartida.get(posicion).setDinero(disminuir);
                }
            }
        }
        return disminuir;
    }
    
    public void aumentarNivel(int aumento){
        int suma=0;
        int nivel=0;
        int dinero=0;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                suma = listaPartida.get(posicion).getExperiencia()+aumento;
                listaPartida.get(posicion).setExperiencia(suma);
                if(listaPartida.get(posicion).getExperiencia()>=200 && listaPartida.get(posicion).getExperiencia()<=324){
                    nivel = 2;
                    while(vez == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+100;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=325 && listaPartida.get(posicion).getExperiencia()<=449){
                    nivel = 3;
                    while(vez2 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+150;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez2++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=450 && listaPartida.get(posicion).getExperiencia()<=574){
                    nivel = 4;
                    while(vez3 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+200;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez3++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=575 && listaPartida.get(posicion).getExperiencia()<=699){
                    nivel = 5;
                    while(vez4 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+250;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez4++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=700 && listaPartida.get(posicion).getExperiencia()<=849){
                    nivel = 6;
                    while(vez5 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+300;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez5++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=850 && listaPartida.get(posicion).getExperiencia()<=999){
                    nivel = 7;
                    while(vez6 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+350;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez6++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=1000 && listaPartida.get(posicion).getExperiencia()<=1149){
                    nivel = 8;
                    while(vez7 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+400;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez7++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=1150 && listaPartida.get(posicion).getExperiencia()<=1299){
                    nivel = 9;
                    while(vez8 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+450;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez8++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=1300 && listaPartida.get(posicion).getExperiencia()<=1474){
                    nivel = 10;
                    while(vez9 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+500;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez9++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=1475 && listaPartida.get(posicion).getExperiencia()<=1649){
                    nivel = 11;
                    while(vez10 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+550;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez10++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=1650 && listaPartida.get(posicion).getExperiencia()<=1824){
                    nivel = 12;
                    while(vez11 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+600;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez11++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=1825 && listaPartida.get(posicion).getExperiencia()<=1999){
                    nivel = 13;
                    while(vez12 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+650;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez12++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=2000 && listaPartida.get(posicion).getExperiencia()<=2199){
                    nivel = 14;
                    while(vez13 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+700;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez13++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=2200 && listaPartida.get(posicion).getExperiencia()<=2399){
                    nivel = 15;
                    while(vez14 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+750;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez14++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=2400 && listaPartida.get(posicion).getExperiencia()<=2599){
                    nivel = 16;
                    while(vez15 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+800;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez15++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=2600 && listaPartida.get(posicion).getExperiencia()<=2799){
                    nivel = 17;
                    while(vez16 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+850;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez16++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=2800 && listaPartida.get(posicion).getExperiencia()<=3024){
                    nivel = 18;
                    while(vez17 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+900;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez17++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=3025 && listaPartida.get(posicion).getExperiencia()<=3249){
                    nivel = 19;
                    while(vez18 == 0){
                        listaPartida.get(posicion).setNivel(nivel);
                        dinero = listaPartida.get(posicion).getDinero()+950;
                        listaPartida.get(posicion).setDinero(dinero);
                        vez18++;
                    }
                }else{
                if(listaPartida.get(posicion).getExperiencia()>=3250){
                    nivel = 20;
                    listaPartida.get(posicion).setNivel(nivel);
                } } } } } } } } } } } } } } } } } } }
            }
        }
    }
    
    public boolean victoria(){
        boolean resultado=false;
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                if(listaPartida.get(posicion).getSalud()>=70 && listaPartida.get(posicion).getNivel()==20){
                    resultado = true;
                }else{
                    resultado = false;
                }
            }
        }
        return resultado;
    }
    
    public Object buscarE(int nivel) {
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                if(listaPartida.get(posicion).getNivel()==nivel){
                    return (Object) listaPartida.get(posicion);
                }
            }
        }
        return null;
    }
    
    public String eliminarPartida(int nivel){
       Partida partida = (Partida) buscarE(nivel);
       System.out.println("este es el valor de jugador " +partida + " nombre " + nivel);
       if(listaPartida.remove(partida)){
           escribirJSON();
           System.out.println("La partida ha sido eliminado");
           return "El jugador ha sido eliminado";
       }else{
           System.out.println("Error: no se pudo eliminar la partida");
           return "Error: no se pudo eliminar el jugador";
       }
    }
    
    public String toString(){
        String datos="La partida registrada es \n";
        for(int posicion=0;posicion<listaPartida.size();posicion++){
            if(listaPartida.get(posicion)!=null){
                datos+=listaPartida.get(posicion)+"\n";
            }
        }
        return datos;
    }
}
