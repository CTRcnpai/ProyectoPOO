package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 */
public class Repuesto {
    
    // Definición de Atributos
    
    String codigo; // Formato: R###
    String nombreRepuesto;
    String marcaRepuesto;
    String compatibilidadRepuesto; // Formato: modelo/año/motor
    String categoria; // enum con 5 opciones: Filtros, Frenos, Suspensión, Eléctrico, Lubricantes
    double precioVentaRepuesto; // var > 0
    int stockRepuesto;
    int stockMinimoRepuesto;
    
    public void MostrarRepuestos (){
        if (stockRepuesto <= 0) {
            System.out.println("hola mundo");
        }else{
            System.out.println("adios mundo");
        }
    }
    
}