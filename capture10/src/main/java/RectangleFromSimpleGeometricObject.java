public class RectangleFromSimpleGeometricObject extends SimpleGeometricObject {
    private double width;
    private double height;
    private double area;

    public RectangleFromSimpleGeometricObject() {
        this.area = width * height;
    }

    public RectangleFromSimpleGeometricObject(double width, double height) {
        this.area = width * height;
        this.width = width;
        this.height = height;
    }

    public RectangleFromSimpleGeometricObject(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.area = width * height;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "RectangleFromSimpleGeometricObject{" +
                "width=" + width +
                ", height=" + height +
                ", CreateDate=" + getDateCreated() +
                ", area=" + area +
                '}';
    }
}
