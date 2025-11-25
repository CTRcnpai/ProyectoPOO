package com.mycompany.proyectopoo;

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

    // --- Constante que cuenta la cantidad de repuestos ---
    private static int cantidad = 0;

    // === Constructor ===
    public Negocio(String codigoNegocio, String nombreNegocio, String correoNegocio, String contactoNegocio,
            String telefonoNegocio, String direccionNegocio,
            TipoNegocio tipoNegocio, double saldoNegocio, double limiteCreditoNegocio) {
        this.codigoNegocio = codigoNegocio;
        this.nombreNegocio = nombreNegocio;
        this.correoNegocio = correoNegocio;
        this.contactoNegocio = contactoNegocio;
        this.telefonoNegocio = telefonoNegocio;
        this.direccionNegocio = direccionNegocio;
        this.tipoNegocio = tipoNegocio;
        this.limiteCreditoNegocio = limiteCreditoNegocio;
        this.saldoNegocio = saldoNegocio;
    }

    // === Definición de Métodos ===
    public void MostrarNegocios() {
        // --- Método para mostrar todos los repuestos ---
        System.out.println(formatoColumna(codigoNegocio) + "|"
                + formatoColumna(nombreNegocio + "") + "|"
                + formatoColumna(tipoNegocio + "") + "|"
                + formatoColumna(contactoNegocio + "") + "|"
                + formatoColumna(telefonoNegocio + "") + "|"
                + formatoColumna(correoNegocio + "") + "|"
                + formatoColumna(direccionNegocio + ""));

    }
    // --- Método para mostrar todos los repuestos ---

    public static String formatoColumna(String dato) {
        int numero = 20 - dato.length();
        String datoFormato = dato;

        for (int i = 0; i < numero; i++) {
            datoFormato += " ";
        }

        return datoFormato;

    }

    // --- Método para generar códigos ---
    public String generarCodigo() {
        // === Asignación de código ===
        cantidad++;
        if (cantidad < 10) {
            codigoNegocio = "N00" + cantidad;
        } else if (cantidad < 100) {
            codigoNegocio = "N0" + cantidad;
        } else {
            codigoNegocio = "N" + cantidad;
        }
        return codigoNegocio;
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

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int aCantidad) {
        cantidad = aCantidad;
    }
}
