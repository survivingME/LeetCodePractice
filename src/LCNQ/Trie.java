package LCNQ;

class Trie {
    class TrieNode {
        char val;
        TrieNode[] next;

        public TrieNode(char val) {
            this.val = val;
            next = new TrieNode[27];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if(cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new TrieNode(c);
            }
            cur = cur.next[c - 'a'];
        }
        if(cur.next[26] == null) cur.next[26] = new TrieNode('1');
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if(cur.next[c - 'a'] == null) return false;
            cur = cur.next[c - 'a'];
        }
        if(cur.next[26] == null) return false;
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if(cur.next[c - 'a'] == null) return false;
            cur = cur.next[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }
}