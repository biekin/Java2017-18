package shape;

import java.util.LinkedList;
import java.util.Collections;

public class ShapeList {

    private LinkedList<Shape> list_;

    public ShapeList(){}

    public void PushBack(Shape value) {
        list_.addLast(value);

    }

    public void Sort() {
        Collections.sort(list_, new CompareShape());
    }
}
