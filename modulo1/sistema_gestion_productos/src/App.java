import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static String nombre = "N/A";
    static double precioUnitario = 0;
    static int cantidad = 0;
    public static void main(String[] args) throws Exception {
        mostrarMenu();
        registrarProducto();
        mostrarProductoActual();
        calcularValorTotalInventario();
        mostrarResumenProducto();
        limpiarDatos();
    }

    public static void mostrarMenu() {
        String opciones = """
                --- Sistema de Gestión de Productos ---
                1. Registrar nuevo producto
                2. Mostrar información del producto actual
                3. Calcular valor total del inventario
                4. Mostrar resumen completo del producto
                5. Limpiar datos del producto actual
                0. Salir
                Ingrese su opción:
                """;
        System.out.println(opciones);
    }

    public static void registrarProducto(){
        if (validarProductoRegistrado()) {
            nombre = solicitarNombre();
            precioUnitario = solicitarPrecioUnitario();
            cantidad = solicitarStock();
        }else{
            System.out.println("Registro de producto cancelado.");
        }
    }

    public static boolean validarProductoRegistrado(){
        if (!nombre.equals("N/A")) {
            System.out.print("Ya existe un producto registrado. Dese sobreescribir los datos? (s/n)");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                return true;
            }
        }
        return false;
    }

    public static double solicitarPrecioUnitario(){
        double precio;
        do{
            System.out.print("Ingrese el precio unitario: ");
            precio = sc.nextDouble();
            if (!esPrecioValido(precio)) {
                System.out.println("El precio unitario debe ser mayor a 0. Intentelo nuevamente.");
            }
        }while(!esPrecioValido(precio));
        return precio;
    }

    public static int solicitarStock(){
        int stock;
        do{
            System.out.print("Ingrese la cantidad en stock: ");
            stock = sc.nextInt();
            if (!esCantidadValida(stock)) {
                System.out.println("El cantidad debe ser un número entero no negativo. Intentelo nuevamente.");
            }
        }while(!esCantidadValida(stock));
        return stock;
    }

    public static String solicitarNombre(){
        String nombre;
        do{
            System.out.print("Ingrese el nombre del producto: ");
            nombre = sc.nextLine();
            if (!esNombreValido(nombre)) {
                System.out.println("El nombre del producto debe ser valido. Intentelo nuevamente.");
            }
        }while(!esNombreValido(nombre));
        return nombre;
    }

    public static void mostrarProductoActual() {
        if (cantidad != 0) {
            System.out.println("Nombre: " + nombre);
            System.out.println("Precio: " + precioUnitario);
            System.out.println("Cantidad: " + cantidad);
        }else{
            System.out.println("No hay datos de producto registrados actualmente.");
        }
    }

    private static double calcularValorTotalInventario() {
        double valorTotal = 0;
        if (!nombre.equals("N/A")) {
            valorTotal = precioUnitario * cantidad;
        }else{
            System.out.println("No hay datos registrados para calcular el valor total del inventario.");
        }
        return valorTotal;
    }

    public static void mostrarResumenProducto(){
        if (cantidad != -1) {
            System.out.println("--- Resumen del Producto ---");
            System.out.println("Nombre: " + nombre);
            System.out.printf("Precio Unitario: $%.2f%n", precioUnitario);
            System.out.printf("Cantidad en Inventario: f%n", cantidad);
            System.out.printf("Valor Total en Inventario: $%.2f%n", calcularValorTotalInventario() );
            String estado = setEstadoStock();
            System.out.println("Estado del Stock: " + estado);
        }else{
            System.out.println("No hay productos registrados para mostrar resumen.");
        }
    }

    public static String setEstadoStock(){
        String estado = "N/A";
        if (cantidad < 5) {
            estado = "Stock bajo";
        } else if (cantidad >= 5 && cantidad <= 20) {
            estado = "Stock suficiente";
        }else{
            estado = "Stock alto";
        }
        return estado;
    }

    public static boolean esPrecioValido(double precio){
        return precio > 0;
    }

    public static boolean esCantidadValida(int stock){
        return stock >= 0;
    }

    public static boolean esNombreValido(String nombre){
        return !nombre.isBlank();
    }

    public static void limpiarDatos(){
        nombre = "N/A";
        precioUnitario = 0.0;
        cantidad = 0;
        System.out.println("Los datos del producto actual han sido borrados exitosamente.");
    }
}
