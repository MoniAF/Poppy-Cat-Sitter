/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.modelo;

/**
 *
 * @author Mónica Artavia
 */
public class Partida {
    private int nivel;
    private int experiencia;
    private int dinero;
    private int cantCarne;
    private int cantLeche;
    private int cantAgua;
    private int cantCerdo;
    private int cantPescado;
    private int cantPollo;
    private int cantMedicina;
    private int cantPastilla;
    private int cantJabon;
    private int hambre;
    private int dormir;
    private int salud;
    private int limpieza;
    
    public static final String[] ETIQUETAS_PARTIDA = {"Nivel","Salud"};

    public Partida(int nivel, int experiencia, int dinero, int cantCarne, int cantLeche, int cantAgua, int cantCerdo, int cantPescado, int cantPollo, int cantMedicina, int cantPastilla, int cantJabon, int hambre, int dormir, int salud, int limpieza) {
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.dinero = dinero;
        this.cantCarne = cantCarne;
        this.cantLeche = cantLeche;
        this.cantAgua = cantAgua;
        this.cantCerdo = cantCerdo;
        this.cantPescado = cantPescado;
        this.cantPollo = cantPollo;
        this.cantMedicina = cantMedicina;
        this.cantPastilla = cantPastilla;
        this.cantJabon = cantJabon;
        this.hambre = hambre;
        this.dormir = dormir;
        this.salud = salud;
        this.limpieza = limpieza;
    }

    public Partida() {
    }

    public String getDatos(int indice){
        switch(indice){
            case 0:
                return nivel + "";
            case 1:
                return salud + " %";
        }
        return null;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getCantCarne() {
        return cantCarne;
    }

    public void setCantCarne(int cantCarne) {
        this.cantCarne = cantCarne;
    }

    public int getCantLeche() {
        return cantLeche;
    }

    public void setCantLeche(int cantLeche) {
        this.cantLeche = cantLeche;
    }

    public int getCantAgua() {
        return cantAgua;
    }

    public void setCantAgua(int cantAgua) {
        this.cantAgua = cantAgua;
    }

    public int getCantCerdo() {
        return cantCerdo;
    }

    public void setCantCerdo(int cantCerdo) {
        this.cantCerdo = cantCerdo;
    }

    public int getCantPescado() {
        return cantPescado;
    }

    public void setCantPescado(int cantPescado) {
        this.cantPescado = cantPescado;
    }

    public int getCantPollo() {
        return cantPollo;
    }

    public void setCantPollo(int cantPollo) {
        this.cantPollo = cantPollo;
    }

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public int getDormir() {
        return dormir;
    }

    public void setDormir(int dormir) {
        this.dormir = dormir;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getLimpieza() {
        return limpieza;
    }

    public void setLimpieza(int limpieza) {
        this.limpieza = limpieza;
    }

    public int getCantMedicina() {
        return cantMedicina;
    }

    public void setCantMedicina(int cantMedicina) {
        this.cantMedicina = cantMedicina;
    }

    public int getCantPastilla() {
        return cantPastilla;
    }

    public void setCantPastilla(int cantPastilla) {
        this.cantPastilla = cantPastilla;
    }

    public int getCantJabon() {
        return cantJabon;
    }

    public void setCantJabon(int cantJabon) {
        this.cantJabon = cantJabon;
    }

    @Override
    public String toString() {
        return "Partida{" + "nivel=" + nivel + ", experiencia=" + experiencia + ", dinero=" + dinero + ", cantCarne=" + cantCarne + ", cantLeche=" + cantLeche + ", cantAgua=" + cantAgua + ", cantCerdo=" + cantCerdo + ", cantPescado=" + cantPescado + ", cantPollo=" + cantPollo + ", cantMedicina=" + cantMedicina + ", cantPastilla=" + cantPastilla + ", cantJabon=" + cantJabon + ", hambre=" + hambre + ", dormir=" + dormir + ", salud=" + salud + ", limpieza=" + limpieza + '}';
    }
}