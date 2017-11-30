package shape;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Shape extends JComponent{
    protected String name;
    protected int x;
    protected int y;
    protected int height;
    protected int width;


    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public abstract void draw(Graphics graphics);

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void changePosition(int x, int y) {
        setX(x);
        setY(y);
    }


}