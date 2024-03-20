package co.icesi.edu.model;



import java.util.ArrayList;
import java.util.List;

public class ListNodes<T> {

    Node<T> first;
    Node<T> prev;


    public void addElement(T element){
        Node<T> newElement = new Node<>(element);
        if(first == null){
            first = newElement;
        }else{
            Node<T> current = first;
            while(current.next != null){
                current = current.next;
            }
            current.setNext(newElement);
        }
    }

    public List<T> show() {
        List<T> elements = new ArrayList<>();
        Node<T> current = first;
        while (current != null) {
            elements.add(current.getData());
            current = current.next;
        }
        return elements;
    }
    public void remove(T element) {
        if (first != null) {
            Node<T> prev = first; // Initialize prev to first
            Node<T> current = first;
            while (current != null && !current.data.equals(element)) {
                prev = current;
                current = current.next;
            }
            if (current != null) {
                prev.next = current.next;
                current.next = null;
            }
        }
    }

}
