package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 *
 */
public class GestionRepuestos {

    // Listas de repuestos
    Repuesto repuestos[] = new Repuesto[999];

    // Submenú de Gestión de Repuestos y bucle del menu
    // POR EL MOMENTO SOLAMENTE MOSTRAR Y AGREGAR FUNCIONARÁN
    public void menuGestionRepuesto() {
        boolean menuLoop = true;

        while (menuLoop) {

            String optGestion = JOptionPane.showInputDialog("""
                                                             1. Mostrar todos los repuestos
                                                             2. Agregar repuesto
                                                             3. Editar repuesto
                                                             4. Buscar repuesto
                                                             5. Reponer stock
                                                             6. Regresar
                                                             """);
            switch (optGestion) {

                // 1. Mostrar todos los repuestos
                case "1":
                    if (Repuesto.getCantidad() == 0) {
                        System.out.println("No hay repuestos disponibles");
                    } else {
                        for (int i = 0; i < Repuesto.getCantidad(); i++) {
                            System.out.println(repuestos[i].formatoColumna("Codigo") + "|"
                                    + repuestos[i].formatoColumna("Nombre") + "|"
                                    + repuestos[i].formatoColumna("Marca") + "|"
                                    + repuestos[i].formatoColumna("Categoria") + "|"
                                    + repuestos[i].formatoColumna("Compatibilidad") + "|"
                                    + repuestos[i].formatoColumna("Precio ($)") + "|"
                                    + repuestos[i].formatoColumna("Stock") + "|"
                                    + repuestos[i].formatoColumna("Strock Min" + "|"));
                            repuestos[i].MostrarRepuestos();
                        }
                    }
                    break;
                // 2. Agregar repuesto
                case "2":
                    agregarRepuesto();
                    break;
                // 3. Editar repuesto
                case "3":
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    break;
                // 4. Buscar repuesto
                case "4":
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    break;
                // 5. Reponer stock
                case "5":
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    break;
                // 6. Regresar
                case "6":
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    menuLoop = false;
                    break;
                // OptGestion invalida
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
            }
        }
    }

    public void agregarRepuesto() {
        // --- Método para agregar repuestos ---

        // === Variables de metodo ===
        String codigo = ""; // Formato: R###
        String nombreRepuesto;
        String marcaRepuesto;
        String compatibilidadRepuesto_modelo;
        String compatibilidadRepuesto_motor;

        // --- Enum ---
        Categoria categoria = null;

        // --- Numeros (int / double) ---
        int compatibilidadRepuesto_anho = 0;
        double precioVentaRepuesto = 0.0;
        int stockRepuesto = 0;
        int stockMinimoRepuesto = 0;

        // === Variables de validación del formato ===
        // --- General ---
        boolean error_compatibilidadRepuesto_anho = false;
        boolean error_categoria = false;
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
        // MODELO: Texto plano, no necesita validación
        compatibilidadRepuesto_modelo = JOptionPane.showInputDialog("Ingrese el modelo del repuesto");

        // AÑO: Verificación de que el año tenga el formato correcto ---
        compatibilidadRepuesto_anhoSTR = JOptionPane.showInputDialog("Ingrese el año del repuesto del repuesto (####)");

        for (int i = 0; i < compatibilidadRepuesto_anhoSTR.length(); i++) {
            if (!(compatibilidadRepuesto_anhoSTR.charAt(i) >= '0' && compatibilidadRepuesto_anhoSTR.charAt(i) <= '9')) {
                error_compatibilidadRepuesto_anho = true;
                break;
            }
        }
        if (compatibilidadRepuesto_anhoSTR.length() != 4) {
            error_compatibilidadRepuesto_anho = true;
        }

        if (error_compatibilidadRepuesto_anho == false) {
            compatibilidadRepuesto_anho = Integer.parseInt(compatibilidadRepuesto_anhoSTR);
        }

        // MOTOR: Texto plano, no necesita validación
        compatibilidadRepuesto_motor = JOptionPane.showInputDialog("Ingrese el motor del repuesto");

        // --- Categoria ---
        String optcategoria = JOptionPane.showInputDialog("""
                                                        Ingrese una categoria de la lista:
                                                        1. Filtros
                                                        2. Frenos 
                                                        3, Suspensión
                                                        4. Eléctrico
                                                        5. Lubricantes
                                                        """);

        // --- CATEGORIA: Enum de categoria y validación de errores ---
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
            // 
            default:
                error_categoria = true;
        }

