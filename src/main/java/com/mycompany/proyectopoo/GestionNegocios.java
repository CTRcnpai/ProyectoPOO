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
    public void negociosPrecargados() {
        negocios[0] = new Negocio("N001", "Gollo", "gollocontacto@gollo.com", "Oscar Astora", "1111-0000", "Moravia Centro, calle 10", TipoNegocio.Venta_Repuestos, 0, 2000);
        negocios[1] = new Negocio("N002", "Guacamaya", "guacamayarepuestos@gmail.com", "Don Guacamaya", "0000-0001", "Tibas", TipoNegocio.Venta_Repuestos, 0, 2000);
        negocios[2] = new Negocio("N003", "Autoshop", "autoshopinfo@autoshop.com", "Saul Chinchilla", "1010-1010", "Moravia", TipoNegocio.Taller, 0, 3000);
        negocios[3] = new Negocio("N004", "Gaso San Pedro", "GSPcr@outlook.com", "Nestrons Diaz", "0101-0101", "San Pedro", TipoNegocio.Gasolinera, 0, 4000);
        negocios[4] = new Negocio("N005", "Yeryas Arrelga", "yeryilse@gmail.com", "Sebastian Arce", "1420-0110", "La Trinidad de Moravia", TipoNegocio.Taller, 0, 3000);
        negocios[5] = new Negocio("N006", "AlquileresCTR", "alquileresCTR@alquileresCTR.com", "CTR", "0000-0002", "Coronado", TipoNegocio.Alquiler_Vehiculos, 0, 6000);
        //
        //  
    }

    //Submenú de Gestión de Negocios y bucle del menu     
    public void menuGestionNegocios() {
        negociosPrecargados();

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
                                + Negocio.formatoColumna("Tipo") + "|"
                                + Negocio.formatoColumna("Contacto") + "|"
                                + Negocio.formatoColumna("Teléfono") + "|"
                                + Negocio.formatoColumna("Correo") + "|"
                                + Negocio.formatoColumna("Dirección" + "|"));
                        for (int i = 0; i < Negocio.getCantidad(); i++) {
                            negocios[i].MostrarNegocios();
                        }
                    }
                    break;

                case "2": //Agregar
                    agregarNegocio();
                    break;

                case "3": // Editar
                    editarNegocio(negocios);
                    break;
                case "4": // Eliminar
                    GestionPedidos pedido = new GestionPedidos();
                    eliminarNegocio(negocios, pedido);

                    break;
                case "5": // Regresar
                    JOptionPane.showMessageDialog(null, "Volviendo al menú de distribuidora");
                    menuLoop = false;
                    return;
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
        //
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

                String mensajeError = "La información posee un formato incorrecto en: \n";

                if (error_TipoNegocio) {
                    mensajeError += "- El tipo de negocio.\n";
                }
                if (error_telefonoNegocio) {
                    mensajeError += "- El formato del teléfono\n";
                }
                if (error_correoNegocio) {
                    mensajeError += "- El formato del correo\n";
                }

                String opcionesReintento[] = {"Reintentar", "Cancelar"};

                optFormato = JOptionPane.showOptionDialog(
                        null,
                        mensajeError
                        + "\n¿Desea agregar la información de nuevo?",
                        "CONFIRMACIÓN",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesReintento,
                        "No");

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
                    JOptionPane.showMessageDialog(null, "Se canceló el proceso");
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
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Opción invalida. \nIntente de nuevo.");
                }
            }
        }

        String opcionesConfirmacion[] = {"Sí", "No"};

        int valorBotonConfirmacion = JOptionPane.showOptionDialog(
                null,
                "¿Desea agregar el negocio " + nombreNegocio + "?"
                + "\n Tipo: " + tipoNegocio
                + "\n Límite de crédito: " + limiteCreditoNegocio
                + "\n Correo: " + correoNegocio
                + "\n Contacto: " + contactoNegocio
                + "\n Dirección: " + direccionNegocio,
                "CONFIRMACIÓN",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesConfirmacion,
                "No");

        switch (valorBotonConfirmacion) {
            case 0: // Si desea guardar el repuesto
                Negocio nuevoNegocio = new Negocio(codigoNegocio, nombreNegocio, correoNegocio, contactoNegocio,
                        telefonoNegocio, direccionNegocio, tipoNegocio, saldoNegocio, limiteCreditoNegocio);
                nuevoNegocio.setCodigoNegocio(nuevoNegocio.generarCodigo());
                negocios[Negocio.getCantidad() - 1] = nuevoNegocio;
                break;
            case 1: // No desea guardar el repuesto
                JOptionPane.showMessageDialog(null, "No se agregó el repuesto " + nombreNegocio + "\nVolviendo al menú de gestión de repuestos.");
                break;
            case -1:
                JOptionPane.showMessageDialog(null, "No se agregó el repuesto " + nombreNegocio + "\nVolviendo al menú de gestión de repuestos.");
                break;
            default: // Opción de control
                JOptionPane.showMessageDialog(null, "No se agregó el repuesto " + nombreNegocio + "\nVolviendo al menú de gestión de repuestos.");
                break;
        }
    }

    public void editarNegocio(Negocio[] negocios) {

        if (Negocio.getCantidad() == 0) {
            JOptionPane.showMessageDialog(null, """
                                                Por el momento no hay negocios. 
                                                Por favor agregue un negocio para usar esta característica.
                                                Volviendo al menú de Gestión de Negocios.
                                                """);
            return;
        }

        // === Variables de la clase ===
        String nuevoNombre = null;
        TipoNegocio tipoNegocio = null;
        String nuevoContacto = null;
        String telefonoNegocio = null;
        String correoNegocio = null;
        String direccionNegocio = null;
        double limiteCredito = 0.0;

        // === Variables de validación del formato ===
        boolean error_correoNegocio = false;
        boolean error_telefonoNegocio = false;
        boolean error_credito = false;

        String codigoBuscar = JOptionPane.showInputDialog("""
                                                          Ingrese el código del repuesto a editar
                                                          Formato: R###
                                                          """);

        for (int i = 0; i < Negocio.getCantidad(); i++) {

            if (negocios[i].getCodigoNegocio().equalsIgnoreCase(codigoBuscar)) {

                int opt = Integer.parseInt(JOptionPane.showInputDialog(
                        "=== Menu de actualización ==="
                        + "\n1. Nombre (Actual: " + negocios[i].getNombreNegocio() + ")"
                        + "\n2. Tipo de negocio (Actual: " + negocios[i].getTipoNegocio() + ")"
                        + "\n3. Contacto (Actual: " + negocios[i].getContactoNegocio() + ")"
                        + "\n4. Teléfono (Actual: " + negocios[i].getTelefonoNegocio() + ")"
                        + "\n5. Correo (Actual: " + negocios[i].getCorreoNegocio() + ")"
                        + "\n6. Dirección (Actual: " + negocios[i].getDireccionNegocio() + ")"
                        + "\n7. Límite de crédito ($) (Actual: " + negocios[i].getLimiteCreditoNegocio() + ")"
                        + "\n8. Regresar"
                ));

                do {
                    switch (opt) {

                        case 1: // Nuevo nombre
                            nuevoNombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                            negocios[i].setNombreNegocio(nuevoNombre);
                            JOptionPane.showMessageDialog(null, "Nombre actualizado con éxito a " + negocios[i].getNombreNegocio());
                            break;

                        case 2: // Nuevo tipo

                            tipoNegocio = null;
                            String optBotones[] = {"Gasolinera", "Taller", "Venta de repuestos", "Alquiler de vehículos"};
                            int optCatFiltrada = JOptionPane.showOptionDialog(
                                    null,
                                    "Elija el tipo de negocio",
                                    "FILTRO DE NEGOCIO",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    optBotones,
                                    "Gasolinera");

                            switch (optCatFiltrada) {
                                case 0:
                                    tipoNegocio = TipoNegocio.Gasolinera;
                                    break;
                                case 1:
                                    tipoNegocio = TipoNegocio.Taller;
                                    break;
                                case 2:
                                    tipoNegocio = TipoNegocio.Venta_Repuestos;
                                    break;
                                case 3:
                                    tipoNegocio = TipoNegocio.Alquiler_Vehiculos;
                                    break;
                                // OptGestion invalida
                                default:
                                    JOptionPane.showMessageDialog(null, "Opción no valida\nElegido por defecto (Gasolinera)");
                            }

                            negocios[i].setTipoNegocio(tipoNegocio);
                            JOptionPane.showMessageDialog(null, "Tipo de negocio de " + negocios[i].getNombreNegocio() + "actualizado con éxito a " + negocios[i].getTipoNegocio());
                            break;

                        case 3: // Contacto
                            nuevoContacto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                            negocios[i].setContactoNegocio(nuevoContacto);
                            JOptionPane.showMessageDialog(null, "Nombre del contacto ha sido actualizado con éxito a " + negocios[i].getContactoNegocio());
                            break;

                        case 4: // Telefono

                            do {
                                telefonoNegocio = JOptionPane.showInputDialog("""
                                                    "Ingrese el número de teléfono del negocio 
                                                    Siga el siguiente formato '####-####'
                                                     """);
                                if (telefonoNegocio.length() != 9) {
                                    error_telefonoNegocio = true;
                                } else {

                                    if (telefonoNegocio.charAt(4) == '-') {

                                        for (int j = 0; j < telefonoNegocio.length(); j++) {

                                            if (j != 4) {
                                                if (!(telefonoNegocio.charAt(j) >= '0' && telefonoNegocio.charAt(j) <= '9')) {
                                                    error_telefonoNegocio = true;
                                                }
                                            }
                                        }
                                    } else {
                                        error_telefonoNegocio = true;
                                    }
                                }

                                if (error_telefonoNegocio) {
                                    error_telefonoNegocio = false;
                                    telefonoNegocio = JOptionPane.showInputDialog("""
                                                    Formato incorrecto
                                                    Ingrese de nuevo el número de teléfono del negocio 
                                                    Siga el siguiente formato '####-####'
                                                     """);

                                    if (telefonoNegocio.length() != 9) {
                                        error_telefonoNegocio = true;
                                    } else {

                                        if (telefonoNegocio.charAt(4) == '-') {

                                            for (int j = 0; j < telefonoNegocio.length(); j++) {

                                                if (j != 4) {
                                                    if (!(telefonoNegocio.charAt(j) >= '0' && telefonoNegocio.charAt(j) <= '9')) {
                                                        error_telefonoNegocio = true;
                                                    }
                                                }
                                            }
                                        } else {
                                            error_telefonoNegocio = true;
                                        }
                                    }
                                } else {
                                    negocios[i].setTelefonoNegocio(telefonoNegocio);
                                    JOptionPane.showMessageDialog(null, "Nombre número del negocio ha sido actualizado con éxito a " + negocios[i].getTelefonoNegocio());
                                    break;
                                }
                            } while (error_telefonoNegocio == true);

                        case 5: // Correo

                            do {
                                correoNegocio = JOptionPane.showInputDialog("Ingrese el correo del negocio");
                                if (error_correoNegocio) {
                                    error_correoNegocio = false;
                                    correoNegocio = JOptionPane.showInputDialog("Ingrese el correo del negocio");

                                    int ubicacionArroba = -1;
                                    int ubicacionPunto = -1;

                                    for (int j = 0; j < correoNegocio.length(); j++) {
                                        if (correoNegocio.charAt(j) == '@') {
                                            ubicacionArroba = j;

                                            for (int k = 0; k < correoNegocio.length(); k++) {
                                                if (correoNegocio.charAt(k) == '.') {
                                                    ubicacionPunto = k;
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
                                } else {
                                    negocios[i].setCorreoNegocio(correoNegocio);
                                    JOptionPane.showMessageDialog(null, "Nombre correo del negocio ha sido actualizado con éxito a " + negocios[i].getCorreoNegocio());
                                    break;
                                }
                            } while (error_correoNegocio == true);

                        case 6: // Dirección
                            direccionNegocio = JOptionPane.showInputDialog("Ingrese la nueva dirección de " + negocios[i].getNombreNegocio());
                            negocios[i].setDireccionNegocio(direccionNegocio);
                            JOptionPane.showMessageDialog(null, "La direción del negocio ha sido actualizada con éxito a " + negocios[i].getDireccionNegocio());
                            break;

                        case 7:
                            do {
                                limiteCredito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo límite de crédito para " + negocios[i].getNombreNegocio()));

                                if (limiteCredito < 1000 || limiteCredito > 8000) {
                                    error_credito = true;
                                } else {
                                    negocios[i].setLimiteCreditoNegocio(limiteCredito);
                                    JOptionPane.showMessageDialog(null, "El límite del crédito del negocio ha sido actualizado con éxito a " + negocios[i].getLimiteCreditoNegocio());
                                    break;
                                }

                            } while (error_credito == true);

                        case 8:
                            JOptionPane.showMessageDialog(null, "Volviendo al menú de Gestión de Repuestos");
                            return;

                        default:
                            JOptionPane.showMessageDialog(null, "Opción no valida, intente de nuevo");
                            opt = Integer.parseInt(JOptionPane.showInputDialog(
                                    "=== Menu de actualización ==="
                                    + "\n1. Nombre (Actual: " + negocios[i].getNombreNegocio() + ")"
                                    + "\n2. Tipo de negocio (Actual: " + negocios[i].getTipoNegocio() + ")"
                                    + "\n3. Contacto (Actual: " + negocios[i].getContactoNegocio() + ")"
                                    + "\n4. Teléfono (Actual: " + negocios[i].getTelefonoNegocio() + ")"
                                    + "\n5. Correo (Actual: " + negocios[i].getCorreoNegocio() + ")"
                                    + "\n6. Dirección (Actual: " + negocios[i].getDireccionNegocio() + ")"
                                    + "\n7. Límite de crédito ($) (Actual: " + negocios[i].getLimiteCreditoNegocio() + ")"
                                    + "\n8. Regresar"
                            ));

                    }
                } while (opt != 8);
            }
        }

        JOptionPane.showMessageDialog(null, """
                                            No se encotraron negocios que coindidan
                                            Volviendo al menú de gestión de negocios
                                            """);

    }

    public void eliminarNegocio(Negocio[] negocios, GestionPedidos gestionPedidos) {

        int valorBoton = 0;

        do {

            if (Negocio.getCantidad() == 0) {
                JOptionPane.showMessageDialog(null, """
                                                Por el momento no hay negocios. 
                                                Por favor agregue un negocio para usar esta característica.
                                                Volviendo al menú de Gestión de Negocios.
                                                """);
                return;
            }

            String codigoBuscar = JOptionPane.showInputDialog("""
                                                          Ingrese el código del repuesto a editar
                                                          Formato: R###
                                                          """);

            // --- REVISAR SI HAY PEDIDOS ASOCIADOS ---
            if (gestionPedidos.revisarPedidosNegocios(codigoBuscar).equals(codigoBuscar)) {

                String opcionesNegocios[] = {"Aceptar"};

                valorBoton = JOptionPane.showOptionDialog(
                        null,
                        "No es posible eliminar el negocio porque tiene pedidos asociados.",
                        "Reintentar busqueda",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesNegocios,
                        "Aceptar");

                return;
            }

            // --- Eliminar negocio ---
            for (int i = 0; i < Negocio.getCantidad(); i++) {
                if (negocios[i].getCodigoNegocio().equalsIgnoreCase(codigoBuscar)) {

                    String opcionesNegocios[] = {"Confirmar eliminación", "Cancelar"};

                    valorBoton = JOptionPane.showOptionDialog(
                            null,
                            "Esta acción es permanente y no se puede deshacer"
                            + "\nCódigo: " + negocios[i].getCodigoNegocio()
                            + "\nNombre: " + negocios[i].getNombreNegocio()
                            + "\nTipo: " + negocios[i].getTipoNegocio()
                            + "\nContacto: " + negocios[i].getContactoNegocio(),
                            "Confirmación de eliminación",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcionesNegocios,
                            "Cancelar");

                    switch (valorBoton) {
                        case 0: // Confirmar

                            // Lista temporal
                            Negocio[] negociosTemp = new Negocio[Negocio.getCantidad()];

                            int indice = 0;

                            for (int j = 0; j < Negocio.getCantidad(); j++) {
                                if (!(negocios[j].getCodigoNegocio().equals(codigoBuscar))) {
                                    negociosTemp[indice] = negocios[j];
                                    indice++;
                                }
                            }
                            Negocio.setCantidad(Negocio.getCantidad() - 1);
                            negocios = negociosTemp;
                            JOptionPane.showMessageDialog(null, "El negocio ha sido eliminado correctamente");
                            return;

                        case 1: // Cancelar
                            JOptionPane.showMessageDialog(null, "Operación cancelada.");
                            return;

                        default: // Cancelar / Opcion invalida
                            JOptionPane.showMessageDialog(null, """
                                                                Opción invalidaOperación cancelada.
                                                                """);
                            return;
                    }
                }
            }

            // --- SI NO EXISTE NIGUN NEGOCIO ---
            String opcionesNegocios[] = {"Reintentar", "Regresar"};

            valorBoton = JOptionPane.showOptionDialog(
                    null,
                    "No se encontró ningún negocio con el código ingresado",
                    "Reintentar busqueda",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesNegocios,
                    "Regresar");

        } while (valorBoton != 1);
    }
}
