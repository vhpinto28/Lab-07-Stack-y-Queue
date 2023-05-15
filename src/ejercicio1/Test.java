
package ejercicio1;

import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        // Pruebas de la clase StackLink
        System.out.println("Pruebas de la clase StackLink:");

        // Crear una pila de tipo Integer
        Stack<Integer> stack = new StackLink<>();

        try {
            // Push de elementos
            stack.push(1);
            stack.push(2);
            stack.push(3);

            // Mostrar el elemento en la parte superior de la pila
            System.out.println("Top: " + stack.top()); // Debería ser 3

            // Pop de elementos
            System.out.println("Pop: " + stack.pop()); // Debería ser 3
            System.out.println("Pop: " + stack.pop()); // Debería ser 2
            System.out.println("Pop: " + stack.pop()); // Debería ser 1

            // Verificar si la pila está vacía
            System.out.println("Is empty? " + stack.isEmpty()); // Debería ser true
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
    }
}

