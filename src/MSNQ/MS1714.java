package MSNQ;

import java.util.PriorityQueue;

public class MS1714 {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if(k == 0) return res;
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int num : arr) {
            if(que.size() < k) que.add(num);
            else {
                if(que.peek() > num) {
                    que.poll();
                    que.add(num);
                }
            }
        }
        for(int i = 0;i < k;i++) res[i] = que.poll();
        return res;
    }
}
