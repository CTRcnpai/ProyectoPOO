package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 *
 *
 *
 */
public class GestionRepuestos {

    public static void main(String[] args) {

        // Llamada a objetos. Por el momento, al no poder usar listas 
        Repuesto repuesto1 = new Repuesto();

        repuesto1.stockRepuesto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero de stock"));

        // Submenú de Gestión de Repuestos
        int optGestion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                         1. Mostrar todos los repuestos
                                                         2. Agregar repuesto
                                                         3. Editar repuesto
                                                         4. Buscar repuesto
                                                         5. Reponer stock
                                                         6. Regresar
                                                         """));

        // POR EL MOMENTO SOLAMENTE MOSTRAR Y AGREGAR FUNCIONARÁN
        boolean menuLoop = true;

        while (menuLoop) {
            switch (optGestion) {

                // 1. Mostrar todos los repuestos
                case 1:
                    repuesto1.MostrarRepuestos();
                    menuLoop = false;
                    break;
                // 2. Agregar repuesto
                case 2:
                    menuLoop = false;
                    break;
                // 3. Editar repuesto
                case 3:
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    menuLoop = false;
                    break;
                // 4. Buscar repuesto
                case 4:
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    menuLoop = false;
                    break;
                // 5. Reponer stock
                case 5:
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    menuLoop = false;
                    break;
                // 6. Regresar
                case 6:
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    menuLoop = false;
                    break;
                // OptGestion invalida
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
                    optGestion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                         1. Mostrar todos los repuestos
                                                         2. Agregar repuesto
                                                         3. Editar repuesto
                                                         4. Buscar repuesto
                                                         5. Reponer stock
                                                         6. Regresar
                                                         """));
            }
        }
    }
}
