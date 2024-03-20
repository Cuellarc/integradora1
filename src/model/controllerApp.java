package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import co.icesi.edu.model.User;
import model.Node;

public class ControllerApp {

    private Scanner sc;
    private Node<User> headUser;
    private Node<User> tailUser;
    private Node<Product> headProduct;
    private Node<Product> tailProduct;
    private ListNodes<User> userList = new ListNodes<>();
    private ListNodes<Product> productList = new ListNodes<>();

    public ControllerApp() {
        sc = new Scanner(System.in);
        this.headUser = null;
        this.tailUser = null;
        this.headProduct = null;
        this.tailProduct = null;
    }

    public List<Product> showProducts() {
        return productList.show();
    }

    public void addUser(String userName, String name, String secName, String password, LocalDate birthdate, String city,
            int telefNumber, String mailPers) {
        User user = new User(userName, name, secName, password, birthdate, city, telefNumber, mailPers);
        userList.addElement(user);
    }

    public void addProduct(String id, String description, int price, int amount, Category category) {
        Product product = new Product(id, description, price, amount, category);
        System.out.println("Select a category:");
        int categoryIndex = 0;
        for (Category cat : Category.values()) {
            System.out.println((categoryIndex++) + ". " + cat.name());
        }
        categoryIndex = sc.nextInt();
        sc.nextLine();
        category = Category.values()[categoryIndex];
        product.setCategory(category);
        productList.addElement(product);
        System.out.println("Product added successfully.");
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }
}