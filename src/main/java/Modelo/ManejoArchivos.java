/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La clase ManejoArchivos permite la lectura de datos de personas desde un archivo de texto estructurado.
 * Cada persona debe estar definida con varias líneas que representan sus atributos,
 * como nombre, fecha de nacimiento, graduación, matrimonio, muerte y lotería.
 * En caso de no existir los datos se debe llenar el espacio con N/A
 */

public class ManejoArchivos {

    public static void main(String[] args) {
        
    }
    
    /**
     * Lee una lista de personas desde un archivo de texto con formato específico.
     * Se espera que cada persona esté definida en el archivo en el siguiente formato:
     * <pre>
     * Nombre: Juan Perez
     * Nacimiento: 1980-05-10
     * Graduacion: 2000-11-30
     * Matrimonio: N/A
     * Muerte: N/A
     * Loteria: 2010-06-25
     * ----
     * </pre>
     *
     * @param rutaArchivo Ruta del archivo que contiene los datos de las personas.
     * @return Lista de objetos Persona construidos a partir de la información del archivo.
     */
    
    public static ArrayList<Persona> leerPersonasDesdeArchivo(String rutaArchivo) {
        ArrayList<Persona> personas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Nombre:")) {
                    String nombre = linea.substring(7).trim();

                    String nacimientoLine = br.readLine();
                    String graduacionLine = br.readLine();
                    String matrimonioLine = br.readLine();
                    String muerteLine = br.readLine();
                    String loteriaLine = br.readLine();
                    String separador = br.readLine();

                    LocalDate fechaNacimiento = LocalDate.parse(nacimientoLine.substring(11).trim());
                    LocalDate fechaGraduacion = null;
                    if (graduacionLine != null) {
                        String textoGraduacion = graduacionLine.substring(11).trim();
                        if (!textoGraduacion.equals("N/A")) {
                            fechaGraduacion = LocalDate.parse(textoGraduacion);
                        }
                    }

                    // Procesar fecha de matrimonio
                    LocalDate fechaMatrimonio = null;
                    if (matrimonioLine != null) {
                        String textoMatrimonio = matrimonioLine.substring(11).trim();
                        if (!textoMatrimonio.equals("N/A")) {
                            fechaMatrimonio = LocalDate.parse(textoMatrimonio);
                        }
                    }
                    LocalDate fechaMuerte = null;
                    if(muerteLine != null){
                        String textomuerte = muerteLine.substring(7).trim();
                        if (!textomuerte.equals("N/A")){
                          fechaMuerte = LocalDate.parse(textomuerte);
                        }
                    }
                     LocalDate fechaLoteria = null;
                    if (loteriaLine != null) {
                        String textoLoteria = loteriaLine.substring(8).trim();
                        if (!textoLoteria.equals("N/A")) {
                            fechaLoteria = LocalDate.parse(textoLoteria);
                        }
                    }
                    Persona persona = new Persona(nombre, fechaNacimiento, fechaGraduacion, fechaMatrimonio, fechaMuerte, fechaLoteria);
                    personas.add(persona);                 
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error procesando los datos: " + e.getMessage());
        }

        return personas;
    }
}

