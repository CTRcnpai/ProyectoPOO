package com.mycompany.proyectopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristopher Cardoza
 *
 */
public class GestionRepuestos {

    // Listas de repuestos
    private Repuesto repuestos[] = new Repuesto[200];

    // 20 Repuestos precargados
    public void repuestosPrecargados() {
        repuestos[0] = new Repuesto("R001", "Focos", "Mazda", "Miata", "1.8L", Categoria.Electrico, 1989, 200.00, 10, 3);
        repuestos[1] = new Repuesto("R002", "Filtro aceite", "Toyota", "Corolla", "2.0L", Categoria.Filtros, 2020, 25.00, 50, 10);
        repuestos[2] = new Repuesto("R003", "Pastilla freno", "Honda", "Civic", "1.5L", Categoria.Frenos, 2018, 35.50, 40, 8);
        repuestos[3] = new Repuesto("R004", "Amortiguador", "Ford", "Focus", "2.0L", Categoria.Suspension, 2019, 120.00, 15, 5);
        repuestos[4] = new Repuesto("R005", "Bujia", "Chevrolet", "Cruze", "1.4L", Categoria.Electrico, 2021, 12.00, 100, 20);
        repuestos[5] = new Repuesto("R006", "Aceite", "Castrol", "Universal", "N/A", Categoria.Lubricantes, 2024, 50.00, 60, 10);
        repuestos[6] = new Repuesto("R007", "Filtro aire", "BMW", "X3", "2.0L", Categoria.Filtros, 2022, 40.00, 30, 5);
        repuestos[7] = new Repuesto("R008", "Disco freno", "Audi", "A4", "2.0T", Categoria.Frenos, 2020, 80.00, 20, 5);
        repuestos[8] = new Repuesto("R009", "Amortiguador", "Volkswagen", "Golf", "1.6L", Categoria.Suspension, 2017, 110.00, 12, 3);
        repuestos[9] = new Repuesto("R010", "Bateria", "Nissan", "Sentra", "1.8L", Categoria.Electrico, 2023, 150.00, 25, 5);
        repuestos[10] = new Repuesto("R011", "Aceite", "Mobil", "Universal", "N/A", Categoria.Lubricantes, 2024, 45.00, 70, 15);
        repuestos[11] = new Repuesto("R012", "Filtro combustible", "Kia", "Rio", "1.6L", Categoria.Filtros, 2019, 30.00, 35, 8);
        repuestos[12] = new Repuesto("R013", "Frenos", "Hyundai", "Elantra", "2.0L", Categoria.Frenos, 2021, 38.00, 40, 10);
        repuestos[13] = new Repuesto("R014", "Amortiguador", "Suzuki", "Swift", "1.2L", Categoria.Suspension, 2018, 100.00, 18, 5);
        repuestos[14] = new Repuesto("R015", "Luces LED", "Volkswagen", "Tiguan", "2.0L", Categoria.Electrico, 2022, 220.00, 8, 2);
        repuestos[15] = new Repuesto("R016", "Aceite", "Total", "Universal", "N/A", Categoria.Lubricantes, 2024, 55.00, 65, 10);
        repuestos[16] = new Repuesto("R017", "Filtro cabina", "Ford", "Explorer", "3.0L", Categoria.Filtros, 2021, 28.00, 30, 5);
        repuestos[17] = new Repuesto("R018", "Disco freno", "Toyota", "Camry", "2.5L", Categoria.Frenos, 2020, 90.00, 22, 6);
        repuestos[18] = new Repuesto("R019", "Amortiguador", "Honda", "Accord", "2.0L", Categoria.Suspension, 2019, 115.00, 14, 4);
        repuestos[19] = new Repuesto("R020", "Bujia encendido", "Mazda", "CX5", "2.5L", Categoria.Electrico, 2023, 15.00, 90, 20);

    }

