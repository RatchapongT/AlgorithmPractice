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
        public TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (currentNode.children[c - 'a'] == null) {
                    currentNode.numOfChildren++;
                    currentNode.children[c - 'a'] = new TrieNode();
                }
                currentNode = currentNode.children[c - 'a'];
            }
        }

        public String abbreviate(String word) {
            String compressed;
            TrieNode currentNode = root;
            TrieNode lowestSplit = currentNode;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (currentNode.numOfChildren > 1) {
                    lowestSplit = currentNode;
                }
                currentNode = currentNode.children[c - 'a'];
            }

            currentNode = root;

            //Break at lowest split
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (currentNode != lowestSplit) {
                    sb.append(c);
                    currentNode = currentNode.children[c - 'a'];
                } else {
                    sb.append(c);
                    break;
                }
            }
            compressed = sb.toString() + word.length() + word.charAt(word.length() - 1);
            return compressed.length() >= word.length() ? word : compressed;
        }
    }

    public List<String> abbreviation(List<String> wordList) {
        String compressed;
        Map<String, Trie> map = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        //Construct multiple Tries based on simple abbreviation key
        for (String word : wordList) {
            compressed = "" + word.charAt(0) + word.length() + word.charAt(word.length() - 1);
            if (!map.containsKey(compressed)) map.put(compressed, new Trie());
            map.get(compressed).insert(word);
        }

        for (String word : wordList) {
            compressed = "" + word.charAt(0) + word.length() + word.charAt(word.length() - 1);
            resultList.add(map.get(compressed).abbreviate(word));
        }
        return resultList;
    }
}
