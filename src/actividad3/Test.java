package actividad3;

import actividad1.ExceptionIsEmpty;


public class Test {
    public static void main(String[] args) {
        // Pruebas de la clase PriorityQueueLinkSort
        System.out.println("Pruebas de la clase PriorityQueueLinkSort:");

        // Crear una cola de prioridad de tipo String y Integer
        PriorityQueue<String, Integer> priorityQueue = new PriorityQueueLinkSort<>();

        try {
            // Enqueue de elementos con prioridad
            priorityQueue.enqueue("Elemento 1", 3);
            priorityQueue.enqueue("Elemento 2", 1);
            priorityQueue.enqueue("Elemento 3", 2);

            // Mostrar el frente y la parte posterior de la cola
            System.out.println("Front: " + priorityQueue.front()); // Debería ser "Elemento 2"
            System.out.println("Back: " + priorityQueue.back()); // Debería ser "Elemento 1"

            // Dequeue de elementos
            System.out.println("Dequeue: " + priorityQueue.dequeue()); // Debería ser "Elemento 2"
            System.out.println("Dequeue: " + priorityQueue.dequeue()); // Debería ser "Elemento 3"
            System.out.println("Dequeue: " + priorityQueue.dequeue()); // Debería ser "Elemento 1"

            // Verificar si la cola de prioridad está vacía
            System.out.println("Is empty? " + priorityQueue.isEmpty()); // Debería ser true
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
    }
}

