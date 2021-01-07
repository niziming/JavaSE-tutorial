package itcast.chap13.demo3;

public class MyGenericClass<MPV> {
    private MPV mvp;

    public MPV getMvp() {
        return mvp;
    }

    public void setMvp(MPV mvp) {
        this.mvp = mvp;
    }

    public MPV setMvp1(MPV mvp) {
        return mvp;
    }

    // Used
    public static void main(String[] args) {
        MyGenericClass mg = new MyGenericClass<>();
        mg.setMvp("hello");
        System.out.println(mg.getMvp().getClass().getName());

        MyGenericClass mg1 = new MyGenericClass();
        mg1.setMvp(1);

        System.out.println(mg1.getMvp().getClass().getName());


    }
}
