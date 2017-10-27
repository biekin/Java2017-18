package shape;

public class Circle extends Shape{

    public Circle(double r) {
        area=3.14*r*r;
    }

    public void draw() {
        System.out.println("   *");
        System.out.println("  * *");
        System.out.println(" *   *");
        System.out.println(" *   *");
        System.out.println("  * *");
        System.out.println("   *");
    }
}
