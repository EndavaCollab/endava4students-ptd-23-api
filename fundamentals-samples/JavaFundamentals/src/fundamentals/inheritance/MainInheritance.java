package fundamentals.inheritance;

public class MainInheritance {
    public static void main(String[] args) {
        Child child1 = new Child("dev.senior", "senior@endava.com", 10);
        child1.printUsernameAndEmail();

        child1.setUsername("junior.senior");

        child1.printUsernameAndEmail();

        Parent parent1 = new Parent("popescu", "mihai@gmail.com");
    }
}
