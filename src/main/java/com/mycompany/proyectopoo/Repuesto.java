package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 *
 */
public class Repuesto {

    // === Definición de Atributos ===
    // --- Texto ---
    private String codigo; // Formato: R###
    private String nombreRepuesto;
    private String marcaRepuesto;
    private String compatibilidadRepuesto_modelo;
    private String compatibilidadRepuesto_motor;

    // --- Enum ---
    private Categoria categoria;

    // --- Numeros (int / double)
    private int compatibilidadRepuesto_anho;
    private double precioVentaRepuesto;
    private int stockRepuesto;
    private int stockMinimoRepuesto;

    // === Definición de Métodos ===
    public void MostrarRepuestos() {
        // --- Método para mostrar todos los repuestos ---
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
        // --- Método para agregar repuestos ---

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

                        compatibilidadRepuesto_motor = JOptionPane.showInputDialog("Ingrese el motor del repuesto");

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
                    // --- USUARIO DESEA CANCELAR ---

                    // === Reseteo de Atributos ===
                    // --- Texto ---
                    codigo = null; // Formato: R###
                    nombreRepuesto = null;
                    marcaRepuesto = null;
                    compatibilidadRepuesto_modelo = null;
                    compatibilidadRepuesto_motor = null;
                    // --- Enum ---
                    categoria = null;
                    // --- Numeros (int / double)
                    compatibilidadRepuesto_anho = 0;
                    precioVentaRepuesto = 0;
                    stockRepuesto = 0;
                    stockMinimoRepuesto = 0;
                    optFormato = 2;
                } else {
                    JOptionPane.showMessageDialog(null, "Opción invalida. \nIntente de nuevo.");
                }
            }
        }
    }

    // === Getters & Setters ===
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getMarcaRepuesto() {
        return marcaRepuesto;
    }

    public void setMarcaRepuesto(String marcaRepuesto) {
        this.marcaRepuesto = marcaRepuesto;
    }

    public String getCompatibilidadRepuesto_modelo() {
        return compatibilidadRepuesto_modelo;
    }

    public void setCompatibilidadRepuesto_modelo(String compatibilidadRepuesto_modelo) {
        this.compatibilidadRepuesto_modelo = compatibilidadRepuesto_modelo;
    }

    public String getCompatibilidadRepuesto_motor() {
        return compatibilidadRepuesto_motor;
    }

    public void setCompatibilidadRepuesto_motor(String compatibilidadRepuesto_motor) {
        this.compatibilidadRepuesto_motor = compatibilidadRepuesto_motor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCompatibilidadRepuesto_anho() {
        return compatibilidadRepuesto_anho;
    }

    public void setCompatibilidadRepuesto_anho(int compatibilidadRepuesto_anho) {
        this.compatibilidadRepuesto_anho = compatibilidadRepuesto_anho;
    }

    public double getPrecioVentaRepuesto() {
        return precioVentaRepuesto;
    }

    public void setPrecioVentaRepuesto(double precioVentaRepuesto) {
        this.precioVentaRepuesto = precioVentaRepuesto;
    }

    public int getStockRepuesto() {
        return stockRepuesto;
    }

    public void setStockRepuesto(int stockRepuesto) {
        this.stockRepuesto = stockRepuesto;
    }

    public int getStockMinimoRepuesto() {
        return stockMinimoRepuesto;
    }

    public void setStockMinimoRepuesto(int stockMinimoRepuesto) {
        this.stockMinimoRepuesto = stockMinimoRepuesto;
    }
}
