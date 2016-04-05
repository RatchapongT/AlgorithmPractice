package Solutions;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * File Name: Custom002_SimpleWords.java
 * User: Ratchapong T.
 * Date: 28-Mar-2016
 * Time: 11:47 PM
 */
public class Custom002_SimpleWords {

    public String[] simpleWords(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Set<String> answer = new HashSet<>();
        for (String word : set) {
            if (!simpleWordsHelper(word, set)) {
                answer.add(word);
            }
        }
        return answer.toArray(new String[answer.size()]);
    }

    public boolean simpleWordsHelper(String s, Set<String> dict) {
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String word : dict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        boolean[] found = new boolean[s.length() + 1];
        found[0] = true;
        for (int i = minLen; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if ((i - j) < maxLen || !found[j]) continue;
                String substring = s.substring(j, i);
                boolean same = substring.equals(s);
                if (dict.contains(substring) && !same) {
                    found[i] = true;
                    break;
                }
            }
        }
        return found[s.length()];
    }

    public Set<String> simpleWords_DP(Set<String> wordSet) {
        Set<String> simpleWordsSet = new HashSet<>();
        for (String word : wordSet) {
            if (!(wordBreak_DP(word, wordSet))) {
                simpleWordsSet.add(word);
            }
        }
        return simpleWordsSet;
    }

    public boolean wordBreak_DP(String s, Set<String> wordDict) {
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        boolean[] found = new boolean[s.length() + 1];
        found[0] = true;
        for (int i = minLen; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if ((i - j) > maxLen || !found[j]) continue;
                String substring = s.substring(j, i);
                boolean same = substring.equals(s);
                if (wordDict.contains(substring) && !same) {
                    found[i] = true;
                    break;
                }
            }
        }

        return found[s.length()];
    }

    public Set<String> simpleWords_BFS(Set<String> wordSet) {
        Set<String> simpleWordsSet = new HashSet<>();
        for (String word : wordSet) {
            if (!(wordBreak_BFS(word, wordSet))) {
                simpleWordsSet.add(word);
            }
        }
        return simpleWordsSet;
    }

    public boolean wordBreak_BFS(String s, Set<String> wordDict) {
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        List<Integer> BFS = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        BFS.add(0);
        while (BFS.size() > 0) {
            int start = BFS.remove(0);
            if (!visited.contains(start)) {
                visited.add(start);
                for (int j = start + minLen - 1; j < Math.min(start + maxLen, s.length()); j++) {
                    String substring = s.substring(start, j + 1);
                    boolean same = substring.equals(s);
                    if (wordDict.contains(substring) && !same) {
                        BFS.add(j + 1);
                        if (j + 1 == s.length()) {
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }

    public Set<String> simpleWords_DFS(Set<String> wordSet) {
        Set<String> simpleWordsSet = new HashSet<>();
        for (String word : wordSet) {
            if (!(wordBreak_DFS(word, wordSet))) {
                simpleWordsSet.add(word);
            }
        }
        return simpleWordsSet;
    }

    public boolean wordBreak_DFS(String s, Set<String> wordDict) {
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        Stack<Integer> DFS = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        DFS.push(0);
        while (!DFS.empty()) {
            int start = DFS.pop();
            if (!visited.contains(start)) {
                visited.add(start);
                for (int j = start + minLen - 1; j < Math.min(start + maxLen, s.length()); j++) {
                    String substring = s.substring(start, j + 1);
                    boolean same = substring.equals(s);
                    if (wordDict.contains(substring) && !same) {
                        DFS.push(j + 1);
                        if (j + 1 == s.length()) {
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }
}
