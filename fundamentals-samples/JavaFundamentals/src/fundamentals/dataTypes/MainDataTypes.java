package fundamentals.dataTypes;

public class MainDataTypes {

//    byte => [-128 -> 127]
//    short => [-32,768 -> 32,767]
//    int => [-2,147,483,648 -> 2,147,483,647]
//    long => [-2^63 -> 2^63 - 1]

//    float => floating point number
//    double => floating point number

//    boolean => true sau false

//     char = 'a' => a - z, 0 - 9, +,-,*,., ,

    public static void main(String[] args) {
        // int => tip de data
        int age;
//         age => name of variable

        age = 100;
        System.out.println(age); // (sout) => shortcut for print in console
        age = 200;
        System.out.println(age);

        double money = 30.5;
        System.out.println(money);
        money = 500.78;
        System.out.println(money);

        char text = 'a';
        System.out.println(text);

        boolean isTrue = true;
        System.out.println(isTrue);

        boolean isFalse = false;
        System.out.println(isFalse);

//        Inline definition and initialization
        double km = 100.0, m = 1.0, cm = 0.01, hectar = 20.0;
        System.out.println(km);
        System.out.println(m);
        System.out.println(cm);
        System.out.println(hectar);

        String name = "Java Developer";

        String initial = "C";

        String courseName = new String("Java from basic!");
        System.out.println(courseName);
        courseName = "1"; //
        char text2 = '1';

//        CREARE OBIECT ANIMAL
        Animal dog = new Animal();

//        Animal => class (blueprint)
//        dog => variable/object

//         WRAPPER CLASSES
//        int => Integer
        Integer number = 100;
//        boolean => Boolean
        Boolean trueOrFalse = true;
//        short => Short
//        byte => Byte
//        long => Long
//        float => Float
//        double => Double
//        char => Character
    }
}
