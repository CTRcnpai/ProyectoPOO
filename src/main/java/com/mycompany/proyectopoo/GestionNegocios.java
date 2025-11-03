
package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 */
public class GestionNegocios {
    // Llamada a objetos. Por el momento, al no poder usar listas 

    Negocio negocio1 = new Negocio();
    Negocio negocio2 = new Negocio();

    // Submenú de Gestión de Negocios y bucle del menu
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
                    if (negocio1.getCodigoNegocio() == null && negocio1.getCodigoNegocio() == null) {
                        System.out.println("No hay repuestos disponibles");
                    }

                    if (negocio1.getCodigoNegocio() != null && negocio2.getCodigoNegocio() != null) {
                        System.out.println(negocio1.formatoColumna("Codigo") + "|"
                                + negocio1.formatoColumna("Nombre") + "|"
                                + negocio1.formatoColumna("Marca") + "|"
                                + negocio1.formatoColumna("Categoria") + "|"
                                + negocio1.formatoColumna("Compatibilidad") + "|"
                                + negocio1.formatoColumna("Precio ($)") + "|"
                                + negocio1.formatoColumna("Stock") + "|"
                                + negocio1.formatoColumna("Strock Min" + "|"));
                        negocio1.MostrarNegocios();
                        negocio1.MostrarNegocios();
                        break;
                    } else if (negocio1.getCodigoNegocio() != null) {
                        System.out.println(negocio1.formatoColumna("Codigo") + "|"
                                + negocio1.formatoColumna("Nombre") + "|"
                                + negocio1.formatoColumna("Tipo") + "|"
                                + negocio1.formatoColumna("Contacto") + "|"
                                + negocio1.formatoColumna("Teléfono") + "|"
                                + negocio1.formatoColumna("Correo") + "|"
                                + negocio1.formatoColumna("Dirección" + "|"));
                        negocio1.MostrarNegocios();

                        if (negocio2.getCodigoNegocio() != null) {
                            negocio2.MostrarNegocios();
                        }
                        System.out.println("");
                        break;
                    }

                    break;
                case "2":
                    if (negocio1.getNombreNegocio() == null) {
                        negocio1.setCodigoNegocio("N001");
                        negocio1.AgregarNegocio();
                    } else if (negocio2.getNombreNegocio() == null) {
                        negocio2.setCodigoNegocio("N002");
                        negocio2.AgregarNegocio();
                    } else {
                        System.out.println("No hay espacio para negocios");
                    }
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");

                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    menuLoop = false;
                    break;
                // OptNegocio invalida
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
            }
        }
    }
}
