package fundamentals.polymorphism;

public class Dog extends Animal {
    private String sound;

    public Dog(String name, String sound) {
        super(name);

        this.sound = sound;
    }

    @Override
    public void makeSound() {
        System.out.println("------------");
        super.makeSound();

        System.out.println("Clasa dog");

        System.out.println(sound + ", " + sound);
    }

    public void stay() {
        System.out.println("Stay");
    }

}