package fundamentals.composition;

public class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private double batterySize;

    public Laptop(String brand, int ram, int storage,  double batterySize) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.batterySize = batterySize;
    }
}
