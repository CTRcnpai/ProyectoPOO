package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 * 
 */
public class Menu {

    public static void main(String[] args) {

        // === Creación de objetos (sub-menús) ===
        SubMenuDistribuidora subMenuDistribuidora = new SubMenuDistribuidora();

        // === Menú principal ===
        boolean loopMenuPrincipal = true;
        while (loopMenuPrincipal) {
            String optMenuPrincipal = JOptionPane.showInputDialog("""
                                    ¡Bienvenid@ al sistema de gestión!
                                    ¿En qué le podemos ayudar?
                                    
                                    1. Distribuidora
                                    2. Negocios
                                    3. Salir
                                    
                                    """);

            switch (optMenuPrincipal) {

                // Opción de Distribuidora
                case "1":
                    subMenuDistribuidora.SubMenuDistribuidora();
                    break;

                // Opción de Negocios
                case "2":
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    break;

                // Opción de Salir
                case "3":
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    loopMenuPrincipal = false;
                    break;

                // Opción invalida
                default:
                    JOptionPane.showMessageDialog(null, "Opción invalida, intente de nuevo");
                    break;
            }
        }
    }
}
