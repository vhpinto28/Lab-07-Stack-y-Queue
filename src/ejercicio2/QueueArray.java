package ejercicio2;

import actividad1.ExceptionIsEmpty;

public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int maxSize;
    private int first;
    private int last;
    private int size;

    public QueueArray(int maxSize) {
        this.maxSize = maxSize;
        this.array = createGenericArray(maxSize);
        this.first = 0;
        this.last = -1;
        this.size = 0;
    }

    private E[] createGenericArray(int size) {
        @SuppressWarnings("unchecked")
        E[] newArray = (E[]) new Object[size];
        return newArray;
    }

    public void enqueue(E x) {
        if (isFull()) {
            System.out.println("La cola está llena. No se puede agregar el elemento: " + x);
            return;
        }
        last = (last + 1) % maxSize;
        array[last] = x;
        size++;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("No se puede eliminar de una cola vacía");
        }
        E elemento = array[first];
        array[first] = null;
        first = (first + 1) % maxSize;
        size--;
        return elemento;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return array[first];
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return array[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "La cola está vacía.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Elementos de la cola: ");
        int current = first;
        for (int i = 0; i < size; i++) {
            sb.append(array[current]);
            if (i < size - 1) {
                sb.append(", ");
            }
            current = (current + 1) % maxSize;
        }
        return sb.toString();
    }
}
