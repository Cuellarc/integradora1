import java.util.Scanner;

public class Executable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 4) {
            System.out.println("Menu:");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver carrito");
            System.out.println("3. Realizar pago");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción deseada: ");

            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    agregarProductoAlCarrito();
                    break;
                case 2:
                    sawCar();
                    break;
                case 3:
                    removeItemOfList();
                    break;
                case 4:
                    realizarPago();
                    break;
                case 5:
                    System.out.println("¡Gracias por su visita!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    /* 
    private static void agregarProductoAlCarrito() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        // Aquí iría la lógica para agregar el producto al carrito
        System.out.println(nombre + " agregado al carrito.");
    }

    private static void verCarrito() {
        // Aquí iría la lógica para ver el contenido del carrito
        System.out.println("Contenido del carrito:");
        System.out.println("Producto 1: $10.00");
        System.out.println("Producto 2: $20.00");
        System.out.println("Total: $30.00");
    }

    private static void realizarPago() {
        // Aquí iría la lógica para realizar el pago
        System.out.println("Pago realizado correctamente. Gracias por su compra.");
    }
    */
    
}
