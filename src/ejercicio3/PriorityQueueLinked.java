package ejercicio3;

import actividad1.ExceptionIsEmpty;
import actividad2.QueueLink;

public class PriorityQueueLinked<E, P extends Comparable<P>> implements PriorityQueue<E, P> {
    private int numPriorities;
    private QueueLink<E>[] queues;

    public PriorityQueueLinked(int numPriorities) {
        this.numPriorities = numPriorities;
        this.queues = createGenericArray(numPriorities);
        for (int i = 0; i < numPriorities; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    private QueueLink<E>[] createGenericArray(int size) {
        @SuppressWarnings("unchecked")
        QueueLink<E>[] newArray = (QueueLink<E>[]) java.lang.reflect.Array.newInstance(QueueLink.class, size);
        return newArray;
    }

    public void enqueue(E x, P pr) {
        int priorityIndex = prToIndex(pr);

        if (priorityIndex >= 0 && priorityIndex < numPriorities) {
            queues[priorityIndex].enqueue(x);
        } else {
            throw new IllegalArgumentException("Invalid priority value: " + pr);
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (int i = numPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cannot remove from an empty priority queue");
    }

    public E front() throws ExceptionIsEmpty {
        for (int i = numPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].front();
            }
        }
        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    public E back() throws ExceptionIsEmpty {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    public boolean isEmpty() {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private int prToIndex(P pr) {
        int priorityIndex = pr.compareTo(pr);
        if (priorityIndex >= 0 && priorityIndex < numPriorities) {
            return numPriorities - priorityIndex - 1;
        } else {
            throw new IllegalArgumentException("Invalid priority value: " + pr);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = numPriorities - 1; i >= 0; i--) {
            sb.append("Priority ");
            sb.append(i + 1);
            sb.append(": ");
            sb.append(queues[i].toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
