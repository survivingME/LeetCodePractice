package LCNQ;

public class LC978 {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length, res = 1;
        int l = 0, r = 0;
        while(r < len - 1) {
            if(l == r) {
                if(arr[l] == arr[l + 1]) l++;
                r++;
            } else {
                if((arr[r - 1] < arr[r] && arr[r] > arr[r + 1]) ||
                        (arr[r - 1] > arr[r] && arr[r] < arr[r + 1])) r++;
                else {
                    l = r;
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {100,100,100};
        System.out.println(new LC978().maxTurbulenceSize(arr));
    }
}

