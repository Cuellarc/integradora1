package co.icesi.edu.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.core.type.TypeReference;

public class ControllerApp {

    private Scanner sc;
    private Node<User> headUser;
    private Node<User> tailUser;
    private Node<Product> headProduct;
    private Node<Product> tailProduct;
    private ListNodes<User> userList;
    private ListNodes<Product> productList;
    private static final String PRODUCTS_FILE_PATH = "path/to/your/products.json";

    public ControllerApp() {
        sc = new Scanner(System.in);
        headUser = null;
        tailUser = null;
        headProduct = null;
        tailProduct = null;
        userList = new ListNodes<>();
        productList = new ListNodes<>();
        loadProducts(); 

    }
    public void loadProducts() {
        try {
            String json = new String(Files.readAllBytes(Paths.get(PRODUCTS_FILE_PATH)));
            TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {};
            List<Product> loadedProducts = JsonUtil.deserializeFromJson(json, typeReference);
            for (Product product : loadedProducts) {
                productList.addElement(product);
            }
            System.out.println("Products loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }


    public List<Product> showProducts() {
        return productList.show();
    }

    public void addUser(String name, String secName, String password, LocalDate birthdate, String city, String telefNumber, String mainPers) {
        User user = new User(name, secName, password, birthdate, city, telefNumber, mainPers);
        userList.addElement(user);
    }

    public void addProduct(String id, String description, int price, int amount, Category category) {
        Product product = new Product(id, description, price, amount, category);
        productList.addElement(product);
        loadProducts(); // Guardar productos después de agregar uno nuevo
        System.out.println("Product added successfully.");
    }

    public void removeProduct(Product product) {
        productList.remove(product);
        loadProducts(); // Guardar productos después de eliminar uno
    }

    public List<Product> searchProductsByPriceRange(int minPrice, int maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList.show()) {
            int price = product.getPrice();
            if (price >= minPrice && price <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> searchProductsByName(String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList.show()) {
            if (product.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

}