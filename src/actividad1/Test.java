package actividad1;

public class Test {
    public static void main(String[] args) {
        // Crear una pila de enteros
        Stack<Integer> pilaEnteros = new StackArray<>(5);

        try {
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);

            System.out.println("Pila de enteros:");
            System.out.println("Top: " + pilaEnteros.top());
            System.out.println("Pop: " + pilaEnteros.pop());
            System.out.println("Top: " + pilaEnteros.top());
            System.out.println("IsEmpty: " + pilaEnteros.isEmpty());

            pilaEnteros.push(40);
            pilaEnteros.push(50);

            // Verificar si la implementación es una StackArray
            if (pilaEnteros instanceof StackArray) {
                StackArray<Integer> stackArray = (StackArray<Integer>) pilaEnteros;
                System.out.println("IsFull: " + stackArray.isFull());
            }

            pilaEnteros.push(60); // La pila está llena, mostrará un mensaje de error

        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        System.out.println();

        // Crear una pila de cadenas
        Stack<String> pilaCadenas = new StackArray<>(3);

        try {
            pilaCadenas.push("Hola");
            pilaCadenas.push("Mundo");

            System.out.println("Pila de cadenas:");
            System.out.println("Top: " + pilaCadenas.top());
            System.out.println("Pop: " + pilaCadenas.pop());
            System.out.println("Top: " + pilaCadenas.top());
            System.out.println("IsEmpty: " + pilaCadenas.isEmpty());

            // Verificar si la implementación es una StackArray
            if (pilaCadenas instanceof StackArray) {
                StackArray<String> stackArray = (StackArray<String>) pilaCadenas;
                System.out.println("IsFull: " + stackArray.isFull());
            }

            pilaCadenas.push("Stack");

        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}

