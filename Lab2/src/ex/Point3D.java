package ex;

public class Point3D extends Point2D {
    double z_;

    public Point3D(double _x, double _y, double _z) {
        super(_x,_y);
        z_=_z;
    }

    public double GetZ() {
        return z_;
    }

    public void SetZ(double value) {
        z_=value;
    }

    public double Distance(Point3D another) {
        return Math.sqrt(Math.pow(x_-another.GetX(),2)+Math.pow(y_-another.GetY(),2)+Math.pow(z_-another.GetZ(),2));
    }

    public String toString(){
        return Double.toString(x_)+Double.toString(y_)+Double.toString(z_);
    }
}
