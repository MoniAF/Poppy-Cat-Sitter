/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.vista;

import javax.swing.JLabel;
import ucr.ac.cr.controlador.ControladorA;

/**
 *
 * @author Mónica Artavia
 */
public class PanelJuegoAS extends javax.swing.JPanel {

    private ControladorA controlador;
    /**
     * Creates new form PanelPJuegoA
     */
    public PanelJuegoAS() {
        initComponents();
    }
    
    public void iniciandoNuevo(){
        deshabilitarBotonesComida(false);
        mostrarDia();
    }
    
    public void deshabilitarDormir(boolean estado){
        btnComida.setEnabled(estado);
        btnNoche.setEnabled(estado);
        btnDia.setEnabled(estado);
        btnLimpiar.setEnabled(estado);
        btnAgua.setEnabled(estado);
        btnCarne.setEnabled(estado);
        btnCerdo.setEnabled(estado);
        btnLeche.setEnabled(estado);
        btnPescado.setEnabled(estado);
        btnPollo.setEnabled(estado);
    }
    
    public void deshabilitarResultado(boolean estado){
        btnAnterior.setVisible(estado);
        btnComida.setVisible(estado);
        btnNoche.setVisible(estado);
        btnDia.setVisible(estado);
        btnLimpiar.setVisible(estado);
        btnNivel.setVisible(estado);
        btnAgua.setVisible(estado);
        btnCarne.setVisible(estado);
        btnCerdo.setVisible(estado);
        btnLeche.setVisible(estado);
        btnPescado.setVisible(estado);
        btnPollo.setVisible(estado);
        btnDespertar.setVisible(estado);
        btnDurmiendo.setVisible(estado);
        btnJabon.setVisible(estado);
        poppyNormal.setVisible(estado);
    }
    
    public void escuchar(ControladorA controlador){
        btnAnterior.addActionListener(controlador);
        btnComida.addActionListener(controlador);
        btnNoche.addActionListener(controlador);
        btnDia.addActionListener(controlador);
        btnLimpiar.addActionListener(controlador);
        btnNivel.addActionListener(controlador);
        btnAgua.addActionListener(controlador);
        btnCarne.addActionListener(controlador);
        btnCerdo.addActionListener(controlador);
        btnLeche.addActionListener(controlador);
        btnPescado.addActionListener(controlador);
        btnPollo.addActionListener(controlador);
        btnDespertar.addActionListener(controlador);
        btnDurmiendo.addActionListener(controlador);
        btnJabon.addActionListener(controlador);
    }
    
    public void deshabilitarBotonesComida(boolean estado){
        btnAgua.setEnabled(estado);
        btnCarne.setEnabled(estado);
        btnCerdo.setEnabled(estado);
        btnLeche.setEnabled(estado);
        btnPescado.setEnabled(estado);
        btnPollo.setEnabled(estado);
    }
    
    public void mostrarDia(){
        fondoDia.setVisible(true);
        fondoNocheOff.setVisible(false);
        fondoNocheOn.setVisible(false);
        btnDurmiendo.setVisible(false);
        btnDespertar.setVisible(false);
        poppyNormal.setVisible(true);
        btnDia.setVisible(false);
        btnNoche.setVisible(true);
        amarilloOff.setVisible(false);
        amarillo.setVisible(true);
    }
    
    public void mostrarNocheOn(){
        fondoDia.setVisible(false);
        fondoNocheOff.setVisible(false);
        fondoNocheOn.setVisible(true);
        btnDurmiendo.setVisible(true);
        btnDespertar.setVisible(false);
        poppyNormal.setVisible(false);
        btnDia.setVisible(true);
        btnNoche.setVisible(false);
        amarilloOff.setVisible(false);
        amarillo.setVisible(true);
    }
    
    public void mostrarNocheOff(){
        fondoDia.setVisible(false);
        fondoNocheOff.setVisible(true);
        fondoNocheOn.setVisible(false);
        btnDurmiendo.setVisible(false);
        btnDespertar.setVisible(true);
        poppyNormal.setVisible(false);
        btnDia.setVisible(true);
        btnNoche.setVisible(false);
        amarilloOff.setVisible(true);
        amarillo.setVisible(false);
    }
    
