package MSNQ;

import java.util.*;

public class MS1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (map.containsKey(key)) map.get(key).add(str);
            else {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> res = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) res.add(entry.getValue());
        return res;
    }
}
