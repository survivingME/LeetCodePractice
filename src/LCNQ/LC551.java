package LCNQ;

public class LC551 {
    public boolean checkRecord(String s) {
        int anum = 0, cnum = 0;
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == 'A') {
                anum++;
                if(anum > 1) return false;
            } else if(s.charAt(i) == 'L') {
                if(cnum >= 2 && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') return false;
                cnum++;
            }
        }
        return true;
    }
}
