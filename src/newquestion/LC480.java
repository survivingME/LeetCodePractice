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
            makeInvalid(x);
            balance();
            removeTop();
        }

        public double getMedian() {
            switch (smallSize - bigSize) {
                case -1 :   return big.peek();
                case 0  :   return ((double)small.peek() + (double)big.peek()) / 2;
                case 1  :   return small.peek();
                default :   return 0;
            }
        }


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

        public void makeInvalid(int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if(x <= small.peek()) {
                smallSize--;
            } else {
                bigSize--;
            }
        }

        public void removeTop() {
            while(!small.isEmpty() && map.containsKey(small.peek())) {
                decrease(small.poll());
            }
            while(!big.isEmpty() && map.containsKey(big.peek())) {
                decrease(big.poll());
            }
        }

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
