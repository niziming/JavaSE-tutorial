package chap11.RedPacket.src.know;

import java.util.ArrayList;

public class Common extends RedPacket{
    public Common(int totalMoney, int count) {
        super(totalMoney, count);
    }
    @Override
    public ArrayList<Integer> divide() {
        ArrayList<Integer> list = new ArrayList<>();
        int time = count - 1;
        int money = totalMoney / count;
        for (int i = 0; i < time; i++) {
            list.add(money);
            totalMoney -= money;
        }
        list.add(totalMoney);
        return list;
    }
}
