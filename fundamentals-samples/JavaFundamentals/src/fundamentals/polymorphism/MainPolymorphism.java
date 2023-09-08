package fundamentals.polymorphism;

public class MainPolymorphism {
    // OVERLOAD => it does not allow to have several methods with the same name but with a
    //             different number and type of parameters or the order of the parameters
    //             to be different

    // OVERRIDE => allows us to override a method from the parent class in the child class,
    //             that is, we can change the functionality of a method

    public static void main(String[] args) {
        Animal animal = new Animal("rex");
        animal.makeSound();

        Dog dog = new Dog("Dog", "woof");
        dog.makeSound();


    }
}
