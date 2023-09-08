package fundamentals.methods;

import java.util.Scanner;

public class MainMethods {
    public static void main(String[] args) {

        Calculator.printMessage("This is a message from a static method");
        Scanner scanner = new Scanner(System.in);

        while (1 > 0) {
            System.out.println("Input a: ");
            int a = scanner.nextInt();

            System.out.println("Input b: ");
            int b = scanner.nextInt();

            Calculator calc = new Calculator();

            // sum
            int sum = calc.sum(a, b);
            System.out.println("Sum: " + sum);

            // difference
            int difference = calc.difference(a, b);
            System.out.println("Difference: " + difference);

            // multiply
            int multiply = calc.multiply(a, b);
            System.out.println("Multiply: " + multiply);

            // Divide
            double divide = calc.divide(a, b);
            System.out.println("Cat: " + divide);
        }
    }
}
