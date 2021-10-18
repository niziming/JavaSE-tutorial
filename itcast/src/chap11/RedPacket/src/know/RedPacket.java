package chap11.RedPacket.src.know;

import java.util.ArrayList;

public class RedPacket extends RedPacketFrame implements OpenMode {
    int totalMoney;
    int count;

    public RedPacket(int totalMoney, int count) {
        this.totalMoney = totalMoney;
        this.count = count;
    }
    public RedPacket() {
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public int getCount() {
        return count;
    }

    @Override
    public ArrayList<Integer> divide() {
        return null;
    }
}
