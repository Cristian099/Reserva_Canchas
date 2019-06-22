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
public class CdeTenis implements ICancha{
    private int codigo;
    private String nombre;
    private boolean estado;
public CdeTenis(int codigo, String nombre, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public CdeTenis() {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

 
    @Override
    public void CambiarEstado(boolean Estado) {
        this.estado = Estado;
    }

    @Override
    public boolean ConsultarEstado() {
        return this.estado;
    }


   
    
}
