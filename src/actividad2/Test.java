package actividad2;

import actividad1.ExceptionIsEmpty;
import actividad1.Stack;
import actividad1.StackArray;

public class Test {
    public static void main(String[] args) {
        // Pruebas de la clase StackArray
        System.out.println("Pruebas de la clase StackArray:");
        Stack<Integer> stack = new StackArray<>(5);
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println("Top: " + stack.top()); // Debería ser 3
            stack.pop();
            System.out.println("Top: " + stack.top()); // Debería ser 2
            stack.pop();
            System.out.println("Top: " + stack.top()); // Debería ser 1
            stack.pop();
            System.out.println("Is empty? " + stack.isEmpty()); // Debería ser true
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }

        // Pruebas de la clase QueueLink
        System.out.println("\nPruebas de la clase QueueLink:");
        Queue<String> queue = new QueueLink<>();
        try {
            queue.enqueue("A");
            queue.enqueue("B");
            queue.enqueue("C");
            System.out.println("Front: " + queue.front()); // Debería ser A
            System.out.println("Back: " + queue.back()); // Debería ser C
            queue.dequeue();
            System.out.println("Front: " + queue.front()); // Debería ser B
            queue.dequeue();
            System.out.println("Front: " + queue.front()); // Debería ser C
            queue.dequeue();
            System.out.println("Is empty? " + queue.isEmpty()); // Debería ser true
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
    }
}
