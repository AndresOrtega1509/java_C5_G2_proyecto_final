import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static String nombre = "N/A";
    static double precioUnitario = -1;
    static int cantidad = -1;
    public static void main(String[] args) throws Exception {
        mostrarMenu();
        registrarProducto();
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
            System.out.print("Ingrese el nombre del producto: ");
            nombre = sc.nextLine();
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

    public static boolean esPrecioValido(double precio){
        return precio > 0;
    }

    public static boolean esCantidadValida(int stock){
        return stock >= 0;
    }
}
