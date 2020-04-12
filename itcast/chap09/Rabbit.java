package itcast.day09;

public class Rabbit extends Mammal {
    public void getType () {
        System.out.println("type=" + type);
    }

    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        rabbit.type = "liechi";
        rabbit.getType();
    }
}
