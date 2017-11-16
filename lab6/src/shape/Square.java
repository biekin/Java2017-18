package shape;

import java.awt.*;

public class Square extends Shape {

    public Square (double a) {
        super();
        x=10; y= 10; height=40; width=40;
        area=a*a;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(this.x, this.y, this.width, this.height);
        this.setSize(this.width, this.height);
        this.setLocation(this.x, this.y);
    }
}
