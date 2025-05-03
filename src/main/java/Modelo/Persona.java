/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/*
 *
 * @author Emanuel
 */
import java.time.LocalDate;

public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaGraduacion;
    private LocalDate fechaMatrimonio;
    private LocalDate fechaMuerte;
    private LocalDate fechaLoteria;

    public Persona() {
    }

   
    public Persona(String nombre, LocalDate fechaNacimiento, LocalDate fechaGraduacion, 
                   LocalDate fechaMatrimonio, LocalDate fechaMuerte, 
                   LocalDate fechaLoteria) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaGraduacion = fechaGraduacion;
        this.fechaMatrimonio = fechaMatrimonio;
        this.fechaMuerte = fechaMuerte;
        this.fechaLoteria = fechaLoteria;
    }

    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaGraduacion() {
        return fechaGraduacion;
    }

    public LocalDate getFechaMatrimonio() {
        return fechaMatrimonio;
    }

    public LocalDate getFechaMuerte() {
        return fechaMuerte;
    }

    public LocalDate getFechaLoteria() {
        return fechaLoteria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaGraduacion(LocalDate fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public void setFechaMatrimonio(LocalDate fechaMatrimonio) {
        this.fechaMatrimonio = fechaMatrimonio;
    }

    public void setFechaMuerte(LocalDate fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public void setFechaLoteria(LocalDate fechaLoteria) {
        this.fechaLoteria = fechaLoteria;
    }

    // Método para saber si la persona está viva
    public boolean estaViva() {
        return fechaMuerte == null;
    }
    
}