        // --- PRECIO DE VENTA: Verificación de que se hayan ingresado solo números ---
        precioVentaRepuestoSTR = JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto (Decimales separados por un punto)");
        for (int i = 0; i < precioVentaRepuestoSTR.length(); i++) {
            if (!((precioVentaRepuestoSTR.charAt(i) >= '0' && precioVentaRepuestoSTR.charAt(i) <= '9') || precioVentaRepuestoSTR.charAt(i) == '.')) {
                error_precioVentaRepuestoSTR = true;
                break;
            }
        }

        if (error_precioVentaRepuestoSTR == false) {
            precioVentaRepuesto = Double.parseDouble(precioVentaRepuestoSTR);
        }

        // --- STOCK DEL REPUESTO: Verificación de que se hayan ingresado solo números ---
        stockRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad de unidades");
        for (int i = 0; i < stockRepuestoSTR.length(); i++) {
            if (!(stockRepuestoSTR.charAt(i) >= '0' && stockRepuestoSTR.charAt(i) <= '9')) {
                error_stockRepuestoSTR = true;
                break;
            }
        }
        if (error_stockRepuestoSTR == false) {
            stockRepuesto = Integer.parseInt(stockRepuestoSTR);
        }

        // --- STOCK MÍNIMO: Verificación de que se hayan ingresado solo números ---
        stockMinimoRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad mínima de stock de los repuestos (Umbral de alerta)");
        for (int i = 0; i < stockMinimoRepuestoSTR.length(); i++) {
            if (!(stockMinimoRepuestoSTR.charAt(i) >= '0' && stockMinimoRepuestoSTR.charAt(i) <= '9')) {
                error_stockMinimoSTR = true;
                break;
            }
        }
        if (error_stockMinimoSTR == false) {
            stockMinimoRepuesto = Integer.parseInt(stockMinimoRepuestoSTR);
        }

