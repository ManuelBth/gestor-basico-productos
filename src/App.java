import java.util.Scanner;

public class App {
    // Variables estáticas para almacenar los datos del producto
    private static String nombreProducto = "N/A";
    private static double precioUnitario = 0.0;
    private static int cantidadInventario = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarProducto(scanner);
                    break;
                case 2:
                    mostrarInformacion();
                    break;
                case 3:
                    calcularValorTotal();
                    break;
                case 4:
                    mostrarResumen();
                    break;
                case 5:
                    limpiarDatos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            System.out.println(); // Línea en blanco para mejor legibilidad
        } while (opcion != 0);

        scanner.close();
        System.out.println("Programa finalizado.");
    }

    // 1. Mostrar Menú Principal
    public static void mostrarMenu() {
        System.out.println("--- Sistema de Gestión de Productos ---");
        System.out.println();
        System.out.println("1. Registrar nuevo producto");
        System.out.println("2. Mostrar información del producto actual");
        System.out.println("3. Calcular valor total del inventario");
        System.out.println("4. Mostrar resumen completo del producto");
        System.out.println("5. Limpiar datos del producto actual");
        System.out.println("0. Salir");
    }

    // 2. Registrar la Información de un Producto
    public static void registrarProducto(Scanner scanner) {
        // Verificar si ya hay un producto guardado
        if (!nombreProducto.equals("N/A") || precioUnitario > 0 || cantidadInventario > 0) {
            System.out.println("Ya existe un producto registrado.");
            System.out.print("¿Desea sobrescribir los datos? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (!respuesta.equals("s")) {
                System.out.println("Registro cancelado.");
                return;
            }
        }

        // Solicitar nombre del producto
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        if (!validarNombre(nombre)) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        // Solicitar precio unitario
        System.out.print("Ingrese el precio unitario: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        if (!validarPrecio(precio)) {
            System.out.println("Error: El precio debe ser mayor que 0.");
            return;
        }

        // Solicitar cantidad en inventario
        System.out.print("Ingrese la cantidad en inventario: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (!validarCantidad(cantidad)) {
            System.out.println("Error: La cantidad debe ser un número entero no negativo.");
            return;
        }

        // Guardar los datos en las variables estáticas
        nombreProducto = nombre;
        precioUnitario = precio;
        cantidadInventario = cantidad;

        System.out.println("Producto registrado exitosamente.");
    }

    // 3. Mostrar Información del Producto Actual
    public static void mostrarInformacion() {
        if (nombreProducto.equals("N/A") && precioUnitario == 0.0 && cantidadInventario == 0) {
            System.out.println("No hay datos de producto registrados actualmente.");
            return;
        }

        System.out.println("--- Información del Producto ---");
        System.out.println("Nombre: " + nombreProducto);
        System.out.println("Precio Unitario: $" + String.format("%,.2f", precioUnitario));
        System.out.println("Cantidad en Inventario: " + cantidadInventario);
    }

    // 4. Calcular Valor Total del Inventario
    public static double calcularValorTotal() {
        if (nombreProducto.equals("N/A") && precioUnitario == 0.0 && cantidadInventario == 0) {
            System.out.println("No hay datos de producto registrados actualmente.");
            return 0.0;
        }

        double valorTotal = precioUnitario * cantidadInventario;
        System.out.printf("Valor Total del Inventario: $%,.2f%n", valorTotal);
        return valorTotal;
    }

    // 5. Mostrar Resumen Completo del Producto
    public static void mostrarResumen() {
        if (nombreProducto.equals("N/A") && precioUnitario == 0.0 && cantidadInventario == 0) {
            System.out.println("No hay datos de producto registrados actualmente.");
            return;
        }

        double valorTotal = precioUnitario * cantidadInventario;
        String estadoStock;

        if (cantidadInventario < 5) {
            estadoStock = "Stock bajo";
        } else if (cantidadInventario <= 20) {
            estadoStock = "Stock suficiente";
        } else {
            estadoStock = "Stock alto";
        }

        System.out.println("--- Resumen del Producto ---");
        System.out.println("Nombre: " + nombreProducto);
        System.out.printf("Precio Unitario: $%,.2f%n", precioUnitario);
        System.out.println("Cantidad en Inventario: " + cantidadInventario);
        System.out.printf("Valor Total en Inventario: $%,.2f%n", valorTotal);
        System.out.println("Estado del Stock: " + estadoStock);
    }

    // 6. Limpiar Datos del Producto Actual
    public static void limpiarDatos() {
        nombreProducto = "N/A";
        precioUnitario = 0.0;
        cantidadInventario = 0;
        System.out.println("Los datos del producto actual han sido borrados exitosamente.");
    }

    // 7. Validar Precio
    public static boolean validarPrecio(double precio) {
        return precio > 0;
    }

    // 8. Validar Cantidad
    public static boolean validarCantidad(int cantidad) {
        return cantidad >= 0;
    }

    // 9. Validar Nombre del Producto
    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
}