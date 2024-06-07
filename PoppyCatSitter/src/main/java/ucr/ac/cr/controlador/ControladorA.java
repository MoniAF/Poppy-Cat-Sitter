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
import javax.swing.Timer;
import ucr.ac.cr.modelo.Partida;
import ucr.ac.cr.modelo.RegistroPartida;
import ucr.ac.cr.vista.GUIA;
import ucr.ac.cr.vista.GUIInicio;
import ucr.ac.cr.vista.PanelCompra;
import ucr.ac.cr.vista.PanelJuegoAP;
import ucr.ac.cr.vista.PanelJuegoAS;
import ucr.ac.cr.vista.PanelReporte;

/**
 *
 * @author Mónica Artavia
 */
public class ControladorA implements ActionListener{

    private GUIA guiA;
    private GUIInicio guiInicio;
    private PanelJuegoAP panelAP;
    private PanelReporte panelR;
    private PanelJuegoAS panelAS;
    private PanelCompra panelC;
    private RegistroPartida registroP;
    private Partida partida;
    private HiloPartida hiloP;
    private HiloDormir hiloD;
    private HiloLimpieza hiloL;
    private Timer tiempo;
    private int ms, seg, min;
    private AudioInputStream musica, sonido;
    private Clip clip, clip2;

    public ControladorA(GUIA guiA, PanelJuegoAP panelAP, PanelJuegoAS panelAS, PanelCompra panelC, PanelReporte panelR, GUIInicio guiInicio) {
        this.guiA = guiA;
        this.panelAP = panelAP;
        this.panelAS = panelAS;
        this.panelC = panelC;
        this.guiInicio = guiInicio;
        this.panelR = panelR;
        registroP = new RegistroPartida();
        hiloP = new HiloPartida(registroP, panelAP, panelAS, panelC, guiA, this);
        hiloD = new HiloDormir(registroP, panelAP, panelAS, panelC, guiA, this);
        hiloL = new HiloLimpieza(registroP, panelAP, panelAS, panelC, guiA, this);
        tiempo = new Timer(100, accion);
        panelR.setDatosTablaP(registroP.getDatosTabla());
    }
    
    public void mostrarPartidaGuardada(){
        if(registroP.getNivel()!=0){
           panelAP.mostrarNivel(""+registroP.getNivel()+"");
           panelAP.mostrarSalud(""+registroP.getSalud()+"");
           panelAP.mostrarPastilla(""+registroP.getPastilla()+"");
           panelAP.mostrarMedicamento(""+registroP.getMedicina()+"");
           panelAS.mostrarNivel(""+registroP.getNivel()+"");
           panelAS.mostrarComida(""+registroP.getHambre()+"");
           panelAS.mostrarDormir(""+registroP.getDormir()+"");
           panelAS.mostrarLimpieza(""+registroP.getLimpieza()+"");
           panelAS.mostrarLeche(""+registroP.getCantLeche()+"");
           panelAS.mostrarAgua(""+registroP.getCantAgua()+"");
           panelAS.mostrarCerdo(""+registroP.getCantCerdo()+"");
           panelAS.mostrarCarne(""+registroP.getCantCarne()+"");
           panelAS.mostrarPescado(""+registroP.getCantPescado()+"");
           panelAS.mostrarPollo(""+registroP.getCantPollo()+"");
           panelAS.mostrarJabon(""+registroP.getCantJabon()+"");
           panelC.mostrarAgua(""+registroP.getCantAgua()+"");
           panelC.mostrarLeche(""+registroP.getCantLeche()+"");
           panelC.mostrarCerdo(""+registroP.getCantCerdo()+"");
           panelC.mostrarCarne(""+registroP.getCantCarne()+"");
           panelC.mostrarPescado(""+registroP.getCantPescado()+"");
           panelC.mostrarPollo(""+registroP.getCantPollo()+"");
           panelC.mostrarDinero(""+registroP.getDinero()+"");
           panelC.mostrarMedicina(""+registroP.getMedicina()+"");
           panelC.mostrarPastilla(""+registroP.getPastilla()+"");
           panelC.mostrarJabon(""+registroP.getCantJabon()+"");
           guiA.setLblNivelP(""+registroP.getNivel()+"");
           guiA.setLblExp(""+registroP.getExperiencia()+"");
           panelAP.visibleComienzo();
           panelAP.mostrarComienzo();
        }
    }
    