    public void deshabilitarBotonAgua(boolean estado){
        btnAgua.setEnabled(estado);
    }
    
    public void deshabilitarBotonLeche(boolean estado){
        btnLeche.setEnabled(estado);
    }
    
    public void deshabilitarBotonCerdo(boolean estado){
        btnCerdo.setEnabled(estado);
    }
    
    public void deshabilitarBotonCarne(boolean estado){
        btnCarne.setEnabled(estado);
    }
    
    public void deshabilitarBotonPescado(boolean estado){
        btnPescado.setEnabled(estado);
    }
    
    public void deshabilitarBotonPollo(boolean estado){
        btnPollo.setEnabled(estado);
    }
    
    public void mostrarJabon(String titulo){
        jabon.setText(titulo);
    }
    
    public void mostrarNivel(String titulo){
        nivel.setText(titulo);
    }
    
    public void mostrarComida(String titulo){
        comida.setText(titulo);
    }
    
    public void mostrarDormir(String titulo){
        dormir.setText(titulo);
    }
    
    public void mostrarLimpieza(String titulo){
        limpieza.setText(titulo);
    }
    
    public void mostrarLeche(String titulo){
        leche.setText(titulo);
    }
    
    public void mostrarAgua(String titulo){
        agua.setText(titulo);
    }
    
    public void mostrarCerdo(String titulo){
        cerdo.setText(titulo);
    }
    
    public void mostrarCarne(String titulo){
        carne.setText(titulo);
    }
    
    public void mostrarPescado(String titulo){
        pescado.setText(titulo);
    }
    
    public void mostrarPollo(String titulo){
        pollo.setText(titulo);
    }

    public void pop() {
        pop.setVisible(true);
    }

    public void pop1() {
        pop1.setVisible(true);
    }

    public void pop2() {
        pop2.setVisible(true);
    }

    public void pop3() {
        pop3.setVisible(true);
    }

    public void pop4() {
        pop4.setVisible(true);
    }

    public void pop5() {
        pop5.setVisible(true);
    }

    public void pop6() {
        pop6.setVisible(true);
    }

    public void pop7() {
        pop7.setVisible(true);
    }

    public void pop8() {
        pop8.setVisible(true);
    }

    public void pop9() {
        pop9.setVisible(true);
    }
    
    public void limpiar(){
        pop.setVisible(false);
        pop1.setVisible(false);
        pop2.setVisible(false);
        pop3.setVisible(false);
        pop4.setVisible(false);
        pop5.setVisible(false);
        pop6.setVisible(false);
        pop7.setVisible(false);
        pop8.setVisible(false);
        pop9.setVisible(false);
    }
    
    public void mostrarJabon(boolean estado){
        btnJabon.setVisible(estado);
        jabon.setVisible(estado);
    }
    
    public void suciedad1(boolean estado){
        amarilloSucio1.setVisible(estado);
    }
    
    public void suciedad2(boolean estado){
        amarilloSucio2.setVisible(estado);
    }
    
    public void suciedad3(boolean estado){
        amarilloSucio3.setVisible(estado);
    }
    
    public void suciedad4(boolean estado){
        amarilloSucio4.setVisible(estado);
    }
    
