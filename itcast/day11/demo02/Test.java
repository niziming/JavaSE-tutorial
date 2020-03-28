package itcast.day11.demo02;

public class Test {
    public static void main(String[] args) {
        Weapon wp = new Weapon("屠龙", 99999);
        Armour armour = new Armour("麒麟甲", 10000);
        Role role = new Role();
        role.setAr(armour);
        role.setWp(wp);
        role.attack();
        role.wear();
    }
}
