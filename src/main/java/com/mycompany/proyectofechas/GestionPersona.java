/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofechas;

import java.util.ArrayList;

/**
 *
 * @author lucia
 */
public class GestionPersona {
    
    /**
     * Busca una persona en una lista por su nombre.
     *
     * @param personas Lista de personas a buscar.
     * @param nombre Nombre de la persona que se desea encontrar.
     * @return La persona con el nombre especificado, o null si no se encuentra.
     */
    
    public Persona buscarPersona(ArrayList<Persona> personas, String nombre){
        for(Persona p: personas){
            if (p.getNombre().equals(nombre)){
                return p;
            }
        }
        return null;
    }
}
