package com.mycompany.proyectopoo;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class GestionPedidos {

    // Listas de pedidos
    private Pedido pedidos[] = new Pedido[100];

    public void menuGestionPedidos() {
        boolean seguir = true;

        while (seguir) {
            String opcion = JOptionPane.showInputDialog(
                    """
                    1. Crear nuevo pedido
                    2. Agregar repuesto
                    3. Quitar repuesto
                    4. Ver resumen
                    5. Confirmar pedido
                    6. Regresar
                    """);

            switch (opcion) {
                case "1": // Crear un nuevo pedido
                    crearPedido();
                    break;

                case "2": // Agregar repuesto
                    JOptionPane.showMessageDialog(null, "Opción no disponible");
                    break;

                case "3": // Quitar repuesto
                    JOptionPane.showMessageDialog(null, "Opción no disponible");
                    seguir = false;
                    break;

                case "4": // Ver resumen
                    JOptionPane.showMessageDialog(null, "Opción no disponible");
                    seguir = false;
                    break;

                case "5": // Confirmar pedido
                    JOptionPane.showMessageDialog(null, "Opción no disponible");
                    seguir = false;
                    break;

                case "6": // Regresar
                    JOptionPane.showMessageDialog(null, "Regresando al menú Gestión de pedidos");
                    return;

                case "-1":
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    seguir = false;
                    return;
                case null:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    seguir = false;
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
            }
        }
    }

    // Para poder solicitar informacion de los pedidos
    //
    public Negocio revisarPedidosNegocios(String negocioComparar) {

        for (int i = 0; i < Pedido.getCantidad(); i++) {
            String codigoNP = pedidos[i].getNegocioAsociado().getCodigoNegocio();
            if (codigoNP.equals(negocioComparar)) {
                return pedidos[i].getNegocioAsociado();
            }
        }
        return null;
    }

    // --- Agregar pedido ---
    public void crearPedido() {

        if (Pedido.getNuevPedidos() == 1) {
            JOptionPane.showMessageDialog(null, "Ya hay un pedido en espera");
            return;
        }

        String negocioComparar = JOptionPane.showInputDialog("Ingrese el codigo del negocio");

        Negocio negocioVinculado = revisarPedidosNegocios(negocioComparar);

        String codigo = null;
        LocalDate fecha = LocalDate.now();
        EstadoPedido estPedido = EstadoPedido.Borrador;

        DetallePedido detalle = null;

        Pedido nuevoPedido = new Pedido(codigo, fecha, estPedido, negocioVinculado, detalle);
        nuevoPedido.setcodigo(nuevoPedido.generarCodigo());
        pedidos[Pedido.getCantidad() - 1] = nuevoPedido;

        JOptionPane.showMessageDialog(null, "No se encontró un negocio con ese código");
        return;

    }

}
