package co.icesi.edu.model;

public class Node<T> {
    Node<T> prev;
    Node<T> next;
    T data;

    public Node(T data) {
        this(null, data, null);
    }

    public Node(Node<T> prev, T data, Node<T> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void insertAfter(Node<T> node) {
        node.next = this.next;
        node.prev = this;
        this.next.prev = node;
        this.next = node;
    }

    public void remove() {
        if (this.prev != null) {
            this.prev.next = this.next;
        }
    }
}