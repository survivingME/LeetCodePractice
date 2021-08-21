package LCNQ;

public class LC541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int cur = 0, left = cur;
        while(cur < arr.length) {
            if(cur > 0 && cur % (2 * k) == 0) {
                int right = left + k - 1;
                while(left < right) {
                    char tmp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = tmp;
                    left++;
                    right--;
                }
                left = cur;
            }
            cur++;
        }
        int right = left + k - 1 >= arr.length ? arr.length - 1 : left + k - 1;
        while(left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(new LC541().reverseStr(str, 8));
    }
}
