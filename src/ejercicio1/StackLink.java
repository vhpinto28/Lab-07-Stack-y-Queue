package ejercicio1;

import actividad1.ExceptionIsEmpty;

public class StackLink<E> implements Stack<E> {
    private Node<E> top;

    public StackLink() {
        this.top = null;
    }

    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.setNext(top);
        top = newNode;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cannot pop from an empty stack");
        }
        E elemento = top.getData();
        top = top.getNext();
        return elemento;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Stack is empty");
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        if (isEmpty()) {
            return "La pila está vacía.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Elementos de la pila: ");
        Node<E> current = top;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}

