package newquestion;

public class LC643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0;i < k;i++) sum += nums[i];
        double avg = sum * 1.0 / k;
        for(int i = k;i < nums.length;i++) {
            sum -= nums[i - k];
            sum += nums[i];
            avg = Math.max(avg, sum * 1.0 / k);
        }
        return avg;
    }
}
