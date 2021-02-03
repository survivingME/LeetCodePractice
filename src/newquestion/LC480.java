package newquestion;

import java.util.*;

public class LC480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianWindow medianWindow = new MedianWindow();
        List<Double> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            medianWindow.add(nums[i]);
        }
        ans.add(medianWindow.getMedian());
        for (int i = k, len = nums.length; i < len; ++i) {
            medianWindow.add(nums[i]);
            medianWindow.remove(nums[i - k]);
            ans.add(medianWindow.getMedian());
        }
        return ans.stream().mapToDouble(i -> i).toArray();
    }
    class MedianWindow {
        PriorityQueue<Integer> small, big;
        Map<Integer, Integer> map;
        int smallSize, bigSize;

        public MedianWindow() {
            small = new PriorityQueue<>(Comparator.reverseOrder());
            big = new PriorityQueue<>(Comparator.naturalOrder());
            map = new HashMap<>();
            smallSize = 0;
            bigSize = 0;
        }

        public void add(int x) {
            //初始状态下把数添加到big中
            if(smallSize == 0 || x > small.peek()) {
                big.add(x);
                bigSize++;
            } else {
                small.add(x);
                smallSize++;
            }
            balance();
            removeTop();
        }

        public void remove(int x) {
            markInvalid(x);
            balance();
            removeTop();
        }
        /**
         * 取中位数，big是存较大数的小顶堆，small是存较小数的大顶堆
         * 比较两堆size，根据条件得到中位数
         */
        public double getMedian() {
            switch (smallSize - bigSize) {
                case -1 :   return big.peek();
                case 0  :   return ((double)small.peek() + (double)big.peek()) / 2;
                case 1  :   return small.peek();
                default :   return 0;
            }
        }
        //做平衡
        public void balance() {
            while(smallSize - bigSize > 1) {
                smallSize--;
                bigSize++;
                big.add(small.poll());
            }
            while(bigSize - smallSize > 1) {
                smallSize++;
                bigSize--;
                small.add(big.poll());
            }
        }
        //标记删除
        public void markInvalid(int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if(x <= small.peek()) {
                smallSize--;
            } else {
                bigSize--;
            }
        }
        //对两堆顶判定是否需要删除
        public void removeTop() {
            while(!small.isEmpty() && map.containsKey(small.peek())) {
                decrease(small.poll());
            }
            while(!big.isEmpty() && map.containsKey(big.peek())) {
                decrease(big.poll());
            }
        }
        //map中同步数据
        public void decrease(int x) {
            int num = map.get(x);
            if(num == 1) {
                map.remove(x);
            } else {
                map.put(x, num - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        new LC480().medianSlidingWindow(arr, 3);
    }
}
