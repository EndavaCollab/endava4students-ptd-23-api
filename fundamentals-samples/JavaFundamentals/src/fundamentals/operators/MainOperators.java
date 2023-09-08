package fundamentals.operators;

public class MainOperators {
    /**
     * Operators
     * <p>
     * 1. Assignment
     * = operator used for assigned a value to a variable;
     *
     * 2. Arithmetic
     * =, -, *, /, %, ++, --, +=, -=, *=, /=
     * +, -, *, /, ++, --, % (modulo - the remainder dividing a number) -
     * *  % => we can use it to check if a number is even or odd
     *
     * 3. Logical
     * not: !
     * and: &&
     * or: ||
     * if((2 > 3) || (3 < 2)) {
     *
     * }
     * if((2 > 3) && (3 < 2)) {
     *
     * }
     *
     * 4. Relational
     * !=, ==, <=, >=, >, <
     */
    public static void main(String[] args) {
        // Assignment
        int a = 0;
        a++; // <=> a = a + 1
        // a--; // <=> a = a - 1
        // System.out.println(a);

        // Arithmetic
        a = 1 + 2;
        System.out.println(a);
        a = 1 - 2;
        System.out.println(a);
        a = 1 * 2;
        System.out.println(a);
        a = 1 / 2;
        System.out.println(a);
        // assign the new value to a
        a = 0;
        System.out.println("--------");
        a += 3; // <=> a = a + 3
        System.out.println(a);
        a *= 2; // <=> a = 3 * 2
        System.out.println(a);
        a /= 3; // <=> a = 6 / 3;
        System.out.println(a);

        System.out.println("-------");

        // Logical
        // if, if else, switch

        a = 10;
        if (a == 100) {
            // this is TRUE case
            System.out.println("a is 10");
        } else {
            // this is FALSE case
            System.out.println("a is not 10");
        }

        if (a == 5) {
            System.out.println("a is 5");
        } else if (a == 6) {
            System.out.println("a is 6");
        } else {
            System.out.println("a it not 5 and is not 6");
        }

        a = 3;
        switch (a) {
            case 1:
                System.out.println("a is 1");
                break; // every case should have "break"
            case 2:
                System.out.println("a is 2");
                break;
            case 3:
                System.out.println("a is 3");
                break;

            case 50:
                System.out.println("a is 50");
                break;

            default: // this is optional case
                System.out.println("a este: ");
                System.out.println(a);
        }
    }
}
