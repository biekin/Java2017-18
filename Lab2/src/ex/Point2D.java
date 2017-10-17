package ex;

public class Point2D {
    double x_, y_;

    public Point2D(double _x, double _y) {
        x_=_x;
        y_=_y;
    }

    public double GetX() {
        return x_;
    }

    public double GetY() {
        return y_;
    }

    public void SetX(double value) {
        x_=value;
    }

    public void SetY(double value) {
        y_=value;
    }

    public double Distance(Point2D another) {
        return Math.sqrt(Math.pow(x_-another.GetX(),2)+Math.pow(y_-another.GetY(),2));
    }
}
