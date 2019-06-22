/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Control.Controlador;
import Negocio.CdeBaloncesto;
import Negocio.CdeFutbol;
import Negocio.CdeFutbolSala;
import Negocio.CdeTenis;
import Negocio.CdeVolleybol;
import Presentacion.GUIPrincipal;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author faber
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controlador.CrearEstudiante(1, "Estudiante 1", "Apell Estudiante 1", "Est1@correo.com", "Sistemas", "Fiet");
        Controlador.CrearEstudiante(2, "Estudiante 2", "Apell Estudiante 2", "Est2@correo.com", "Sistemas", "Fiet");
        Controlador.CrearEstudiante(3, "Estudiante 3", "Apell Estudiante 3", "Est3@correo.com", "Sistemas", "Fiet");
        Controlador.CrearEstudiante(4, "Estudiante 4", "Apell Estudiante 4", "Est4@correo.com", "Sistemas", "Fiet");
        Controlador.CrearProfesor(5, "Profesor 1", "Apell Profesor 1", "Prof1@correo.com");
        Controlador.CrearProfesor(5, "Profesor 2", "Apell Profesor 2", "Prof1@correo.com");
        Controlador.CrearProfesor(5, "Profesor 3", "Apell Profesor 3", "Prof1@correo.com");
        Controlador.CrearProfesor(5, "Profesor 4", "Apell Profesor 4", "Prof1@correo.com");
        Controlador.CrearCancha(1, "Futbol", true, new CdeFutbol());
        Controlador.CrearCancha(2, "FutbolSala1", true, new CdeFutbolSala());
        Controlador.CrearCancha(3, "FutbolSala2", true, new CdeFutbolSala());
        Controlador.CrearCancha(4, "FutbolSala3", true, new CdeFutbolSala());
        Controlador.CrearCancha(5, "Baloncesto1", true, new CdeBaloncesto());
        Controlador.CrearCancha(6, "Baloncesto2", true, new CdeBaloncesto());
        Controlador.CrearCancha(7, "Baloncesto3", true, new CdeBaloncesto());
        Controlador.CrearCancha(8, "Tenis1", true, new CdeTenis());
        Controlador.CrearCancha(9, "Volleybol1", true, new CdeVolleybol());
        Controlador.CrearCancha(10, "Volleybol2", true,new CdeVolleybol());
        Controlador.CrearCancha(11, "Volleybol3", true,new CdeVolleybol());
        /*
        if(Controlador.registrarReserva(1, new CdeTenis(),"20/06/2019", (short)14)){
            System.out.println("Se registro correctamente la Reserva");
        }else{
            System.err.println("NO se pudo registrar la reserva");
        }
        if(Controlador.registrarReserva(2, new CdeTenis(),"20/06/2019", (short)14)){
            System.out.println("Se registro correctamente la Reserva");
        }else{
            System.err.println("NO se pudo registrar la reserva");
        }
        */
        GUIPrincipal Principa = new GUIPrincipal();
    }
    
}
