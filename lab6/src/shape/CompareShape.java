package shape;

import java.util.Comparator;

public class CompareShape implements Comparator<Shape>{
    @Override
    public int compare(Shape shape, Shape t1) {
        if (shape.area>t1.area) return 1;
        if (shape.area<t1.area) return -1;
        return 0;
    }
}