    public void eliminarPartida(){
        if(registroP.getNivel()!=0){
            registroP.eliminarPartida(registroP.getNivel());
        }
    }
    
    public void reproducirMusica(String nombre){
        try {
            musica = AudioSystem.getAudioInputStream(new File(nombre).getAbsoluteFile());
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
    
    private ActionListener accion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evento) {
            ms++;
            if(ms==10){
                ms=0;
                seg ++;
            }
            if(seg==60){
                seg=0;
                min ++;
            }
            if(min==2 && ms==1){
                tiempo.restart();
                min=0;
                seg=1;
                ms=1;
            }
            mostrar();
            minuto();
            ms();
            seg();
        }
    };
    
    public void mostrar(){
        System.out.println(" min " + min + " seg " + seg + " ms " + ms);
    }
    
    public boolean tiempo(){
        if(minuto()==2 && ms()==0){
            iniciarTiempo();
            return true;
        }
        return false;
    }
    
    public boolean tiempoD(){
        if(minuto()==2 && ms()==0){
            iniciarTiempo();
            return true;
        }
        return false;
    }
    
    public boolean tiempoDurmiendo(){
        if(seg()==30 && ms()==0 || minuto()==1 && seg()==30 && ms()==0 || minuto()==1 && seg()==30 && ms()==0 || minuto()==2 && ms()==0){
            return true;
        }
        return false;
    }
    
    public int minuto(){
        return min;
    }
    
    public int ms(){
        return ms;
    }
    
    public int seg(){
        return seg;
    }
    
    public void iniciarTiempo(){
        tiempo.start();
    }
    
    public void finalizarTiempo(){
        tiempo.stop();
    }
    
    public RegistroPartida getRegistroP() {
        return registroP;
    }
    
