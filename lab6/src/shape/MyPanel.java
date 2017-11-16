package shape;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class MyPanel extends JPanel {

    private LinkedList<Shape> shapes_ = new LinkedList<>();

    MyPanel(){
        super();
        setBackground(Color.YELLOW);
        shapes_.add(new Circle(5));
        shapes_.add(new Triangle(3));
        shapes_.add(new Square(4));
        this.add(shapes_.get(0));
        this.add(shapes_.get(1));
        this.add(shapes_.get(2));
    }

    @Override
    public void paintComponents(Graphics graphics) {
        super.paintComponents(graphics);
        for (Shape shape : shapes_) {
            shape.draw(graphics);
        }
    }
}
