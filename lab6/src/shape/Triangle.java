package shape;

import java.awt.*;

public class Triangle extends Shape {

    public Triangle() {
        width = 37;
        height = 37;
        x = 30;
        y = 30;
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