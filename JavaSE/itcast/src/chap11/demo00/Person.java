package chap11.demo00;

public class Person {
    private boolean live = true;
    class Heart{
        private boolean live = false;
        public void jump () {
            System.out.println("this.live" + this.live);
            System.out.println("live" + live);
            if (live) {
                System.out.println("jump");
            } else {
                System.out.println("stop jump");
            }
        }
    }
    public boolean isAlive () {
        return live;
    }
    public void setLive (boolean live) {
        this.live = live;
    }
}
