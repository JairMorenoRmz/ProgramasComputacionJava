import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook("contacts.txt");
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("1. Lista de contactos");
            System.out.println("2. Crear un contacto");
            System.out.println("3. Borrar un contacto");
            System.out.println("4. Salir del menú");
            System.out.print("Escoge una opción: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addressBook.list();
                    break;
                case "2":
                    System.out.print("Ingresa el número del contacto: ");
                    String number = scanner.nextLine();
                    System.out.print("Ingresa el nombre del contacto: ");
                    String name = scanner.nextLine();
                    addressBook.create(number, name);
                    break;
                case "3":
                    System.out.print("Ingresa el número a eliminar: ");
                    number = scanner.nextLine();
                    addressBook.delete(number);
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción invalida, favor de ingresar otra.");
            }
        } while (!choice.equals("4"));

        scanner.close();
    }
}
