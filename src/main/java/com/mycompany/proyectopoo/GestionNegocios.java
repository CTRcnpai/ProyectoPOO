/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 */
public class GestionNegocios {

    public void menuGestionNegocios() {

        boolean menuLoop = true;

        while (menuLoop) {

            String optNegocio = JOptionPane.showInputDialog("""
                                                             1. Mostrar todos los negocios
                                                             2. Agregar negocio
                                                             3. Editar negocio
                                                             4. Eliminar negocio
                                                             5. Regresar
                                                             """);
            switch (optNegocio) {

                case "1":

                case "2":

                case "3":
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");

                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    break;
                // OptNegocio invalida
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
            }
        }
    }
}
