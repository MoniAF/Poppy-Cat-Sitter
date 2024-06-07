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
import ucr.ac.cr.vista.GUIG;
import ucr.ac.cr.vista.PanelCompra;
import ucr.ac.cr.vista.PanelJuegoGP;
import ucr.ac.cr.vista.PanelJuegoGS;

/**
 *
 * @author Mónica Artavia
 */
public class HiloLimpiezaG extends Thread{
    private RegistroPartida registroP;
    private PanelJuegoGP panelGP;
    private PanelJuegoGS panelGS;
    private PanelCompra panelCompra;
    private GUIG guiG;
    private ControladorG controladorG;

    public HiloLimpiezaG(RegistroPartida registroP, PanelJuegoGP panelGP, PanelJuegoGS panelGS, PanelCompra panelCompra, GUIG guiG, ControladorG controladorG) {
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
                //System.out.println("ABRE HILO LIMPIEZA");
                if(registroP.getLimpieza()>=76){
                    panelGS.limpiar();
                }
                if(registroP.getLimpieza()==75){
                    panelGS.pop();
                }
                if(registroP.getLimpieza()==65){
                    panelGS.pop();
                    panelGS.pop1();
                }
                if(registroP.getLimpieza()<65 && registroP.getLimpieza()>=45 && registroP.retornaEstadoHiloL()){
                    panelGP.suciedad1(true);
                    panelGS.suciedad1(true);
                    panelGS.limpio(false);
                    panelGP.limpio(false);
                    System.out.println("se ejecuta el si");
                }else{
                    panelGP.suciedad1(false);
                    panelGS.suciedad1(false);
                }
                if(registroP.getLimpieza()==50){
                    panelGS.pop();
                    panelGS.pop1();
                    panelGS.pop2();
                }
                if(registroP.getLimpieza()==45){
                    panelGS.pop();
                    panelGS.pop1();
                    panelGS.pop2();
                    panelGS.pop3();
                }
                if(registroP.getLimpieza()<45 && registroP.getLimpieza()>=30 && registroP.retornaEstadoHiloL()){
                    panelGP.suciedad2(true);
                    panelGS.suciedad2(true);
                    panelGP.suciedad1(false);
                    panelGS.suciedad1(false);
                    panelGS.limpio(false);
                    panelGP.limpio(false);
                    System.out.println("se ejecuta el si 2");
                }else{
                    panelGP.suciedad2(false);
                    panelGS.suciedad2(false);
                }
                if(registroP.getLimpieza()==40){
                    panelGS.pop();
                    panelGS.pop1();
                    panelGS.pop2();
                    panelGS.pop3();
                    panelGS.pop4();
                }
                if(registroP.getLimpieza()==35){
                    panelGS.pop();
                    panelGS.pop1();
                    panelGS.pop2();
                    panelGS.pop3();
                    panelGS.pop4();
                    panelGS.pop5();
                }
                if(registroP.getLimpieza()==30){
                    panelGS.pop();
                    panelGS.pop1();
                    panelGS.pop2();
                    panelGS.pop3();
                    panelGS.pop4();
                    panelGS.pop5();
                    panelGS.pop6();
                }
                if(registroP.getLimpieza()<30 && registroP.getLimpieza()>=15 && registroP.retornaEstadoHiloL()){
                    panelGP.suciedad3(true);
                    panelGS.suciedad3(true);
                    panelGP.suciedad2(false);
                    panelGS.suciedad2(false);
                    panelGS.limpio(false);
                    panelGP.limpio(false);
                    System.out.println("se ejecuta el si 3");
                }else{
                    panelGP.suciedad3(false);
                    panelGS.suciedad3(false);
                }
                if(registroP.getLimpieza()==25){
                    panelGS.pop();
                    panelGS.pop1();
                    panelGS.pop2();
                    panelGS.pop3();
                    panelGS.pop4();
                    panelGS.pop5();
                    panelGS.pop6();
                    panelGS.pop7();
                }
                if(registroP.getLimpieza()==20){
                    panelGS.pop();
                    panelGS.pop1();
                    panelGS.pop2();
                    panelGS.pop3();
                    panelGS.pop4();
                    panelGS.pop5();
                    panelGS.pop6();
                    panelGS.pop7();
                    panelGS.pop8();
                }
                if(registroP.getLimpieza()==15){
                    panelGS.pop();
                    panelGS.pop1();
                    panelGS.pop2();
                    panelGS.pop3();
                    panelGS.pop4();
                    panelGS.pop5();
                    panelGS.pop6();
                    panelGS.pop7();
                    panelGS.pop8();
                    panelGS.pop9();
                }
                if(registroP.getLimpieza()<15 && registroP.retornaEstadoHiloL()){
                    panelGP.suciedad4(true);
                    panelGS.suciedad4(true);
                    panelGP.suciedad3(false);
                    panelGS.suciedad3(false);
                    panelGS.limpio(false);
                    panelGP.limpio(false);
                    System.out.println("se ejecuta el si 4");
                }else{
                    panelGP.suciedad4(false);
                    panelGS.suciedad4(false);
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