        // === Aquí se valida si hay algún error, se le indica al usuario el error y se le ofrece ingresar la información otra vez o cancelar la acción ===
        if (error_compatibilidadRepuesto_anho || error_categoria
                || error_precioVentaRepuestoSTR || error_stockRepuestoSTR || error_stockMinimoSTR) {
            int optFormato = 0;

            // --- Bucle while para permitir al usuario elegir si desea hacer correciones o no las veces que sea necesario ---
            while (optFormato != 2) {

                optFormato = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                          El formato de la información no es el correcto.
                                                                          ¿Desea agregar el dato de nuevo?
                                                                          1. Sí
                                                                          2. No
                                                                          """));

                if (optFormato == 1) {
                    // --- USUARIO DESEA SEGUIR EDITANDO ---

                    // AÑO: Verificación de que el año tenga el formato correcto ---
                    if (error_compatibilidadRepuesto_anho) {

                        error_compatibilidadRepuesto_anho = false;

                        compatibilidadRepuesto_anhoSTR = JOptionPane.showInputDialog("Ingrese el año del repuesto del repuesto (####)");

                        for (int i = 0; i < compatibilidadRepuesto_anhoSTR.length(); i++) {
                            if (!(compatibilidadRepuesto_anhoSTR.charAt(i) >= '0' && compatibilidadRepuesto_anhoSTR.charAt(i) <= '9')) {
                                error_compatibilidadRepuesto_anho = true;
                                break;
                            }
                        }
                        if (compatibilidadRepuesto_anhoSTR.length() != 4) {
                            error_compatibilidadRepuesto_anho = true;
                        }

                        if (error_compatibilidadRepuesto_anho == false) {
                            compatibilidadRepuesto_anho = Integer.parseInt(compatibilidadRepuesto_anhoSTR);

                        }
                    }

                    // --- CATEGORIA: Enum de categoria y validación de errores ---
                    if (error_categoria) {

                        error_categoria = false;

                        optcategoria = JOptionPane.showInputDialog("""
                                                        Ingrese una categoria de la lista:
                                                        1. Filtros
                                                        2. Frenos 
                                                        3. Suspensión
                                                        4. Eléctrico
                                                        5. Lubricantes
                                                        """);

                        // Ya que categoria es un enum, el sigueinte switch es para asignar la categoria a la opcion correcta del menu
                        switch (optcategoria) {

                            // 1. FILTROS
                            case "1":
                                categoria = categoria.Filtros;
                                error_categoria = false;
                                break;
                            // 2. FRENOS
                            case "2":
                                categoria = categoria.Frenos;
                                error_categoria = false;
                                break;
                            // 3. SUSPENCIÓN
                            case "3":
                                categoria = categoria.Suspension;
                                error_categoria = false;
                                break;
                            // 4. ELÉCTRICO
                            case "4":
                                categoria = categoria.Electrico;
                                error_categoria = false;
                                break;
                            // 5. LUBRICANTES
                            case "5":
                                categoria = categoria.Lubricantes;
                                error_categoria = false;
                                break;
                        }
                    }

                    // --- PRECIO DE VENTA: Verificación de que se hayan ingresado solo números ---
                    if (error_precioVentaRepuestoSTR) {

                        error_precioVentaRepuestoSTR = false;

                        precioVentaRepuestoSTR = JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto (Decimales separados por un punto)");
                        for (int i = 0; i < precioVentaRepuestoSTR.length(); i++) {
                            if (!((precioVentaRepuestoSTR.charAt(i) >= '0' && precioVentaRepuestoSTR.charAt(i) <= '9') || precioVentaRepuestoSTR.charAt(i) == '.')) {
                                error_precioVentaRepuestoSTR = true;
                                break;
                            }
                        }

                        if (error_precioVentaRepuestoSTR == false) {
                            precioVentaRepuesto = Double.parseDouble(precioVentaRepuestoSTR);
                        }
                    }

                    // --- STOCK DEL REPUESTO: Verificación de que se hayan ingresado solo números ---
                    if (error_stockRepuestoSTR) {

                        error_stockRepuestoSTR = false;

                        stockRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad de unidades");
                        for (int i = 0; i < stockRepuestoSTR.length(); i++) {
                            if (!(stockRepuestoSTR.charAt(i) >= '0' && stockRepuestoSTR.charAt(i) <= '9')) {
                                error_stockRepuestoSTR = true;
                                break;
                            }
                        }
                        if (error_stockRepuestoSTR == false) {
                            stockRepuesto = Integer.parseInt(stockRepuestoSTR);
                        }
                    }

                    // --- STOCK MÍNIMO: Verificación de que se hayan ingresado solo números ---
                    if (error_stockMinimoSTR) {

                        error_stockMinimoSTR = false;

                        stockMinimoRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad mínima de stock de los repuestos (Umbral de alerta)");
                        for (int i = 0; i < stockMinimoRepuestoSTR.length(); i++) {
                            if (!(stockMinimoRepuestoSTR.charAt(i) >= '0' && stockMinimoRepuestoSTR.charAt(i) <= '9')) {
                                error_stockMinimoSTR = true;
                                break;
                            }
                        }
                        if (error_stockMinimoSTR == false) {
                            stockMinimoRepuesto = Integer.parseInt(stockMinimoRepuestoSTR);
                        }
                    }

                    if (!error_compatibilidadRepuesto_anho
                            && !error_precioVentaRepuestoSTR
                            && !error_stockRepuestoSTR
                            && !error_stockMinimoSTR
                            && !error_categoria) {
                        optFormato = 2;
                    }
                } else if (optFormato == 2) {
                    JOptionPane.showMessageDialog(null, "No se agregó el repuesto " + nombreRepuesto + "\nVolviendo al menú de gestión de repuestos.");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Opción invalida. \nIntente de nuevo.");
                }
            }
        }

        String opcionesConfirmacion[] = {"Sí", "No"};

        int valorBotonConfirmacion = JOptionPane.showOptionDialog(
                null,
                "¿Desea agregar el repuesto " + nombreRepuesto + "?"
                + "\n Marca: " + marcaRepuesto
                + "\n Compatibilidad: " + compatibilidadRepuesto_modelo + "/" + compatibilidadRepuesto_anho + "/" + compatibilidadRepuesto_motor
                + "\n Precio: " + precioVentaRepuesto
                + "\n Stock: " + stockRepuesto
                + "\n Stock Mínimo: " + stockMinimoRepuesto,
                "CONFIRMACIÓN",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesConfirmacion,
                "No");

        switch (valorBotonConfirmacion) {
            case 0: // Si desea guardar el repuesto
                Repuesto nuevoRepuesto = new Repuesto(codigo, nombreRepuesto, marcaRepuesto, compatibilidadRepuesto_modelo, compatibilidadRepuesto_motor,
                        categoria, compatibilidadRepuesto_anho, precioVentaRepuesto, stockRepuesto, stockMinimoRepuesto);
                repuestos[Repuesto.getCantidad() - 1] = nuevoRepuesto;
                break;
            case 1: // No desea guardar el repuesto
                JOptionPane.showMessageDialog(null, "No se agregó el repuesto " + nombreRepuesto + "\nVolviendo al menú de gestión de repuestos.");
                break;
            default: // Opción de control
                JOptionPane.showMessageDialog(null, "No se agregó el repuesto " + nombreRepuesto + "\nVolviendo al menú de gestión de repuestos.");
                break;
        }
    }
}
