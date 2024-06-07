/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import ucr.ac.cr.modelo.RegistroPartida;
import ucr.ac.cr.vista.GUIA;
import ucr.ac.cr.vista.PanelCompra;
import ucr.ac.cr.vista.PanelJuegoAP;
import ucr.ac.cr.vista.PanelJuegoAS;

/**
 *
 * @author Mónica Artavia
 */
public class HiloPartida extends Thread{
    
    private RegistroPartida registroP;
    private PanelJuegoAP panelAP;
    private PanelJuegoAS panelAS;
    private PanelCompra panelCompra;
    private GUIA guiA;
    private ControladorA controladorA;
    
    public HiloPartida(RegistroPartida registroP, PanelJuegoAP panelAP, PanelJuegoAS panelAS, PanelCompra panelCompra, GUIA guiA, ControladorA controladorA) {
        this.registroP = registroP;
        this.panelAP = panelAP;
        this.panelAS = panelAS;
        this.panelCompra = panelCompra;
        this.guiA = guiA;
        this.controladorA = controladorA;
    }

    @Override
    public void run() {
        while(registroP.getNivel()<20 && !registroP.victoria()){
            try {
                if(registroP.retornaEstadoHiloP()){
                    //System.out.println("ABRE HILO PARTIDA");
                    if(controladorA.tiempo()){
                        controladorA.reproducirSonido("src/main/resources/img/maullido (mp3cut.net).wav");
                        registroP.disminuirHambre();
                        panelAS.mostrarComida(""+registroP.getHambre()+"");
                        registroP.disminuirDescanso();
                        panelAS.mostrarDormir(""+registroP.getDormir()+"");
                        registroP.disminuirLimpieza();
                        panelAS.mostrarLimpieza(""+registroP.getLimpieza()+"");
                        registroP.disminuirSalud();
                        panelAP.mostrarSalud(""+registroP.getSalud()+"");
                    }
                }
            sleep(100);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(HiloPartida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if(registroP.victoria()){
        guiA.mostrarGane();
        panelAS.deshabilitarResultado(false);
        panelAP.deshabilitarResultado(false);
        panelCompra.deshabilitarResultado(false);
        controladorA.reproducirSonido("src/main/resources/img/victoria (mp3cut.net).wav");
    }else{
        if(registroP.getNivel()==20){
            guiA.mostrarPerdida();
            panelAS.deshabilitarResultado(false);
            panelAP.deshabilitarResultado(false);
            panelCompra.deshabilitarResultado(false);
            controladorA.reproducirSonido("src/main/resources/img/perdio (mp3cut.net).wav");
        }
    }
    this.interrupt();
    }  
}
