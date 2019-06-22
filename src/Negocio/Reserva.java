/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Crist
 */
public class Reserva {
    private int NS;
    private String Fecha;
    private short horainicio;
    private short horafin;
    private Persona Reservante;
    private ICancha Cancha;

    public Reserva(int NS,String Fecha, short horainicio, short horafin, Persona Reservante, ICancha Cancha) {
        this.NS = NS;
        this.Fecha = Fecha;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.Reservante = Reservante;
        this.Cancha = Cancha;
    }

    public int getNS() {
        return NS;
    }

    public void setNS(int NS) {
        this.NS = NS;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public short getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(short horainicio) {
        this.horainicio = horainicio;
    }

    public short getHorafin() {
        return horafin;
    }

    public void setHorafin(short horafin) {
        this.horafin = horafin;
    }

    public Persona getReservante() {
        return Reservante;
    }

    public void setReservante(Persona Reservante) {
        this.Reservante = Reservante;
    }

    public ICancha getCancha() {
        return Cancha;
    }

    public void setCancha(ICancha Cancha) {
        this.Cancha = Cancha;
    }
    
}
