package chap25enum;

enum Signal {
    GREEN, YELLOW, RED
}

public class TrafficLight {

    public static void main(String[] args) {
        Signal color = Signal.RED;
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.RED;
                break;
            case YELLOW:
                color = Signal.YELLOW;
                break;
        }
        System.out.println(color);
    }
}
