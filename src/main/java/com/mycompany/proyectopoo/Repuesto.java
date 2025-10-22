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
    
    public void MostrarRepuestos() {
        if (codigo != "null") {
            System.out.println(nombreRepuesto);
        } else {
            System.out.println("No hay repuestos disponibles");
        }
    }

    public void AgregarRepuesto() {
        
        if (stockRepuesto < 2) {
            for (int i = 1; i < 2; i++) {
                codigo = "R" + i;
                System.out.println(codigo);
            }
        } else {
            System.out.println("No hay más espacio para repuestos");
        }
        
        nombreRepuesto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
        
    }
}
