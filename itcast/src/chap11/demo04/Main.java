package chap11.demo04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= 20; i++) {
            arrayList.add(i);
        }
        List eventNum = getEventNum(arrayList);
        System.out.println(eventNum);
    }
    public static List<Integer> getEventNum(List<Integer> list) {
        ArrayList eventList = new ArrayList();
        for (Integer a: list) {
            if (a % 2 == 0){
                eventList.add(a);
            }
        }
        return eventList;
    }
}
