package ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Polaca {

    public static void readFile(String ruta) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("$") && linea.endsWith("$")) {
                    String expresionInfija = linea.substring(1, linea.length() - 1);
                    String expresionPostfija = inToPos(expresionInfija);
                    int resultado = resultExpression(expresionPostfija);
                    System.out.println("Expresión infija: " + expresionInfija);
                    System.out.println("Expresión postfija: " + expresionPostfija);
                    System.out.println("Resultado: " + resultado);
                    System.out.println();
                } else {
                    System.out.println("Expresión inválida: " + linea);
                    System.out.println();
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String inToPos(String expresionInfija) {
        StringBuilder expresionPostfija = new StringBuilder();
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresionInfija.length(); i++) {
            char caracter = expresionInfija.charAt(i);

            if (Character.isDigit(caracter)) {
                expresionPostfija.append(caracter);
            } else if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    expresionPostfija.append(pila.pop());
                }
                pila.pop(); // Descartar el '(' de la pila
            } else {
                while (!pila.isEmpty() && getPrecedence(caracter) <= getPrecedence(pila.peek())) {
                    expresionPostfija.append(pila.pop());
                }
                pila.push(caracter);
            }
        }

        while (!pila.isEmpty()) {
            expresionPostfija.append(pila.pop());
        }

        return expresionPostfija.toString();
    }

    public static int resultExpression(String expresionPostfija) {
        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < expresionPostfija.length(); i++) {
            char caracter = expresionPostfija.charAt(i);

            if (Character.isDigit(caracter)) {
                pila.push(Character.getNumericValue(caracter));
            } else {
                int operando2 = pila.pop();
                int operando1 = pila.pop();
                int resultado = performOperation(operando1, operando2, caracter);
                pila.push(resultado);
            }
        }

        return pila.pop();
    }

    private static int getPrecedence(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        } else if (operador == 'S') {
            return 3;
        } else {
            return 0;
        }
    }

    private static int performOperation(int operando1, int operando2, char operador) {
        switch (operador) {
            case '+':
                return operando1 + operando2;
            case '-':
                return operando1 - operando2;
            case '*':
                return operando1 * operando2;
            case '/':
                return operando1 / operando2;
            case 'S':
                return (int) Math.pow(operando1, operando2);
            default:
                return 0;
        }
    }
}

