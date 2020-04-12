package itcast.day13.poker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Pocker {
    private ArrayList<String> pockerBox = new ArrayList<>();
    private ArrayList<String> colors = new ArrayList<>();
    private ArrayList<String> numbers = new ArrayList<>();

    private ArrayList<String> getColors() {
        colors.add("♥");
        colors.add("♦");
        colors.add("♠");
        colors.add("♣");
        return colors;
    }

    private ArrayList<String> getNumbers() {
        for (int i = 2; i <= 10; i++) {
            numbers.add(i+"");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");
        return numbers;
    }

    public ArrayList<String> getPockerBox() {
        getColors();
        getNumbers();
        for (String color : colors) {
            for (String num : numbers) {
                String card = color + num;
                pockerBox.add(card);
            }
        }
        pockerBox.add("joker");
        pockerBox.add("JOKER");
        return pockerBox;
    }
    public void shuffle(ArrayList<?> list){
        Collections.shuffle(list);
    }
}
