package JUnits;

import Solutions.Custom003_SudokuVerifier;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * File Name: Custom003_SudokuVerfier_Test.java
 * User: Ratchapong T.
 * Date: 29-Mar-2016
 * Time: 6:46 PM
 */
public class Custom003_SudokuVerfier_Test {
    private Custom003_SudokuVerifier custom003_sudokuVerifier;
    private String board;

    @Before
    public void setUp() {
        custom003_sudokuVerifier = new Custom003_SudokuVerifier();
    }

    @Test
    public void sudokuVerifierTest1() {
        board = "963174258" +
                "178325649" +
                "254689731" +
                "821437596" +
                "496852317" +
                "735961824" +
                "589713462" +
                "317246985" +
                "642598173";
        assertEquals(custom003_sudokuVerifier.sudokuVerifier(board), 1);
    }

    @Test
    public void sudokuVerifierTest2() {
        board = "963174258" +
                "178325649" +
                "254689731" +
                "821437596" +
                "496852317" +
                "735961824" +
                "589713462" +
                "317246985" +
                "642598172";
        assertEquals(custom003_sudokuVerifier.sudokuVerifier(board), 0);
    }
}
