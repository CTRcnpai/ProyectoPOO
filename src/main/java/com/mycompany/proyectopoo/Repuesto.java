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
    String compatibilidadRepuesto_Modelo; // Formato: modelo/año/motor
    String compatibilidadRepuesto_anho;
    String compatibilidadRepuesto_motor;
    Categoria categoria;
    double precioVentaRepuesto; // var > 0
    int stockRepuesto;
    int stockMinimoRepuesto;

    // Definición de Métodos
    public void MostrarRepuestos() {
        // Método para mostrar todos los repuestos

        if (codigo != "null") {
            System.out.println(nombreRepuesto);
        } else {
            System.out.println("No hay repuestos disponibles");
        }
    }
    
    public void AgregarRepuesto() {
        // Método para agregar repuestos

        nombreRepuesto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
        marcaRepuesto = JOptionPane.showInputDialog("Ingrese la marca del repuesto");

        // Separe la compatibilidad en 3 secciones para solo unirlar en un string separados por "/"
        compatibilidadRepuesto_Modelo = JOptionPane.showInputDialog("Ingrese el modelo del dispositivo (modelo/año/motor)");
        compatibilidadRepuesto_anho = JOptionPane.showInputDialog("Ingrese el año del repuesto del dispositivo (modelo/año/motor)");

        // Ya que debe seguir un formato, la condicional es para asegurar que sigue el formato modelo/año/motor el siguiente condicional es para asegurar que sea correcto
        if (compatibilidadRepuesto_anho.length() != 3) {
            compatibilidadRepuesto_anho = "error";
        }
        
        compatibilidadRepuesto_motor = JOptionPane.showInputDialog("Ingrese el motor del dispositivo (modelo/año/motor)");
        
        int optcategoria = Integer.parseInt(JOptionPane.showInputDialog("""
                                                        Ingrese una categoria de la lista:
                                                        1. Filtros
                                                        2. Frenos 
                                                        3, Suspensión
                                                        4. Eléctrico
                                                        5. Lubricantes
                                                        """));

        // Ya que categoria es un enum, el sigueinte switch es para asignar la categoria a la opcion correcta del menu
        switch (optcategoria) {

            // 1. FILTROS
            case 1:
                categoria = categoria.Filtros;
                break;
            // 2. FRENOS
            case 2:
                categoria = categoria.Frenos;
                break;
            // 3. SUSPENCIÓN
            case 3:
                categoria = categoria.Suspension;
                break;
            // 4. ELÉCTRICO
            case 4:
                categoria = categoria.Electrico;
                break;
            // 5. LUBRICANTES
            case 5:
                categoria = categoria.Lubricantes;
                break;
            default:
                categoria = categoria.Error;
        }
        
        precioVentaRepuesto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto"));

        // El precio debe ser mayor a 0. El siguiente condicional es para asegurar que se cumpla.
        if (precioVentaRepuesto <= 0) {
            precioVentaRepuesto = 0;
        }
        
        stockRepuesto = Integer.parseInt("Ingrese la cantidad de unidades");
        stockMinimoRepuesto = Integer.parseInt("Ingrese la cantidad mínima de stock de los repuestos (Umbral de alerta)");
    }
}
