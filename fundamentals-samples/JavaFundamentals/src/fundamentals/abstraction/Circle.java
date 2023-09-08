package fundamentals.abstraction;

public class Circle extends Shape implements PolygonShape {
    double radius;

    public Circle(String color, double radius)
    {

        // calling Shape constructor
        super(color);
        System.out.println("Circle constructor called");
        this.radius = radius;
    }

    @Override double area()
    {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void calculatePerimeter(int length, int breadth) {
        System.out.println("The perimeter of the circle is: " + 2 * Math.PI * radius);
    }

    @Override public String toString()
    {
        return "Circle color is " + super.getColor()
                + "and area is : " + area();
    }
}
