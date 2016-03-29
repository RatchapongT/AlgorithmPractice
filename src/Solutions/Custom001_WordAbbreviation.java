package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * File Name: Custom001_WordAbbreviation.java
 * User: Ratchapong T.
 * Date: 15-Mar-2016
 * Time: 10:08 PM
 */
public class Custom001_WordAbbreviation {

    class TrieNode {
        public int numOfChildren;
        public TrieNode[] children = new TrieNode[26];
    }

    public class Trie {
        public void insert(String word, TrieNode root) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (root.children[c - 'a'] == null) {
                    root.numOfChildren++;
                    root.children[c - 'a'] = new TrieNode();
                }
                root = root.children[c - 'a'];
            }
        }

        public String search(String word, TrieNode root) {
            TrieNode tmp = root;
            TrieNode node = tmp;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (tmp.numOfChildren > 1) node = tmp;
                if (i == word.length() - 1 && node == root) {
                    String compressed = "" + word.charAt(0) + word.length() + word.charAt(word.length() - 1);
                    if (compressed.length() >= word.length()) return word;
                    else return compressed;
                }
                tmp = tmp.children[c - 'a'];
            }


            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (root != node) {
                    sb.append(c);
                    root = root.children[c - 'a'];
                } else {
                    sb.append(c);
                    break;
                }
            }
            String compressed = sb.toString() + word.length() + word.charAt(word.length() - 1);

            return compressed.length() >= word.length() ? word : compressed;
        }
    }

    public List<String> abbreviation(List<String> wordList) {
        Trie trie = new Trie();
        HashMap<String, TrieNode> h = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        for (String word : wordList) {
            String compressed = "" + word.charAt(0) + word.length() + word.charAt(word.length() - 1);
            if (!h.containsKey(compressed)) h.put(compressed, new TrieNode());
            trie.insert(word, h.get(compressed));
        }

        for (String word : wordList) {
            String compressed = "" + word.charAt(0) + word.length() + word.charAt(word.length() - 1);
            resultList.add(trie.search(word, h.get(compressed)) + " ");
        }
        return resultList;
    }
}
