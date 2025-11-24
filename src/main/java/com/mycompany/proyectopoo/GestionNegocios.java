package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 */
public class GestionNegocios {

    // Listas de negocios
    private Negocio negocios[] = new Negocio[40];

    // 6 Negociosprecargados
    public void repuestosPrecargados() {
        negocios[0] = new Negocio();
        negocios[1] = new Negocio();
        negocios[2] = new Negocio();
        negocios[3] = new Negocio();
        negocios[4] = new Negocio();
        negocios[5] = new Negocio();

    }

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

                case "1": // Mostrar 
                    if (Negocio.getCantidad() == 0) {
                        System.out.println("No hay repuestos disponibles");
                    } else {
                        System.out.println(Repuesto.formatoColumna("Codigo") + "|"
                                + Negocio.formatoColumna("Nombre") + "|"
                                + Negocio.formatoColumna("Marca") + "|"
                                + Negocio.formatoColumna("Categoria") + "|"
                                + Negocio.formatoColumna("Compatibilidad") + "|"
                                + Negocio.formatoColumna("Precio ($)") + "|"
                                + Negocio.formatoColumna("Stock") + "|"
                                + Negocio.formatoColumna("Stock Min" + "|"));
                        for (int i = 0; i < Negocio.getCantidad(); i++) {
                            negocios[i].MostrarNegocios();
                        }
                    }
                    break;

                case "2": //Agregar
                    agregarNegocio();
                    break;

                case "3": // Editar
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");
                    break;
                case "4": // Eliminar
                    JOptionPane.showMessageDialog(null, "Opción no disponible aún");