    // Submenú de Gestión de Repuestos y bucle del menu
    public void menuGestionRepuesto() {
        repuestosPrecargados();

        boolean menuLoop = true;

        while (menuLoop) {

            String optGestion = JOptionPane.showInputDialog("""
                                                             1. Mostrar todos los repuestos
                                                             2. Agregar repuesto
                                                             3. Editar repuesto
                                                             4. Buscar repuesto
                                                             5. Reponer stock
                                                             6. Regresar
                                                             """);
            switch (optGestion) {

                // 1. Mostrar todos los repuestos
                case "1":
                    if (Repuesto.getCantidad() == 0) {
                        System.out.println("No hay repuestos disponibles");
                    } else {
                        System.out.println(Repuesto.formatoColumna("Codigo") + "|"
                                + Repuesto.formatoColumna("Nombre") + "|"
                                + Repuesto.formatoColumna("Marca") + "|"
                                + Repuesto.formatoColumna("Categoria") + "|"
                                + Repuesto.formatoColumna("Compatibilidad") + "|"
                                + Repuesto.formatoColumna("Precio ($)") + "|"
                                + Repuesto.formatoColumna("Stock") + "|"
                                + Repuesto.formatoColumna("Stock Min" + "|"));
                        for (int i = 0; i < Repuesto.getCantidad(); i++) {
                            repuestos[i].MostrarRepuestos();
                        }
                    }
                    break;
                // 2. Agregar repuesto
                case "2":
                    agregarRepuesto();
                    break;
                // 3. Editar repuesto
                case "3":
                    editarRepuesto(repuestos);
                    break;
                // 4. Buscar repuesto
                case "4":
                    buscarRepuesto(repuestos);
                    break;
                // 5. Reponer stock
                case "5":
                    reponerStock(repuestos);
                    break;
                // 6. Regresar
                case "6":
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

    // Métodos
    private void agregarRepuesto() {
        // --- Método para agregar repuestos ---

        // === Variables de metodo ===
        String codigo = ""; // Formato: R###
        String nombreRepuesto;
        String marcaRepuesto;
        String compatibilidadRepuesto_modelo;
        String compatibilidadRepuesto_motor;

        // --- Enum ---
        Categoria categoria = null;

        // --- Numeros (int / double) ---
        int compatibilidadRepuesto_anho = 0;
        double precioVentaRepuesto = 0.0;
        int stockRepuesto = 0;
        int stockMinimoRepuesto = 0;

        // === Variables de validación del formato ===
        // --- General ---
        boolean error_compatibilidadRepuesto_anho = false;
        boolean error_categoria = false;
        boolean error_precioVentaRepuestoSTR = false;
        boolean error_stockRepuestoSTR = false;
        boolean error_stockMinimoSTR = false;

        // --- Números ---
        String compatibilidadRepuesto_anhoSTR; // STR para validación futura del formato
        String precioVentaRepuestoSTR; // STR para validación futura del formato
        String stockRepuestoSTR; // STR para validación futura del formato
        String stockMinimoRepuestoSTR; // STR para validación futura del formato

        // === Petición de datos ===
        nombreRepuesto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
        marcaRepuesto = JOptionPane.showInputDialog("Ingrese la marca del repuesto");

        // --- Separé la compatibilidad en 3 secciones para solo utilizar en un string separados por "/" al momento de mostrar ---
        // MODELO: Texto plano, no necesita validación
        compatibilidadRepuesto_modelo = JOptionPane.showInputDialog("Ingrese el modelo del repuesto");

        // AÑO: Verificación de que el año tenga el formato correcto ---
        compatibilidadRepuesto_anhoSTR = JOptionPane.showInputDialog("Ingrese el año del repuesto del repuesto (####)");

        for (int i = 0; i < compatibilidadRepuesto_anhoSTR.length(); i++) {
            if (!(compatibilidadRepuesto_anhoSTR.charAt(i) >= '0' && compatibilidadRepuesto_anhoSTR.charAt(i) <= '9')) {
                error_compatibilidadRepuesto_anho = true;
                break;
            }
        }
        if (compatibilidadRepuesto_anhoSTR.length() != 4) {
            error_compatibilidadRepuesto_anho = true;
        }

        if (error_compatibilidadRepuesto_anho == false) {
            compatibilidadRepuesto_anho = Integer.parseInt(compatibilidadRepuesto_anhoSTR);
        }

        // MOTOR: Texto plano, no necesita validación
        compatibilidadRepuesto_motor = JOptionPane.showInputDialog("Ingrese el motor del repuesto");

        // --- Categoria ---
        String optcategoria = JOptionPane.showInputDialog("""
                                                        Ingrese una categoria de la lista:
                                                        1. Filtros
                                                        2. Frenos 
                                                        3, Suspensión
                                                        4. Eléctrico
                                                        5. Lubricantes
                                                        """);

        // --- CATEGORIA: Enum de categoria y validación de errores ---
        switch (optcategoria) {

            // 1. FILTROS
            case "1":
                categoria = Categoria.Filtros;
                break;
            // 2. FRENOS
            case "2":
                categoria = Categoria.Frenos;
                break;
            // 3. SUSPENSIÓN
            case "3":
                categoria = Categoria.Suspension;
                break;
            // 4. ELÉCTRICO
            case "4":
                categoria = Categoria.Electrico;
                break;
            // 5. LUBRICANTES
            case "5":
                categoria = Categoria.Lubricantes;
                break;

            // Opciones invalidas
            case "-1":
                JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                error_categoria = true;
                break;
            case null:
                JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                error_categoria = true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                error_categoria = true;
        }

        // --- PRECIO DE VENTA: Verificación de que se hayan ingresado solo números ---
        precioVentaRepuestoSTR = JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto (Decimales separados por un punto)");
        for (int i = 0; i < precioVentaRepuestoSTR.length(); i++) {
            if (!((precioVentaRepuestoSTR.charAt(i) >= '0' && precioVentaRepuestoSTR.charAt(i) <= '9') || precioVentaRepuestoSTR.charAt(i) == '.')) {
                error_precioVentaRepuestoSTR = true;
                break;
            }

        }

        if (error_precioVentaRepuestoSTR == false) {
            precioVentaRepuesto = Double.parseDouble(precioVentaRepuestoSTR);
            if (precioVentaRepuesto < 0.0) {
                error_precioVentaRepuestoSTR = true;
            }
        }

        // --- STOCK DEL REPUESTO: Verificación de que se hayan ingresado solo números ---
        stockRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad de unidades");
        for (int i = 0; i < stockRepuestoSTR.length(); i++) {
            if (!(stockRepuestoSTR.charAt(i) >= '0' && stockRepuestoSTR.charAt(i) <= '9')) {
                error_stockRepuestoSTR = true;
                break;
            }
        }
        if (error_stockRepuestoSTR == false) {
            stockRepuesto = Integer.parseInt(stockRepuestoSTR);
        }

        // --- STOCK MÍNIMO: Verificación de que se hayan ingresado solo números ---
        stockMinimoRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad mínima de stock de los repuestos (Umbral de alerta)");
        for (int i = 0; i < stockMinimoRepuestoSTR.length(); i++) {
            if (!(stockMinimoRepuestoSTR.charAt(i) >= '0' && stockMinimoRepuestoSTR.charAt(i) <= '9')) {
                error_stockMinimoSTR = true;
                break;
            }
        }
        if (error_stockMinimoSTR == false) {
            stockMinimoRepuesto = Integer.parseInt(stockMinimoRepuestoSTR);
        }

        // === Aquí se valida si hay algún error, se le indica al usuario el error y se le ofrece ingresar la información otra vez o cancelar la acción ===
        if (error_compatibilidadRepuesto_anho || error_categoria
                || error_precioVentaRepuestoSTR || error_stockRepuestoSTR || error_stockMinimoSTR) {

            int optFormato = 0;

            // --- Bucle while para permitir al usuario elegir si desea hacer correciones o no las veces que sea necesario ---
            while (optFormato != 2) {

                String mensajeError = "La información posee un formato incorrecto en: \n";

                if (error_compatibilidadRepuesto_anho) {
                    mensajeError += "- El formato del año del repuesto (####).\n";
                }
                if (error_categoria) {
                    mensajeError += "- La opción de categoría. (Opciónes solamente dentro del menú)\n";
                }
                if (error_precioVentaRepuestoSTR) {
                    mensajeError += "- El formato del precio de venta. (Solamente numeros o puntos y cifras mayores a cero)\n";
                }
                if (error_stockRepuestoSTR) {
                    mensajeError += "- El formato del stock (Solamente numeros).\n";
                }
                if (error_stockMinimoSTR) {
                    mensajeError += "- El formato del stock mínimo (Solamente numeros).\n";
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

                if (optFormato == 0) {
                    // --- USUARIO DESEA SEGUIR EDITANDO ---

                    // AÑO: Verificación de que el año tenga el formato correcto ---
                    if (error_compatibilidadRepuesto_anho) {

                        error_compatibilidadRepuesto_anho = false;

                        compatibilidadRepuesto_anhoSTR = JOptionPane.showInputDialog("Ingrese el año del repuesto del repuesto (####)");

                        for (int i = 0; i < compatibilidadRepuesto_anhoSTR.length(); i++) {
                            if (!(compatibilidadRepuesto_anhoSTR.charAt(i) >= '0' && compatibilidadRepuesto_anhoSTR.charAt(i) <= '9')) {
                                error_compatibilidadRepuesto_anho = true;
                                break;
                            }
                        }
                        if (compatibilidadRepuesto_anhoSTR.length() != 4) {
                            error_compatibilidadRepuesto_anho = true;
                        }

                        if (error_compatibilidadRepuesto_anho == false) {
                            compatibilidadRepuesto_anho = Integer.parseInt(compatibilidadRepuesto_anhoSTR);

                        }
                    }

                    // --- CATEGORIA: Enum de categoria y validación de errores ---
                    if (error_categoria) {

                        error_categoria = false;

                        optcategoria = JOptionPane.showInputDialog("""
                                                        Ingrese una categoria de la lista:
                                                        1. Filtros
                                                        2. Frenos 
                                                        3. Suspensión
                                                        4. Eléctrico
                                                        5. Lubricantes
                                                        """);

                        // Ya que categoria es un enum, el sigueinte switch es para asignar la categoria a la opcion correcta del menu
                        switch (optcategoria) {

                            // 1. FILTROS
                            case "1":
                                categoria = Categoria.Filtros;
                                error_categoria = false;
                                break;
                            // 2. FRENOS
                            case "2":
                                categoria = Categoria.Frenos;
                                error_categoria = false;
                                break;
                            // 3. SUSPENSIÓN
                            case "3":
                                categoria = Categoria.Suspension;
                                error_categoria = false;
                                break;
                            // 4. ELÉCTRICO
                            case "4":
                                categoria = Categoria.Electrico;
                                error_categoria = false;
                                break;
                            // 5. LUBRICANTES
                            case "5":
                                categoria = Categoria.Lubricantes;
                                error_categoria = false;
                                break;
                            // Opciones invalidas
                            case "-1":
                                JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                                error_categoria = true;
                                break;
                            case null:
                                JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                                error_categoria = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                                error_categoria = true;
                        }
                    }

                    // --- PRECIO DE VENTA: Verificación de que se hayan ingresado solo números ---
                    if (error_precioVentaRepuestoSTR) {

                        error_precioVentaRepuestoSTR = false;

                        precioVentaRepuestoSTR = JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto (Decimales separados por un punto)");
                        for (int i = 0; i < precioVentaRepuestoSTR.length(); i++) {
                            if (!((precioVentaRepuestoSTR.charAt(i) >= '0' && precioVentaRepuestoSTR.charAt(i) <= '9') || precioVentaRepuestoSTR.charAt(i) == '.')) {
                                error_precioVentaRepuestoSTR = true;
                                break;
                            }

                        }

                        if (error_precioVentaRepuestoSTR == false) {
                            precioVentaRepuesto = Double.parseDouble(precioVentaRepuestoSTR);
                            if (precioVentaRepuesto < 0.0) {
                                error_precioVentaRepuestoSTR = true;
                            }
                        }
                    }

                    // --- STOCK DEL REPUESTO: Verificación de que se hayan ingresado solo números ---
                    if (error_stockRepuestoSTR) {

                        error_stockRepuestoSTR = false;

                        stockRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad de unidades");
                        for (int i = 0; i < stockRepuestoSTR.length(); i++) {
                            if (!(stockRepuestoSTR.charAt(i) >= '0' && stockRepuestoSTR.charAt(i) <= '9')) {
                                error_stockRepuestoSTR = true;
                                break;
                            }
                        }
                        if (error_stockRepuestoSTR == false) {
                            stockRepuesto = Integer.parseInt(stockRepuestoSTR);
                        }
                    }

                    // --- STOCK MÍNIMO: Verificación de que se hayan ingresado solo números ---
                    if (error_stockMinimoSTR) {

                        error_stockMinimoSTR = false;

                        stockMinimoRepuestoSTR = JOptionPane.showInputDialog("Ingrese la cantidad mínima de stock de los repuestos (Umbral de alerta)");
                        for (int i = 0; i < stockMinimoRepuestoSTR.length(); i++) {
                            if (!(stockMinimoRepuestoSTR.charAt(i) >= '0' && stockMinimoRepuestoSTR.charAt(i) <= '9')) {
                                error_stockMinimoSTR = true;
                                break;
                            }
                        }
                        if (error_stockMinimoSTR == false) {
                            stockMinimoRepuesto = Integer.parseInt(stockMinimoRepuestoSTR);
                        }
                    }

                    if (!error_compatibilidadRepuesto_anho
                            && !error_precioVentaRepuestoSTR
                            && !error_stockRepuestoSTR
                            && !error_stockMinimoSTR
                            && !error_categoria) {
                        optFormato = 2;
                    }
                } else if (optFormato == 1 || optFormato == -1) {
                    JOptionPane.showMessageDialog(null, "No se agregó el repuesto " + nombreRepuesto + "\nVolviendo al menú de gestión de repuestos.");
                    return;
                }
            }
        }

        String opcionesConfirmacion[] = {"Sí", "No"};

        int valorBotonConfirmacion = JOptionPane.showOptionDialog(
                null,
                "¿Desea agregar el repuesto " + nombreRepuesto + "?"
                + "\n Marca: " + marcaRepuesto
                + "\n Compatibilidad: " + compatibilidadRepuesto_modelo + "/" + compatibilidadRepuesto_anho + "/" + compatibilidadRepuesto_motor
                + "\n Precio: " + precioVentaRepuesto
                + "\n Stock: " + stockRepuesto
                + "\n Stock Mínimo: " + stockMinimoRepuesto,
                "CONFIRMACIÓN",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesConfirmacion,
                "No");

        switch (valorBotonConfirmacion) {
            case 0: // Si desea guardar el repuesto
                Repuesto nuevoRepuesto = new Repuesto(codigo, nombreRepuesto, marcaRepuesto, compatibilidadRepuesto_modelo, compatibilidadRepuesto_motor,
                        categoria, compatibilidadRepuesto_anho, precioVentaRepuesto, stockRepuesto, stockMinimoRepuesto);
                repuestos[Repuesto.getCantidad() - 1] = nuevoRepuesto;
                break;
            case 1: // No desea guardar el repuesto
                JOptionPane.showMessageDialog(null, "No se agregó el repuesto " + nombreRepuesto + "\nVolviendo al menú de gestión de repuestos.");
                break;
            case -1:
                JOptionPane.showMessageDialog(null, "No se agregó el repuesto " + nombreRepuesto + "\nVolviendo al menú de gestión de repuestos.");
                break;
            default: // Opción de control
                JOptionPane.showMessageDialog(null, "No se agregó el repuesto " + nombreRepuesto + "\nVolviendo al menú de gestión de repuestos.");
                break;
        }
    }

    private void editarRepuesto(Repuesto[] repuestos) {
        // --- Metodo para editar objetos ---
        if (Repuesto.getCantidad() == 0) {
            JOptionPane.showMessageDialog(null, """
                                                Por el momento no hay repuestos. 
                                                Por favor agregue un repuesto para usar esta característica.
                                                Volviendo al menú de Gestión de Repuestos.
                                                """);
            return;
        }

        String codigoBuscar = JOptionPane.showInputDialog("""
                                                          Ingrese el código del repuesto a editar
                                                          Formato: R###
                                                          """);

        for (int i = 0; i < Repuesto.getCantidad(); i++) {

            if (repuestos[i].getCodigo().equalsIgnoreCase(codigoBuscar)) {

                boolean error_compatibilidadRepuesto_anho = false;
                boolean error_categoria = false;
                boolean error_precioVentaRepuestoSTR = false;
                boolean error_stockRepuestoSTR = false;
                boolean error_stockMinimoSTR = false;
                String nuevoModelo = "";
                String nuevoMotor = "";

                int opt = Integer.parseInt(JOptionPane.showInputDialog(
                        "=== Menu de actualización ==="
                        + "\n1. Nombre (Actual: " + repuestos[i].getNombreRepuesto() + ")"
                        + "\n2. Marca (Actual: " + repuestos[i].getMarcaRepuesto() + ")"
                        + "\n3. Compatibilidad (modelo/año/motor) (Actual: " + repuestos[i].getCompatibilidadRepuesto_modelo()
                        + repuestos[i].getCompatibilidadRepuesto_anho()
                        + repuestos[i].getCompatibilidadRepuesto_motor() + ")"
                        + "\n4. Categoría (Actual: " + repuestos[i].getNombreRepuesto() + ")"
                        + "\n5. Precio de venta ($) (Actual: $" + repuestos[i].getNombreRepuesto() + ")"
                        + "\n6. Stock (unidades) (Actual: " + repuestos[i].getNombreRepuesto() + ")"
                        + "\n7. Stock mínimo (umbral) (Actual: " + repuestos[i].getNombreRepuesto() + ")"
                        + "\n8. Salir"));

                do {

                    switch (opt) {
                        case 1: // Editar Nombre
                            String nuevoRepuesto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                            repuestos[i].setNombreRepuesto(nuevoRepuesto);
                            JOptionPane.showMessageDialog(null, "Nombre actualizado con éxito a " + repuestos[i].getNombreRepuesto());
                            opt = 8;
                            break;
                        case 2: // Editar Marca
                            String nuevaMarca = JOptionPane.showInputDialog("Ingrese la marca del repuesto");
                            repuestos[i].setMarcaRepuesto(nuevaMarca);
                            JOptionPane.showMessageDialog(null, "Marca actualizada con éxito a " + repuestos[i].getMarcaRepuesto());
                            opt = 8;
                            break;

                        case 3: // Editar Compatibilidad

                            // MODELO: Texto plano, no necesita validación
                            nuevoModelo = JOptionPane.showInputDialog("Ingrese el modelo del repuesto");

                            // AÑO: Verificación de que el año tenga el formato correcto ---
                            String nuevoAnioSTR = JOptionPane.showInputDialog("Ingrese el año del repuesto del repuesto (####)");

                            for (int j = 0; j < nuevoAnioSTR.length(); j++) {
                                if (!(nuevoAnioSTR.charAt(j) >= '0' && nuevoAnioSTR.charAt(j) <= '9')) {
                                    error_compatibilidadRepuesto_anho = true;
                                    break;
                                }
                            }
                            if (nuevoAnioSTR.length() != 4) {
                                error_compatibilidadRepuesto_anho = true;
                            }

                            // MOTOR: Texto plano, no necesita validación
                            nuevoMotor = JOptionPane.showInputDialog("Ingrese el motor del repuesto");

                            if (error_compatibilidadRepuesto_anho == false) {
                                repuestos[i].setCompatibilidadRepuesto_modelo(nuevoModelo);
                                int nuevoAnho = Integer.parseInt(nuevoAnioSTR);
                                repuestos[i].setCompatibilidadRepuesto_anho(nuevoAnho);
                                repuestos[i].setCompatibilidadRepuesto_motor(nuevoMotor);
                                JOptionPane.showMessageDialog(null, "Compatibilidad actualizada con éxito a " + repuestos[i].getCompatibilidadRepuesto_modelo()
                                        + "/" + repuestos[i].getCompatibilidadRepuesto_anho()
                                        + "/" + repuestos[i].getCompatibilidadRepuesto_motor());
                                opt = 8;
                            }

                            break;

                        case 4: // Editar Categoria
                            String optcategoria = JOptionPane.showInputDialog("""
                                                        Ingrese una categoria de la lista:
                                                        1. Filtros
                                                        2. Frenos 
                                                        3, Suspensión
                                                        4. Eléctrico
                                                        5. Lubricantes
                                                        """);

                            // --- CATEGORIA: Enum de categoria y validación de errores ---
                            switch (optcategoria) {

                                // 1. FILTROS
                                case "1":
                                    repuestos[i].setCategoria(Categoria.Filtros);
                                    JOptionPane.showMessageDialog(null, "La categoría fue actualizada con éxito a " + repuestos[i].getCategoria());
                                    opt = 8;
                                    break;
                                // 2. FRENOS
                                case "2":
                                    repuestos[i].setCategoria(Categoria.Frenos);
                                    JOptionPane.showMessageDialog(null, "La categoría fue actualizada con éxito a " + repuestos[i].getCategoria());
                                    opt = 8;
                                    break;
                                // 3. SUSPENSIÓN
                                case "3":
                                    repuestos[i].setCategoria(Categoria.Suspension);
                                    JOptionPane.showMessageDialog(null, "La categoría fue actualizada con éxito a " + repuestos[i].getCategoria());
                                    opt = 8;
                                    break;
                                // 4. ELÉCTRICO
                                case "4":
                                    repuestos[i].setCategoria(Categoria.Electrico);
                                    JOptionPane.showMessageDialog(null, "La categoría fue actualizada con éxito a " + repuestos[i].getCategoria());
                                    opt = 8;
                                    break;
                                // 5. LUBRICANTES
                                case "5":
                                    repuestos[i].setCategoria(Categoria.Lubricantes);
                                    JOptionPane.showMessageDialog(null, "La categoría fue actualizada con éxito a " + repuestos[i].getCategoria());
                                    opt = 8;
                                    break;
                                // Opciones invalidas
                                case "-1":
                                    JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                                    error_categoria = true;
                                    break;
                                case null:
                                    JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                                    error_categoria = true;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                                    error_categoria = true;
                            }
                            break;

                        case 5: // Editar Precio de venta
                            String nuevoPrecioVentaSTR = JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto (Decimales separados por un punto)");

                            for (int j = 0; j < nuevoPrecioVentaSTR.length(); j++) {
                                if (!((nuevoPrecioVentaSTR.charAt(j) >= '0' && nuevoPrecioVentaSTR.charAt(j) <= '9') || nuevoPrecioVentaSTR.charAt(j) == '.')) {
                                    error_precioVentaRepuestoSTR = true;
                                    break;
                                }
                            }

                            if (error_precioVentaRepuestoSTR == false) {
                                double nuevoprecioVentaRepuesto = Double.parseDouble(nuevoPrecioVentaSTR);
                                if (nuevoprecioVentaRepuesto < 0.0) {
                                    error_precioVentaRepuestoSTR = true;
                                    break;
                                } else {
                                    repuestos[i].setPrecioVentaRepuesto(nuevoprecioVentaRepuesto);
                                    JOptionPane.showMessageDialog(null, "El precio de venta fue actualizado con éxito a $" + repuestos[i].getPrecioVentaRepuesto());
                                    opt = 8;
                                }
                            }
                            break;

                        case 6: // Editar Stock (unidades)

                            // --- STOCK DEL REPUESTO: Verificación de que se hayan ingresado solo números ---
                            String nuevoStockSTR = JOptionPane.showInputDialog("Ingrese la cantidad de unidades");
                            for (int j = 0; j < nuevoStockSTR.length(); j++) {
                                if (!(nuevoStockSTR.charAt(j) >= '0' && nuevoStockSTR.charAt(j) <= '9')) {
                                    error_stockRepuestoSTR = true;
                                    break;
                                }
                            }
                            if (error_stockRepuestoSTR == false) {
                                int nuevoStockRepuesto = Integer.parseInt(nuevoStockSTR);
                                repuestos[i].setStockRepuesto(nuevoStockRepuesto);
                                JOptionPane.showMessageDialog(null, "El stock fue actualizado con éxito a " + repuestos[i].getStockRepuesto());
                                opt = 8;
                            }
                            break;
                        case 7: // Editar Stock minimo

                            // --- STOCK MÍNIMO: Verificación de que se hayan ingresado solo números ---
                            String nuevoStockMinimoSTR = JOptionPane.showInputDialog("Ingrese la cantidad mínima de stock de los repuestos (Umbral de alerta)");
                            for (int j = 0; j < nuevoStockMinimoSTR.length(); j++) {
                                if (!(nuevoStockMinimoSTR.charAt(j) >= '0' && nuevoStockMinimoSTR.charAt(j) <= '9')) {
                                    error_stockMinimoSTR = true;
                                    break;
                                }
                            }
                            if (error_stockMinimoSTR == false) {
                                int nuevostockMinimo = Integer.parseInt(nuevoStockMinimoSTR);
                                repuestos[i].setStockMinimoRepuesto(nuevostockMinimo);
                                JOptionPane.showMessageDialog(null, "El stock fue actualizado con éxito a " + repuestos[i].getStockMinimoRepuesto());
                                opt = 8;
                            }
                            break;
                        case 8:
                            JOptionPane.showMessageDialog(null, "Volviendo al menú de Gestión de Repuestos");
                            break;

                        // OptGestion invalida

                        default:
                            JOptionPane.showMessageDialog(null, "Opción no valida, intente de nuevo");
                            opt = Integer.parseInt(JOptionPane.showInputDialog(
                                    "=== Menu de actualización ==="
                                    + "\n1. Nombre (actual: " + repuestos[i].getNombreRepuesto() + ")"
                                    + "\n2. Marca (actual: " + repuestos[i].getMarcaRepuesto() + ")"
                                    + "\n3. Compatibilidad (modelo/año/motor)(actual: " + repuestos[i].getCompatibilidadRepuesto_modelo()
                                    + repuestos[i].getCompatibilidadRepuesto_anho()
                                    + repuestos[i].getCompatibilidadRepuesto_motor()) + ")"
                                    + "\n4. Categoría (actual: " + repuestos[i].getNombreRepuesto() + ")"
                                    + "\n5. Precio de venta ($) (actual: $" + repuestos[i].getNombreRepuesto() + ")"
                                    + "\n6. Stock (unidades) (actual: " + repuestos[i].getNombreRepuesto() + ")"
                                    + "\n7. Stock mínimo (umbral) (actual: " + repuestos[i].getNombreRepuesto() + ")"
                                    + "\n8. Salir");
                    }

                    // === Aquí se valida si hay algún error, se le indica al usuario el error y se le ofrece ingresar la información otra vez o cancelar la acción ===
                    if (error_compatibilidadRepuesto_anho || error_categoria
                            || error_precioVentaRepuestoSTR || error_stockRepuestoSTR || error_stockMinimoSTR) {

                        int optFormato = 0;

                        // --- Bucle while para permitir al usuario elegir si desea hacer correciones o no las veces que sea necesario ---
                        while (optFormato != 2) {

                            String mensajeError = "La información posee un formato incorrecto en: \n";

                            if (error_compatibilidadRepuesto_anho) {
                                mensajeError += "- El formato del año del repuesto (####).\n";
                            }
                            if (error_categoria) {
                                mensajeError += "- La opción de categoría. (Opciónes solamente dentro del menú)\n";
                            }
                            if (error_precioVentaRepuestoSTR) {
                                mensajeError += "- El formato del precio de venta. (Solamente numeros o puntos y cifras mayores a cero)\n";
                            }
                            if (error_stockRepuestoSTR) {
                                mensajeError += "- El formato del stock (Solamente numeros).\n";
                            }
                            if (error_stockMinimoSTR) {
                                mensajeError += "- El formato del stock mínimo (Solamente numeros).\n";
                            }

                            String opcionesReintento[] = {"Reintentar", "Cancelar"};

                            optFormato = JOptionPane.showOptionDialog(
                                    null,
                                    mensajeError
                                    + "\n¿Desea agregar la información de nuevo? ",
                                    "CONFIRMACIÓN",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opcionesReintento,
                                    "No");

                            if (optFormato == 0) {
                                // --- USUARIO DESEA SEGUIR EDITANDO ---

                                // AÑO: Verificación de que el año tenga el formato correcto ---
                                if (error_compatibilidadRepuesto_anho) {

                                    error_compatibilidadRepuesto_anho = false;

                                    // AÑO: Verificación de que el año tenga el formato correcto ---
                                    String nuevoAnioSTR = JOptionPane.showInputDialog("Ingrese el año del repuesto del repuesto (####)");

                                    for (int j = 0; j < nuevoAnioSTR.length(); j++) {
                                        if (!(nuevoAnioSTR.charAt(j) >= '0' && nuevoAnioSTR.charAt(j) <= '9')) {
                                            error_compatibilidadRepuesto_anho = true;
                                            break;
                                        }
                                    }
                                    if (nuevoAnioSTR.length() != 4) {
                                        error_compatibilidadRepuesto_anho = true;
                                    }

                                    if (error_compatibilidadRepuesto_anho == false) {
                                        repuestos[i].setCompatibilidadRepuesto_modelo(nuevoModelo);
                                        int nuevoAnho = Integer.parseInt(nuevoAnioSTR);
                                        repuestos[i].setCompatibilidadRepuesto_anho(nuevoAnho);
                                        repuestos[i].setCompatibilidadRepuesto_motor(nuevoMotor);
                                        JOptionPane.showMessageDialog(null, "Compatibilidad actualizada con éxito a " + repuestos[i].getCompatibilidadRepuesto_modelo()
                                                + "/" + repuestos[i].getCompatibilidadRepuesto_anho()
                                                + "/" + repuestos[i].getCompatibilidadRepuesto_motor());
                                        return;
                                    }
                                    break;
                                }

                                // --- CATEGORIA: Enum de categoria y validación de errores ---
                                if (error_categoria) {

                                    error_categoria = false;

                                    String optcategoria = JOptionPane.showInputDialog("""
                                                        Ingrese una categoria de la lista:
                                                        1. Filtros
                                                        2. Frenos 
                                                        3, Suspensión
                                                        4. Eléctrico
                                                        5. Lubricantes
                                                        """);

                                    // --- CATEGORIA: Enum de categoria y validación de errores ---
                                    switch (optcategoria) {

                                        // 1. FILTROS
                                        case "1":
                                            repuestos[i].setCategoria(Categoria.Filtros);
                                            break;
                                        // 2. FRENOS
                                        case "2":
                                            repuestos[i].setCategoria(Categoria.Frenos);
                                            break;
                                        // 3. SUSPENSIÓN
                                        case "3":
                                            repuestos[i].setCategoria(Categoria.Suspension);
                                            break;
                                        // 4. ELÉCTRICO
                                        case "4":
                                            repuestos[i].setCategoria(Categoria.Electrico);
                                            break;
                                        // 5. LUBRICANTES
                                        case "5":
                                            repuestos[i].setCategoria(Categoria.Lubricantes);
                                            break;
                                        // Opciones invalidas
                                        case "-1":
                                            JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                                            error_categoria = true;
                                            break;
                                        case null:
                                            JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                                            error_categoria = true;
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "No se eligió una categoría valida");
                                            error_categoria = true;
                                    }
                                }

                                // --- PRECIO DE VENTA: Verificación de que se hayan ingresado solo números ---
                                if (error_precioVentaRepuestoSTR) {

                                    error_precioVentaRepuestoSTR = false;

                                    String nuevoPrecioVentaSTR = JOptionPane.showInputDialog("Ingrese el precio de venta del repuesto (Decimales separados por un punto)");

                                    for (int j = 0; j < nuevoPrecioVentaSTR.length(); j++) {
                                        if (!((nuevoPrecioVentaSTR.charAt(j) >= '0' && nuevoPrecioVentaSTR.charAt(j) <= '9') || nuevoPrecioVentaSTR.charAt(j) == '.')) {
                                            error_precioVentaRepuestoSTR = true;
                                            break;
                                        }
                                    }

                                    if (error_precioVentaRepuestoSTR == false) {
                                        double nuevoprecioVentaRepuesto = Double.parseDouble(nuevoPrecioVentaSTR);
                                        if (nuevoprecioVentaRepuesto < 0.0) {
                                            error_precioVentaRepuestoSTR = true;
                                            break;
                                        } else {
                                            repuestos[i].setPrecioVentaRepuesto(nuevoprecioVentaRepuesto);
                                        }
                                    }
                                }

                                // --- STOCK DEL REPUESTO: Verificación de que se hayan ingresado solo números ---
                                if (error_stockRepuestoSTR) {

                                    error_stockRepuestoSTR = false;

                                    String nuevoStockSTR = JOptionPane.showInputDialog("Ingrese la cantidad de unidades");
                                    for (int j = 0; j < nuevoStockSTR.length(); j++) {
                                        if (!(nuevoStockSTR.charAt(j) >= '0' && nuevoStockSTR.charAt(j) <= '9')) {
                                            error_stockRepuestoSTR = true;
                                            break;
                                        }
                                    }
                                    if (error_stockRepuestoSTR == false) {
                                        int nuevoStockRepuesto = Integer.parseInt(nuevoStockSTR);
                                        repuestos[i].setStockRepuesto(nuevoStockRepuesto);
                                    }
                                }

                                // --- STOCK MÍNIMO: Verificación de que se hayan ingresado solo números ---
                                if (error_stockMinimoSTR) {

                                    error_stockMinimoSTR = false;

                                    String nuevoStockMinimoSTR = JOptionPane.showInputDialog("Ingrese la cantidad mínima de stock de los repuestos (Umbral de alerta)");
                                    for (int j = 0; j < nuevoStockMinimoSTR.length(); j++) {
                                        if (!(nuevoStockMinimoSTR.charAt(j) >= '0' && nuevoStockMinimoSTR.charAt(j) <= '9')) {
                                            error_stockMinimoSTR = true;
                                            break;
                                        }
                                    }
                                    if (error_stockMinimoSTR == false) {
                                        int nuevostockMinimo = Integer.parseInt(nuevoStockMinimoSTR);
                                        repuestos[i].setStockMinimoRepuesto(nuevostockMinimo);
                                    }
                                }

                                if (!error_compatibilidadRepuesto_anho
                                        && !error_precioVentaRepuestoSTR
                                        && !error_stockRepuestoSTR
                                        && !error_stockMinimoSTR
                                        && !error_categoria) {
                                    optFormato = 2;
                                }
                            } else if (optFormato == 1 || optFormato == -1) {
                                JOptionPane.showMessageDialog(null, "No se editó el repuesto " + repuestos[i].getCodigo() + "(" + repuestos[i].getCodigo() + ")"
                                        + "\nVolviendo al menú de gestión de repuestos.");
                                return;
                            }
                        }
                    }

                } while (opt != 8);
            } else {
                JOptionPane.showMessageDialog(null, "No existe un repuesto con el código " + codigoBuscar
                        + "\nVolviendo al menú de Gestión de Repuestos.");
            }
        }

    }

    private void buscarRepuesto(Repuesto[] repuestos) {
        // --- Metodo para buscar repuestos ---

        // --- Paso 1: Filtro de compatibilidad ---
        // --- Mostrar con el formato correcto ---
        if (Repuesto.getCantidad() == 0) {
            System.out.println("No hay repuestos disponibles");
        } else {

            // --- Petición de datos ---
            String compatibilidadRepuesto_modelo = JOptionPane.showInputDialog("Ingrese el modelo del repuesto");
            String compatibilidadRepuesto_anhoSTR = JOptionPane.showInputDialog("Ingrese el año del repuesto del repuesto (####)");
            int compatibilidadRepuesto_anho = 0; // Variable por si el usuario usa el formato correcto para el año

            if (!(compatibilidadRepuesto_anhoSTR.equalsIgnoreCase("Cualquiera") || compatibilidadRepuesto_anhoSTR.equalsIgnoreCase(""))) {
                for (int i = 0; i < compatibilidadRepuesto_anhoSTR.length(); i++) {
                    if (!(compatibilidadRepuesto_anhoSTR.charAt(i) >= '0' && compatibilidadRepuesto_anhoSTR.charAt(i) <= '9')) {
                        JOptionPane.showMessageDialog(null, """
                                                        Formato de fecha no compatible.
                                                        El formato debe ser cuatro (4) números ####
                                                        """);
                        return;
                    }
                }
                if (compatibilidadRepuesto_anhoSTR.length() != 4) {
                    JOptionPane.showMessageDialog(null, """
                                                        Formato de fecha no compatible.
                                                        El formato debe ser cuatro (4) números ####
                                                        """);
                    return;
                } else {
                    compatibilidadRepuesto_anho = Integer.parseInt(compatibilidadRepuesto_anhoSTR);
                }
            }

            String compatibilidadRepuesto_motor = JOptionPane.showInputDialog("Ingrese el motor del repuesto");

            // Categoria 
            Categoria categoriaFiltro = null;
            String optCategoria[] = {"Filtros", "Frenos", "Suspension", "Electrico", "Lubricantes"};
            int optCatFiltrada = JOptionPane.showOptionDialog(
                    null,
                    "Elija una categoría",
                    "FILTRO DE CATEGORÍA",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optCategoria,
                    "Filtros");

            switch (optCatFiltrada) {

                // 1. FILTROS
                case 0:
                    categoriaFiltro = Categoria.Filtros;
                    break;
                // 2. FRENOS
                case 1:
                    categoriaFiltro = Categoria.Frenos;
                    break;
                // 3. SUSPENSIÓN
                case 2:
                    categoriaFiltro = Categoria.Suspension;
                    break;
                // 4. ELÉCTRICO
                case 3:
                    categoriaFiltro = Categoria.Electrico;
                    break;
                // 5. LUBRICANTES
                case 4:
                    categoriaFiltro = Categoria.Lubricantes;
                    break;

                // Opcion invalida
                default:
                    JOptionPane.showMessageDialog(null, """
                                                        No se eligió una categoría valida
                                                        Regresando al menú de Gestión de repuestos
                                                        """);
                    return;
            }

            // --- Lista para almacenar objetos compatibles ---
            Repuesto[] repuestosFiltrados = new Repuesto[Repuesto.getCantidad()];

            // --- Variable de control de cantidad de repuestos filtrados ---
            int cantidadFiltrados = 0;

            // --- Configuración por si el cliente deja en blanco o elije cualquiera ---
            for (int i = 0; i < Repuesto.getCantidad(); i++) {
                boolean modeloFiltrado = compatibilidadRepuesto_modelo == null || compatibilidadRepuesto_modelo.equalsIgnoreCase("Cualquiera")
                        || compatibilidadRepuesto_modelo.equalsIgnoreCase("") || compatibilidadRepuesto_modelo.equalsIgnoreCase(repuestos[i].getCompatibilidadRepuesto_modelo());

                boolean anhoFiltrado = compatibilidadRepuesto_anhoSTR.equalsIgnoreCase("Cualquiera")
                        || compatibilidadRepuesto_anhoSTR.equalsIgnoreCase("") || compatibilidadRepuesto_anho == repuestos[i].getCompatibilidadRepuesto_anho();

                boolean motorFiltrado = compatibilidadRepuesto_motor == null || compatibilidadRepuesto_motor.equalsIgnoreCase("Cualquiera")
                        || compatibilidadRepuesto_motor.equalsIgnoreCase("") || compatibilidadRepuesto_motor.equalsIgnoreCase(repuestos[i].getCompatibilidadRepuesto_motor());

                boolean categoriaFiltrada = repuestos[i].getCategoria() == categoriaFiltro;

                if (modeloFiltrado && anhoFiltrado && motorFiltrado && categoriaFiltrada) {
                    repuestosFiltrados[cantidadFiltrados] = repuestos[i];
                    cantidadFiltrados++;
                }
            }

            // --- Impresion de los repuestos filtrados ---
            if (cantidadFiltrados == 0) {
                JOptionPane.showMessageDialog(null, """
                                                    "No se encontraron repuestos que coincidan con los filtros mencionados
                                                    Regresando al menú de Gestión de repuestos
                                                     """);
                return;
            }
            System.out.println(Repuesto.formatoColumna("Codigo") + "|"
                    + Repuesto.formatoColumna("Nombre") + "|"
                    + Repuesto.formatoColumna("Marca") + "|"
                    + Repuesto.formatoColumna("Categoria") + "|"
                    + Repuesto.formatoColumna("Compatibilidad") + "|"
                    + Repuesto.formatoColumna("Precio ($)") + "|"
                    + Repuesto.formatoColumna("Stock") + "|"
                    + Repuesto.formatoColumna("Stock Min" + "|"));
            for (int i = 0; i < cantidadFiltrados; i++) {
                repuestosFiltrados[i].MostrarRepuestos();
            }

        }
    }

    private void reponerStock(Repuesto[] repuestos) {

        int optReponer;
        do {

            optReponer = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                    ¿Cómo desea reabastecer el stock?
                                                                    1. Búsqueda individual
                                                                    2. Todos los repuestos
                                                                    3. Regresar
                                                                    """));

            switch (optReponer) {
                case 1:

                    if (Repuesto.getCantidad() == 0) {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún repuesto con el código ingresado. \n"
                                + "Volviendo al menú de Reponer Stock");
                        break;
                    }
                    String codigoBuscar = JOptionPane.showInputDialog("Ingrese el código del repuesto");

                    for (int i = 0; i < Repuesto.getCantidad(); i++) {

                        if (repuestos[i].getCodigo().equalsIgnoreCase(codigoBuscar)) {

                            String cantidadReponerSTR = JOptionPane.showInputDialog(
                                    "Ingrese la cantidad de stock a reponer de " + repuestos[i].getNombreRepuesto()
                                    + "\nSolamente números enteros mayores a cero (0)");

                            int cantidadReponer = 0;

                            for (int j = 0; j < cantidadReponerSTR.length(); j++) {
                                if (!(cantidadReponerSTR.charAt(j) >= '0' && cantidadReponerSTR.charAt(j) <= '9')) {
                                    JOptionPane.showMessageDialog(null, "Solamente se aceptan números enteros mayores a cero (0)\n"
                                            + "Volviendo al menú de Reponer Stock");
                                    return;
                                }
                            }

                            cantidadReponer = Integer.parseInt(cantidadReponerSTR);

                            if (cantidadReponer >= 1) {
                                JOptionPane.showMessageDialog(null, "El stock del repuesto " + repuestos[i].getNombreRepuesto() + " ha sido actualizado"
                                        + "Cantidad anterior: " + repuestos[i].getStockRepuesto()
                                        + "Nueva cantidad: " + cantidadReponer);
                                repuestos[i].setStockRepuesto(cantidadReponer);
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "Solamente se aceptan números enteros mayores a cero (0)\n"
                                        + "Volviendo al menú de Reponer Stock");
                                break;
                            }

                        }
                    }
                case 2:

                    String matrizStock[][] = new String[Repuesto.getCantidad()][3];

                    // 
                    for (int i = 0; i < Repuesto.getCantidad(); i++) {
                        String cantidadReponerSTR = JOptionPane.showInputDialog("Ingrese la cantidad de stock a reponer de " + repuestos[i].getNombreRepuesto()
                                + "\nCódigo: " + repuestos[i].getCodigo()
                                + "\nStock actual: " + repuestos[i].getStockRepuesto());

                        if (cantidadReponerSTR == null && i == 0) {
                            JOptionPane.showMessageDialog(null, "No se realizaron actualizaciones de stock.");
                            return;
                        }

                        if (cantidadReponerSTR == null) {
                            JOptionPane.showMessageDialog(null, "Se ha cancelado el proceso"
                                    + "\nMostrando en consola los cambios y regresando al menú de Gestión");

                            // Imprimir la matriz
                            System.out.println(
                                    Repuesto.formatoColumna("Nombre") + "|"
                                    + Repuesto.formatoColumna("Stock Viejo") + "|"
                                    + Repuesto.formatoColumna("Stock Nuevo")
                            );

                            for (int k = 0; k < matrizStock.length; k++) {
                                if (matrizStock[k][0] != null) {
                                    System.out.println(
                                            Repuesto.formatoColumna(matrizStock[k][0]) + "|"
                                            + Repuesto.formatoColumna(matrizStock[k][1]) + "|"
                                            + Repuesto.formatoColumna(matrizStock[k][2])
                                    );
                                }
                            }
                            return;
                        }

                        for (int j = 0; j < cantidadReponerSTR.length(); j++) {
                            if (!(cantidadReponerSTR.charAt(j) >= '0' && cantidadReponerSTR.charAt(j) <= '9')) {
                                JOptionPane.showMessageDialog(null, "Solamente se aceptan números"
                                        + "\nMostrando en consola los cambios y regresando al menú de Gestión");

                                // Imprimir la matriz
                                System.out.println(
                                        Repuesto.formatoColumna("Nombre") + "|"
                                        + Repuesto.formatoColumna("Stock Viejo") + "|"
                                        + Repuesto.formatoColumna("Stock Nuevo")
                                );

                                for (int k = 0; k < matrizStock.length; k++) {
                                    if (matrizStock[k][0] != null) {
                                        System.out.println(
                                                Repuesto.formatoColumna(matrizStock[k][0]) + "|"
                                                + Repuesto.formatoColumna(matrizStock[k][1]) + "|"
                                                + Repuesto.formatoColumna(matrizStock[k][2])
                                        );
                                    }
                                }
                                return;
                            }
                        }

                        int cantidadReponer = Integer.parseInt(cantidadReponerSTR);
                        String stockViejo = repuestos[i].getStockRepuesto() + "";
                        String stockNuevo = (repuestos[i].getStockRepuesto() + cantidadReponer) + "";

                        matrizStock[i][0] = repuestos[i].getNombreRepuesto();
                        matrizStock[i][1] = stockViejo;
                        matrizStock[i][2] = stockNuevo;
                    }

                    // Imprimir la matriz
                    System.out.println(
                            Repuesto.formatoColumna("Nombre") + "|"
                            + Repuesto.formatoColumna("Stock Viejo") + "|"
                            + Repuesto.formatoColumna("Stock Nuevo")
                    );

                    for (int i = 0; i < matrizStock.length; i++) {
                        if (matrizStock[i][0] != null) {
                            System.out.println(
                                    Repuesto.formatoColumna(matrizStock[i][0]) + "|"
                                    + Repuesto.formatoColumna(matrizStock[i][1]) + "|"
                                    + Repuesto.formatoColumna(matrizStock[i][2])
                            );
                        }
                    }
            }
        } while (optReponer != 3);
    }

    // === Getters y Setters de la lista ===
    public Repuesto[] getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(Repuesto[] repuestos) {
        this.repuestos = repuestos;
    }
}
