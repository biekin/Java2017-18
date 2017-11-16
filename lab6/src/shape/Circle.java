package shape;

import java.awt.*;

public class Circle extends Shape{

    public Circle(double r) {
        super();
        area=3.14*r*r;
        x=200; y= 200; height=40; width=40;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillOval(this.x, this.y, this.width, this.height);
        this.setSize(this.width, this.height);
        this.setLocation(this.x, this.y);
    }
}