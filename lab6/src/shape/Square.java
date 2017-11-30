package shape;

import java.awt.*;

public class Square extends Shape {

    public Square () {
        super();
        width = 80;
        height = 80;
        x = 200;
        y = 200;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(this.x, this.y, this.width, this.height);
        this.setSize(this.width, this.height);
        this.setLocation(this.x, this.y);
    }
}