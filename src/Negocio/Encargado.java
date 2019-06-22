/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author faber
 */
public class Encargado extends Persona{
    private int horaInicio;
    private int horaFinal;
    
    public Encargado(int codigo, String nombres, String apellidos, String correo, int horaInicio, int horaFinal) {
        super(codigo, nombres, apellidos, correo);
        this.horaFinal =horaFinal;
        this.horaInicio = horaInicio;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }
    
    
}
