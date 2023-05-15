package ejercicio3;

import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        // Crear un objeto PriorityQueueLinked con 3 prioridades
        PriorityQueue<String, Integer> priorityQueue = new PriorityQueueLinked<>(3);

        // Agregar elementos a la cola de prioridad
        priorityQueue.enqueue("Elemento 1", 3);
        priorityQueue.enqueue("Elemento 2", 1);
        priorityQueue.enqueue("Elemento 3", 2);

        // Obtener y mostrar el elemento de mayor prioridad (front)
        try {
            String frontElement = priorityQueue.front();
            System.out.println("Elemento de mayor prioridad: " + frontElement);
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola de prioridad está vacía.");
        }

        // Eliminar el elemento de mayor prioridad (dequeue)
        try {
            String removedElement = priorityQueue.dequeue();
            System.out.println("Elemento eliminado: " + removedElement);
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola de prioridad está vacía.");
        }

        // Verificar si la cola de prioridad está vacía
        boolean isEmpty = priorityQueue.isEmpty();
        System.out.println("¿La cola de prioridad está vacía? " + isEmpty);
    }
}

