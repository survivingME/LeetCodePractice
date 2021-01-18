package newquestion;

import java.util.*;

public class LC721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //email2idx：并查集中序号与email对应，email2u：email与账户对应
        Map<String, Integer> email2idx = new HashMap<>();
        Map<String, String> email2u = new HashMap<>();
        int count = 0;
        //构建并查集序号与email对应关系
        for (List<String> account : accounts) {
            String u = account.get(0);
            int size = account.size();
            for(int i = 1;i < size;i++) {
                String email = account.get(i);
                if(!email2idx.containsKey(email)) {
                    email2idx.put(email, count++);
                    email2u.put(email, u);
                }
            }
        }
        int[] parent = new int[count];
        for(int i = 0;i < count;i++) parent[i] = i;
        //对email的归属进行合并
        for(List<String> account : accounts) {
            String femail = account.get(1);
            int findex = email2idx.get(femail);
            int size = account.size();
            for(int i = 2;i < size;i++) {
                String cemail = account.get(i);
                int cindex = email2idx.get(cemail);
                union(parent, findex, cindex);
            }
        }
        //构建相同归属的email列表
        Map<Integer, List<String>> idx2emails = new HashMap<>();
        for (String email : email2idx.keySet()) {
            int idx = find(parent, email2idx.get(email));
            List<String> account = idx2emails.getOrDefault(idx, new ArrayList<String>());
            account.add(email);
            idx2emails.put(idx, account);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        //构建最终结果
        for (List<String> emails : idx2emails.values()) {
            Collections.sort(emails);
            String u = email2u.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(u);
            account.addAll(emails);
            res.add(account);
        }
        return res;
    }

    public int find(int[] parent, int index) {
        if(parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index2)] = find(parent, index1);
    }
}
