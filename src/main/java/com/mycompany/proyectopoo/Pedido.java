
package com.mycompany.proyectopoo;

/**
 *
 */
import javax.swing.JOptionPane;
public class Pedido {
    String idPedido;
    String fechaPedido;
    EstadoPedido estadoPedido;
    Negocio negocio;
    DetallePedido detalle;

    public void agregarPedido() {
        idPedido = JOptionPane.showInputDialog("Ingrese el codigo del pedido \nformato: P001");
        fechaPedido = JOptionPane.showInputDialog("Ingrese la fecha del pedido:");

        String opcion = JOptionPane.showInputDialog(
                "Seleccione el estado del pedido:1-Borrador\n 2- Confirmado\n3- Entregado");

        switch (opcion) {
            case "1":
                estadoPedido = EstadoPedido.Borrador;
                break;
            case "2":
                estadoPedido = EstadoPedido.Confirmado;
                break;
            case "3":
                estadoPedido = EstadoPedido.Entregado;
                break;
            default:
                estadoPedido = EstadoPedido.Borrador;
                break;
        }

        negocio = new Negocio();
        negocio.setNombreNegocio(JOptionPane.showInputDialog("Ingrese el nombre del negocio asociado:"));

        detalle = new DetallePedido();
        detalle.agregarDetalle();
    }

    public void mostrarPedido() {
        System.out.println("Codigo del pedido : " + idPedido);
        System.out.println("Fecha : " + fechaPedido);
        System.out.println("Estado: " + estadoPedido);
        System.out.println("Negocio : " + negocio.getNombreNegocio());
        System.out.println(" Detalle del pedido ");
        detalle.mostrarDetalle();
        
    }
    
}
