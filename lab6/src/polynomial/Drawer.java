package polynomial;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.ArrayList;
import java.util.List;

public class Drawer{
    PolyDraw poly;
    List<Double> X = new ArrayList<>();
    List<Double> Y = new ArrayList<>();
    Double[] coeffs;
    Double min, max, samp;

    public Drawer(PolyDraw pd){
        poly=pd;
    }

    public void draw(){
        min=Double.parseDouble(poly.min.getText());
        max=Double.parseDouble(poly.max.getText());
        samp=Double.parseDouble(poly.sampling.getText());
        coeffs=arrToDouble(poly.coefficients.getText().split(" "));

    }

    private Double[] arrToDouble(String [] s){
        Double [] arr = new Double[s.length];
        for (int i=0; i<arr.length; i++){
            arr[i]=Double.parseDouble(s[i]);
        }
        return arr;
    }

    private void calculateX(){
        Double x = min;
        while (x<max){
            X.add(x);
            x=x+samp;
        }
        X.add(max);
    }

    private void calculateY(){
        for (Double x : X){
            Double y = 0.;
            for (int i=0; i<coeffs.length; i++){
                y+=coeffs[i]*Math.pow(x, i);
            }
            Y.add(y);
        }
    }
}