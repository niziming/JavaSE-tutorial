package chap11.RedPacket.src.know;

import java.util.ArrayList;

public class Lucky extends RedPacket {
    public Lucky(int totalMoney, int count) {
        super(totalMoney, count);
    }

    @Override
    public ArrayList<Integer> divide() {
        ArrayList list = new ArrayList();
        Double min = 4.0;
        int time = count - 1;
        for (int i = 0; i < time; i++) {
            Double max = totalMoney * 2.0 / count;
            double money = (Double) min * Math.random() * (max - min);
            list.add(money);
            totalMoney -= money;
        }
        list.add(totalMoney);
        return list;
    }
}
