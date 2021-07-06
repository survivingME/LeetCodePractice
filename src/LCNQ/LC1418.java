package LCNQ;

import java.util.*;

public class LC1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<String, List<String>> tableMap = new TreeMap<>((o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2));
        TreeSet<String> foodColumn = new TreeSet<>();
        for (List<String> order : orders) {
            String food = order.get(2);
            foodColumn.add(food);
            String tableStr = order.get(1);
            List<String> foodList = tableMap.getOrDefault(order.get(1), new LinkedList<>());
            foodList.add(food);
            tableMap.put(tableStr, foodList);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> tableHead = new LinkedList<>();
        tableHead.add("Table");
        HashMap<String, Integer> foodToCol = new HashMap<>();
        int cur = 1;
        for (String food : foodColumn) {
            tableHead.add(food);
            foodToCol.put(food, cur++);
        }
        res.add(tableHead);
        for (Map.Entry<String, List<String>> entry : tableMap.entrySet()) {
            List<String> rowList = new ArrayList<>();
            rowList.add(entry.getKey());
            for(int i = 0;i < foodColumn.size();i++) rowList.add("0");
            for (String food : entry.getValue()) {
                Integer idx = foodToCol.get(food);
                int old = Integer.parseInt(rowList.get(idx));
                rowList.set(idx, String.valueOf(old + 1));
            }
            res.add(rowList);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> orders = new LinkedList<>();
        List<String> tableHead = new LinkedList<>(Arrays.asList("David","3","Ceviche"));
        orders.add(tableHead);
        List<String> col1 = new LinkedList<>(Arrays.asList("Corina","10","Beef Burrito"));
        List<String> col2 = new LinkedList<>(Arrays.asList("David","3","Fried Chicken"));
        List<String> col3 = new LinkedList<>(Arrays.asList("Carla","5","Water"));
        List<String> col4 = new LinkedList<>(Arrays.asList("Carla","5","Ceviche"));
        List<String> col5 = new LinkedList<>(Arrays.asList("Rous","3","Ceviche"));
        orders.add(col1);
        orders.add(col2);
        orders.add(col3);
        orders.add(col4);
        orders.add(col5);
        List<List<String>> table = new LC1418().displayTable(orders);
        System.out.println(table);
    }
}
