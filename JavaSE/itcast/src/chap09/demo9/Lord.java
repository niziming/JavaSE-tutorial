package chap09.demo9;

public class Lord extends User {
    public Lord(String name, int money) {
        this.name = name;
        this.money = money;
    }

    @Override
    void sendRedPkg(int amount) {
        this.money -= amount;
        System.out.println("发红包后余额" + this.money);
    }

    @Override
    void recRedPkg(int amount, int peopleNum) {
        this.money += amount/ peopleNum;
        System.out.println("收红包后余额" + this.money);
    }

    @Override
    public String toString() {
        return "Lord{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
