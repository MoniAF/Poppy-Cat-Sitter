/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.vista;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import ucr.ac.cr.controlador.ControladorA;

/**
 *
 * @author Mónica Artavia
 */
public class GUIA extends javax.swing.JFrame {

    private ControladorA controlador;
    
    /**
     * Creates new form GUIAP
     */
    public GUIA(GUIInicio guiInicio) {
        initComponents();
        controlador = new ControladorA(this, panelJuegoAP, panelJuegoAS, panelCompra, panelReporte, guiInicio);
        panelJuegoAP.escuchar(controlador);
        panelJuegoAS.escuchar(controlador);
        panelCompra.escucharA(controlador);
        this.mostrarAP();
        panelJuegoAP.ocultoComienzo();
        panelJuegoAP.ocultarComienzo();
        panelJuegoAS.mostrarDia();
        panelJuegoAP.mostrarDia();
        panelJuegoAS.limpiar();
        panelJuegoAP.suciedad1(false);
        panelJuegoAP.suciedad2(false);
        panelJuegoAP.suciedad3(false);
        panelJuegoAP.suciedad4(false);
        panelJuegoAP.limpio(true);
        panelJuegoAS.suciedad1(false);
        panelJuegoAS.suciedad2(false);
        panelJuegoAS.suciedad3(false);
        panelJuegoAS.suciedad4(false);
        panelJuegoAS.limpio(true);
        panelJuegoAP.mostrarMedicina(false);
        panelJuegoAS.mostrarJabon(false);
        panelReporte.escuchar(controlador);
        panelReporte.mostrarOk(false);
        this.mostrarReporte(false);
        this.noMostrar();
        this.escuchar(controlador);
        this.mostrarNivel(false);
        this.ocultar();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void escuchar(ControladorA controlador){
        btnCerrarNivel.addActionListener(controlador);
        btnCerrarResul.addActionListener(controlador);
    }

    public ControladorA getControladorA() {
        return controlador;
    }
    
    public void mostrarAP(){
        panelJuegoAS.setVisible(false);
        panelJuegoAP.setVisible(true);
        panelCompra.setVisible(false);
    }
    
    public void mostrarAS(){
        panelJuegoAS.setVisible(true);
        panelJuegoAP.setVisible(false);
        panelCompra.setVisible(false);
    }
    
    public void mostrarCompra(){
        panelJuegoAS.setVisible(false);
        panelJuegoAP.setVisible(false);
        panelCompra.setVisible(true);
    }
    
    public void mostrarReporte(boolean estado){
        panelReporte.setVisible(estado);
    }
    
    public void setLblExp(String lblExp) {
        this.lblExp.setText(lblExp);
    }

    public void setLblNivelP(String lblNivelP) {
        this.lblNivelP.setText(lblNivelP);
    }
    
    public void btnCerrarResul(boolean estado){
        btnCerrarResul.setVisible(estado);
    }
    
    public void mostrarGane(){
        lblGano.setVisible(true);
        btnCerrarResul.setVisible(true);
    }
    
    public void noMostrar(){
        lblPerdio.setVisible(false);
        lblGano.setVisible(false);
    }
    
    public void mostrarPerdida(){
        lblPerdio.setVisible(true);
        btnCerrarResul.setVisible(true);
    }
    
    public void ocultar(){
        lblGano.setVisible(false);
        lblPerdio.setVisible(false);
        btnCerrarResul.setVisible(false);
    }
    
    public void mostrarNivel(boolean estado){
        lblNivel.setVisible(estado);
        lblNivelP.setVisible(estado);
        lblExp.setVisible(estado);
        btnCerrarNivel.setVisible(estado);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCerrarResul = new javax.swing.JButton();
        btnCerrarNivel = new javax.swing.JButton();
        panelReporte = new ucr.ac.cr.vista.PanelReporte();
        lblExp = new javax.swing.JLabel();
        lblNivelP = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        lblGano = new javax.swing.JLabel();
        lblPerdio = new javax.swing.JLabel();
        panelJuegoAP = new ucr.ac.cr.vista.PanelJuegoAP();
        panelCompra = new ucr.ac.cr.vista.PanelCompra();
        panelJuegoAS = new ucr.ac.cr.vista.PanelJuegoAS();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrarResul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CERRAR.png"))); // NOI18N
        btnCerrarResul.setActionCommand("Cerrar Resultado");
        btnCerrarResul.setBorderPainted(false);
        btnCerrarResul.setContentAreaFilled(false);
        getContentPane().add(btnCerrarResul, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 660, 110, -1));

        btnCerrarNivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CERRAR.png"))); // NOI18N
        btnCerrarNivel.setActionCommand("Cerrar Nivel");
        btnCerrarNivel.setBorderPainted(false);
        btnCerrarNivel.setContentAreaFilled(false);
        getContentPane().add(btnCerrarNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 660, 110, -1));
        getContentPane().add(panelReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 260, 130));

        lblExp.setFont(new java.awt.Font("Rockwell", 0, 55)); // NOI18N
        lblExp.setForeground(new java.awt.Color(255, 255, 255));
        lblExp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExp.setText("0");
        getContentPane().add(lblExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, 550, -1));

        lblNivelP.setFont(new java.awt.Font("Rockwell", 0, 115)); // NOI18N
        lblNivelP.setForeground(new java.awt.Color(255, 255, 255));
        lblNivelP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivelP.setText("0");
        getContentPane().add(lblNivelP, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 550, -1));

        lblNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NIVEL.png"))); // NOI18N
        getContentPane().add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 720, 1080));

        lblGano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GANO.png"))); // NOI18N
        getContentPane().add(lblGano, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 720, 1080));

        lblPerdio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerdio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PERDIO.png"))); // NOI18N
        getContentPane().add(lblPerdio, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 720, 1080));
        getContentPane().add(panelJuegoAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(panelCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(panelJuegoAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarNivel;
    private javax.swing.JButton btnCerrarResul;
    private javax.swing.JLabel lblExp;
    private javax.swing.JLabel lblGano;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNivelP;
    private javax.swing.JLabel lblPerdio;
    private ucr.ac.cr.vista.PanelCompra panelCompra;
    private ucr.ac.cr.vista.PanelJuegoAP panelJuegoAP;
    private ucr.ac.cr.vista.PanelJuegoAS panelJuegoAS;
    private ucr.ac.cr.vista.PanelReporte panelReporte;
    // End of variables declaration//GEN-END:variables
}