package polynomial;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Drawer{
    PolyDraw poly;
    List<Double> X = new ArrayList<>();
    List<Double> X_draw = new ArrayList<>();
    List<Double> Y = new ArrayList<>();
    List<Double> Y_draw = new ArrayList<>();
    Double[] coeffs;
    Double x_min, x_max, samp, y_min, y_max;

    public Drawer(PolyDraw pd){
        poly=pd;
    }

    public void draw(){
        x_min =Double.parseDouble(poly.min.getText());
        x_max =Double.parseDouble(poly.max.getText());
        samp=Double.parseDouble(poly.sampling.getText());
        coeffs=arrToDouble(poly.coefficients.getText().split(" "));
        calculateX();
        calculateY();

        GraphicsContext gc = poly.plot.getGraphicsContext2D();

        gc.setLineWidth(1.0);

        for (int i=0; i<X.size(); i++){
            gc.fillOval(X_draw.get(i), Y_draw.get(i), 2, 2);
            if(i!=X.size()-1) gc.strokeLine(X_draw.get(i)+1, Y_draw.get(i)+1, X_draw.get(i+1)+1, Y_draw.get(i+1)+1);
        }

    }

    private Double[] arrToDouble(String [] s){
        Double [] arr = new Double[s.length];
        for (int i=0; i<arr.length; i++){
            arr[i]=Double.parseDouble(s[i]);
        }
        return arr;
    }

    private void calculateX(){
        Double x = x_min;
        while (x< x_max){
            X.add(x);
            x=x+samp;
        }
        X.add(x_max);

        Double delta_x=x_max-x_min;

        for (Double el :X){
            X_draw.add(((el-x_min)/delta_x)*600);
        }
    }

    private void calculateY(){
        y_min=10000000.;
        y_max=-10000000.;
        for (Double x : X){
            Double y = 0.;
            for (int i=0; i<coeffs.length; i++){
                y+=coeffs[i]*Math.pow(x, i);
            }
            if(y<y_min) y_min=y;
            else if (y>y_max) y_max=y;
            Y.add(y);
        }

        Double delta_y=y_max-y_min;
        if(delta_y==0) delta_y=1.;

        for (Double el :Y){
            Y_draw.add((1-((el-y_min)/delta_y))*300-3);
        }
    }
}