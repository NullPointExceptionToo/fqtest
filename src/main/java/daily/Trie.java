package daily;

/**
 * 前缀树
 */
public class Trie {
    private class TrieNode{
        TrieNode[] next;
        boolean isEnd;
        public TrieNode(){
            next = new TrieNode[26];
            isEnd = false;
        }
    }
    private TrieNode node;
    public Trie(){
        node = new TrieNode();
    }
    public static void main(String[] args) {
        Trie tree = new Trie();
        tree.insert("apple");
        tree.insert("pig");
        tree.insert("apples");
        tree.insert("dog");
        System.out.println(tree.search("apple"));
        System.out.println(tree.search("app"));
        System.out.println(tree.startWith("app"));
    }
    public void insert(String str){
        TrieNode cur = node;
        for(int i=0;i<str.length();i++) {
            if(cur.next[str.charAt(i)-'a'] == null) {
                cur.next[str.charAt(i)-'a'] = new TrieNode();
            }
            cur = cur.next[str.charAt(i)-'a'];
        }
        cur.isEnd = true;
    }
    public boolean search(String str) {
        TrieNode cur = node;
        for(int i=0;i<str.length();i++) {
            if(cur.next[str.charAt(i)-'a'] == null) {
                return false;
            }
            cur = cur.next[str.charAt(i)-'a'];
        }
        return cur.isEnd;

    }
    public boolean startWith(String str) {
        TrieNode cur = node;
        for(int i=0;i<str.length();i++) {
            if(cur.next[str.charAt(i)-'a'] == null) {
                return false;
            }
            cur = cur.next[str.charAt(i)-'a'];
        }
        return true;
    }


}
