package Solutions;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * File Name: LeetCode140.java
 * User: Ratchapong T.
 * Date: 15-Mar-2016
 * Time: 9:22 PM
 */
public class LeetCode139_WordBreak {
    // 1 + 2 + 3 + ... n
    // n(n+1)/2 => O (n ^ 2)
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
                if (wordDict.contains(s.substring(j, i))) {
                    found[i] = true;
                    break;
                }
            }
        }

        return found[s.length()];
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
                    if (wordDict.contains(substring)) {
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
                    if (wordDict.contains(substring)) {
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
