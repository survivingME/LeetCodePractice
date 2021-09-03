package LCNQ;

public class LC1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            int f = booking[0], l = booking[1], s = booking[2];
            res[f - 1] += s;
            res[l] -= s;
        }
        for(int i = 1;i < n;i++) res[i] += res[i - 1];
        return res;
    }
}
