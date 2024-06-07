/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.controlador;

import static java.lang.Thread.sleep;
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
public class HiloDormir extends Thread{
    
    private RegistroPartida registroP;
    private PanelJuegoAP panelAP;
    private PanelJuegoAS panelAS;
    private PanelCompra panelCompra;
    private GUIA guiA;
    private ControladorA controladorA;
    
    public HiloDormir(RegistroPartida registroP, PanelJuegoAP panelAP, PanelJuegoAS panelAS, PanelCompra panelCompra, GUIA guiA, ControladorA controladorA) {
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
                if(registroP.retornaEstadoHiloD()){
                    //System.out.println("EMPIEZA HILO DORMIR");
                    if(controladorA.tiempoDurmiendo()){
                        registroP.aumentarDescanso();
                        panelAS.mostrarDormir(""+registroP.getDormir()+"");
                        System.out.println("mimida");
                    }
                    if(controladorA.tiempoD()){
                        registroP.disminuirHambre();
                        panelAS.mostrarComida(""+registroP.getHambre()+"");
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
        System.out.println("has ganado, deja de dormir");
    }else{
        if(registroP.getNivel()==20){
            System.out.println("ha perdido, sigue durmiendo mejor");
        }
    }
    this.interrupt();
    }
    
}
