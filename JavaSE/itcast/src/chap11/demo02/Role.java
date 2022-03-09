package chap11.demo02;

public class Role {
    int id;
    int blood;
    String name;
    Weapon wp;
    Armour ar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWp() {
        return wp;
    }

    public void setWp(Weapon wp) {
        this.wp = wp;
    }

    public Armour getAr() {
        return ar;
    }

    public void setAr(Armour ar) {
        this.ar = ar;
    }
    public void attack () {
        System.out.println("使用 " + wp.getName() + ", 造成 " + wp.getHurt() + "点伤害");
    }
    public void wear () {
        this.blood += ar.getProtect();
        System.out.println("穿上 " + ar.getName() + ", 生命增加" + ar.getProtect() + "点生命");
    }
}
