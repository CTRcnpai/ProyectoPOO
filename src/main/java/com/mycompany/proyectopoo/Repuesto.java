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

    // --- Numeros (int / double) ---
    private int compatibilidadRepuesto_anho;
    private double precioVentaRepuesto;
    private int stockRepuesto;
    private int stockMinimoRepuesto;

    // --- Constante que cuenta la cantidad de repuestos ---
    private static int cantidad = 0;

    // === Constructor ===
    public Repuesto(String codigo, String nombreRepuesto, String marcaRepuesto, String compatibilidadRepuesto_modelo,
            String compatibilidadRepuesto_motor,
            Categoria categoria, int compatibilidadRepuesto_anho, double precioVentaRepuesto, int stockRepuesto, int stockMinimoRepuesto) {

        this.codigo = generarCodigo();
        this.nombreRepuesto = nombreRepuesto;
        this.marcaRepuesto = marcaRepuesto;
        this.compatibilidadRepuesto_modelo = compatibilidadRepuesto_modelo;
        this.compatibilidadRepuesto_motor = compatibilidadRepuesto_motor;
        this.categoria = categoria;
        this.compatibilidadRepuesto_anho = compatibilidadRepuesto_anho;
        this.precioVentaRepuesto = precioVentaRepuesto;
        this.stockRepuesto = stockRepuesto;
        this.stockMinimoRepuesto = stockMinimoRepuesto;
    }

    // === Definición de Métodos ===
    public void MostrarRepuestos() {
        // --- Método para mostrar todos los repuestos ---
        System.out.println(formatoColumna(codigo) + "|"
                + formatoColumna(nombreRepuesto + "") + "|"
                + formatoColumna(marcaRepuesto + "") + "|"
                + formatoColumna(compatibilidadRepuesto_modelo + "/" + compatibilidadRepuesto_anho + "/" + compatibilidadRepuesto_motor + "") + "|"
                + formatoColumna(categoria + "") + "|"
                + formatoColumna(precioVentaRepuesto + "") + "|"
                + formatoColumna(stockRepuesto + "") + "|"
                + formatoColumna(stockMinimoRepuesto + ""));

    }
    // --- Método para mostrar todos los repuestos ---

    public String formatoColumna(String dato) {
        int numero = 20 - dato.length();
        String datoFormato = dato;

        for (int i = 0; i < numero; i++) {
            datoFormato += " ";
        }

        return datoFormato;

    }
    
    // --- Método para generar códigos ---

    public String generarCodigo() {
        // === Asignación de código ===
        cantidad++;
        if (cantidad < 10) {
            codigo = "R00" + cantidad;
        } else if (cantidad < 100) {
            codigo = "R0" + cantidad;
        } else {
            codigo = "R" + cantidad;
        }
        return codigo;
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

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        Repuesto.cantidad = cantidad;
    }
}
