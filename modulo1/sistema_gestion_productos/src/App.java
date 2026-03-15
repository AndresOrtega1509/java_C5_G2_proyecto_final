public class App {
    public static void main(String[] args) throws Exception {
        mostrarMenu();
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
}
