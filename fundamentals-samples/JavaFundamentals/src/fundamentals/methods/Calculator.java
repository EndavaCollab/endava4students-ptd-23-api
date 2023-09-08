package fundamentals.methods;

public class Calculator {
    public Calculator() {
        // constructor
    }

     /* void -> return type
     *  - void => this method hasn't a return type
     *  - int, double, float, String etc => return types
     *
     *  sum -> method name
     *   - the name should describe what method does
     *   - numele metodei trebuie sa reflecte ce face metoda
     *
     *   parameters
     *   - int a, int b sunt parametrii metodei adunare
     *   - parameters are used to send data between other methods
     */
    int sum(int a, int b) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        int result = a + b;
//        System.out.println("Suma: " + suma);
        return result;
    }

    protected int difference(int a, int b) {
        int result;
        if(a <= b) {
            result = b - a;
        } else {
            result = a - b;
        }
        return result;
    }

    public int multiply(int a, int b) {
        int result = a * b;

        return result;
    }

    public double divide(int a, int b) {
        double result = (double) a / (double) b;

        return result;
    }

    /**
     * static -> he static keyword in Java is mainly used for memory management.
     *           The static keyword in Java is used to share the same variable
     *           or method of a given class
     * @param message
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }
}
