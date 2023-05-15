package actividad3;

import actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, P extends Comparable<P>> implements PriorityQueue<E, P> {
    class EntryNode {
        E data;
        P priority;

        EntryNode(E data, P priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x, P pr) {
        EntryNode newEntry = new EntryNode(x, pr);
        Node<EntryNode> newNode = new Node<>(newEntry);

        if (isEmpty() || pr.compareTo(this.first.getData().priority) > 0) {
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            Node<EntryNode> current = this.first; 
            while (current.getNext() != null && pr.compareTo(current.getNext().getData().priority) <= 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

        if (newNode.getNext() == null) {
            this.last = newNode;
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cannot remove from an empty queue");
        }

        E data = this.first.getData().data;
        this.first = this.first.getNext();
        if (this.first == null) {
            this.last = null;
        }
        return data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty");
        }
        return this.last.getData().data;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty");
        }
        return this.first.getData().data;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public String toString() {
        if (isEmpty()) {
            return "La cola de prioridad está vacía.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Elementos de la cola de prioridad: ");
        Node<EntryNode> current = this.first;
        while (current != null) {
            sb.append(current.getData().data);
            sb.append(" (");
            sb.append(current.getData().priority);
            sb.append(")");
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}

