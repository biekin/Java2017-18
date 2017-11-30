package shape;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class MyPanel extends JPanel {

    private LinkedList<Shape> shapes_ = new LinkedList<>();
    MyPanel(){
        super();
        this.setBackground(Color.YELLOW);
        addShape(new Circle());
        addShape(new Triangle());
        addShape(new Square());
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Shape shape : shapes_) {
            shape.draw(graphics);
        }
    }

    public void addShape(Shape toAdd) {
        shapes_.add(toAdd);
        this.add(toAdd);
        MouseListener mouseListener = new MouseListener();
        toAdd.addMouseMotionListener(mouseListener);
        toAdd.addMouseListener(mouseListener);
    }

}
