package JUnits;

/**
 * Created by IntelliJ IDEA.
 * File Name: Custom001_SimpleWords_Test.java
 * User: Ratchapong T.
 * Date: 29-Mar-2016
 * Time: 5:11 PM
 */
import Solutions.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class Custom001_SimpleWords_Test {
    private Custom002_SimpleWords custom002_simpleWords;
    private Set<String> wordSet;

    @Before
    public void setUp() {
        custom002_simpleWords = new Custom002_SimpleWords();
    }

    @Test
    public void simpleWordsTest1_DP() {
        wordSet = new HashSet<>(Arrays.asList("so", "what", "whatsoever", "son", "sales", "per", "person", "chat", "ever", "snapchat", "snap", "salesperson"));
        List<String> answer = new ArrayList<>(Arrays.asList("so", "what", "son", "sales", "per", "snap", "chat", "ever"));
        Set<String> result = custom002_simpleWords.simpleWords_DP(wordSet);
        assertEquals(result.size(), answer.size());
        for (String word : answer) {
            assertTrue(result.contains(word));
            result.remove(word);
        }
        assertEquals(result.size(), 0);
    }

    @Test
    public void simpleWordsTest1_BFS() {
        wordSet = new HashSet<>(Arrays.asList("so", "what", "whatsoever", "son", "sales", "per", "person", "chat", "ever", "snapchat", "snap", "salesperson"));
        List<String> answer = new ArrayList<>(Arrays.asList("so", "what", "son", "sales", "per", "snap", "chat", "ever"));
        Set<String> result = custom002_simpleWords.simpleWords_BFS(wordSet);
        assertEquals(result.size(), answer.size());
        for (String word : answer) {
            assertTrue(result.contains(word));
            result.remove(word);
        }
        assertEquals(result.size(), 0);
    }

    @Test
    public void simpleWordsTest1_DFS() {
        wordSet = new HashSet<>(Arrays.asList("so", "what", "whatsoever", "son", "sales", "per", "person", "chat", "ever", "snapchat", "snap", "salesperson"));
        List<String> answer = new ArrayList<>(Arrays.asList("so", "what", "son", "sales", "per", "snap", "chat", "ever"));
        Set<String> result = custom002_simpleWords.simpleWords_DFS(wordSet);
        assertEquals(result.size(), answer.size());
        for (String word : answer) {
            assertTrue(result.contains(word));
            result.remove(word);
        }
        assertEquals(result.size(), 0);
    }

    @Test
    public void simpleWordsTest2_DP() {
        wordSet = new HashSet<>(Arrays.asList("aaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaa",
                "aaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaa", "aaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaa", "aa",
                "aaaaaaaaaaaaaaaaaaaaaaa", "aaa", "aaaaaaaaaaa", "aaaaaaa", "aaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaa", "aaaaaaaaaaaaa",
                "aaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaa"));
        List<String> answer = new ArrayList<>(Arrays.asList("a"));
        Set<String> result = custom002_simpleWords.simpleWords_DP(wordSet);
        assertEquals(result.size(), answer.size());
        for (String word : answer) {
            assertTrue(result.contains(word));
            result.remove(word);
        }
        assertEquals(result.size(), 0);
    }

    @Test
    public void simpleWordsTest2_BFS() {
        wordSet = new HashSet<>(Arrays.asList("aaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaa",
                "aaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaa", "aaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaa", "aa",
                "aaaaaaaaaaaaaaaaaaaaaaa", "aaa", "aaaaaaaaaaa", "aaaaaaa", "aaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaa", "aaaaaaaaaaaaa",
                "aaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaa"));
        List<String> answer = new ArrayList<>(Arrays.asList("a"));
        Set<String> result = custom002_simpleWords.simpleWords_BFS(wordSet);
        assertEquals(result.size(), answer.size());
        for (String word : answer) {
            assertTrue(result.contains(word));
            result.remove(word);
        }
        assertEquals(result.size(), 0);
    }

    @Test
    public void simpleWordsTest2_DFS() {
        wordSet = new HashSet<>(Arrays.asList("aaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaa",
                "aaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaa", "aaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaa", "aa",
                "aaaaaaaaaaaaaaaaaaaaaaa", "aaa", "aaaaaaaaaaa", "aaaaaaa", "aaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaa", "aaaaaaaaaaaaa",
                "aaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaa"));
        List<String> answer = new ArrayList<>(Arrays.asList("a"));
        Set<String> result = custom002_simpleWords.simpleWords_DFS(wordSet);
        assertEquals(result.size(), answer.size());
        for (String word : answer) {
            assertTrue(result.contains(word));
            result.remove(word);
        }
        assertEquals(result.size(), 0);
    }

}
