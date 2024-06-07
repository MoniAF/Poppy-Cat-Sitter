/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import ucr.ac.cr.modelo.Jugador;
import ucr.ac.cr.modelo.RegistroJugador;
import ucr.ac.cr.modelo.RegistroPartida;
import ucr.ac.cr.vista.GUIA;
import ucr.ac.cr.vista.GUIG;
import ucr.ac.cr.vista.GUIInicio;
import ucr.ac.cr.vista.PanelMenu;
import ucr.ac.cr.vista.PanelRegistro;
import ucr.ac.cr.vista.PanelSplashscreen;

/**
 *
 * @author Mónica Artavia
 */
public class ControladorInicio implements ActionListener {

    private GUIInicio guiInicio;
    private PanelMenu panelM;
    private GUIA guiAP;
    private GUIG guiGP;
    private PanelSplashscreen panelSp;
    private PanelRegistro panelR;
    private RegistroJugador registroJ;
    private RegistroPartida registroP;
    private Jugador jugador;
    private AudioInputStream musica, sonido;
    private Clip clip, clip2;

    public ControladorInicio(GUIInicio guiInicio, PanelMenu panelM, PanelSplashscreen panelSp, PanelRegistro panelR) {
        this.guiInicio = guiInicio;
        this.panelM = panelM;
        this.panelSp = panelSp;
        this.panelR = panelR;
        instanciar();
        registroJ = new RegistroJugador();
        registroJ.estadoJuego(false);
    }
    
    public void instanciar(){
        guiAP = new GUIA(guiInicio);
        registroP = guiAP.getControladorA().getRegistroP();
    }
    
    public void instanciarG(){
        guiGP = new GUIG(guiInicio);
        registroP = guiGP.getControladorG().getRegistroP();
    }
    
    public void mostrarJugadorGuardado(){
        if(registroJ.nombreJugador()!=null){
            panelM.esconderRegistro();
            panelM.mostrarCancelar();
        }else{
            panelM.mostrarRegistro();
            panelM.ocultarCancelar();
        }
    }
    
