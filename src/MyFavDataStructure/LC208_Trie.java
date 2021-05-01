package MyFavDataStructure;

public class LC208_Trie {
    static class Trie {
        Node root;

        static class Node {
            Node[] children;
            boolean isWord;

            public Node() {
                isWord = false;
                children = new Node[26];
            }
        }

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                if (cur.children[ch] == null) {
                    cur.children[ch] = new Node();
                }
                cur = cur.children[ch];
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                cur = cur.children[word.charAt(i) - 'a'];
                if (cur == null) {
                    return false;
                }
            }
            return cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                cur = cur.children[prefix.charAt(i) - 'a'];
                if (cur == null) {
                    return false;
                }
            }
            return true;
        }
    }
}
