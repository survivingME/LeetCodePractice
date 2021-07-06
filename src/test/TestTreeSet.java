package test;

import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("ab");
        set.add("ba");
        set.add("cba");
        set.add("ccab");
        set.add("ca");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
