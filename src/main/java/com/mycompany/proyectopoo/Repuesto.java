package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 */
public class Repuesto {

    // === Definición de Atributos ===
    // --- Texto ---
    String codigo; // Formato: R###
    String nombreRepuesto;
    String marcaRepuesto;
    String compatibilidadRepuesto_modelo;
    String compatibilidadRepuesto_motor;

    // --- Enum ---
    Categoria categoria;

    // --- Numeros (int / double)
    int compatibilidadRepuesto_anho;
    double precioVentaRepuesto;
    int stockRepuesto;
    int stockMinimoRepuesto;

    // === Definición de Métodos ===
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
        // === Método para agregar repuestos ===

        // === Variables de validación del formato ===
        // --- General ---
        boolean error_compatibilidadRepuesto_anho = false;
        boolean error_compatibilidadRepuesto_motor = false;
        boolean error_precioVentaRepuestoSTR = false;
        boolean error_stockRepuestoSTR = false;
        boolean error_stockMinimoSTR = false;

        // --- Números ---
        String compatibilidadRepuesto_anhoSTR; // STR para validación futura del formato
        String precioVentaRepuestoSTR; // STR para validación futura del formato
        String stockRepuestoSTR; // STR para validación futura del formato
        String stockMinimoRepuestoSTR; // STR para validación futura del formato

        // === Petición de datos ===
        nombreRepuesto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
        marcaRepuesto = JOptionPane.showInputDialog("Ingrese la marca del repuesto");

        // --- Separé la compatibilidad en 3 secciones para solo utilizar en un string separados por "/" al momento de mostrar ---
        compatibilidadRepuesto_modelo = JOptionPane.showInputDialog("Ingrese el modelo del repuesto");

        // --- Verificación de que el año tenga el formato correcto ---
        compatibilidadRepuesto_anhoSTR = JOptionPane.showInputDialog("Ingrese el año del repuesto del repuesto (####)");

        for (int i = 0; i < compatibilidadRepuesto_anhoSTR.length(); i++) {
            if (!(compatibilidadRepuesto_anhoSTR.charAt(i) >= '0' && compatibilidadRepuesto_anhoSTR.charAt(i) <= '9')
                    || (compatibilidadRepuesto_anhoSTR.length() != 4)) {
                error_compatibilidadRepuesto_anho = true;
                break;
            } else {
                compatibilidadRepuesto_anho = Integer.parseInt(compatibilidadRepuesto_anhoSTR);
                break;
            }
        }

        compatibilidadRepuesto_motor = JOptionPane.showInputDialog("Ingrese el motor del repuesto");

        String optcategoria = JOptionPane.showInputDialog("""
                                                        Ingrese una categoria de la lista:
                                                        1. Filtros
                                                        2. Frenos 
                                                        3, Suspensión
                                                        4. Eléctrico
                                                        5. Lubricantes
                                                        """);

        // Ya que categoria es un enum, el sigueinte switch es para asignar la categoria a la opcion correcta del menu
        switch (optcategoria) {

            // 1. FILTROS
            case "1":
                categoria = categoria.Filtros;
                break;
            // 2. FRENOS
            case "2":
                categoria = categoria.Frenos;
                break;
            // 3. SUSPENCIÓN
            case "3":
                categoria = categoria.Suspension;
                break;
            // 4. ELÉCTRICO
            case "4":
                categoria = categoria.Electrico;
                break;
            // 5. LUBRICANTES
            case "5":
                categoria = categoria.Lubricantes;
                break;
            default:
                error_compatibilidadRepuesto_motor = true;
        }

        // --- PRECIO DE VENTA: Verificación de que se hayan ingresado solo números ---
        precioVentaRepuestoSTR = JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto");
        for (int i = 0; i < precioVentaRepuestoSTR.length(); i++) {
            if (!(precioVentaRepuestoSTR.charAt(i) >= '0' && precioVentaRepuestoSTR.charAt(i) <= '9')
                    || precioVentaRepuestoSTR.charAt(i) != ',' || precioVentaRepuestoSTR.charAt(i) != '.') {
                error_precioVentaRepuestoSTR = true;
                break;
            } else {
                precioVentaRepuesto = Double.parseDouble(precioVentaRepuestoSTR);
            }
        }

        // --- STOCK DEL REPUESTO: Verificación de que se hayan ingresado solo números ---
        stockRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad de unidades");
        for (int i = 0; i < stockRepuestoSTR.length(); i++) {
            if (!(stockRepuestoSTR.charAt(i) >= '0' && stockRepuestoSTR.charAt(i) <= '9')) {
                error_stockRepuestoSTR = true;
                break;
            } else {
                stockRepuesto = Integer.parseInt(stockRepuestoSTR);
            }
        }

        // --- STOCK MÍNIMO: Verificación de que se hayan ingresado solo números ---
        stockMinimoRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad mínima de stock de los repuestos (Umbral de alerta)");
        for (int i = 0; i < stockMinimoRepuestoSTR.length(); i++) {
            if (!(stockMinimoRepuestoSTR.charAt(i) >= '0' && stockMinimoRepuestoSTR.charAt(i) <= '9')) {
                error_stockMinimoSTR = true;
                break;
            } else {
                stockMinimoRepuesto = Integer.parseInt(stockMinimoRepuestoSTR);
            }
        }