    public void reproducirMusica(){
        try {
            musica = AudioSystem.getAudioInputStream(new File("src/main/resources/img/musica menu (mp3cut.net).wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(musica);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException evento) {
           System.out.println("Error de reproduccion");
       }
    }
    
    public void reproducirSonido(String nombre){
        try {
            sonido = AudioSystem.getAudioInputStream(new File(nombre).getAbsoluteFile());
            clip2 = AudioSystem.getClip();
            clip2.open(sonido);
            clip2.start();
       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException evento) {
           System.out.println("Error de reproduccion");
       }
    }
    
    public void detener(){
        clip.stop();
        clip.close();
    }
    
    public void eliminarRegistro(){
        if(registroJ.personajeElegido().equalsIgnoreCase("Gato Amarillo")){
            registroJ.cancelarRegistro(registroJ.nombreJugador());
            panelR.ocultarCancelado();
            guiAP.getControladorA().eliminarPartida();
        }else{
            if(registroJ.personajeElegido().equalsIgnoreCase("Gato Gris")){
                registroJ.cancelarRegistro(registroJ.nombreJugador());
                panelR.ocultarCancelado();
                guiGP.getControladorG().eliminarPartida();
            }
        }
    }
    
    public String[][] getDatosJugador(){
        return registroJ.getDatosTabla();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        String datoLeido= evento.getActionCommand();
        
        switch(datoLeido){
           
           case "Play":
               this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
               if(registroJ.nombreJugador()==null){
                   panelM.mostrarRegistro();
                   panelM.ocultarCancelar();
               }else{
                   panelM.esconderRegistro();
                   panelM.mostrarCancelar();
                }
               guiInicio.mostrarMenu();
           break;
           
           case "Registrar Juego":
               this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
               guiInicio.mostrarRegistro();
               System.out.println("Registrar juego");
               panelM.esconderRegistro();
               panelM.mostrarCancelar();
           break;
           
           case "Jugar":
               this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
               System.out.println("se creo la instancia");
               if(registroJ.personajeElegido().equalsIgnoreCase("Gato Amarillo")){
                   if(registroP==null){
                       this.detener();
                       this.instanciar();
                       guiAP.setVisible(true);
                       guiInicio.dispose();
                       guiAP.getControladorA().reproducirMusica("src/main/resources/img/Sonido juego (mp3cut.net).wav");
                       guiAP.getControladorA().iniciarHilos();
                       guiAP.getControladorA().iniciarTiempo();
                       System.out.println("jugando con null");
                   }else{
                       if(registroP!=null && registroP.getNivel()>=1){
                           if(registroJ.retornaJuego()){
                               this.detener();
                               guiAP.setVisible(true);
                               guiInicio.dispose();
                               guiAP.getControladorA().reproducirMusica("src/main/resources/img/Sonido juego (mp3cut.net).wav");
                               guiAP.getControladorA().mostrarPartidaGuardada();
                               registroP.estadoHiloP(true);
                               registroP.estadoHiloL(true);
                               System.out.println("jugando con mayor a 1 sin iniciar hilos y tiempo");
                           }else{
                               this.detener();
                               guiAP.setVisible(true);
                               guiInicio.dispose();
                               guiAP.getControladorA().reproducirMusica("src/main/resources/img/Sonido juego (mp3cut.net).wav");
                               guiAP.getControladorA().mostrarPartidaGuardada();
                               registroP.estadoHiloP(true);
                               registroP.estadoHiloL(true);
                               guiAP.getControladorA().iniciarHilos();
                               guiAP.getControladorA().iniciarTiempo();
                               registroJ.estadoJuego(true);
                               System.out.println("jugando con mayor a 1 iniciando hilos y tiempo");
                           }
                       }else{
                           if(registroP!=null && registroP.getNivel()==0){
                               this.detener();
                               this.instanciar();
                               guiAP.setVisible(true);
                               guiInicio.dispose();
                               registroJ.estadoJuego(true);
                               System.out.println("jugando con igual a nada");
                               guiAP.getControladorA().reproducirMusica("src/main/resources/img/Sonido juego (mp3cut.net).wav");
                           }
                       }
                   }
               }else{
                   if(registroJ.personajeElegido().equalsIgnoreCase("Gato Gris")){
                        if(registroP==null){
                            this.detener();
                            this.instanciarG();
                            guiGP.setVisible(true);
                            guiInicio.dispose();
                            guiGP.getControladorG().reproducirMusica("src/main/resources/img/Sonido juego (mp3cut.net).wav");
                            guiGP.getControladorG().iniciarHilos();
                            guiGP.getControladorG().iniciarTiempo();
                            System.out.println("jugando con null");
                        }else{
                            if(registroP!=null && registroP.getNivel()>=1){
                                if(registroJ.retornaJuego()){
                                    this.detener();
                                    guiGP.setVisible(true);
                                    guiInicio.dispose();
                                    guiGP.getControladorG().reproducirMusica("src/main/resources/img/Sonido juego (mp3cut.net).wav");
                                    guiGP.getControladorG().mostrarPartidaGuardada();
                                    registroP.estadoHiloP(true);
                                    registroP.estadoHiloL(true);
                                    System.out.println("jugando con mayor a 1 sin iniciar hilos y tiempo");
                                }else{
                                    this.detener();
                                    guiGP.setVisible(true);
                                    guiInicio.dispose();
                                    guiGP.getControladorG().reproducirMusica("src/main/resources/img/Sonido juego (mp3cut.net).wav");
                                    guiGP.getControladorG().mostrarPartidaGuardada();
                                    registroP.estadoHiloP(true);
                                    registroP.estadoHiloL(true);
                                    guiGP.getControladorG().iniciarHilos();
                                    guiGP.getControladorG().iniciarTiempo();
                                    registroJ.estadoJuego(true);
                                    System.out.println("jugando con mayor a 1 iniciando hilos y tiempo");
                                }
                            }else{
                                if(registroP!=null && registroP.getNivel()==0){
                                    this.detener();
                                    this.instanciarG();
                                    guiGP.setVisible(true);
                                    guiInicio.dispose();
                                    registroJ.estadoJuego(true);
                                    System.out.println("jugando con igual a nada");
                                    guiGP.getControladorG().reproducirMusica("src/main/resources/img/Sonido juego (mp3cut.net).wav");
                                }
                            }
                        }
                   /*if(registroJ.personajeElegido().equalsIgnoreCase("Gato Gris")){
                       if(registroP==null){
                           guiInicio.mostrarMensaje("no has programado el gris aun", "");
                       }else{
                           if(registroP!=null){
                               guiInicio.mostrarMensaje("2 no has programado el gris aun", "");
                           }
                       }*/
                   } 
               }
               System.out.println("Jugar");
           break;
           
           case "Instrucciones":
               this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
               if(registroP==null){
                   System.out.println("entre a si " +registroP);
                    guiInicio.mostrarMensaje(registroJ.toString(),"");
                }else{
                    System.out.println("entre a no");
                    guiInicio.mostrarMensaje(registroJ.toString(), registroP.toString());
               }
               guiInicio.instru1(true);
               guiInicio.botonCerrar(true);
               panelM.botonesParaMensajes(false);
               System.out.println("Instrucciones");
           break;
           
           case "Salir":
               this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
               System.out.println("Salir");
               System.exit(0);
           break;
           
           case "Cancelar Registro":
               this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
               if(registroJ.personajeElegido().equalsIgnoreCase("Personaje")){
                   guiInicio.mostrarMensaje("Debe estar registrado", "");
                }else{
                   guiInicio.mostrarRegistro();
                   panelM.esconderRegistro();
                   panelR.mostrarCancelado();
               }
               System.out.println("Cancelar registro");
           break;
           
           case "Amarillo":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                System.out.println("Amarillo");
                panelR.amarillo();
                panelR.mostrarElegido("Gato Amarillo");
            break;
            
            case "Gris":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                System.out.println("gris");
                panelR.gris();
                panelR.mostrarElegido("Gato Gris");
            break;
            
            case "Crear":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                if(panelR.getTxtNombreP().equalsIgnoreCase("")){
                    guiInicio.mostrarMensaje("El nombre del felino no se puede agregar vacio", "");
                }else{
                    if(panelR.getTxtNombreJ().equalsIgnoreCase("")){
                        guiInicio.mostrarMensaje("Su nombre no se puede agregar vacio", "");
                    }else{
                        if(panelR.getLblTxtPersonaje().equalsIgnoreCase("Personaje")){
                            guiInicio.mostrarMensaje("Debe elegir un personaje","");
                        }else{
                            String nombreP = panelR.getTxtNombreP();
                            System.out.println("crear partida");
                            String nombreJ = panelR.getTxtNombreJ();
                            String elegido = panelR.getLblTxtPersonaje();
                            jugador = new Jugador(nombreJ, elegido, nombreP);
                            registroJ.agregar(jugador);
                            guiInicio.mostrarMenu();
                            panelR.limpiar();
                            
                        }
                    }
                }
                System.out.println("crear");
            break;
            
            case "Reiniciar Registro":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                eliminarRegistro();
                
            break;
            
            case "Derecha 1":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiInicio.instru1(false);
                guiInicio.instru2(true);
            break;
            
            case "Derecha 2":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiInicio.instru2(false);
                guiInicio.instru3(true);
            break;
            
            case "Izquierda 1":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiInicio.instru1(true);
                guiInicio.instru2(false);
            break;
            
            case "Izquierda 2":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiInicio.instru2(true);
                guiInicio.instru3(false);
            break;
            
            case "Cerrar Ins":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiInicio.instru1(false);
                guiInicio.instru2(false);
                guiInicio.instru3(false);
                guiInicio.botonCerrar(false);
                if(registroJ.nombreJugador()==null){
                   panelM.mostrarRegistro();
                   panelM.ocultarCancelar();
                   panelM.mostrarDosBotones(true);
               }else{
                   panelM.esconderRegistro();
                   panelM.mostrarCancelar();
                   panelM.mostrarDosBotones(true);
                }
            break;
            
            case "Cerrar MB":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiInicio.botonCerrarMB(false);
                guiInicio.mostrarCreditos(false);
                guiInicio.mostrarComentarios(false);
                guiInicio.mostrarVersion(false);
                if(registroJ.nombreJugador()==null){
                    panelM.mostrarRegistro();
                    panelM.ocultarCancelar();
                    panelM.mostrarDosBotones(true);
                }else{
                    panelM.esconderRegistro();
                    panelM.mostrarCancelar();
                    panelM.mostrarDosBotones(true);
                }
            break;
            
            case "Creditos":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiInicio.botonCerrarMB(true);
                guiInicio.mostrarCreditos(true);
                panelM.botonesParaMensajes(false);
            break;
            
            case "Version":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiInicio.botonCerrarMB(true);
                guiInicio.mostrarVersion(true);
                panelM.botonesParaMensajes(false);
            break;
            
            case "Comentarios":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiInicio.mostrarComentarios(true);
                guiInicio.botonCerrarMB(true);
                panelM.botonesParaMensajes(false);
            break;
       }
    }
}
