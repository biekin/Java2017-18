package shape;

import javax.swing.*;
import java.awt.*;

public class Root extends JFrame {

    Root () {
        super();
        setSize(800,800);
        MyPanel drawPanel = new MyPanel();
        this.getContentPane().add(drawPanel);
       // drawPanel.paintComponents(this.getGraphics());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
