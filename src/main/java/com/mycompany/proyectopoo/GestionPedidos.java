package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

public class GestionPedidos {

    // Listas de pedidos
    private Pedido pedidos[] = new Pedido[100];

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
                    if (pedido1.getIdPedido() == null) {
                        JOptionPane.showMessageDialog(null, "no hay pedidos registrados.");
                    } else {
                        pedido1.mostrarPedido();
                    }
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "regresndo al menu principal");
                    seguir = false;
                    break;

                case "-1":
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    seguir = false;
                    break;
                case null:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    seguir = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
            }
        }
    }

    // Para poder solicitar informacion de los pedidos
    //
    public boolean revisarPedidosNegocios(String negocioComparar) {

        for (int i = 0; i < Pedido.getCantidad(); i++) {
            String codigoNP = pedidos[i].getNegocioAsociado().getCodigoNegocio();
            if (codigoNP.equals(negocioComparar)){
                return true;
            }
        }
        return false;
    }

}
