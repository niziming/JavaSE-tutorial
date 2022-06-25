package chap13.poker;

import java.util.ArrayList;

public class Player {
    ArrayList<String> player3 = new ArrayList();
    ArrayList<String> player1 = new ArrayList();
    ArrayList<String> player2 = new ArrayList();
    ArrayList<String> dipai = new ArrayList();
    public void licensing(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++) {
            String card = list.get(i);
            if (i >= 51) {
                dipai.add(card);
            } else {
                if (i%3==0) {
                    player1.add(card);
                } else if (i%3==1) {
                    player2.add(card);
                } else {
                    player3.add(card);
                }
            }
        }
        System.out.println("player1" + player1);
        System.out.println("player2" + player2);
        System.out.println("player3" + player3);
        System.out.println("底牌" + dipai);
    }
}
