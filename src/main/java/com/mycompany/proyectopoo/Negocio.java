
package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 */
public class Negocio {

    // === Definición de Atributos ===
    // --- Texto ---
    private String codigoNegocio;
    private String nombreNegocio;
    private String correoNegocio;
    private String contactoNegocio; // Nombre de la persona encargada
    private String telefonoNegocio;
    private String direccionNegocio;

    // --- Enum ---
    private TipoNegocio tipoNegocio;

    // --- Numeros (int / double)
    private double limiteCreditoNegocio;
    private double saldoNegocio = 0;

    // === Definición de Métodos ===
    public void MostrarNegocios() {
        // --- Método para mostrar todos los negocios ---
        System.out.println("Código: " + codigoNegocio);
        System.out.println("Nombre: " + nombreNegocio);
        System.out.println("Tipo de Negocio: " + tipoNegocio);
        System.out.println("Contacto principal: " + contactoNegocio);
        System.out.println("Telefono: " + telefonoNegocio);
        System.out.println("Correo electronico: " + correoNegocio);
        System.out.println("Direccion: " + direccionNegocio);
        System.out.println("====================================");
    }

    public void AgregarNegocio() {

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

    // === Getters y Setters
    public String getCodigoNegocio() {
        return codigoNegocio;
    }

    public void setCodigoNegocio(String codigoNegocio) {
        this.codigoNegocio = codigoNegocio;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getCorreoNegocio() {
        return correoNegocio;
    }

    public void setCorreoNegocio(String correoNegocio) {
        this.correoNegocio = correoNegocio;
    }

    public String getContactoNegocio() {
        return contactoNegocio;
    }

    public void setContactoNegocio(String contactoNegocio) {
        this.contactoNegocio = contactoNegocio;
    }

    public String getTelefonoNegocio() {
        return telefonoNegocio;
    }

    public void setTelefonoNegocio(String telefonoNegocio) {
        this.telefonoNegocio = telefonoNegocio;
    }

    public String getDireccionNegocio() {
        return direccionNegocio;
    }

    public void setDireccionNegocio(String direccionNegocio) {
        this.direccionNegocio = direccionNegocio;
    }

    public TipoNegocio getTipoNegocio() {
        return tipoNegocio;
    }

    public void setTipoNegocio(TipoNegocio tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }

    public double getLimiteCreditoNegocio() {
        return limiteCreditoNegocio;
    }

    public void setLimiteCreditoNegocio(double limiteCreditoNegocio) {
        this.limiteCreditoNegocio = limiteCreditoNegocio;
    }

    public double getSaldoNegocio() {
        return saldoNegocio;
    }

    public void setSaldoNegocio(double saldoNegocio) {
        this.saldoNegocio = saldoNegocio;
    }
}
