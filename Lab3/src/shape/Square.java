package shape;

public class Square extends Shape {

    public Square (double a) {
        area=a*a;
    }

    public void draw() {
        System.out.println("*****");
        System.out.println("*****");
        System.out.println("*****");
        System.out.println("*****");
        System.out.println("*****");
        System.out.println("*****");
    }
}
