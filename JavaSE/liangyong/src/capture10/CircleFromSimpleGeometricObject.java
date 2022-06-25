package capture10;

public class CircleFromSimpleGeometricObject extends SimpleGeometricObject {
    private double radius;
    private double area;
    final double PI = 3.1415926;

    public CircleFromSimpleGeometricObject(){}

    public CircleFromSimpleGeometricObject(double radius){
        this.radius = radius;
    }

    public CircleFromSimpleGeometricObject(String color, boolean filled, double radius) {
        area = radius*radius*PI;
        this.radius = radius;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = radius*radius*PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "liangyong.capture10.CircleFromSimpleGeometricObject{" +
                "The circle is created=" + getDateCreated() +
                ", radius=" + radius +
                ", area=" + area +
                '}';
    }
}
