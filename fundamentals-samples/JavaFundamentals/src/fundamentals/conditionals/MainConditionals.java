package fundamentals.conditionals;

public class MainConditionals {
    public static void main(String[] args) {
        int a = 10;

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
