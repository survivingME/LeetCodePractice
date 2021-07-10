package LCNQ;

import java.util.ArrayList;
import java.util.HashMap;

class TimeMap {
    HashMap<String, ArrayList<TimeNode>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        ArrayList<TimeNode> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new TimeNode(value, timestamp));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            ArrayList<TimeNode> list = map.get(key);if(list.get(0).timestamp > timestamp) return "";
            if(list.get(list.size() - 1).timestamp <= timestamp) return list.get(list.size() - 1).value;
            int l = 0, r = list.size() - 1;
            while(l < r) {
                int mid = (l + r) / 2;
                TimeNode node = list.get(mid);
                if(node.timestamp == timestamp) return node.value;
                else if(node.timestamp > timestamp) l = mid;
                else r = mid;
            }
            return list.get(l).value;
        }
        return "";
    }

    class TimeNode {
        public String value;
        public int timestamp;
        public TimeNode(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }


    public static void main(String[] args) {
        TimeMap map = new TimeMap();
        map.set("love", "high", 10);
        map.set("love", "low", 20);
        System.out.println(map.get("love", 5));
        System.out.println(map.get("love", 10));
        System.out.println(map.get("love", 15));
        System.out.println(map.get("love", 20));
        System.out.println(map.get("love", 25));
    }
}
