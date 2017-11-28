package shape;

import java.awt.*;

public class Circle extends Shape{

    public Circle(double r) {
        super();
        area=5;
        x=200; y= 200; height=40; width=40;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillOval(100, 100, 100, 100);

    }
}