
package com.mycompany.proyectopoo;

/**
 *
 */
import javax.swing.JOptionPane;
public class DetallePedido {
   int codigoRepuesto;
    int cantidad;
    double precioUnitario;

    public void agregarDetalle() {
        codigoRepuesto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del repuesto:"));
        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));
        precioUnitario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio unitario:"));
    }

    public double calculartotal() {
        double total = cantidad * precioUnitario;
        return total;
    }

    public void mostrarDetalle() {
        System.out.println("Código del repuesto: " + codigoRepuesto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: " + precioUnitario);
        System.out.println("Subtotal: " + calculartotal());
    }
}