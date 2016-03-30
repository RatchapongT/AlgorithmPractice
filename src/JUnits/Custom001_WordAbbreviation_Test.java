package JUnits;

import Solutions.Custom001_WordAbbreviation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * File Name: Custom001_WordAbbreviation_Test.java
 * User: Ratchapong T.
 * Date: 29-Mar-2016
 * Time: 8:32 PM
 */
public class Custom001_WordAbbreviation_Test {
    Custom001_WordAbbreviation custom001_wordAbbreviation;
    List<String> wordList;

    @Before
    public void setUp() {
        custom001_wordAbbreviation = new Custom001_WordAbbreviation();
    }

    @Test
    public void wordAbbreviationTest1() {
        wordList = new ArrayList<>(Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion", "international"));

        List<String> answerList = new ArrayList<>(Arrays.asList("l4e", "god", "internal", "me", "i8t", "interval", "inte9n", "f4e", "intr9n", "i13l"));
        List<String> resultList = new ArrayList<>(custom001_wordAbbreviation.abbreviation(wordList));
        assertEquals(resultList, answerList);
    }
    @Test
    public void wordAbbreviationTest2() {
        wordList = new ArrayList<>(Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"));

        List<String> answerList = new ArrayList<>(Arrays.asList("l4e", "god", "internal", "me", "i8t", "interval", "inte9n", "f4e", "intr9n"));
        List<String> resultList = new ArrayList<>(custom001_wordAbbreviation.abbreviation(wordList));
        assertEquals(resultList, answerList);
    }
    @Test
    public void wordAbbreviationTest3() {
        wordList = new ArrayList<>(Arrays.asList("interval", "internal", "intaaaal"));

        List<String> answerList = new ArrayList<>(Arrays.asList("interval", "internal", "inta8l"));
        List<String> resultList = new ArrayList<>(custom001_wordAbbreviation.abbreviation(wordList));
        assertEquals(resultList, answerList);
    }

    @Test
    public void wordAbbreviationTest4() {
        wordList = new ArrayList<>(Arrays.asList("intervalaasdfy","intervaliasdfy", "internaloasdfy", "internaliasdfy"));

        List<String> answerList = new ArrayList<>(Arrays.asList("intervala14y", "intervali14y", "internalo14y", "internali14y"));
        List<String> resultList = new ArrayList<>(custom001_wordAbbreviation.abbreviation(wordList));
        assertEquals(resultList, answerList);
    }

    @Test
    public void wordAbbreviationTest5() {
        wordList = new ArrayList<>(Arrays.asList("aaa"));

        List<String> answerList = new ArrayList<>(Arrays.asList("aaa"));
        List<String> resultList = new ArrayList<>(custom001_wordAbbreviation.abbreviation(wordList));
        assertEquals(resultList, answerList);
    }

    @Test
    public void wordAbbreviationTest6() {
        wordList = new ArrayList<>(Arrays.asList("internal", "hahahah", "lalala"));

        List<String> answerList = new ArrayList<>(Arrays.asList("i8l", "h7h", "l6a"));
        List<String> resultList = new ArrayList<>(custom001_wordAbbreviation.abbreviation(wordList));
        assertEquals(resultList, answerList);
    }
}
