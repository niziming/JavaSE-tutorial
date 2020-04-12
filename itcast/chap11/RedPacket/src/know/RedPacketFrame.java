package itcast.day11.RedPacket.src.know;

import java.util.ArrayList;

public abstract class RedPacketFrame {
    public String ownerName = "群主";
    public OpenMode openMode = null;

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public void openRedPkt (RedPacket rp) {
        ArrayList<Integer> divide = rp.divide();
        System.out.println("群主: " + this.ownerName);
        String sn = rp.getClass().getSimpleName();
        System.out.println("红包类型: " + (sn.equalsIgnoreCase("Common") ? "普通红包" : "手气红包"));
        System.out.println("红包总金额: " + rp.totalMoney);
        System.out.println("领取总人数: " + rp.count);
        System.out.println("发放结果:" + divide);
        System.out.println("**********************************");
    }
}