    public void limpio(boolean estado){
        amarillo.setVisible(estado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pollo = new javax.swing.JLabel();
        pescado = new javax.swing.JLabel();
        cerdo = new javax.swing.JLabel();
        carne = new javax.swing.JLabel();
        agua = new javax.swing.JLabel();
        leche = new javax.swing.JLabel();
        btnJabon = new javax.swing.JButton();
        btnDurmiendo = new javax.swing.JButton();
        btnDespertar = new javax.swing.JButton();
        btnPollo = new javax.swing.JButton();
        btnPescado = new javax.swing.JButton();
        nivel = new javax.swing.JLabel();
        jabon = new javax.swing.JLabel();
        btnCarne = new javax.swing.JButton();
        btnCerdo = new javax.swing.JButton();
        btnAgua = new javax.swing.JButton();
        btnLeche = new javax.swing.JButton();
        comida = new javax.swing.JLabel();
        dormir = new javax.swing.JLabel();
        limpieza = new javax.swing.JLabel();
        btnNivel = new javax.swing.JButton();
        btnNoche = new javax.swing.JButton();
        btnDia = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnComida = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        amarilloSucio4 = new javax.swing.JLabel();
        amarilloSucio3 = new javax.swing.JLabel();
        amarilloSucio2 = new javax.swing.JLabel();
        amarilloSucio1 = new javax.swing.JLabel();
        amarillo = new javax.swing.JLabel();
        amarilloOff = new javax.swing.JLabel();
        poppyNormal = new javax.swing.JButton();
        pop9 = new javax.swing.JLabel();
        pop8 = new javax.swing.JLabel();
        pop7 = new javax.swing.JLabel();
        pop6 = new javax.swing.JLabel();
        pop5 = new javax.swing.JLabel();
        pop4 = new javax.swing.JLabel();
        pop3 = new javax.swing.JLabel();
        pop2 = new javax.swing.JLabel();
        pop1 = new javax.swing.JLabel();
        pop = new javax.swing.JLabel();
        fondoDia = new javax.swing.JLabel();
        fondoNocheOn = new javax.swing.JLabel();
        fondoNocheOff = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pollo.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        pollo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(pollo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 360, 50, 10));

        pescado.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        pescado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(pescado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 360, 50, 10));

