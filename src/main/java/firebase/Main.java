package firebase;

import java.util.Scanner;

public class Main {
    private static final FirebaseService firebaseService = new FirebaseService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Agregar Item");
            System.out.println("2. Eliminar Item");
            System.out.println("3. Listar Items");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregarItem(scanner);
                case 2 -> eliminarItem(scanner);
                case 3 -> firebaseService.listItems();
                case 4 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opcion no valida.");
            }
        }
    }

    private static void agregarItem(Scanner scanner) {
        System.out.print("ID del item: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Nombre del item: ");
        String name = scanner.nextLine();
        System.out.print("Precio del item: ");
        Double price = scanner.nextDouble();

        Item item = new Item(id, name, price);
        firebaseService.addItem(item);
    }

    private static void eliminarItem(Scanner scanner) {
        System.out.print("ID del item a eliminar: ");
        Long id = scanner.nextLong();
        firebaseService.deleteItem(id);
    }
}
