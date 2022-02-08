package Ex4_MyPoint;

public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(0,0);
        System.out.println("point1(x,y) = (" + point1.getX() + "," + point1.getY() +")");
        point1.setX(2);
        point1.setY(2);
        System.out.println("point1(x,y) = (" + point1.getX() + "," + point1.getY() +")");
        point1.setXY(3,3);
        System.out.println("point1(x,y) = (" + point1.getX() + "," + point1.getY() +")");
        System.out.println("Distance from point1 (" + point1.getX() + "," + point1.getY() +") to (0,0) is "
                + point1.distance(0,0));
        MyPoint point2 = new MyPoint(2,2);
        System.out.println("Distance from point1 (" + point1.getX() + "," + point1.getY() +") to point2("
                + point2.getX() + "," + point2.getY() + ")is " + point1.distanceToAnother(point2));
    }
}
