package LCNQ;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LC773 {
    int[] d = new int[]{-1, 0, 1, 0, -1};
    public int slidingPuzzle(int[][] board) {
        String end = "123450";
        String cur = boardToString(board);
        if(end.equals(cur)) return 0;
        ArrayDeque<String> q1 = new ArrayDeque<>();
        HashSet<String> seen = new HashSet<>();
        q1.add(cur);
        int step = 0;
        while(!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0;i < size;i++) {
                String curBoard = q1.poll();
                if(end.equals(curBoard)) return step;
                seen.add(curBoard);
                for (String nextBoard : getAll(curBoard)) if(!seen.contains(nextBoard)) q1.add(nextBoard);
            }
            step++;
        }
        return -1;
    }

    public List<String> getAll(String cur) {
        LinkedList<String> list = new LinkedList<>();
        char[] charArray = cur.toCharArray();
        int index = cur.indexOf("0");
        if(index >= 3) {
            charArray[index] = charArray[index - 3];
            charArray[index - 3] = '0';
            list.add(new String(charArray));
            charArray[index - 3] = charArray[index];
            charArray[index] = '0';
        }
        if(index < 3) {
            charArray[index] = charArray[index + 3];
            charArray[index + 3] = '0';
            list.add(new String(charArray));
            charArray[index + 3] = charArray[index];
            charArray[index] = '0';
        }
        if(index != 0 && index != 3) {
            charArray[index] = charArray[index - 1];
            charArray[index - 1] = '0';
            list.add(new String(charArray));
            charArray[index - 1] = charArray[index];
            charArray[index] = '0';
        }
        if(index != 2 && index != 5) {
            charArray[index] = charArray[index + 1];
            charArray[index + 1] = '0';
            list.add(new String(charArray));
        }
        return list;
    }

    public String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 2;i++) {
            for(int j = 0;j < 3;j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{1,2,3},{4,0,5}};
        System.out.println(new LC773().slidingPuzzle(board));
    }

    public List<String> getAllOld(String cur) {
        LinkedList<String> list = new LinkedList<>();
        int[][] curBoard = new int[2][3];
        int zx = 0, zy = 0;
        for(int i = 0;i < 2;i++) {
            for(int j = 0;j < 3;j++) {
                char c = cur.charAt(i * 3 + j);
                if(c == '0') {
                    zx = i;
                    zy = j;
                }
                curBoard[i][j] = c - '0';
            }
        }
        for(int i = 0;i < 4;i++) {
            int sx = zx + d[i], sy = zy + d[i + 1];
            if(sx >= 0 && sx < 2 && sy >=0 && sy < 3) {
                curBoard[zx][zy] = curBoard[sx][sy];
                curBoard[sx][sy] = 0;
                list.add(boardToString(curBoard));
                curBoard[sx][sy] = curBoard[zx][zy];
                curBoard[zx][zy] = 0;
            }
        }
        return list;
    }

}
