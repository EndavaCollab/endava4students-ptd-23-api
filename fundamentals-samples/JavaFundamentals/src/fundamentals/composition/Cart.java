package fundamentals.composition;

public class Cart {
    String composition = new String("This is a cart");
    String aggregation;

    private Laptop laptop;
    private Keyboard keyboard;

    public Cart(Laptop laptop, Keyboard keyboard) {
        this.laptop = laptop;
        this.keyboard = keyboard;

        this.aggregation = "This is message";
    }
}
