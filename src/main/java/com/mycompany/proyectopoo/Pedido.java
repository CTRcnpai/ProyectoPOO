package com.mycompany.proyectopoo;

/**
 *
 */
import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Pedido {

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int aCantidad) {
        cantidad = aCantidad;
    }

    // === Vars ===
    private String numero;
    private Negocio negocioAsociado; //(referencia)
    private LocalDate fecha;
    private EstadoPedido setEstadoPedido;
    private DetallePedido detalle;

    // --- var extra ---
    private double total = 0.0;

    // --- Constante que cuenta la cantidad de pedidos ---
    private static int cantidad = 0;

    // === arreglo ===
    private DetallePedido[] detalles = new DetallePedido[50];

    // === Constructor ===
    public Pedido(String numero, LocalDate fecha, EstadoPedido setEstadoPedido, Negocio negocioAsociado, DetallePedido detalle) {
        this.numero = numero;
        this.fecha = fecha;
        this.setEstadoPedido = setEstadoPedido;
        this.negocioAsociado = negocioAsociado;
        this.detalle = detalle;
    }

    // === Metodos ===
    // --- Agregar pedido ---
    public void agregarPedido() {
        numero = JOptionPane.showInputDialog("Ingrese el codigo del pedido \nformato: P001");
        fecha = LocalDate.now();

        String opcion = JOptionPane.showInputDialog(
                "Seleccione el estado del pedido:\n1-Borrador\n 2- Confirmado\n3- Entregado");

        switch (opcion) {
            case "1":
                setEstadoPedido = EstadoPedido.Borrador;
                break;
            case "2":
                setEstadoPedido = EstadoPedido.Confirmado;
                break;
            case "3":
                setEstadoPedido = EstadoPedido.Entregado;
                break;
            default:
                setEstadoPedido = EstadoPedido.Borrador;
                break;
        }

//        negocio = new Negocio();
        negocioAsociado.setNombreNegocio(JOptionPane.showInputDialog("Ingrese el nombre del negocio asociado:"));

        detalle = new DetallePedido();
        detalle.agregarDetalle();
    }

    // --- Método para mostrar todos los negocios ---
    public void MostrarRepuestos() {

        System.out.println(formatoColumna(numero) + "|"
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
            numero = "P00" + cantidad;
        } else if (cantidad < 100) {
            numero = "P0" + cantidad;
        } else {
            numero = "P" + cantidad;
        }
        return numero;
    }

    // === Getters and setters ===

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
    
    
}
