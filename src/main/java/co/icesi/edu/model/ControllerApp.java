package co.icesi.edu.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllerApp {
    private Node<User> headUser;
    private Node<User> tailUser;
    private Node<Product> headProduct;
    private Node<Product> tailProduct;
    private ListNodes<User> userList;
    private ListNodes<Product> productList;

    public ControllerApp() {
        headUser = null;
        tailUser = null;
        headProduct = null;
        tailProduct = null;
        userList = new ListNodes<>();
        productList = new ListNodes<>();
    }

    public List<Product> showProducts() {
        return productList.show();
    }

    
    public void importUsersFromJSON(String filePath) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> loadedUsers = objectMapper.readValue(json, new TypeReference<List<User>>() {});
            for (User user : loadedUsers) {
                userList.addElement(user);
            }
            System.out.println("Users imported successfully.");
        } catch (IOException e) {
            System.out.println("Error importing users: " + e.getMessage());
        }
    }
    
    public void exportUsersToJSON(String filePath) {
        try {
            List<User> users = userList.show();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(users);
            Files.write(Paths.get(filePath), json.getBytes());
            System.out.println("Users exported successfully.");
        } catch (IOException e) {
            System.out.println("Error exporting users: " + e.getMessage());
        }
    }

    public void addUser(String userName, String name, String secName, String password, LocalDate birthdate, String city, int telefNumber, String mailPers) {
        User user = new User(userName, name, secName, password, birthdate, city, telefNumber, mailPers);
        userList.addElement(user);
    }

    public void addProduct(String id, String description, int price, int amount, Category category) {
        Product product = new Product(id, description, price, amount, category);
        productList.addElement(product);
        System.out.println("Product added successfully.");
    }

    public void removeProduct(Product product) {
        productList.remove(product);
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
