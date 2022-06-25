package chap11.demo5;

public class Role implements Magic {
    Magic m;

    public Magic getM() {
        return m;
    }

    public void setM(Magic m) {
        this.m = m;
    }

    @Override
    public void Attack() {
        System.out.println("发动攻击");
        m.Attack();
        System.out.println("完毕");
    }

    public static void main(String[] args) {
        Role role = new Role();
        role.setM(new Magic() {
            @Override
            public void Attack() {
                System.out.println("魔法攻击1");
            }
        });
        role.Attack();

        role.setM(new Magic() {
            @Override
            public void Attack() {
                System.out.println("魔法攻击2");
            }
        });
        role.Attack();
    }
}
