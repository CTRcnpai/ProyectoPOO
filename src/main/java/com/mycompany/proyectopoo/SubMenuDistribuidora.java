package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 * 
 */
public class SubMenuDistribuidora {

    // === Creación de objetos (sub-menús) ===
    GestionRepuestos gestionRepuestos = new GestionRepuestos();
    GestionNegocios gestionNegocios = new GestionNegocios();

    // === Sub-Menú de la opción de Distribuidora ===
    public void SubMenuDistribuidora() {

        boolean loopMenuDistribuidora = true;

        while (loopMenuDistribuidora) {
            String optMenuPrincipal = JOptionPane.showInputDialog("""
                                                                                
                                                                                Menú de distribuidora
                                                                                
                                                                                1. Gestión de negocios
                                                                                2. Gestión de repuestos
                                                                                3. Gestión de pedidos
                                                                                4. Reportes
                                                                                5. Regresar al menú principal
                                                                                
                                                                                """);

            switch (optMenuPrincipal) {
                // Opción Gestión de negocios
                case "1":
                    gestionNegocios.menuGestionNegocios();
                    break;

                // Opción Gestión de repuestos
                case "2":
                    gestionRepuestos.menuGestionRepuesto();
                    break;
                
                // Opción Gestión de pedidos
                case "3":
                    // INGRESAR CLASE DE GESTION DE PEDIDOS
                    break;

                // Opción Reportes
                case "4":
                    // INGRESAR CLASE DE REPORTES (AVANCE 2)
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    break;
                
                // Opción Regresar al menú principal
                case "5":
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
                    loopMenuDistribuidora = false;
                    break;
                    
                // Opción invalida
                default:
                    JOptionPane.showMessageDialog(null, "Opción invalida, intente de nuevo");
                    break;
            }
        }
    }

    public void GestionNegocios() {

    }

    public void GestionRepuestos() {
        gestionRepuestos.menuGestionRepuesto();
    }

    public void GestionPedidos() {

    }

    public void reportes() {

    }

}
