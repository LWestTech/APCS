import java.util.ArrayList;

public class Polygon {
    private ArrayList<Point> vertices;

    public Polygon()
    {
        vertices = new ArrayList<Point>();
    }

    public void add(Point p)
    {
        vertices.add(p);
    }

    public static double triangleArea(Point p1, Point p2, Point p3)
    {
        double a1 = p1.getX() * p2.getY();
        double a2 = p2.getX() * p3.getY();
        double a3 = p3.getX() * p1.getY();
        double b1 = p1.getY() * p2.getX();
        double b2 = p2.getY() * p3.getX();
        double b3 = p3.getY() * p1.getX();

        return Math.abs(a1 + a2 + a3 - b1 - b2 - b3) / 2;
    }

    public double getArea() 
    {
        if (vertices.size() < 3) {return 0;}

        Polygon polygon = new Polygon();
        
        for (int i = 0; i < vertices.size() - 1; i++) {polygon.add(vertices.get(i));}

        Point a = vertices.get(0);
        Point b = vertices.get(vertices.size() - 1);
        Point c = vertices.get(vertices.size() - 2);

        return triangleArea(a,b,c) + polygon.getArea();
    }
}
