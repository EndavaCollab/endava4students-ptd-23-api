package fundamentals.inheritance;

public class Child extends Parent {
    private int age;

    public Child(String username, String email, int age) {
        super(username, email);

        this.age = age;
    }

    public void printUsernameAndEmail() {
        System.out.println("Username: " + super.getUsername() + ", Email: " + super.getEmail() );
    }
}
