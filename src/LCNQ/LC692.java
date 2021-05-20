package LCNQ;

import sun.awt.image.ImageWatched;

import java.util.*;

public class LC692 {
    /**
     * ["i", "love", "leetcode", "i", "love", "coding"]
     * "i": 2, "love" : 2, "coding" : 1, "leetcode" : 1 小顶堆要保持逆序，因此单词比较时为结果的反
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        PriorityQueue<Map.Entry<String ,Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if(queue.size() > k) queue.poll();
        }
        List<String> res = new LinkedList<>();
        while(!queue.isEmpty()) {
            res.add(queue.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }

}
