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
public class Negocio {

    // === Definición de Atributos ===
    // --- Texto ---
    private String codigoNegocio;
    private String nombreNegocio;
    private String correoNegocio;
    private String contactoNegocio; // Nombre de la persona encargada
    private String telefonoNegocio;
    private String emailNegocio;
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
        System.out.println("Correo electronico: " + emailNegocio);
        System.out.println("Direccion: " + direccionNegocio);
        System.out.println("====================================");
    }

    public void AgregarNegocio() {

        // === Variables de validación del formato ===
        // --- General ---
        boolean error_codigoNegocio = false;
        boolean error_nombreNegocio = false;
        boolean error_correoNegocio = false;
        boolean error_contactoNegocio = false;
        boolean error_telefonoNegocio = false;
        boolean error_emailNegocio = false;
        boolean error_direccionNegocio = false;
        boolean error_TipoNegocio = false;

        // --- Números ---
        boolean error_limiteCreditoNegocio; // STR para validación futura del formato
        boolean error_saldoNegocio; // STR para validación futura del formato


        // === Petición de información ===
        nombreNegocio = JOptionPane.showInputDialog("Ingrese el nombre del negocio");

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

        contactoNegocio = JOptionPane.showInputDialog("Ingrese el nombre del contacto principal");

        telefonoNegocio = JOptionPane.showInputDialog("""
                                                    "Ingrese el número de teléfono del negocio 
                                                    Siga el siguiente formato '####-####'
                                                     """);

        emailNegocio = JOptionPane.showInputDialog("Ingrese el correo del negocio");

        direccionNegocio = JOptionPane.showInputDialog("Ingrese la dirección del negocio");

        if (tipoNegocio == TipoNegocio.Gasolinera) {
            limiteCreditoNegocio = 4000; //En dolares
        } else if (tipoNegocio == TipoNegocio.Taller) {
            limiteCreditoNegocio = 3000; //En dolares
        } else if (tipoNegocio == TipoNegocio.Venta_Repuestos) {
            limiteCreditoNegocio = 2000; //En dolares
        } else if (tipoNegocio == TipoNegocio.Alquiler_Vehiculos) {
            limiteCreditoNegocio = 6000; //En dolares
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

    public String getEmailNegocio() {
        return emailNegocio;
    }

    public void setEmailNegocio(String emailNegocio) {
        this.emailNegocio = emailNegocio;
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
