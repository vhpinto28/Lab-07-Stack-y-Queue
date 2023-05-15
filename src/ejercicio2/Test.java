package ejercicio2;

import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        // Pruebas de la clase QueueArray
        System.out.println("Pruebas de la clase QueueArray:");
        Queue<Integer> queue = new QueueArray<>(5);
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            System.out.println("Front: " + queue.front()); // Debería ser 1
            System.out.println("Back: " + queue.back()); // Debería ser 3
            queue.dequeue();
            System.out.println("Front: " + queue.front()); // Debería ser 2
            queue.dequeue();
            System.out.println("Front: " + queue.front()); // Debería ser 3
            queue.dequeue();
            System.out.println("Is empty? " + queue.isEmpty()); // Debería ser true
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
    }
}