    public void iniciarHilos(){
        hiloP.start();
        hiloD.start();
        hiloL.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        String datoLeido = evento.getActionCommand();
        switch(datoLeido){
            //PANTALLA 1
            case "Comenzar":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                int nivel=1, experiencia=100, dinero=200, carne=3, leche=3, agua=3, cerdo=3, pescado=3, pollo=3, medicina=0, pastilla=0, jabon=3, hambre=55, dormir=55, salud=100, limpieza=55;
                partida = new Partida(nivel, experiencia, dinero, carne, leche, agua, cerdo, pescado, pollo, medicina, pastilla, jabon, hambre, dormir, salud, limpieza);
                registroP.agregar(partida);
                panelAP.mostrarNivel(""+registroP.getNivel()+"");
                panelAP.mostrarSalud(""+registroP.getSalud()+"");
                panelAP.mostrarMedicamento(""+registroP.getMedicina());
                panelAS.mostrarNivel(""+registroP.getNivel()+"");
                panelAS.mostrarComida(""+registroP.getHambre()+"");
                panelAS.mostrarDormir(""+registroP.getDormir()+"");
                panelAS.mostrarLimpieza(""+registroP.getLimpieza()+"");
                panelAS.mostrarLeche(""+registroP.getCantLeche()+"");
                panelAS.mostrarAgua(""+registroP.getCantAgua()+"");
                panelAS.mostrarCerdo(""+registroP.getCantCerdo()+"");
                panelAS.mostrarCarne(""+registroP.getCantCarne()+"");
                panelAS.mostrarPescado(""+registroP.getCantPescado()+"");
                panelAS.mostrarPollo(""+registroP.getCantPollo()+"");
                panelAS.mostrarJabon(""+registroP.getCantJabon()+"");
                panelC.mostrarAgua(""+registroP.getCantAgua()+"");
                panelC.mostrarLeche(""+registroP.getCantLeche()+"");
                panelC.mostrarCerdo(""+registroP.getCantCerdo()+"");
                panelC.mostrarCarne(""+registroP.getCantCarne()+"");
                panelC.mostrarPescado(""+registroP.getCantPescado()+"");
                panelC.mostrarPollo(""+registroP.getCantPollo()+"");
                panelC.mostrarMedicina(""+registroP.getMedicina()+"");
                panelC.mostrarPastilla(""+registroP.getPastilla()+"");
                panelC.mostrarJabon(""+registroP.getCantJabon()+"");
                guiA.setLblNivelP(""+registroP.getNivel()+"");
                guiA.setLblExp(""+registroP.getExperiencia()+"");
                panelR.setDatosTablaP(registroP.getDatosTabla());
                panelAP.visibleComienzo();
                panelAP.mostrarComienzo();
                registroP.estadoHiloP(true);
                registroP.estadoHiloL(true);
                this.iniciarHilos();
                iniciarTiempo();
            break;
            
            case "Comprar":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                detener();
                this.reproducirMusica("src/main/resources/img/tienda (mp3cut.net).wav");
                panelC.mostrarDinero(""+registroP.getDinero()+"");
                guiA.mostrarCompra();
                
                System.out.println("comprar");
            break;
            
            case "Salud":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                panelAP.mostrarMedicina(true);
                panelAP.mostrarSaludBotones(false);
                if(registroP.getMedicina()==1){
                    panelAP.medicamentoEnable(true);
                }else{
                    panelAP.medicamentoEnable(false);
                    
                }
                if(registroP.getPastilla()==1){
                    panelAP.pastillaEnable(true);
                }else{
                    panelAP.pastillaEnable(false);
                }
                System.out.println("salud");
            break;
            
            case "Salud2":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                panelAP.mostrarMedicina(false);
                panelAP.mostrarSaludBotones(true);
                System.out.println("salud");
            break;
            
            case "Medicina":
                int totalMedicina=45;
                int ingresa=30;
                panelAP.mostrarMedicina(false);
                panelAP.mostrarSaludBotones(true);
                if(registroP.getMedicina()>0){
                    this.reproducirSonido("src/main/resources/img/medicina (mp3cut.net).wav");
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                    panelAP.mostrarSalud(""+registroP.aumentarSalud(totalMedicina)+"");
                    panelAP.mostrarMedicamento(""+registroP.disminuirCantMedicina()+"");
                }
                System.out.println("Medicina");
            break;
            
            case "Pastilla":
                int totalPastilla=35;
                ingresa=30;
                panelAP.mostrarMedicina(false);
                panelAP.mostrarSaludBotones(true);
                if(registroP.getPastilla()>0){
                    this.reproducirSonido("src/main/resources/img/medicina (mp3cut.net).wav");
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                    panelAP.mostrarSalud(""+registroP.aumentarSalud(totalPastilla)+"");
                    panelAP.mostrarPastilla(""+registroP.disminuirCantPastilla()+"");
                }
                System.out.println("Pastilla");
            break;
            
            case "Nivel 1":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiA.mostrarNivel(true);
                System.out.println("nivel");
            break;
            
            case "Cerrar Nivel":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiA.mostrarNivel(false);
            break;
            
            case "Cerrar Resultado":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                registroP.escribirJSON();
                panelR.setDatosTablaP(registroP.getDatosTabla());
                guiA.mostrarReporte(true);
                panelR.mostrarOk(true);
                guiA.btnCerrarResul(false);
                panelR.setDatosTablaJ(guiInicio.getControlador().getDatosJugador());
                
            break;
            
            case "Ok":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiInicio.getControlador().eliminarRegistro();
                this.eliminarPartida();
                detener();
                guiInicio.getControlador().reproducirMusica();
                this.finalizarTiempo();
                guiA.dispose();
                guiInicio.setVisible(true);
                guiInicio.mostrarMenu();
                guiInicio.getPanelMenu().mostrarRegistro();
                guiInicio.getPanelMenu().ocultarCancelar();
                guiA.mostrarReporte(false);
                panelR.mostrarOk(false);
            break;
            
            case "Siguiente":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                System.out.println("Siguiente");
                guiA.mostrarAS();
            break;
            
            case "Volver":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                detener();
                registroP.escribirJSON();
                registroP.estadoHiloP(false);
                registroP.estadoHiloL(false);
                guiInicio.getControlador().reproducirMusica();
                guiA.dispose();
                guiInicio.setVisible(true);
                guiInicio.mostrarMenu();
                System.out.println("volver");
            break;
            
            case "Anterior":
                panelAS.deshabilitarBotonesComida(false);
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiA.mostrarAP();
            break;
            
            case "Comida":
                this.reproducirSonido("src/main/resources/img/maullido comer (mp3cut.net).wav");
                if(registroP.getCantCarne()>0){
                    panelAS.deshabilitarBotonCarne(true);
                }else{
                    panelAS.deshabilitarBotonCarne(false);
                }
                if(registroP.getCantCerdo()>0){
                    panelAS.deshabilitarBotonCerdo(true);
                }else{
                    panelAS.deshabilitarBotonCerdo(false);
                }
                if(registroP.getCantPescado()>0){
                    panelAS.deshabilitarBotonPescado(true);
                }else{
                    panelAS.deshabilitarBotonPescado(false);
                }
                if(registroP.getCantPollo()>0){
                    panelAS.deshabilitarBotonPollo(true);
                }else{
                    panelAS.deshabilitarBotonPollo(false);
                }
                if(registroP.getCantAgua()>0){
                    panelAS.deshabilitarBotonAgua(true);
                }else{
                    panelAS.deshabilitarBotonAgua(false);
                }
                if(registroP.getCantLeche()>0){
                    panelAS.deshabilitarBotonLeche(true);
                }else{
                    panelAS.deshabilitarBotonLeche(false);
                }
                System.out.println("comida");
            break;
            
            case "Nivel 2":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiA.mostrarNivel(true);
            break;
            
            case "Noche":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                panelAS.mostrarNocheOn();
                System.out.println("dormir");
            break;
            
            case "Dia":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                panelAS.mostrarDia();
                System.out.println("dormir");
            break;
            
            case "Dormir":
                panelAP.lizzyMostrar(false);
                panelAS.mostrarNocheOff();
                panelAP.mostrarNoche();
                detener();
                panelAS.deshabilitarDormir(false);
                panelAP.deshabilitarDormir(false);
                reproducirMusica("src/main/resources/img/Musica de Cuna (mp3cut.net).wav");
                registroP.estadoHiloD(true);
                registroP.estadoHiloP(false);
                registroP.estadoHiloL(false);
                System.out.println("dormir");
            break;
            
            case "Despertar":
                detener();
                panelAP.lizzyMostrar(true);
                this.reproducirMusica("src/main/resources/img/Sonido juego (mp3cut.net).wav");
                panelAS.deshabilitarDormir(true);
                panelAP.deshabilitarDormir(true);
                panelAS.mostrarNocheOn();
                panelAP.mostrarDia();
                registroP.estadoHiloD(false);
                registroP.estadoHiloP(true);
                registroP.estadoHiloL(true);
                ingresa = 0;
                if(registroP.aumentarDescanso()>=20 && registroP.aumentarDescanso()<30){
                    if(registroP.getDormir()>=80 && registroP.getDormir()<90){
                        System.out.println("experiencia aumento en 20");
                        ingresa=20;
                        registroP.aumentarNivel(ingresa);
                    }
                }else{
                    if(registroP.aumentarDescanso()>=30 && registroP.aumentarDescanso()<40){
                        if(registroP.getDormir()>=90 && registroP.getDormir()<100){
                            System.out.println("experiencia aumento en 30");
                            ingresa=30;
                            registroP.aumentarNivel(ingresa);
                        }
                    }else{
                        if(registroP.aumentarDescanso()>=40){
                            if(registroP.getDormir()==100){
                                System.out.println("experiencia aumento en 40");
                                ingresa=40;
                                registroP.aumentarNivel(ingresa);
                            }
                        }
                    }
                }
                panelAS.mostrarNivel(""+registroP.getNivel()+"");
                panelAP.mostrarNivel(""+registroP.getNivel()+"");
                System.out.println("dormir");
            break;
            
            case "Limpiar":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                panelAS.mostrarJabon(true);
                System.out.println("Limpiar");
            break;
            
            case "Jabon":
                this.reproducirSonido("src/main/resources/img/burbujas (mp3cut.net).wav");
                limpieza=100;
                panelAP.limpio(true);
                panelAS.limpio(true);
                if(registroP.getLimpieza()<95){
                    panelAS.mostrarLimpieza(""+registroP.aumentarLimpieza(limpieza)+"");
                    panelAS.mostrarJabon(""+registroP.disminuirCantJabon()+"");
                    ingresa=15;
                    registroP.aumentarNivel(ingresa);
                }
                panelAS.mostrarNivel(""+registroP.getNivel()+"");
                panelAP.mostrarNivel(""+registroP.getNivel()+"");
                panelC.mostrarJabon(""+registroP.getCantJabon()+"");
                guiA.setLblNivelP(""+registroP.getNivel()+"");
                guiA.setLblExp(""+registroP.getExperiencia()+"");
                panelAS.mostrarJabon(false);
            break;
            
            case "Carne":
                carne=15;
                ingresa=25;
                if(registroP.getHambre()<100){
                    this.reproducirSonido("src/main/resources/img/comer .wav");
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                    panelAS.mostrarComida(registroP.aumentarHambre(carne));
                    panelAS.mostrarCarne(""+registroP.disminuirCantCarne()+"");
                    panelC.mostrarCarne(""+registroP.getCantCarne());
                    if(registroP.getHambre()==100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                    if(registroP.getCantCarne()==0){
                        panelAS.deshabilitarBotonCarne(false);
                    }
                }else{
                    if(registroP.getHambre()>=100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                }
            break;
            
            case "Cerdo":
                cerdo=15;
                ingresa=25;
                if(registroP.getHambre()<100){
                    this.reproducirSonido("src/main/resources/img/comer .wav");
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                    panelAS.mostrarComida(registroP.aumentarHambre(cerdo));
                    panelAS.mostrarCerdo(""+registroP.disminuirCantCerdo()+"");
                    panelC.mostrarCerdo(""+registroP.getCantCerdo()+"");
                    if(registroP.getHambre()==100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                    if(registroP.getCantCerdo()==0){
                        panelAS.deshabilitarBotonCerdo(false);
                    }
                }else{
                    if(registroP.getHambre()>=100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                }
                System.out.println("cerdo");
            break;
            
            case "Pescado":
                pescado=15;
                ingresa=25;
                if(registroP.getHambre()<100){
                    this.reproducirSonido("src/main/resources/img/comer .wav");
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                    panelAS.mostrarComida(registroP.aumentarHambre(pescado));
                    panelAS.mostrarPescado(""+registroP.disminuirCantPescado()+"");
                    panelC.mostrarPescado(""+registroP.getCantPescado()+"");
                    if(registroP.getHambre()==100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                    if(registroP.getCantPescado()==0){
                        panelAS.deshabilitarBotonPescado(false);
                    }
                }else{
                    if(registroP.getHambre()>=100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                }
                System.out.println("pescado");
            break;
            
            case "Pollo":
                pollo=15;
                ingresa=25;
                if(registroP.getHambre()<100){
                    this.reproducirSonido("src/main/resources/img/comer .wav");
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                    panelAS.mostrarComida(registroP.aumentarHambre(pollo));
                    panelAS.mostrarPollo(""+registroP.disminuirCantPollo()+"");
                    panelC.mostrarPollo(""+registroP.getCantPollo()+"");
                    if(registroP.getHambre()==100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                    if(registroP.getCantPollo()==0){
                        panelAS.deshabilitarBotonPollo(false);
                    }
                }else{
                    if(registroP.getHambre()>=100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                }
                System.out.println("pollo");
            break;
            
            case "Agua":
                agua=5;
                ingresa=10;
                if(registroP.getHambre()<100){
                    this.reproducirSonido("src/main/resources/img/comer .wav");
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                    panelAS.mostrarComida(registroP.aumentarHambre(agua));
                    panelAS.mostrarAgua(""+registroP.disminuirCantAgua()+"");
                    panelC.mostrarAgua(""+registroP.getCantAgua());
                    if(registroP.getHambre()==100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                    if(registroP.getCantAgua()==0){
                        panelAS.deshabilitarBotonAgua(false);
                    }
                }else{
                    if(registroP.getHambre()>=100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                }
                System.out.println("agua");
            break;
            
            case "Leche":
                leche=10;
                ingresa=15;
                if(registroP.getHambre()<100){
                    this.reproducirSonido("src/main/resources/img/comer .wav");
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                    panelAS.mostrarComida(registroP.aumentarHambre(leche));
                    panelAS.mostrarLeche(""+registroP.disminuirCantLeche()+"");
                    panelC.mostrarLeche(""+registroP.getCantLeche()+"");
                    if(registroP.getHambre()==100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                    if(registroP.getCantLeche()==0){
                        panelAS.deshabilitarBotonLeche(false);
                    }
                }else{
                    if(registroP.getHambre()>=100){
                        panelAS.deshabilitarBotonesComida(false);
                    }
                }
                System.out.println("Leche");
            break;
            
            case "Comprar Cerdo":
                int valor = 40;
                if(registroP.getDinero()>=valor && registroP.getDinero()>0){
                    this.reproducirSonido("src/main/resources/img/compra (mp3cut.net).wav");
                    panelC.mostrarCerdo(""+registroP.aumentarCantCerdo()+"");
                    panelAS.mostrarCerdo(""+registroP.getCantCerdo()+"");
                    panelC.mostrarDinero(""+registroP.disminuirDinero(valor)+"");
                    ingresa=5;
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                }else{
                    guiA.mostrarMensaje("NO PUEDES ADQUIRIR ESTE PRODUCTO");
                }
                System.out.println("cerdo");
            break;
            
            case "Comprar Carne":
                valor = 40;
                if(registroP.getDinero()>=valor && registroP.getDinero()>0){
                    this.reproducirSonido("src/main/resources/img/compra (mp3cut.net).wav");
                    panelC.mostrarCarne(""+registroP.aumentarCantCarne()+"");
                    panelAS.mostrarCarne(""+registroP.getCantCarne()+"");
                    panelC.mostrarDinero(""+registroP.disminuirDinero(valor));
                    ingresa=5;
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                }else{
                    guiA.mostrarMensaje("NO PUEDES ADQUIRIR ESTE PRODUCTO");
                }
                System.out.println("Carne");
            break;
            
            case "Comprar Pescado":
                valor = 40;
                if(registroP.getDinero()>=valor && registroP.getDinero()>0){
                    this.reproducirSonido("src/main/resources/img/compra (mp3cut.net).wav");
                    panelC.mostrarPescado(""+registroP.aumentarCantPescado()+"");
                    panelAS.mostrarPescado(""+registroP.getCantPescado()+"");
                    panelC.mostrarDinero(""+registroP.disminuirDinero(valor));
                    ingresa=5;
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                }else{
                    guiA.mostrarMensaje("NO PUEDES ADQUIRIR ESTE PRODUCTO");
                }
                System.out.println("Pescado");
            break;
            
            case "Comprar Pollo":
                valor = 40;
                if(registroP.getDinero()>=valor && registroP.getDinero()>0){
                    this.reproducirSonido("src/main/resources/img/compra (mp3cut.net).wav");
                    panelC.mostrarPollo(""+registroP.aumentarCantPollo()+"");
                    panelAS.mostrarPollo(""+registroP.getCantPollo()+"");
                    panelC.mostrarDinero(""+registroP.disminuirDinero(valor));
                    ingresa=5;
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                }else{
                    guiA.mostrarMensaje("NO PUEDES ADQUIRIR ESTE PRODUCTO");
                }
                System.out.println("Pollo");
            break;
            
            case "Comprar Leche":
                valor = 30;
                if(registroP.getDinero()>=valor && registroP.getDinero()>0){
                    this.reproducirSonido("src/main/resources/img/compra (mp3cut.net).wav");
                    panelC.mostrarLeche(""+registroP.aumentarCantLeche()+"");
                    panelAS.mostrarLeche(""+registroP.getCantLeche()+"");
                    panelC.mostrarDinero(""+registroP.disminuirDinero(valor));
                    ingresa=3;
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                }else{
                    guiA.mostrarMensaje("NO PUEDES ADQUIRIR ESTE PRODUCTO");
                }
                System.out.println("Leche");
            break;
            
            case "Comprar Agua":
                valor = 20;
                if(registroP.getDinero()>=valor && registroP.getDinero()>0){
                    this.reproducirSonido("src/main/resources/img/compra (mp3cut.net).wav");
                    panelC.mostrarAgua(""+registroP.aumentarCantAgua()+"");
                    panelAS.mostrarAgua(""+registroP.getCantAgua()+"");
                    panelC.mostrarDinero(""+registroP.disminuirDinero(valor));
                    ingresa=1;
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                }else{
                    guiA.mostrarMensaje("NO PUEDES ADQUIRIR ESTE PRODUCTO");
                }
                System.out.println("Agua");
            break;
            
            case "Comprar Pastilla":
                valor = 3000;
                int comprado = 0;
                if(registroP.getDinero()>=valor && registroP.getDinero()>0){
                    if(registroP.getPastilla()==0){
                        while(comprado == 0){
                            this.reproducirSonido("src/main/resources/img/compra (mp3cut.net).wav");
                            panelC.mostrarPastilla(""+registroP.aumentarPastilla()+"");
                            comprado++;
                            panelAP.mostrarPastilla(""+registroP.getPastilla()+"");
                            panelC.mostrarDinero(""+registroP.disminuirDinero(valor));
                            ingresa=30;
                            registroP.aumentarNivel(ingresa);
                            panelAS.mostrarNivel(""+registroP.getNivel()+"");
                            panelAP.mostrarNivel(""+registroP.getNivel()+"");
                            guiA.setLblNivelP(""+registroP.getNivel()+"");
                            guiA.setLblExp(""+registroP.getExperiencia()+"");
                        }
                    }else{
                        guiA.mostrarMensaje("NO PUEDES ADQUIRIR ESTE PRODUCTO");
                    }
                }else{
                    guiA.mostrarMensaje("DINERO INSUFICIENTE");
                }
                System.out.println("Agua");
            break;
            
            case "Comprar Medicina":
                valor = 3000;
                int comprado2 = 0;
                if(registroP.getDinero()>=valor && registroP.getDinero()>0){
                    if(registroP.getMedicina()==0){
                        while(comprado2 == 0){
                            this.reproducirSonido("src/main/resources/img/compra (mp3cut.net).wav");
                            panelC.mostrarMedicina(""+registroP.aumentarMedicina()+"");
                            comprado2 ++;
                            panelAP.mostrarMedicamento(""+registroP.getMedicina()+"");
                            panelC.mostrarDinero(""+registroP.disminuirDinero(valor));
                            ingresa=30;
                            registroP.aumentarNivel(ingresa);
                            panelAS.mostrarNivel(""+registroP.getNivel()+"");
                            panelAP.mostrarNivel(""+registroP.getNivel()+"");
                            guiA.setLblNivelP(""+registroP.getNivel()+"");
                            guiA.setLblExp(""+registroP.getExperiencia()+"");
                        }
                    }else{
                        guiA.mostrarMensaje("NO PUEDES ADQUIRIR ESTE PRODUCTO");
                    }
                }else{
                    guiA.mostrarMensaje("DINERO INSUFICIENTE");
                }
                System.out.println("Medicina");
            break;
            
            case "Comprar Jabon":
                valor = 40;
                if(registroP.getDinero()>=valor && registroP.getDinero()>0){
                    this.reproducirSonido("src/main/resources/img/compra (mp3cut.net).wav");
                    panelC.mostrarJabon(""+registroP.aumentarCantJabon()+"");
                    panelAS.mostrarJabon(""+registroP.getCantJabon()+"");
                    panelC.mostrarDinero(""+registroP.disminuirDinero(valor)+"");
                    ingresa=5;
                    registroP.aumentarNivel(ingresa);
                    panelAS.mostrarNivel(""+registroP.getNivel()+"");
                    panelAP.mostrarNivel(""+registroP.getNivel()+"");
                    guiA.setLblNivelP(""+registroP.getNivel()+"");
                    guiA.setLblExp(""+registroP.getExperiencia()+"");
                }else{
                    guiA.mostrarMensaje("NO PUEDES ADQUIRIR ESTE PRODUCTO");
                }
                System.out.println("Agua");
            break;
            
            case "Volver Pantalla":
                this.reproducirSonido("src/main/resources/img/boton tutuuun (mp3cut.net).wav");
                guiA.mostrarAP();
                detener();
                reproducirMusica("src/main/resources/img/Sonido juego (mp3cut.net).wav");
                System.out.println("Agua");
            break;
        }
    }
}
