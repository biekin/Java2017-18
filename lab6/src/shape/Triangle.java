package shape;

import java.awt.*;

public class Triangle extends Shape {

    public Triangle(double h) {
        super();
        area=0.5*h*h;
        x=100; y= 100; height=40; width=40;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillPolygon(new int[]{this.x, this.x + this.width, x + width / 2},
                new int[]{this.y + height, this.y + height, this.y}, 3);
        this.setSize(this.width, this.height);
        this.setLocation(this.x, this.y);
    }
}
