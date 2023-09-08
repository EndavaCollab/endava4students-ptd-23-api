package fundamentals.exceptions;

import java.util.Scanner;

public class MainExceptions {
//    1. Throwable => Environment Exceptions  (OutOfMemoryException)
//    2. Exception => Runtime Exceptions (OutOfBoundsException, NullPointerException, etc.)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            testCnpThrows();
        } catch (CnpException cnpException) {
            System.out.println("Eroare CNP: " + cnpException.getMessage());

        }

        System.out.println("-----------------------------");

        String name = null;

        // try - catch -> help us to handle the exceptions
        try {
            System.out.println(name.length());

        } catch (Exception e) {
            System.out.println("Invalid name!");
        }

        System.out.println("---------------------");

        try {
            name = "Developer";
            System.out.println("Name length: " + name.length());
        } catch (Exception e) {
            System.out.println("Invalid name!");
        } finally {
            System.out.println("Finally block code!");
        }

        System.out.println("Have a nice day!");

        System.out.println("---------------------");

        try {
//            ArithmeticException
//            int a  = 10 / 0;

//            NullPointerException
            String course = null;
            System.out.println(course.length());
        } catch (ArithmeticException arithmeticException) {
            System.out.println("Arithmetical exception!!!!");
        } catch (NullPointerException nullPointerException) {
            System.out.println("Null pointer exception");
        } catch (Exception e) {
            System.out.println("Other exception!");
        } catch (Throwable t) {
            System.out.println("Here is a problem!");
        }

        System.out.println("---------------------");

        try {
//            ArithmeticException
//            int a  = 10 / 0;

//            NullPointerException
            String javaCourse = null;
            System.out.println(javaCourse.length());
        } catch (ArithmeticException | NullPointerException combineException) {
            System.out.println("Arithmetical or NullPointer exception!!!!");
        } catch (Exception e) {
            System.out.println("Other exception!");
        } catch (Throwable t) {
            System.out.println("Here is a problem!");
        }

        // custom exception sample
        testCnp();
    }

    public static void testCnp() {
        try {
            String cnp = "8234567890123";

            if (cnp.length() != 13) {
                // throw an Exception
                throw new CnpException("The length is invalid!");
            }

            if (!(cnp.charAt(0) == '1' || cnp.charAt(0) == '2' || cnp.charAt(0) == '3' || cnp.charAt(0) == '4')) {
                throw new CnpException("Gender is invalid");
            }
        } catch (CnpException cnpException) {
            System.out.println("Exception CNP: " + cnpException.getMessage());
        }
    }

    public static void testCnpThrows() throws CnpException {
        String cnp = "8234567890123";

        if (cnp.length() != 13) {
            throw new CnpException("The length is invalid!");
        }

        if (!(cnp.charAt(0) == '1' || cnp.charAt(0) == '2' || cnp.charAt(0) == '3' || cnp.charAt(0) == '4')) {
            // cu throw aruncam o exceptie
            throw new CnpException("Gender is invalid");
        }
    }
}

