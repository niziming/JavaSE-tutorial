package itcast.day11.RedPacket.src.know;

public class Main {
    public static void main(String[] args) {
        RedPacket rp = new RedPacket();
        rp.setOwnerName("我是群主");
        Common c = new Common(200, 17);
        Lucky lucky = new Lucky(150, 10);
        rp.openRedPkt(c);
        rp.openRedPkt(lucky);
    }
}
