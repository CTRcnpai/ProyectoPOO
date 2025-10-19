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
        Repuesto repuesto2 = new Repuesto();

        // Submenú de Gestión de Repuestos y bucle del menu
        // POR EL MOMENTO SOLAMENTE MOSTRAR Y AGREGAR FUNCIONARÁN
        
        boolean menuLoop = true;

        while (menuLoop) {

            int optGestion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                         1. Mostrar todos los repuestos
                                                         2. Agregar repuesto
                                                         3. Editar repuesto
                                                         4. Buscar repuesto
                                                         5. Reponer stock
                                                         6. Regresar
                                                         """));
            switch (optGestion) {

                // 1. Mostrar todos los repuestos
                case 1:
                    repuesto1.MostrarRepuestos();
                    break;
                // 2. Agregar repuesto
                case 2:
                    repuesto1.AgregarRepuesto();
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
                // 6. Regresar ESTO HAY QUE CAMBIARLO A QUE REGRESE AL MENU DE DISTRIBUIDORA
                case 6:
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    menuLoop = false;
                    break;
                // OptGestion invalida
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
            }
        }
    }
}
