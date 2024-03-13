package model;

import java.util.ArrayList;
import java.util.List;

public class ListNodes<T> {

    Node<T> first;

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

    public List<String> show() {
    List<String> elements = new ArrayList<>();
    Node<T> current = first;
    int i = 0;
    while (current != null) {
        elements.add((i + 1) + ". " + current.getData().toString());
        current = current.next;
        i++;
    }
    return elements;
}
    
public void remove(T element) {
    if (first != null) {
        if (first.data.equals(element)) {
            first = first.next;
        } else {
            Node<T> prev = first;
            Node<T> current = first.next;
            while (current != null && !current.data.equals(element)) {
                prev = current;
                current = current.next;
            }
            if (current != null) {
                prev.next = current.next;
            }
        }
    }
}


}
