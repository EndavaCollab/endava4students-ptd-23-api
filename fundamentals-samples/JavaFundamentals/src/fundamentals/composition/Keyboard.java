package fundamentals.composition;

public class Keyboard {
    private int buttons = 104;
    private String color;
    private String brand;
    private String layout;

    public Keyboard(int buttons, String color, String brand, String layout) {
        this.buttons = buttons;
        this.color = color;
        this.brand = brand;
        this.layout = layout;
    }
}
