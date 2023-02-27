public class Main {
    public static void main(String[] args) {
        Polygon polygon = new Polygon();
        polygon.add(new Point(0, 2));
        polygon.add(new Point(2, 0));
        polygon.add(new Point(0, -2));
        polygon.add(new Point(-2, 0));

        System.out.println(polygon.getArea());
    }
}
