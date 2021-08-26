package LCNQ;

import java.util.Arrays;

public class LC881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int res = 0;
        while(l < r) {
            if(people[l] + people[r] <= limit) {
                l++;
                r--;
                res += 1;
            } else {
                res += 1;
                r--;
            }
        }
        if(l == r) res++;
        return res;
    }
}
