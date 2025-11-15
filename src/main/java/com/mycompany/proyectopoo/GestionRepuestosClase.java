/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 * 
 */
public class GestionRepuestosClase {
    // Llamada a objetos. Por el momento, al no poder usar listas 

    Repuesto repuesto1 = new Repuesto();
    Repuesto repuesto2 = new Repuesto();

    // Submenú de Gestión de Repuestos y bucle del menu
    
    // POR EL MOMENTO SOLAMENTE MOSTRAR Y AGREGAR FUNCIONARÁN
    public void menuGestionRepuesto() {
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
                    if (repuesto1.getCodigo() == null && repuesto2.getCodigo() == null) {
                        System.out.println("No hay repuestos disponibles");
                    }
                    if (repuesto1.getCodigo() != null) {
                        repuesto1.MostrarRepuestos();
                    }
                    if (repuesto2.getCodigo() != null) {
                        repuesto2.MostrarRepuestos();
                    }

                    break;
                // 2. Agregar repuesto
                case 2:
                    if (repuesto1.getNombreRepuesto() == null) {
                        repuesto1.setCodigo("R001");
                        repuesto1.AgregarRepuesto();
                    } else if (repuesto2.getNombreRepuesto() == null) {
                        repuesto2.setCodigo("R002");
                        repuesto2.AgregarRepuesto();
                    } else {
                        System.out.println("No hay espacio para repuestos");
                    }
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
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    menuLoop = false;
                    break;
                // OptGestion invalida
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
            }
        }
    }
}
