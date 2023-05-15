package actividad1;

import java.lang.reflect.Array;

public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;

    public StackArray(int n) {
        this.array = createGenericArray(n);
        tope = -1;
    }

    private E[] createGenericArray(int size) {
        @SuppressWarnings("unchecked")
        E[] newArray = (E[]) Array.newInstance(Object.class, size);
        return newArray;
    }

    public void push(E x) {
        if (isFull()) {
            System.out.println("La pila está llena. No se puede agregar el elemento: " + x);
            return;
        }
        tope++;
        array[tope] = x;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        E elemento = array[tope];
        array[tope] = null;
        tope--;
        return elemento;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return array[tope];
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public boolean isFull() {
        return tope == array.length - 1;
    }

    public String toString() {
        if (isEmpty()) {
            return "La pila está vacía.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Elementos de la pila: ");
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
