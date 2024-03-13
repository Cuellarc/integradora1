package model;

import model.Node;

public class ControllerApp {

    private Node<User> headUser;
    private Node<User> tailUser;
    private Node<Product> headProduct;
    private Node<Product> tailProduct;

    public ControllerApp() {
        this.headUser = null;
        this.tailUser = null;
        this.headProduct = null;
        this.tailProduct = null;
    }

    public int showProducts() {
        Node<Product> current = headProduct;
        int i = 0;
        while (current != null) {
            System.out.println(i + ". " + current.getData().getDescription());
            current = current.next;
            i++;
        }
        return i;
    }

    public int showUsers() {
        Node<User> current = headUser;
        int i = 0;
        while (current != null) {
            System.out.println(i + ". " + current.getData().getName());
            current = current.next;
            i++;
        }
        return i;
    }

    public void addUser(User user) {
        Node<User> nuevo = new Node<>(user);
        if (headUser == null) {
            headUser = nuevo;
            tailUser = nuevo;
        } else {
            tailUser.next = nuevo;
            nuevo.prev = tailUser;
            tailUser = nuevo;
        }
    }

    public void addProduct(Product product) {
        Node<Product> nuevo = new Node<>(product);
        if (headProduct == null) {
            headProduct = nuevo;
            tailProduct = nuevo;
        } else {
            tailProduct.next = nuevo;
            nuevo.prev = tailProduct;
            tailProduct = nuevo;
        }
    }

    //Metodo para eliminar un producto
    public void removeProduct(Product product) {
        if(headProduct != null){
            if(headProduct.data.equals(product)){
                headProduct = headProduct.next;
            }else{
                Node<Product> prev = headProduct;
                Node<Product> current = headProduct.next;
                while(current != null && !current.data.equals(product)){
                    prev = current;
                    current = current.next;
                }
                if(current != null){
                    prev.next = current.next;
                }


            }
        }

}
}