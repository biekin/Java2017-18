package shape;

public class Triangle extends Shape {

    public Triangle(double h) {
        area=0.5*h*h;
    }

    public void draw() {
        System.out.println("trojkat");
    }
}
