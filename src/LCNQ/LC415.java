package LCNQ;

public class LC415 {
    public String addStrings(String num1, String num2) {
        char[] charArray1 = num1.toCharArray();
        char[] charArray2 = num2.toCharArray();
        int len1 = charArray1.length - 1, len2 = charArray2.length - 1;
        StringBuilder sb = new StringBuilder();
        int jin = 0;
        while(len1 >= 0 && len2 >= 0) {
            int sum = charArray1[len1--] - '0' + charArray2[len2--] - '0' + jin;
            jin = sum / 10;
            sum %= 10;
            sb.append(sum);
        }
        while(len1 >= 0) {
            int sum = charArray1[len1--] - '0' + jin;
            jin = sum / 10;
            sum %= 10;
            sb.append(sum);
        }
        while(len2 >= 0) {
            int sum = charArray2[len2--] - '0' + jin;
            jin = sum / 10;
            sum %= 10;
            sb.append(sum);
        }
        if(jin > 0) sb.append(jin);
        return sb.reverse().toString();
    }
}
