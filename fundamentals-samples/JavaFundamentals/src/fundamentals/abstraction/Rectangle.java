package fundamentals.abstraction;

public class Rectangle extends Shape implements PolygonShape {

    double length;
    double width;

    public Rectangle(String color, double length,
                     double width) {
        // calling Shape constructor
        super(color);
        System.out.println("Rectangle constructor called");
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle color is " + super.getColor()
                + "and area is : " + area();
    }

    @Override
    public void calculatePerimeter(int length, int breadth) {
        System.out.println("The perimeter of the rectangle is " + (2 * (length * breadth)));
    }
}