        // === Aquí se valida si hay algún error, se le indica al usuario el error y se le ofrece ingresar la información otra vez o cancelar la acción ===
        if (error_compatibilidadRepuesto_anho || error_compatibilidadRepuesto_motor
                || error_precioVentaRepuestoSTR || error_stockRepuestoSTR || error_stockMinimoSTR) {
            int optFormato = 0;

            while (optFormato != 2) {
                optFormato = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                          El formato de la información no es el correcto.
                                                                          ¿Desea agregar el dato de nuevo?
                                                                          1. Sí
                                                                          2. No
                                                                          """));
                if (optFormato == 1) {
                    if (error_compatibilidadRepuesto_anho) {
                        compatibilidadRepuesto_anhoSTR = JOptionPane.showInputDialog("Ingrese el año del repuesto del repuesto (####)");

                        for (int i = 0; i < compatibilidadRepuesto_anhoSTR.length(); i++) {
                            if (compatibilidadRepuesto_anhoSTR.charAt(i) >= '0' && compatibilidadRepuesto_anhoSTR.charAt(i) <= '9'
                                    && compatibilidadRepuesto_anhoSTR.length() == 4) {
                                compatibilidadRepuesto_anho = Integer.parseInt(compatibilidadRepuesto_anhoSTR);
                                error_compatibilidadRepuesto_anho = false;
                                optFormato = 2;
                                break;
                            }
                        }
                    }

                
            
        
    

case "error_compatibilidadRepuesto_motor":

                            // ERROR DE FORMATO: CATEGORIA
                            optcategoria = JOptionPane.showInputDialog("""
                                                        Ingrese una categoria de la lista:
                                                        1. Filtros
                                                        2. Frenos 
                                                        3, Suspensión
                                                        4. Eléctrico
                                                        5. Lubricantes
                                                        """);

                            // Ya que categoria es un enum, el sigueinte switch es para asignar la categoria a la opcion correcta del menu
                            switch (optcategoria) {

                                // 1. FILTROS
                                case "1":
                                    categoria = categoria.Filtros;
                                    errorDeFormato = "noHayError";
                                    optFormato = 2;
                                    break;
                                // 2. FRENOS
                                case "2":
                                    categoria = categoria.Frenos;
                                    errorDeFormato = "noHayError";
                                    optFormato = 2;
                                    break;
                                // 3. SUSPENCIÓN
                                case "3":
                                    categoria = categoria.Suspension;
                                    errorDeFormato = "noHayError";
                                    optFormato = 2;
                                    break;
                                // 4. ELÉCTRICO
                                case "4":
                                    categoria = categoria.Electrico;
                                    errorDeFormato = "noHayError";
                                    optFormato = 2;
                                    break;
                                // 5. LUBRICANTES
                                case "5":
                                    categoria = categoria.Lubricantes;
                                    errorDeFormato = "noHayError";
                                    optFormato = 2;
                                    break;
                                default:
                                    errorDeFormato = "error_compatibilidadRepuesto_motor";
                                    break;

                                case "error_precioVentaRepuestoSTR":
                                    precioVentaRepuestoSTR = JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto");
                                    for (int i = 0; i < precioVentaRepuestoSTR.length(); i++) {
                                        if (!(precioVentaRepuestoSTR.charAt(i) >= '0' && precioVentaRepuestoSTR.charAt(i) <= '9')) {
                                            esNumero = false;
                                            errorDeFormato = "error_precioVentaRepuestoSTR";
                                            break;
                                        }
                                    }

                                    if (esNumero == true) {
                                        double precioVentaRepuesto = Double.parseDouble(precioVentaRepuestoSTR);
                                    }
                                    break;
                            }
                            break;

                        case "error_precioVentaRepuestoSTR":

                            // ERROR DE FORMATO: PRECIO DE VENTA
                            precioVentaRepuestoSTR = JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto");
                            for (int i = 0; i < precioVentaRepuestoSTR.length(); i++) {
                                if (precioVentaRepuestoSTR.charAt(i) >= '0' && precioVentaRepuestoSTR.charAt(i) <= '9'
                                        || precioVentaRepuestoSTR.charAt(i) == ',' || precioVentaRepuestoSTR.charAt(i) == '.') {
                                    precioVentaRepuesto = Double.parseDouble(precioVentaRepuestoSTR);
                                    errorDeFormato = "noHayError";
                                    optFormato = 2;
                                    break;
                                }
                            }
                            break;

                        case "error_stockRepuestoSTR":
                            stockRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad de unidades");
                            for (int i = 0; i < stockRepuestoSTR.length(); i++) {
                                if (stockRepuestoSTR.charAt(i) >= '0' && stockRepuestoSTR.charAt(i) <= '9') {
                                    stockRepuesto = Integer.parseInt(stockRepuestoSTR);
                                    errorDeFormato = "noHayError";
                                    optFormato = 2;
                                    break;
                                }
                            }
                    }
                }
            }
        }
    }
