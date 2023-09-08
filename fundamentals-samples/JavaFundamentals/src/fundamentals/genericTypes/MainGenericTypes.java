package fundamentals.genericTypes;

public class MainGenericTypes {
    public static void main(String[] args) {
        GenericBox<String> stringGenericBox = new GenericBox<>("Item");
        System.out.println(stringGenericBox.getItem());

        GenericBox<Double> doubleGenericBox = new GenericBox<>(100.0);
        System.out.println(doubleGenericBox.getItem());
    }
}
