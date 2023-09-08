package fundamentals.encapsulation;

public class MainEncapsulation {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Java Developer");
        student1.setPhone("0700737373");

        System.out.println("Name: " + student1.getName());
        System.out.println("Phone: " + student1.getPhone());

        System.out.println("--------------------");

        Student student2 = new Student("Python Developer", "0750123213");
        System.out.println("Name: " + student2.getName());
        System.out.println("Phone: " + student2.getPhone());

        System.out.println("--------------------");

        student2.setName("");
        System.out.println("Name: " + student2.getName());
    }
}
