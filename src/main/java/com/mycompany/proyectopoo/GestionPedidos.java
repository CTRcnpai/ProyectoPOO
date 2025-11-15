package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

public class GestionPedidos {

    Pedido pedido1 = new Pedido();

    public void menuGestionPedidos() {
        boolean seguir = true;

        while (seguir) {
            String opcion = JOptionPane.showInputDialog(
                    "1-Agregar pedido\n2- mostrar pedido\n3- Regresar");

            switch (opcion) {
                case "1":
                    pedido1.agregarPedido();
                    JOptionPane.showMessageDialog(null, "Se agrego el pedido.");
                    break;

                case "2":
                    if (pedido1.idPedido == null) {
                        JOptionPane.showMessageDialog(null, "no hay pedidos registrados.");
                    } else {
                        pedido1.mostrarPedido();
                    }
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "regresndo al menu principal");
                    seguir = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "opcion invalida.");
                    break;
            }
        }
    }
}
