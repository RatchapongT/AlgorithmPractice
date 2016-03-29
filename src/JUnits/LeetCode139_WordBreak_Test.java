package JUnits;

import Solutions.Custom002_SimpleWords;
import Solutions.LeetCode139_WordBreak;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * File Name: LeetCode139_WordBreak_Test.java
 * User: Ratchapong T.
 * Date: 29-Mar-2016
 * Time: 5:53 PM
 */
public class LeetCode139_WordBreak_Test {
    private LeetCode139_WordBreak leetCode139_wordBreak;
    private Set<String> wordSet;

    @Before
    public void setUp() {
        leetCode139_wordBreak = new LeetCode139_WordBreak();
    }

    @Test
    public void wordbreakTest1_DP() {
        wordSet = new HashSet<>(Arrays.asList("so", "here", "come", "thesun", "sun", "the", "bet", "better", "hi", "hilt", "kill", "sales"));
        String input = "soherecomethesunsunthebetbetterhihiltkillsales";
        assertTrue(leetCode139_wordBreak.wordBreak_DP(input, wordSet));
    }

    @Test
    public void wordbreakTest1_BFS() {
        wordSet = new HashSet<>(Arrays.asList("so", "here", "come", "thesun", "sun", "the", "bet", "better", "hi", "hilt", "kill", "sales"));
        String input = "soherecomethesunsunthebetbetterhihiltkillsales";
        assertTrue(leetCode139_wordBreak.wordBreak_BFS(input, wordSet));
    }

    @Test
    public void wordbreakTest1_DFS() {
        wordSet = new HashSet<>(Arrays.asList("so", "here", "come", "thesun", "sun", "the", "bet", "better", "hi", "hilt", "kill", "sales"));
        String input = "soherecomethesunsunthebetbetterhihiltkillsales";
        assertTrue(leetCode139_wordBreak.wordBreak_DFS(input, wordSet));
    }
}
