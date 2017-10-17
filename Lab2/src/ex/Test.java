package ex;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Test {
    public static void main(String[] args) {
        LinkedList<Point3D> points = new LinkedList<Point3D>();
        int whattodo=0;
        while (whattodo!=4) {
            Scanner in = new Scanner(System.in);
            whattodo = in.nextInt();
            switch (whattodo) {
                case 1: { //wczytaj punkt
                    double x = in.nextInt();
                    double y = in.nextInt();
                    double z = in.nextInt();
                    points.addLast(new Point3D(x,y,z));
                    break;
                }
                case 2: { //wyswietl wszystkie punkty
                    System.out.println(points.toString());
                    break;
                }

                case 3: { //oblicz odl
                    int a = in.nextInt();
                    int b = in.nextInt();
                    double distance = points.get(a).Distance(points.get(b));
                    System.out.println(distance);
                    break;
                }
            }

        }
    }
}
