/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import ucr.ac.cr.modelo.RegistroPartida;
import ucr.ac.cr.vista.GUIG;
import ucr.ac.cr.vista.PanelCompra;
import ucr.ac.cr.vista.PanelJuegoGP;
import ucr.ac.cr.vista.PanelJuegoGS;

/**
 *
 * @author Mónica Artavia
 */
public class HiloPartidaG extends Thread{
    private RegistroPartida registroP;
    private PanelJuegoGP panelGP;
    private PanelJuegoGS panelGS;
    private PanelCompra panelCompra;
    private GUIG guiG;
    private ControladorG controladorG;

    public HiloPartidaG(RegistroPartida registroP, PanelJuegoGP panelGP, PanelJuegoGS panelGS, PanelCompra panelCompra, GUIG guiG, ControladorG controladorG) {
        this.registroP = registroP;
        this.panelGP = panelGP;
        this.panelGS = panelGS;
        this.panelCompra = panelCompra;
        this.guiG = guiG;
        this.controladorG = controladorG;
    }
    
    @Override
    public void run() {
        while(registroP.getNivel()<20 && !registroP.victoria()){
            try {
                if(registroP.retornaEstadoHiloP()){
                    //System.out.println("ABRE HILO PARTIDA");
                    if(controladorG.tiempo()){
                        controladorG.reproducirSonido("src/main/resources/img/maullido (mp3cut.net).wav");
                        registroP.disminuirHambre();
                        panelGS.mostrarComida(""+registroP.getHambre()+"");
                        registroP.disminuirDescanso();
                        panelGS.mostrarDormir(""+registroP.getDormir()+"");
                        registroP.disminuirLimpieza();
                        panelGS.mostrarLimpieza(""+registroP.getLimpieza()+"");
                        registroP.disminuirSalud();
                        panelGP.mostrarSalud(""+registroP.getSalud()+"");
                    }
                }
            sleep(100);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(HiloPartida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if(registroP.victoria()){
        guiG.mostrarGane();
        panelGS.deshabilitarResultado(false);
        panelGP.deshabilitarResultado(false);
        panelCompra.deshabilitarResultado(false);
        controladorG.reproducirSonido("src/main/resources/img/victoria (mp3cut.net).wav");
    }else{
        if(registroP.getNivel()==20){
            guiG.mostrarPerdida();
            panelGS.deshabilitarResultado(false);
            panelGP.deshabilitarResultado(false);
            panelCompra.deshabilitarResultado(false);
            controladorG.reproducirSonido("src/main/resources/img/perdio (mp3cut.net).wav");
        }
    }
    this.interrupt();
    } 
}
