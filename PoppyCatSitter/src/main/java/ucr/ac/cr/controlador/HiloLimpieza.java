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
public class HiloLimpieza extends Thread{
    
    private RegistroPartida registroP;
    private PanelJuegoAP panelAP;
    private PanelJuegoAS panelAS;
    private PanelCompra panelCompra;
    private GUIA guiA;
    private ControladorA controladorA;
    
    public HiloLimpieza(RegistroPartida registroP, PanelJuegoAP panelAP, PanelJuegoAS panelAS, PanelCompra panelCompra, GUIA guiA, ControladorA controladorA) {
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
                //System.out.println("ABRE HILO LIMPIEZA");
                if(registroP.getLimpieza()>=76){
                    panelAS.limpiar();
                }
                if(registroP.getLimpieza()==75){
                    panelAS.pop();
                }
                if(registroP.getLimpieza()==65){
                    panelAS.pop();
                    panelAS.pop1();
                }
                if(registroP.getLimpieza()<65 && registroP.getLimpieza()>=45 && registroP.retornaEstadoHiloL()){
                    panelAP.suciedad1(true);
                    panelAS.suciedad1(true);
                    panelAS.limpio(false);
                    panelAP.limpio(false);
                    System.out.println("se ejecuta el si");
                }else{
                    panelAP.suciedad1(false);
                    panelAS.suciedad1(false);
                }
                if(registroP.getLimpieza()==50){
                    panelAS.pop();
                    panelAS.pop1();
                    panelAS.pop2();
                }
                if(registroP.getLimpieza()==45){
                    panelAS.pop();
                    panelAS.pop1();
                    panelAS.pop2();
                    panelAS.pop3();
                }
                if(registroP.getLimpieza()<45 && registroP.getLimpieza()>=30 && registroP.retornaEstadoHiloL()){
                    panelAP.suciedad2(true);
                    panelAS.suciedad2(true);
                    panelAP.suciedad1(false);
                    panelAS.suciedad1(false);
                    panelAS.limpio(false);
                    panelAP.limpio(false);
                    System.out.println("se ejecuta el si 2");
                }else{
                    panelAP.suciedad2(false);
                    panelAS.suciedad2(false);
                }
                if(registroP.getLimpieza()==40){
                    panelAS.pop();
                    panelAS.pop1();
                    panelAS.pop2();
                    panelAS.pop3();
                    panelAS.pop4();
                }
                if(registroP.getLimpieza()==35){
                    panelAS.pop();
                    panelAS.pop1();
                    panelAS.pop2();
                    panelAS.pop3();
                    panelAS.pop4();
                    panelAS.pop5();
                }
                if(registroP.getLimpieza()==30){
                    panelAS.pop();
                    panelAS.pop1();
                    panelAS.pop2();
                    panelAS.pop3();
                    panelAS.pop4();
                    panelAS.pop5();
                    panelAS.pop6();
                }
                if(registroP.getLimpieza()<30 && registroP.getLimpieza()>=15 && registroP.retornaEstadoHiloL()){
                    panelAP.suciedad3(true);
                    panelAS.suciedad3(true);
                    panelAP.suciedad2(false);
                    panelAS.suciedad2(false);
                    panelAS.limpio(false);
                    panelAP.limpio(false);
                    System.out.println("se ejecuta el si 3");
                }else{
                    panelAP.suciedad3(false);
                    panelAS.suciedad3(false);
                }
                if(registroP.getLimpieza()==25){
                    panelAS.pop();
                    panelAS.pop1();
                    panelAS.pop2();
                    panelAS.pop3();
                    panelAS.pop4();
                    panelAS.pop5();
                    panelAS.pop6();
                    panelAS.pop7();
                }
                if(registroP.getLimpieza()==20){
                    panelAS.pop();
                    panelAS.pop1();
                    panelAS.pop2();
                    panelAS.pop3();
                    panelAS.pop4();
                    panelAS.pop5();
                    panelAS.pop6();
                    panelAS.pop7();
                    panelAS.pop8();
                }
                if(registroP.getLimpieza()==15){
                    panelAS.pop();
                    panelAS.pop1();
                    panelAS.pop2();
                    panelAS.pop3();
                    panelAS.pop4();
                    panelAS.pop5();
                    panelAS.pop6();
                    panelAS.pop7();
                    panelAS.pop8();
                    panelAS.pop9();
                }
                if(registroP.getLimpieza()<15 && registroP.retornaEstadoHiloL()){
                    panelAP.suciedad4(true);
                    panelAS.suciedad4(true);
                    panelAP.suciedad3(false);
                    panelAS.suciedad3(false);
                    panelAS.limpio(false);
                    panelAP.limpio(false);
                    System.out.println("se ejecuta el si 4");
                }else{
                    panelAP.suciedad4(false);
                    panelAS.suciedad4(false);
                }
            sleep(100);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(HiloPartida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if(registroP.victoria()){
        System.out.println("has ganado, no debes limpiarte mas");
    }else{
        if(registroP.getNivel()==20){
            System.out.println("has perdido, limpiate mas seguido");
        }
    }
    this.interrupt();
    }
    
}
