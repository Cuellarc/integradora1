package co.icesi.edu.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import co.icesi.edu.model.Product;
import co.icesi.edu.model.Category;
import co.icesi.edu.model.ControllerApp;

public class Executable {
    private Scanner sc;
    private ControllerApp app;

    public Executable() {
        sc = new Scanner(System.in);
        app = new ControllerApp();
    }

    public static void main(String[] args) {
        
        Executable m = new Executable();
        m.menu();
    }

    public void menu() {
        int menuOption = 0;
        while (menuOption != 3) {
            System.out.println("----------Menu----------\n1. Log in\n2. Register\n3. Exit");
            menuOption = sc.nextInt();
            switch (menuOption) {
                case 1:
                    registro();
                    break;
                case 2:
                    userRegister();
                    break;
                case 3:
                    System.out.println("Bye Bye");
                    break;
                default:
                    System.out.println("Select a valid option");
                    break;
            }
        }
    }

   public void registro() {
        System.out.println("Type your username");
        sc.nextLine();
        String user = sc.nextLine();
        System.out.println("Type your first names");
        String name = sc.nextLine();
        System.out.println("Type your last name");
        String secName = sc.nextLine();
        System.out.println("");
        System.out.println("Type the password");
        String passwordLogIn = sc.nextLine();
        System.out.println("Type your birthday in format AAAA/MM/DD");
        String birthdateString = sc.nextLine();
        LocalDate birthdate = LocalDate.parse(birthdateString);
        System.out.println("Type your city");
        String city = sc.nextLine();
        System.out.println("Type your telephone number");
        int telefNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Type your personal mail");
        String mailPers = sc.nextLine();

        app.addUser(user, name, secName, passwordLogIn, birthdate, city, telefNumber, mailPers);
        boolean comprobation = true;
        if (comprobation) {
            menu2();
        }
    }

    
    public void menu2() {
        int menuOption2 = 0;
        ControllerApp controllerApp = new ControllerApp(); // Crear una instancia de la clase ControllerApp
        while (menuOption2 != 4) {
            System.out.println("----------Menu----------\n1. An Order\n2. Inventory\n3. Search\n4. Exit");
            menuOption2 = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea pendiente
            switch (menuOption2) {
                case 1:
                    //Compra(Canasta y Pago)
                    break;
                case 2:
                    int optionInventory = 0;
                    while (optionInventory != 4) {
                        System.out.println("What do you want to do\n1. See all products\n2. Add a product\n3. Delete a product\n4. Exit");
                        optionInventory = sc.nextInt();
                        sc.nextLine(); // Consumir el salto de línea pendiente
                        switch (optionInventory) {
                            case 1:
                                List<Product> products = controllerApp.showProducts();
                                for (Product product : products) {
                                System.out.println(product);
                            }
                                break;
                                case 2:
                                System.out.print("Enter the product ID: ");
                                String id = sc.nextLine();
                                System.out.print("Enter the product description: ");
                                String description = sc.nextLine();
                                System.out.print("Enter the product price: ");
                                int price = sc.nextInt();
                                sc.nextLine(); 
                                System.out.print("Enter the product amount: ");
                                int amount = sc.nextInt();
                                sc.nextLine(); 
                                System.out.print("Enter the product category: ");
                                Category category = Category.valueOf(sc.nextLine().toUpperCase());
                                controllerApp.addProduct(id, description, price, amount, category);
                                List<Product> updatedProducts = controllerApp.showProducts();
                                for (Product product : updatedProducts) {
                                    System.out.println(product);
                                }
                                break;
                                case 3:
                            
                                System.out.print("Enter the product ID to delete: ");
                                String removeProductId = sc.nextLine();
                                Product productToRemove = new Product(removeProductId, "", 0, 0, Category.OTHER);
                                controllerApp.removeProduct(productToRemove);
                                List<Product> updatedProductList = controllerApp.showProducts();
                                for (Product updatedProduct : updatedProductList) {
                                    System.out.println(updatedProduct);
                                }
                                break;
                            case 4: 
                                System.out.println("Bay good luck");
                                break;
                            default:
                                System.out.println("Pliss selec a valid option");
                                break;
                        }
                    }
                    break;
                case 3:
                    search(controllerApp);

                    break;
                case 4:
                    break;
                default:
                    System.out.println("Select a valid option");
                    break;
            }
        }
    }
    public void userRegister() {
        // Todo lo de registro de usuario
    }

    public void search(ControllerApp controllerApp) {
        int optionSearch = 0;
        while (optionSearch != 3) {
            System.out.println("What do you want to search?\n1. Search a product\n2. Search for an order\n3. Exit");
            optionSearch = sc.nextInt();
            switch (optionSearch) {
                case 1: // Buscar productos
                    int searchOption = 0;
                    while (searchOption != 3) {
                        System.out.println("Select search criteria:\n1. Price range\n2. Product name\n3. Back to main menu");
                        searchOption = sc.nextInt();
                        switch (searchOption) {
                            case 1:
                                System.out.println("Enter the minimum price:");
                                int minPrice = sc.nextInt();
                                System.out.println("Enter the maximum price:");
                                int maxPrice = sc.nextInt();
                                List<Product> productsInRange = controllerApp.searchProductsByPriceRange(minPrice, maxPrice);
                                if (productsInRange.isEmpty()) {
                                    System.out.println("No products found in the specified price range.");
                                } else {
                                    System.out.println("Products in the specified price range:");
                                    for (Product product : productsInRange) {
                                        System.out.println(product);
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Enter the keyword to search:");
                                sc.nextLine(); // Consumir la nueva línea pendiente
                                String keyword = sc.nextLine();
                                List<Product> productsByName = controllerApp.searchProductsByName(keyword);
                                if (productsByName.isEmpty()) {
                                    System.out.println("No products found with the specified keyword.");
                                } else {
                                    System.out.println("Products matching the specified keyword:");
                                    for (Product product : productsByName) {
                                        System.out.println(product);
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Returning to the main menu...");
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
