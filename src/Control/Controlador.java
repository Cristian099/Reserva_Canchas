/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Negocio.CdeBaloncesto;
import Negocio.CdeFutbol;
import Negocio.CdeFutbolSala;
import Negocio.CdeTenis;
import Negocio.CdeVolleybol;
import Negocio.Estudiante;
import Negocio.ICancha;
import Negocio.Persona;
import Negocio.Profesor;
import Negocio.Reserva;
import Negocio.Encargado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Crist
 */
public final class Controlador {

    private static final ArrayList<Reserva> Reservas = new ArrayList<>();
    private static final ArrayList<ICancha> Canchas = new ArrayList<>();
    private static final ArrayList<Estudiante> Estudiantes = new ArrayList<>();
    private static final ArrayList<Profesor> Profesores = new ArrayList<>();
    private static final ArrayList<Encargado> Encargados = new ArrayList<>();
    
    private static ICancha verificarDisponibilidad(Object aClass,String Fecha, short FechaInicio) {
        int cont;
        ArrayList<Reserva> ResDelDia = ReservasDeFecha(Fecha);//Se obtienen las reservas de la fecha pasada como Parametro(Fecha)
        for (ICancha Cancha : Canchas) {//Recorremos cada una de las canchas 
            if (EsInstancia(Cancha,aClass)){// Preguntamos si su instancia es la pasada como parametro
                cont = 0;
                for (Reserva reserva : ResDelDia) { // recorremos las reservas del dia
                    if(reserva.getCancha().equals(Cancha)){ //se pregunta si la cancha que tiene la reserva es igual a la que estamos evaluando
                        if(reserva.getHorainicio() == FechaInicio){// si resulta que el horario esta ya ocupado 
                            cont ++; // se incrementa contador y se sale del bucle
                            break;
                        }
                    }
                }
                if (cont == 0){// en caso de que el horario no este ocupado entonces el horario esta disponible
                    return Cancha;// se retorna el true para decir que si esta disponible el horario y se proceda a hacer la resreva
                }
            }
        }
        return null;// en caso de que el algoritmo termine, quiere decir que el horario no esta disponible para la reserva
    }
    private static ArrayList<Reserva> ReservasDeFecha(String Fecha){
        ArrayList<Reserva> ReservasRes = new ArrayList<>();
        for (Reserva Reserva1 : Reservas) {// se recorre cada una de las reservas
            if (Reserva1.getFecha().equals(Fecha)){// se pregnta si la fecha de la reserva es igual a la pasada
                ReservasRes.add(Reserva1);// si es igual se agrega al arreglo que se va a devolver
            }
        }
        return ReservasRes;// se devuelve el arreglo con las fechas del dia pasado como parametro.
    }
    public static boolean registrarReserva(int Codigo, Object aClass,String Fecha,short FechaInicio){
        Persona Persona = BuscarPersona(Codigo);//se busca la persona 
        boolean respuesta = false;// variable para controlar el registro correcto
        if(Persona != null){//si no existe la persona no deja crear la reserva
            ICancha Cancha = verificarDisponibilidad(aClass, Fecha, FechaInicio);//Se busca la disponibilidad de una cancha pasada como tipo aClass
            boolean HizoReserva = HayReservaEn(Fecha,Persona.getCodigo());
            if(Cancha != null && !HizoReserva){//Si la cancha es null quiere decir que no hay cancha disponible
                Reserva NuevaReserva = new Reserva(Reservas.size()+1, Fecha, FechaInicio, (short) (FechaInicio+1), Persona, Cancha);// crear la reserva
                Reservas.add(NuevaReserva);//Agregar la nueva reserva
                respuesta = true;//cambia el valor a devolver.
            }
        }
        return respuesta;
    }
    private static Persona BuscarPersona(int Codigo) {
        for (Estudiante Est : Estudiantes) {
            if(Est.getCodigo() == Codigo)
                return Est;
        }
        for (Profesor Profesore : Profesores) {
            if(Profesore.getCodigo() == Codigo)
                return Profesore;
        }
        return null;
    }
    public static boolean CrearEstudiante(int codigo, String nombres, String apellidos, String correo,String programa, String facultad){
        Estudiante NuevoEstudiante = new Estudiante(codigo, nombres, apellidos, correo, programa, facultad);
        return Estudiantes.add(NuevoEstudiante);
    }
    public static boolean CrearProfesor(int codigo, String nombres, String apellidos, String correo){
        Profesor NuevoProfesor = new Profesor(codigo, nombres, apellidos, correo);
        return Profesores.add(NuevoProfesor);
    }
    public static boolean CrearEncargado(int codigo, String nombres, String apellidos, String correo, int horaInicio, int horaFinal){
        Encargado NuevoEncargado = new Encargado(codigo, nombres, apellidos, correo, horaInicio, horaFinal);
        return Encargados.add(NuevoEncargado);
    }
    public static boolean EliminarEstudiante(int codigo){
        for (Estudiante Estudiante1 : Estudiantes) {
            if(Estudiante1.getCodigo() == codigo)
                return Estudiantes.remove(Estudiante1);
        }
        return false;
    }
    public static boolean EliminarProfesor(int codigo){
        for (Profesor Profesore : Profesores) {
            if(Profesore.getCodigo() == codigo)
                return Profesores.remove(Profesore);
        }
        return false;
    }
    public static boolean EliminarEncargado(int codigo){
        for (Encargado Encargado1 : Encargados) {
            if(Encargado1.getCodigo() == codigo)
                return Encargados.remove(Encargado1);
        }
        return false;
    }
    public static boolean CrearCancha(int codigo, String nombre, boolean estado,Object aClass){
        ICancha NuevaCancha = null;
        if(aClass instanceof CdeFutbol){
            NuevaCancha = new CdeFutbol(codigo, nombre, estado);
        }
        if(CdeBaloncesto.class.isInstance(aClass)){
            NuevaCancha = new CdeBaloncesto(codigo, nombre, estado);
        }
        if(CdeFutbolSala.class.isInstance(aClass)){
            NuevaCancha = new CdeFutbolSala(codigo, nombre, estado);
        }
        if(CdeTenis.class.isInstance(aClass)){
           NuevaCancha = new CdeTenis(codigo, nombre, estado);
        }
        if(CdeVolleybol.class.isInstance(aClass)){
            NuevaCancha = new CdeVolleybol(codigo, nombre, estado);
        }
        if(NuevaCancha == null){
            return false;
        }
        return Canchas.add(NuevaCancha);
    }
    
    
    
    private static boolean HayReservaEn(String Fecha, int codigo) {
        /*Este metodo pregunta si hay reserva en un dia especifico por una persona
        *retorna true si existe una reserva de la persona para la fecha especificada
        *retorna false si no existe una reserva de la persona para la fecha especificada
        */
        ArrayList<Reserva> ResDelDia = ReservasDeFecha(Fecha);//se obtienen las reservas de la fecha
        for (Reserva reserva : ResDelDia) {
            if(reserva.getReservante().getCodigo() == codigo)
                return true;
        }
        return false;
    }

    private static boolean EsInstancia(ICancha Cancha, Object aClass) {
        return Cancha.getClass().getSimpleName().equals(aClass.getClass().getSimpleName());
    }
}
