package chap11.demo4;

// 引用类型用法总
public class Role {
    int id; // 角色id
    int blood; // 生命值
    String name; // 角色名称
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

    // 攻击方法
    public void attack() {
        System.out.println("使用" + wp.getName() + ", 造成" + wp.getHurt() + "点伤害");
    }

    // 穿戴盔甲
    public void wear() {
        // 增加防御,就是增加blood值
        this.blood += ar.getProtect();
        System.out.println("穿上" + ar.getName() + ", 生命值增加" + ar.getProtect());
    }

    public static void main(String[] args) {
        Weapon weapon = new Weapon("屠龙", 9999);
        Armour armour = new Armour("麒麟甲", 2000);
        Role role = new Role();
        role.setWp(weapon);
        role.setAr(armour);
        role.attack();
        role.wear();
    }
}