        cerdo.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        cerdo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(cerdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 240, 50, 10));

        carne.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        carne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(carne, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 240, 50, 10));

        agua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(agua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 120, 50, 10));

        leche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(leche, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 120, 50, 10));

        btnJabon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JABON.png"))); // NOI18N
        btnJabon.setActionCommand("Jabon");
        btnJabon.setBorderPainted(false);
        btnJabon.setContentAreaFilled(false);
        btnJabon.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JABON.png"))); // NOI18N
        btnJabon.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JBA.png"))); // NOI18N
        add(btnJabon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 910, 60, -1));

        btnDurmiendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Poppy off.png"))); // NOI18N
        btnDurmiendo.setActionCommand("Dormir");
        btnDurmiendo.setBorderPainted(false);
        btnDurmiendo.setContentAreaFilled(false);
        add(btnDurmiendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 730, 160, 240));

        btnDespertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Poppy on.png"))); // NOI18N
        btnDespertar.setActionCommand("Despertar");
        btnDespertar.setBorderPainted(false);
        btnDespertar.setContentAreaFilled(false);
        add(btnDespertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 730, 160, 240));

        btnPollo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pollo.png"))); // NOI18N
        btnPollo.setActionCommand("Pollo");
        btnPollo.setBorderPainted(false);
        btnPollo.setContentAreaFilled(false);
        btnPollo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PO1.png"))); // NOI18N
        btnPollo.setEnabled(false);
        btnPollo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pollo.png"))); // NOI18N
        btnPollo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PO1.png"))); // NOI18N
        add(btnPollo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 280, 70, -1));

        btnPescado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pescado.png"))); // NOI18N
        btnPescado.setActionCommand("Pescado");
        btnPescado.setBorderPainted(false);
        btnPescado.setContentAreaFilled(false);
        btnPescado.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PE1.png"))); // NOI18N
        btnPescado.setEnabled(false);
        btnPescado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pescado.png"))); // NOI18N
        btnPescado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PE1.png"))); // NOI18N
        add(btnPescado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 280, 70, -1));

        nivel.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        nivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivel.setText("0");
        add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 40, 60, -1));

        jabon.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jabon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jabon.setText("0");
        add(jabon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 900, 60, -1));

        btnCarne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carne.png"))); // NOI18N
        btnCarne.setActionCommand("Carne");
        btnCarne.setBorderPainted(false);
        btnCarne.setContentAreaFilled(false);
        btnCarne.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CN1.png"))); // NOI18N
        btnCarne.setEnabled(false);
        btnCarne.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carne.png"))); // NOI18N
        btnCarne.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CN1.png"))); // NOI18N
        add(btnCarne, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 160, 70, -1));

        btnCerdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerdo.png"))); // NOI18N
        btnCerdo.setActionCommand("Cerdo");
        btnCerdo.setBorderPainted(false);
        btnCerdo.setContentAreaFilled(false);
        btnCerdo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CR1.png"))); // NOI18N
        btnCerdo.setEnabled(false);
        btnCerdo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerdo.png"))); // NOI18N
        btnCerdo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CR1.png"))); // NOI18N
        add(btnCerdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 160, 70, -1));

        btnAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agua.png"))); // NOI18N
        btnAgua.setActionCommand("Agua");
        btnAgua.setBorderPainted(false);
        btnAgua.setContentAreaFilled(false);
        btnAgua.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/AG1.png"))); // NOI18N
        btnAgua.setEnabled(false);
        btnAgua.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agua.png"))); // NOI18N
        btnAgua.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/AG1.png"))); // NOI18N
        add(btnAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 40, 70, -1));

        btnLeche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/leche.png"))); // NOI18N
        btnLeche.setActionCommand("Leche");
        btnLeche.setBorderPainted(false);
        btnLeche.setContentAreaFilled(false);
        btnLeche.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LH1.png"))); // NOI18N
        btnLeche.setEnabled(false);
        btnLeche.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/leche.png"))); // NOI18N
        btnLeche.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LH1.png"))); // NOI18N
        add(btnLeche, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 40, 70, -1));

        comida.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        comida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comida.setText("0");
        add(comida, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 1030, 60, -1));

        dormir.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        dormir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dormir.setText("0");
        add(dormir, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 1030, 60, -1));

        limpieza.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        limpieza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        limpieza.setText("0");
        add(limpieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 1030, 60, -1));

        btnNivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NIVEL A.png"))); // NOI18N
        btnNivel.setActionCommand("Nivel 2");
        btnNivel.setBorderPainted(false);
        btnNivel.setContentAreaFilled(false);
        btnNivel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NIVEL A.png"))); // NOI18N
        btnNivel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NVA.png"))); // NOI18N
        add(btnNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 80, -1));

        btnNoche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DORMIR A.png"))); // NOI18N
        btnNoche.setActionCommand("Noche");
        btnNoche.setBorderPainted(false);
        btnNoche.setContentAreaFilled(false);
        btnNoche.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DOA.png"))); // NOI18N
        btnNoche.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DORMIR A.png"))); // NOI18N
        btnNoche.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DOA.png"))); // NOI18N
        add(btnNoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 950, -1, -1));

        btnDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DIA A.png"))); // NOI18N
        btnDia.setActionCommand("Dia");
        btnDia.setBorderPainted(false);
        btnDia.setContentAreaFilled(false);
        btnDia.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DA.png"))); // NOI18N
        btnDia.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DIA A.png"))); // NOI18N
        btnDia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DA.png"))); // NOI18N
        add(btnDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 950, -1, -1));

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ANTERIOR A.png"))); // NOI18N
        btnAnterior.setActionCommand("Anterior");
        btnAnterior.setBorderPainted(false);
        btnAnterior.setContentAreaFilled(false);
        btnAnterior.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ANTERIOR A.png"))); // NOI18N
        btnAnterior.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/AA.png"))); // NOI18N
        add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, 90));

        btnComida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/COMIDA A.png"))); // NOI18N
        btnComida.setActionCommand("Comida");
        btnComida.setBorderPainted(false);
        btnComida.setContentAreaFilled(false);
        btnComida.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CAS.png"))); // NOI18N
        btnComida.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/COMIDA A.png"))); // NOI18N
        btnComida.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CAS.png"))); // NOI18N
        add(btnComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 950, -1, -1));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LIMPIAR A.png"))); // NOI18N
        btnLimpiar.setActionCommand("Limpiar");
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LAS.png"))); // NOI18N
        btnLimpiar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LIMPIAR A.png"))); // NOI18N
        btnLimpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LAS.png"))); // NOI18N
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 950, -1, -1));

        amarilloSucio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Amarillo normal mancha 4.png"))); // NOI18N
        add(amarilloSucio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, -1, -1));

        amarilloSucio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Amarillo normal mancha 3.png"))); // NOI18N
        add(amarilloSucio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, -1, -1));

        amarilloSucio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Amarillo normal mancha 2.png"))); // NOI18N
        add(amarilloSucio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, -1, -1));

        amarilloSucio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Amarillo normal mancha 1.png"))); // NOI18N
        add(amarilloSucio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, -1, -1));

        amarillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Amarillo normal.png"))); // NOI18N
        add(amarillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, -1, -1));

        amarilloOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Amarillo off sleep.png"))); // NOI18N
        add(amarilloOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, -1, -1));

        poppyNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Poppy normal.png"))); // NOI18N
        poppyNormal.setBorderPainted(false);
        poppyNormal.setContentAreaFilled(false);
        add(poppyNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 730, 160, 240));

        pop9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pop.png"))); // NOI18N
        add(pop9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 910, -1, -1));

        pop8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pop.png"))); // NOI18N
        add(pop8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 880, -1, -1));

        pop7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pop.png"))); // NOI18N
        add(pop7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 970, -1, -1));

        pop6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pop.png"))); // NOI18N
        add(pop6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 800, 40, -1));

        pop5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pop.png"))); // NOI18N
        add(pop5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 810, -1, -1));

        pop4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pop.png"))); // NOI18N
        add(pop4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 860, -1, -1));

        pop3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pop.png"))); // NOI18N
        add(pop3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 910, -1, 50));

        pop2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pop.png"))); // NOI18N
        add(pop2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 660, -1, -1));

        pop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pop.png"))); // NOI18N
        add(pop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 680, -1, -1));

        pop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pop.png"))); // NOI18N
        add(pop, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 660, -1, -1));

        fondoDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/A2 dia.png"))); // NOI18N
        add(fondoDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        fondoNocheOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/A2 on.png"))); // NOI18N
        add(fondoNocheOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        fondoNocheOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/A2 off.png"))); // NOI18N
        add(fondoNocheOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agua;
    private javax.swing.JLabel amarillo;
    private javax.swing.JLabel amarilloOff;
    private javax.swing.JLabel amarilloSucio1;
    private javax.swing.JLabel amarilloSucio2;
    private javax.swing.JLabel amarilloSucio3;
    private javax.swing.JLabel amarilloSucio4;
    private javax.swing.JButton btnAgua;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCarne;
    private javax.swing.JButton btnCerdo;
    private javax.swing.JButton btnComida;
    private javax.swing.JButton btnDespertar;
    private javax.swing.JButton btnDia;
    private javax.swing.JButton btnDurmiendo;
    private javax.swing.JButton btnJabon;
    private javax.swing.JButton btnLeche;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNivel;
    private javax.swing.JButton btnNoche;
    private javax.swing.JButton btnPescado;
    private javax.swing.JButton btnPollo;
    private javax.swing.JLabel carne;
    private javax.swing.JLabel cerdo;
    private javax.swing.JLabel comida;
    private javax.swing.JLabel dormir;
    private javax.swing.JLabel fondoDia;
    private javax.swing.JLabel fondoNocheOff;
    private javax.swing.JLabel fondoNocheOn;
    private javax.swing.JLabel jabon;
    private javax.swing.JLabel leche;
    private javax.swing.JLabel limpieza;
    private javax.swing.JLabel nivel;
    private javax.swing.JLabel pescado;
    private javax.swing.JLabel pollo;
    private javax.swing.JLabel pop;
    private javax.swing.JLabel pop1;
    private javax.swing.JLabel pop2;
    private javax.swing.JLabel pop3;
    private javax.swing.JLabel pop4;
    private javax.swing.JLabel pop5;
    private javax.swing.JLabel pop6;
    private javax.swing.JLabel pop7;
    private javax.swing.JLabel pop8;
    private javax.swing.JLabel pop9;
    private javax.swing.JButton poppyNormal;
    // End of variables declaration//GEN-END:variables
}
