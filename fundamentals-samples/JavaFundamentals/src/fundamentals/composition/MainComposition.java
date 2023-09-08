package fundamentals.composition;

public class MainComposition {
    public static void main(String[] args) {
        Keyboard acerKeyboard = new Keyboard(104, "Black", "Acer", "EN");

        Laptop asusNotebook = new Laptop("Asus", 16, 120, 8.0);

        Cart cart = new Cart(asusNotebook, acerKeyboard);
    }
}
