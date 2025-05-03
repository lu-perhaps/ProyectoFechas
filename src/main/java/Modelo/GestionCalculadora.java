/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author lucia
 */
public class GestionCalculadora {
    
    /**
     * Calcula cuántos años han pasado desde el matrimonio de una persona hasta hoy.
     *
     * @param  date Fecha desde la cual se quiere contar (por ejemplo, fecha de casamiento).
     * @return Número de años transcurridos, ajustado si aún no ha pasado el aniversario este año.
     */
    public int contarAñosCasados(LocalDate date){
       LocalDate hoy = LocalDate.now();
       int anoHoy = hoy.getYear();
       int anoFecha = date.getYear();
       int anios = anoHoy - anoFecha;
       if (hoy.getMonthValue() < date.getMonthValue() || (hoy.getMonthValue() == date.getMonthValue() && hoy.getDayOfMonth() < date.getDayOfMonth())) {
           anios--;} // si aun no ha pasado el aniversario de este año
       return anios;
    }
    
    /**
     * Calcula la edad actual en años de una persona según su fecha de nacimiento.
     *
     * @param date Fecha de nacimiento.
     * @return Edad actual en años.
     */
    public int calcularEdad(LocalDate date){
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - date.getYear();
            // Ajustar si aún no ha cumplido años este año
        if (hoy.getMonthValue() < date.getMonthValue() ||
            (hoy.getMonthValue() == date.getMonthValue() &&
             hoy.getDayOfMonth() < date.getDayOfMonth())) {
            edad--;
        }
        return edad;
    }
    
    /**
     * Calcula la cantidad de segundos que han pasado desde que una persona ganó la lotería hasta hoy
     * o hasta su fecha de muerte, si esta es conocida.
     *
     * @param loteria Fecha en que se ganó la lotería.
     * @param muerte Fecha de muerte, o null si aún vive.
     * @return Cantidad de segundos transcurridos desde la fecha de la lotería.
     */
    public long SegundosLoteria(LocalDate loteria, LocalDate muerte){
        Date hoy = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaGanancia = Date.from(loteria.atStartOfDay(ZoneId.systemDefault()).toInstant());
        long segundos;
        if (muerte == null){
            long tiempoTranscurrido = hoy.getTime() - fechaGanancia.getTime();
            TimeUnit unidad = TimeUnit.SECONDS;
            segundos = unidad.convert(tiempoTranscurrido, TimeUnit.MILLISECONDS);
        }else{
            Date fechaMuerte = Date.from(muerte.atStartOfDay(ZoneId.systemDefault()).toInstant());
            long tiempoTranscurrido = fechaMuerte.getTime() - fechaGanancia.getTime();
            TimeUnit unidad = TimeUnit.SECONDS;
            segundos = unidad.convert(tiempoTranscurrido, TimeUnit.MILLISECONDS);
        }
        return segundos;
        
    }

    /**
     * Calcula la cantidad de días entre la graduación y el matrimonio de una persona.
     *
     * @param graduacion Fecha de graduación.
     * @param casamiento Fecha de casamiento.
     * @return Cantidad de días entre la graduación y el matrimonio.
     */
    
    public long DesdeGraduacionHastaCasamiento(LocalDate graduacion, LocalDate casamiento){
        // convertimos los objetos de tipo localDate a Date, para utilizar los milisegundos y poder calcular los dias que han pasado
        Date fechaGraduacion = Date.from(graduacion.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaCasamiento = Date.from(casamiento.atStartOfDay(ZoneId.systemDefault()).toInstant());
        long tiempoTranscurrido = fechaCasamiento.getTime() - fechaGraduacion.getTime();
        TimeUnit unidad = TimeUnit.DAYS;
        // convertimos los milisegundos asociados al tiempo transcurrido entre las dos fechas y lo pasamos a dias con TimeUnit
        long dias = unidad.convert(tiempoTranscurrido, TimeUnit.MILLISECONDS);
        return dias;
    }
      
    /**
     * Devuelve una lista de personas nacidas entre el 10 y el 20 de agosto de los años bisiestos entre 1970 y 1985.
     *
     * @param personas Lista de personas a verificar.
     * @return Nombres de las personas que cumplen la condición o un mensaje si no hay ninguna.
     */
    public String NacieronEnBisiestos(ArrayList<Persona> personas){
        String personasNacidas = "";
        for (Persona p: personas){
            int año = p.getFechaNacimiento().getYear();
            int mes = p.getFechaNacimiento().getMonthValue();
            int dia = p.getFechaNacimiento().getDayOfMonth();
            if (añosBisiestos(año)&& año >= 1970 && año <= 1985){
                if (mes == 8 && dia >= 10 && dia <= 20){
                    personasNacidas += p.getNombre() + " en el año: "+ p.getFechaNacimiento().getYear()+"\n";
                }
            }
        }
        if (!personasNacidas.equals("")){
            return personasNacidas;
        }
        else{
            return "Nadie nació entre el 10 de agosto y el 20 de agosto de los años bisiestos entre 1970 y 1985";
        }
    }

    
    /**
     * Verifica si un año dado es bisiesto.
     *
     * @param año Año a evaluar.
     * @return true si el año es bisiesto, false en caso contrario.
     */ 
    public boolean añosBisiestos(int año){
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }
}



    