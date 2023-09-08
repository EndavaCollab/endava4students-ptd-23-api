package fundamentals.encapsulation;

public class Student {
    private String name;
    private String phone;

    public Student() {

    }

    public Student(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void setName(String name) {
        if(name.equals("")) {
            System.out.println("Name invalid!");
        } else{
            this.name = name;
        }
    }

    public String getName() {
        if(this.name == null) {
            return "";
        }

        return this.name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }
}
