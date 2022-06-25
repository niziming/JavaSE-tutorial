package chap13.poker;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pocker pocker = new Pocker();
        ArrayList<String> pockerBox = pocker.getPockerBox();
        pocker.shuffle(pockerBox);
        Player player = new Player();
        player.licensing(pockerBox);
    }
}
