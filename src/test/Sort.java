package test;

import java.util.Stack;

public class Sort {

    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length == 0) return ;
        int len = arr.length;
        for(int i = 0;i < len;i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return ;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if(left == right) return ;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int c = 0, c1 = left, c2 = mid + 1;
        while(c1 <= mid && c2 <= right) {
            tmp[c++] = arr[c1] < arr[c2] ? arr[c1++] : arr[c2++];
        }
        while(c1 <= mid) tmp[c++] = arr[c1++];
        while(c2 <= right) tmp[c++] = arr[c2++];
        System.arraycopy(tmp, 0, arr, left, tmp.length);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if(arr.length < 1) return ;
        int partition = partition(arr, start, end);
        if(partition > start) partition(arr, start, partition - 1);
        if(partition < end) partition(arr, partition + 1, end);
    }

    public static void quickSortU(int[] arr) {
        int start = 0, end = arr.length - 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        stack.push(start);
        while(!stack.isEmpty()) {
            int l = stack.pop(), r = stack.pop();
            int p = partition(arr, l, r);
            if(l < p) {
                stack.push(p - 1);
                stack.push(l);
            }
            if(r > p) {
                stack.push(r);
                stack.push(p + 1);
            }
        }
    }

    public static int partition(int[] arr, int start, int end) {
        if(start == end) return start;
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(arr, pivot, end);
        for(int i = start;i <= end;i++) {
            if(arr[i] <= arr[end]) {
                smallIndex++;
                if(i > smallIndex) swap(arr, i, smallIndex);
            }
        }
        return smallIndex;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 6, 4, 8, 10, 20, 17, 15, 19};
        quickSortU(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