                    break;
                case "5": // Regresar
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    menuLoop = false;
                    break;
                // OptGestion invalida
                case "-1":
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    menuLoop = false;
                    break;
                case null:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    menuLoop = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
            }
        }
    }

    public void agregarNegocio() {
        // Variables de metodo

        // --- Texto ---
        String codigoNegocio = "";
        String nombreNegocio = "";
        String correoNegocio = "";
        String contactoNegocio = ""; // Nombre de la persona encargada
        String telefonoNegocio = "";
        String direccionNegocio = "";

        // --- Enum ---
        TipoNegocio tipoNegocio = null;

        // --- Numeros (int / double)
        double limiteCreditoNegocio = 0.0;
        double saldoNegocio = 0.0;

        // === Variables de validación del formato ===
        boolean error_correoNegocio = false;
        boolean error_telefonoNegocio = false;
        boolean error_TipoNegocio = false;

        // === Petición de información ===
        // --- NOMBRE DEL NEGOCIO ---
        nombreNegocio = JOptionPane.showInputDialog("Ingrese el nombre del negocio");

        // --- TIPO DEL NEGOCIO ---
        String optTipoNegocio = JOptionPane.showInputDialog("""
                                                  Eliga el tipo de negocio:
                                                    1. Gasolinera,
                                                    2. Taller,
                                                    3. Venta_Repuestos,
                                                    4. Alquiler_Vehiculos
                                                  """);

        switch (optTipoNegocio) {
            case "1":
                tipoNegocio = TipoNegocio.Gasolinera;
                break;
            case "2":
                tipoNegocio = TipoNegocio.Taller;
                break;
            case "3":
                tipoNegocio = TipoNegocio.Venta_Repuestos;
                break;
            case "4":
                tipoNegocio = TipoNegocio.Alquiler_Vehiculos;
                break;
            default:
                error_TipoNegocio = true;
        }

        // --- CONTACTO DEL NEGOCIO ---
        contactoNegocio = JOptionPane.showInputDialog("Ingrese el nombre del contacto principal");

        // --- TELEFONO: Verificación de formato ---
        telefonoNegocio = JOptionPane.showInputDialog("""
                                                    "Ingrese el número de teléfono del negocio 
                                                    Siga el siguiente formato '####-####'
                                                     """);

        if (telefonoNegocio.length() != 9) {
            error_telefonoNegocio = true;
        } else {

            if (telefonoNegocio.charAt(4) == '-') {

                for (int i = 0; i < telefonoNegocio.length(); i++) {

                    if (i != 4) {
                        if (!(telefonoNegocio.charAt(i) >= '0' && telefonoNegocio.charAt(i) <= '9')) {
                            error_telefonoNegocio = true;
                        }
                    }
                }
            } else {
                error_telefonoNegocio = true;
            }
        }

        // --- CORREO: Verificación de formato ---
        correoNegocio = JOptionPane.showInputDialog("Ingrese el correo del negocio");

        int ubicacionArroba = -1;
        int ubicacionPunto = -1;

        for (int i = 0; i < correoNegocio.length(); i++) {
            if (correoNegocio.charAt(i) == '@') {
                ubicacionArroba = i;

                for (int j = 0; j < correoNegocio.length(); j++) {
                    if (correoNegocio.charAt(j) == '.') {
                        ubicacionPunto = j;
                    }
                }
            }
        }

        if (ubicacionArroba <= 0 || ubicacionPunto < ubicacionArroba
                || ubicacionPunto == correoNegocio.length() - 1
                || ubicacionPunto <= ubicacionArroba + 1) {
            error_correoNegocio = true;
        }

        if (ubicacionArroba == -1 || ubicacionPunto == -1) {
            error_correoNegocio = true;
        }

        // --- DIRECCION DEL NEGOCIO ---
        direccionNegocio = JOptionPane.showInputDialog("Ingrese la dirección del negocio");

        // --- LIMITE DEL CREDITO CON BASE AL TIPO ---
        if (tipoNegocio == TipoNegocio.Gasolinera) {
            limiteCreditoNegocio = 4000; //En dolares
        } else if (tipoNegocio == TipoNegocio.Taller) {
            limiteCreditoNegocio = 3000; //En dolares
        } else if (tipoNegocio == TipoNegocio.Venta_Repuestos) {
            limiteCreditoNegocio = 2000; //En dolares
        } else if (tipoNegocio == TipoNegocio.Alquiler_Vehiculos) {
            limiteCreditoNegocio = 6000; //En dolares
        }

        // === Aquí se valida si hay algún error, se le indica al usuario el error y se le ofrece ingresar la información otra vez o cancelar la acción ===
        if (error_TipoNegocio || error_telefonoNegocio || error_correoNegocio) {
            int optFormato = 0;

            // --- Bucle while para permitir al usuario elegir si desea hacer correciones o no las veces que sea necesario ---
            while (optFormato != 2) {

                optFormato = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                          El formato de la información no es el correcto.
                                                                          ¿Desea agregar el dato de nuevo?
                                                                          1. Sí
                                                                          2. No
                                                                          """));

                if (optFormato == 1) {

                    if (error_TipoNegocio) {
                        error_TipoNegocio = false;
                        optTipoNegocio = JOptionPane.showInputDialog("""
                                                  Eliga el tipo de negocio:
                                                    1. Gasolinera
                                                    2. Taller
                                                    3. Venta_Repuestos
                                                    4. Alquiler_Vehiculos
                                                  """);

                        switch (optTipoNegocio) {
                            case "1":
                                tipoNegocio = TipoNegocio.Gasolinera;
                                break;
                            case "2":
                                tipoNegocio = TipoNegocio.Taller;
                                break;
                            case "3":
                                tipoNegocio = TipoNegocio.Venta_Repuestos;
                                break;
                            case "4":
                                tipoNegocio = TipoNegocio.Alquiler_Vehiculos;
                                break;
                            default:
                                error_TipoNegocio = true;
                        }
                    }

                    if (error_telefonoNegocio) {
                        error_telefonoNegocio = false;
                        telefonoNegocio = JOptionPane.showInputDialog("""
                                                    "Ingrese el número de teléfono del negocio 
                                                    Siga el siguiente formato '####-####'
                                                     """);

                        if (telefonoNegocio.length() != 9) {
                            error_telefonoNegocio = true;
                        } else {

                            if (telefonoNegocio.charAt(4) == '-') {

                                for (int i = 0; i < telefonoNegocio.length(); i++) {

                                    if (i != 4) {
                                        if (!(telefonoNegocio.charAt(i) >= '0' && telefonoNegocio.charAt(i) <= '9')) {
                                            error_telefonoNegocio = true;
                                        }
                                    }
                                }
                            } else {
                                error_telefonoNegocio = true;
                            }
                        }
                    }

                    if (error_correoNegocio) {
                        error_correoNegocio = false;
                        correoNegocio = JOptionPane.showInputDialog("Ingrese el correo del negocio");

                        ubicacionArroba = -1;
                        ubicacionPunto = -1;

                        for (int i = 0; i < correoNegocio.length(); i++) {
                            if (correoNegocio.charAt(i) == '@') {
                                ubicacionArroba = i;

                                for (int j = 0; j < correoNegocio.length(); j++) {
                                    if (correoNegocio.charAt(j) == '.') {
                                        ubicacionPunto = j;
                                    }
                                }
                            }
                        }

                        if (ubicacionArroba <= 0 || ubicacionPunto < ubicacionArroba
                                || ubicacionPunto == correoNegocio.length() - 1
                                || ubicacionPunto <= ubicacionArroba + 1) {
                            error_correoNegocio = true;
                        }

                        if (ubicacionArroba == -1 || ubicacionPunto == -1) {
                            error_correoNegocio = true;
                        }
                    }

                } else if (optFormato == 2) {
                    // --- USUARIO DESEA CANCELAR ---

                    // === Reseteo de Atributos ===
                    // --- Texto ---
                    codigoNegocio = null;
                    nombreNegocio = null;
                    correoNegocio = null;
                    contactoNegocio = null;
                    telefonoNegocio = null;
                    direccionNegocio = null;

                    // --- Enum ---
                    tipoNegocio = null;

                    // --- Numeros (int / double)
                    limiteCreditoNegocio = 0.0;
                    saldoNegocio = 0.0;

                    optFormato = 2;
                } else {
                    JOptionPane.showMessageDialog(null, "Opción invalida. \nIntente de nuevo.");
                }
            }
        }
    }
}
