package chap14.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ComparatorUsed {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("cba");
        list.add("aba");
        list.add("sba");
        list.add("nba");

        Collections.sort(list);
        System.out.println(list);
    }
}
