package itcast.day06;

public class Car {
    private String color;

    public Car() {}

    public Car(String color) {
        this.color = color;
    }

    public void drive () {
        int speed = 80;
        System.out.println("速度" + speed);
        System.out.println("颜色" + color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
