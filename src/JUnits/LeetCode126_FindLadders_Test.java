package JUnits;

import Solutions.LeetCode126_FindLadders;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JingWen on 4/10/16.
 */
public class LeetCode126_FindLadders_Test {
    private LeetCode126_FindLadders leetCode126_findLadders;
    private Set<String> wordList;

    @Before
    public void setUp() {
        leetCode126_findLadders = new LeetCode126_FindLadders();
    }

    @Test
    public void ladderLengthTest1() {
        wordList = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        leetCode126_findLadders.findLadders("hit", "cog", wordList);

    }

}
