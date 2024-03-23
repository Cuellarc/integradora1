package co.icesi.edu.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.w3c.dom.Node;

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
        try {
            return productList.show();
        } catch (Exception e) {
            System.out.println("Error showing products: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void loadProducts() {
        try {
            String json = new String(Files.readAllBytes(Paths.get("src/main/resources/products.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            List<Product> loadedProducts = objectMapper.readValue(json, new TypeReference<List<Product>>(){}); 
            for(Product product : loadedProducts) {
                productList.addElement(product);
            }
            System.out.println("Products loaded successfully");
        } catch(IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }

    public void loadUsers() {
        try {
            String json = new String(Files.readAllBytes(Paths.get("src/main/resources/users.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> loadedUsers = objectMapper.readValue(json, new TypeReference<List<User>>(){}); 
            for(User user : loadedUsers) {
                userList.addElement(user);
            }
            System.out.println("Users loaded successfully");
        } catch(IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
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
        } catch (Exception e) {
            System.out.println("Error importing users: " + e.getMessage());
        }
    }

    public void importProductsFromJSON(String filePath) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            ObjectMapper objectMapper = new ObjectMapper();
            List<Product> LoadedProducts = objectMapper.readValue(json, new TypeReference<List<Product>>() {});
            for(Product product : LoadedProducts){
                productList.addElement(product);
            }
            System.out.println("Products imported successfully");
        } catch (IOException e) {
            System.out.println("Error importing products:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error importing products: " + e.getMessage());
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
        } catch (Exception e) {
            System.out.println("Error exporting users: " + e.getMessage());
        }
    }
    
    public void exportProductsToJSON(String filePath){
        try{
            List<Product> products = productList.show();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(products);
            Files.write(Paths.get(filePath), json.getBytes());
            System.out.println("Products exported successfully");
        }catch(IOException e){
            System.out.println("Error exporting products: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error exporting products: " + e.getMessage());
        }
    }
    
    public void addUser(String userName, String name, String secName, String password, LocalDate birthdate, String city, int telefNumber, String mailPers) {
        try {
            User user = new User(userName, name, secName, password, birthdate, city, telefNumber, mailPers);
            userList.addElement(user);
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }
    
    public void addProduct(String id, String description, int price, int amount, Category category) {
        try {
            Product product = new Product(id, description, price, amount, category);
            productList.addElement(product);
            System.out.println("Product added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }
    
    public void removeProduct(Product product) {
        try {
            productList.remove(product);
        } catch (Exception e) {
            System.out.println("Error removing product: " + e.getMessage());
        }
    }
    
    public List<Product> searchProductsByPriceRange(int minPrice, int maxPrice) {
        try {
            List<Product> result = new ArrayList<>();
            for (Product product : productList.show()) {
                int price = product.getPrice();
                if (price >= minPrice && price <= maxPrice) {
                    result.add(product);
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println("Error searching products by price range: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public List<Product> searchProductsByName(String keyword) {
        try {
            List<Product> result = new ArrayList<>();
            for (Product product : productList.show()) {
                if (product.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                    result.add(product);
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println("Error searching products by name: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
    