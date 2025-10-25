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
    String compatibilidadRepuesto_modelo; // Formato: modelo/año/motor
    String compatibilidadRepuesto_anho;
    String compatibilidadRepuesto_motor;
    Categoria categoria;
    double precioVentaRepuesto; // var > 0
    int stockRepuesto;
    int stockMinimoRepuesto;

    // Definición de Métodos
    public void MostrarRepuestos() {
        // Método para mostrar todos los repuestos
            System.out.println("Código: " + codigo);
            System.out.println("Nombre: " + nombreRepuesto);
            System.out.println("Marca: " + marcaRepuesto);
            System.out.println("Compatibilidad: " + compatibilidadRepuesto_modelo + "/" + compatibilidadRepuesto_anho + "/" + compatibilidadRepuesto_motor);
            System.out.println("Categoria: " + categoria);
            System.out.println("Precio ($): " + precioVentaRepuesto);
            System.out.println("Strock: " + stockRepuesto);
            System.out.println("Stock Min: " + stockMinimoRepuesto);
            System.out.println("====================================");

    }

    public void AgregarRepuesto() {
        // Método para agregar repuestos

        nombreRepuesto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
        marcaRepuesto = JOptionPane.showInputDialog("Ingrese la marca del repuesto");

        // Separe la compatibilidad en 3 secciones para solo unirlar en un string separados por "/"
        compatibilidadRepuesto_modelo = JOptionPane.showInputDialog("Ingrese el modelo del repuesto");
        compatibilidadRepuesto_anho = JOptionPane.showInputDialog("Ingrese el año del repuesto del repuesto (####)");

        // Ya que debe seguir un formato, la condicional es para asegurar que sigue el formato modelo/año/motor el siguiente condicional es para asegurar que sea correcto
        if (compatibilidadRepuesto_anho.length() != 4) {
            compatibilidadRepuesto_anho = "error";
        }

        compatibilidadRepuesto_motor = JOptionPane.showInputDialog("Ingrese el motor del repuesto");

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

        precioVentaRepuesto = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto"));

        // El precio debe ser mayor a 0. El siguiente condicional es para asegurar que se cumpla.
        if (precioVentaRepuesto <= 0) {
            precioVentaRepuesto = 0;
        }

        stockRepuesto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades"));
        stockMinimoRepuesto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad mínima de stock de los repuestos (Umbral de alerta)"));
    }
}
