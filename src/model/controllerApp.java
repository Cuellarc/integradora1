package model;

import java.time.LocalDate;
import java.util.List;

import model.Node;

public class ControllerApp {

    private Node<User> headUser;
    private Node<User> tailUser;
    private Node<Product> headProduct;
    private Node<Product> tailProduct;
    private ListNodes<User> userList = new ListNodes<>();
    private ListNodes<Product> productList = new ListNodes<>();
    
    public ControllerApp() {
        this.headUser = null;
        this.tailUser = null;
        this.headProduct = null;
        this.tailProduct = null;
    }
   public List<String> showProducts() {
    return productList.show();
    }

    public void addUser(User user, String name, String secName, String password, LocalDate birthdate, String city, String telefNumber, String mainPers) {
        user.setName(name);
        user.setSecName(secName);
        user.setPassword(password);
        user.setBirthdate(birthdate);
        user.setCity(city);
        user.setTelefNumber(telefNumber);
        user.setMainPers(mainPers);
        userList.addElement(user);
    }

    public void addProduct(Product product, String id, String description, int price, int amount, Category category) {
        product.setId(id);
        product.setDescription(description);
        product.setPrice(price);
        product.setAmount(amount);
        product.setCategory(category);
        productList.addElement(product);
    }

    //Metodo para eliminar un producto
public void removeProduct(Product product) {
    productList.remove(product);
}
}