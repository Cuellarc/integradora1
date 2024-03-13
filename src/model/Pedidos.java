package model;
import java.util.Objects;

public class Pedidos {
    private Node<Product> headNode;
    private Node<Product> tailNode;
    private int size;

    public Pedidos() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    public void addItem(Product product, int quantity) {
        Node<Product> newNode = new Node<>(new Product(product, quantity));
        if (headNode == null) {
            headNode = newNode;
            tailNode = newNode;
        } else {
            newNode.prev = tailNode;
            tailNode.next = newNode;
            tailNode = newNode;
        }
        size++;
    }

    public void removeItem(Product product) {
        Node<Product> current = headNode;
        while (current != null) {
            if (Objects.equals(current.getData().getId(), product.getId())) {
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                } else {
                    headNode = current.getNext();
                }
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                } else {
                    tailNode = current.getPrev();
                }
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        Node<Product> current = headNode;
        while (current != null) {
            totalPrice += current.getData().getPrice() * current.getData().getAmount();
            current = current.getNext();
        }
        return totalPrice;
    }

    public int getSize() {
        return size;
    }
}