import java.util.Scanner;

/**
 * Clase Main
 * ----------
 * Menú interactivo en consola para el sistema Pizza-Track.
 * Opciones:
 *   1. Registrar Pizza (push en pila principal)
 *   2. Deshacer        (pop principal -> push secundaria)
 *   3. Rehacer         (pop secundaria -> push principal)
 *   4. Mostrar Pedido Actual (peek de la pila principal)
 *   0. Salir
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionPedidos gestion = new GestionPedidos();

        int opcion = -1;

        do {
            mostrarMenu();
            opcion = leerOpcion(sc);

            switch (opcion) {
                case 1:
                    registrarPizza(sc, gestion);
                    break;
                case 2:
                    ejecutarDeshacer(gestion);
                    break;
                case 3:
                    ejecutarRehacer(gestion);
                    break;
                case 4:
                    mostrarPedidoActual(gestion);
                    break;
                case 0:
                    System.out.println("\nCerrando Pizza-Track. ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== PIZZA-TRACK =====");
        System.out.println("1. Registrar Pizza");
        System.out.println("2. Deshacer (Undo)");
        System.out.println("3. Rehacer (Redo)");
        System.out.println("4. Mostrar Pedido Actual");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion(Scanner sc) {
        String linea = sc.nextLine().trim();
        try {
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            return -1; // fuerza la rama "default" del switch
        }
    }

    private static void registrarPizza(Scanner sc, GestionPedidos gestion) {
        System.out.print("Nombre de la pizza: ");
        String nombre = sc.nextLine().trim();

        String[] ingredientes = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrediente " + (i + 1) + ": ");
            ingredientes[i] = sc.nextLine().trim();
        }

        Pizza pizza = new Pizza(nombre, ingredientes);
        gestion.registrarPedido(pizza);

        System.out.println("\nPedido registrado con éxito:");
        System.out.println(pizza);
    }

    private static void ejecutarDeshacer(GestionPedidos gestion) {
        if (!gestion.hayPedidosActivos()) {
            System.out.println("\nNo hay pedidos para deshacer.");
            return;
        }
        Pizza deshecha = gestion.deshacer();
        System.out.println("\nSe deshizo el pedido:");
        System.out.println(deshecha);
    }

    private static void ejecutarRehacer(GestionPedidos gestion) {
        if (!gestion.hayPedidosParaRehacer()) {
            System.out.println("\nNo hay pedidos para rehacer.");
            return;
        }
        Pizza recuperada = gestion.rehacer();
        System.out.println("\nSe rehizo el pedido:");
        System.out.println(recuperada);
    }

    private static void mostrarPedidoActual(GestionPedidos gestion) {
        Pizza actual = gestion.mostrarPedidoActual();
        if (actual == null) {
            System.out.println("\nNo hay pedidos activos en este momento.");
        } else {
            System.out.println("\nPedido actual (listo para producción):");
            System.out.println(actual);
        }
    }
}
