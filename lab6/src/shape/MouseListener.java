package shape;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class MouseListener extends MouseAdapter {
    private Point beginingPoint;

    public void mousePressed(MouseEvent event) {
        beginingPoint = event.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        Shape currentShape = (Shape) event.getComponent();
        int new_x = currentShape.getX() + event.getX() - beginingPoint.x;
        int new_y = currentShape.getY() + event.getY() - beginingPoint.y;
        currentShape.changePosition(new_x, new_y);
        currentShape.repaint();
    }
}