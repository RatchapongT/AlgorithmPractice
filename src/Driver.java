import Solutions.Custom002_SimpleWords;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * File Name: Driver.java
 * User: Ratchapong T.
 * Date: 15-Mar-2016
 * Time: 9:50 PM
 */
public class Driver {
    public static void main(String[] args) {
        String[] test = {"so", "what", "whatsoever", "son", "sales", "per", "person", "chat", "ever", "snapchat", "snap", "salesperson"};
        String[] answer = simpleWords(test);
        System.out.println(simpleWords(test));
    }

    public static String[] simpleWords(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Set<String> answer = new HashSet<>();
        for (String word: set) {
            if(!simpleWordsHelper(word, set)) {
                answer.add(word);
            }
        }
        return answer.toArray(new String[answer.size()]);



    }

    public static boolean simpleWordsHelper(String s, Set<String> dict) {
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String word: dict){
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        boolean[] found = new boolean[s.length() + 1];
        found[0] = true;
        for(int i = minLen; i<= s.length(); i++) {
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
}
