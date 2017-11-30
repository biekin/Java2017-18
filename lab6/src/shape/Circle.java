package shape;

import java.awt.*;

public class Circle extends Shape{
    public Circle() {
        super();
        width = 41;
        height = 41;
        x = 100;
        y = 100;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillOval(x, y, width, height);
        this.setSize(this.width, this.height);
        this.setLocation(this.x, this.y);
    }
}