package fundamentals.loops;

import java.util.Scanner;

public class MainLoops {
    public static void main(String[] args) {
//        1. for
//        2. foreach (se foloseste cu array)
//        start
//        end
//        progress

        for(int i = 0; i < 3;i++) {
            System.out.println(i);
        }

//        step 0: i = 0, 0 lower than 3? YES, print i, increase i with 1
//        step 1: i = 1, 1 lower than 3? YES, print i, increase i with 1
//        step 2: i = 2, 2 lower than 3? YES, print i, increase i with 1
//        step 3: i = 3, 3 lower than 3? NO, STOP THE LOOP

//        1. while
//        2. do while

        // Scanner is it used to read data from keyboard
        Scanner scanner = new Scanner(System.in);

        int n = 0;

        while(true) { // while(true) inseamna bucla infinita
            System.out.println("introduceti n:");
            n = scanner.nextInt(); // ne permite sa citim un numar intreg de la tastatura
            if(n == 5) {
                break; // opreste executia unei bucle
            }
        }

        n = 5;
        do {
            System.out.println("do - while");
            System.out.println("introduceti n:");
            n = scanner.nextInt(); // read integer from keyboard

        } while(n != 5);
    }
}
