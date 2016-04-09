package Solutions;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * File Name: LeetCode127_LadderLength.java
 * User: Ratchapong T.
 * Date: 05-Apr-2016
 * Time: 10:32 PM
 */
public class LeetCode127_LadderLength {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);

        return solve(start, end, wordList, 1);
    }

    public int solve(Set<String> start, Set<String> end, Set<String> wordList, int level) {
        if (start.isEmpty()) {
            return 0;
        }
        if (start.size() > end.size()) { //cut the loop
            return solve(end, start, wordList, level);
        }

        for (String s : end) {
            wordList.remove(s);
        }
        Set<String> set = new HashSet<>();

        wordList.removeAll(start);
        for (String s : start) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char temp = chars[i];
                    chars[i] = ch;
                    String word = new String(chars);

                    // found the word in other end(set)
                    if (end.contains(word)) {
                        return level + 1;
                    }

                    // if not, add to the next level
                    if (wordList.contains(word)) {
                        set.add(word);
                    }
                    chars[i] = temp;
                }

            }
        }

        return solve(set, end, wordList, level + 1);
    }
}
