package com.mycompany.proyectopoo;

/**
 *
 */
import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Pedido {

    // === Vars ===
    private String codigo;
    private Negocio negocioAsociado; //(referencia)
    private LocalDate fecha;
    private EstadoPedido setEstadoPedido;
    private DetallePedido detalle;

    // --- var extra ---
    private double total = 0.0;

    // --- Constantes  ---
    private static int cantidad = 0;
    private static int nuevPedidos = 0;

    // === arreglo ===
    private DetallePedido[] detalles = new DetallePedido[50];

    // === Constructor ===
    public Pedido(String codigo, LocalDate fecha, EstadoPedido estadoPedido, Negocio negocioAsociado, DetallePedido detalle) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.setEstadoPedido = estadoPedido;
        this.negocioAsociado = negocioAsociado;
        this.detalle = detalle;
    }

    // === Metodos ===
    // --- Método para mostrar todos los negocios ---
    public void MostrarRepuestos() {

        System.out.println(formatoColumna(codigo) + "|"
                + formatoColumna(negocioAsociado + "") + "|"
                + formatoColumna(fecha + "") + "|"
                + formatoColumna(setEstadoPedido + "") + "|"
                + formatoColumna(total + "$") + "");
    }

    // --- Método de formato ---
    public static String formatoColumna(String dato) {
        int numero = 20 - dato.length();
        String datoFormato = dato;

        for (int i = 0; i < numero; i++) {
            datoFormato += " ";
        }

        return datoFormato;

    }

    // --- Método para generar códigos ---
    public String generarCodigo() {
        cantidad++;
        if (cantidad < 10) {
            codigo = "P00" + cantidad;
        } else if (cantidad < 100) {
            codigo = "P0" + cantidad;
        } else {
            codigo = "P" + cantidad;
        }
        return codigo;
    }

    // === Getters and setters ===
    public String getcodigo() {
        return codigo;
    }

    public void setcodigo(String codigo) {
        this.codigo = codigo;
    }

    public Negocio getNegocioAsociado() {
        return negocioAsociado;
    }

    public void setNegocioAsociado(Negocio negocioAsociado) {
        this.negocioAsociado = negocioAsociado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoPedido getSetEstadoPedido() {
        return setEstadoPedido;
    }

    public void setSetEstadoPedido(EstadoPedido setEstadoPedido) {
        this.setEstadoPedido = setEstadoPedido;
    }

    public DetallePedido getDetalle() {
        return detalle;
    }

    public void setDetalle(DetallePedido detalle) {
        this.detalle = detalle;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public DetallePedido[] getDetalles() {
        return detalles;
    }

    public void setDetalles(DetallePedido[] detalles) {
        this.detalles = detalles;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int aCantidad) {
        cantidad = aCantidad;
    }

    public static int getNuevPedidos() {
        return nuevPedidos;
    }

    public static void setNuevPedidos(int aNuevPedidos) {
        nuevPedidos = aNuevPedidos;
    }

}
