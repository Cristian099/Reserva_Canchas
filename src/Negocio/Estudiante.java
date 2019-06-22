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
public class Estudiante extends Persona{
    private String programa;
    private String facultad;
    public Estudiante(int codigo, String nombres, String apellidos, String correo,String programa, String facultad) {
        super(codigo, nombres, apellidos, correo);
        this.facultad = facultad;
        this.programa = programa;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    
}
