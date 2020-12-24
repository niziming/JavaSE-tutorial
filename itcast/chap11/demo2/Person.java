package itcast.chap11.demo2;

public class Person {
    private boolean live = true;

    public static void main(String[] args) {
        Heart Heart = new Person().new Heart();
        Heart.jump();
        new Person().new Heart().jump();

        Person person = new Person();
        Person.Heart heart = person.new Heart();
        heart.jump();
        person.setLive(false);
        heart.jump();
    }

    class Heart {
        public void jump() {
            // 直接访问外部类成员
            if (live) {
                System.out.println("心脏在跳动");
            } else {
                System.out.println("心脏不跳了");
            }
        }
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
