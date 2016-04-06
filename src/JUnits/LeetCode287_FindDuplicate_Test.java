package JUnits;

import Solutions.LeetCode287_FindDuplicate;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;


/**
 * Created by IntelliJ IDEA.
 * File Name: LeetCode287_FindDuplicate_Test.java
 * User: Ratchapong T.
 * Date: 05-Apr-2016
 * Time: 9:37 PM
 */
public class LeetCode287_FindDuplicate_Test {
    private LeetCode287_FindDuplicate leetCode287_findDuplicate;
    private int[] input;
    private int duplicateNumber;


    @Before
    public void setUp() {
        leetCode287_findDuplicate = new LeetCode287_FindDuplicate();
        Random random = new Random();
        int maxRange = 1000000;
        int minRange = 2;
        //Lower limit is inclusive, but the upper limit is exclusive.
        int randomLength = random.nextInt((maxRange + 1) - minRange) + minRange;
        if (randomLength > 1) {
            duplicateNumber = random.nextInt(randomLength - 1) + 1;

            int numberOfDuplicates = random.nextInt((randomLength + 1) - 1) + 1;
            input = new int[randomLength];
            for (int i = 0; i < input.length; i++) {
                input[i] = i + 1;
            }
            int i = input.length - 1;
            while (i >= 0 && numberOfDuplicates >= 0) {
                if (input[i] != duplicateNumber) {
                    input[i] = duplicateNumber;
                    numberOfDuplicates--;
                    i--;
                } else {
                    i--;
                }
            }
        }
    }

    @Test
    public void findDuplicateTest1_linkedList() {
        long startTime = System.nanoTime();
        int result = leetCode287_findDuplicate.findDuplicate_linkedList(input);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("findDuplicate_linkedList - " + duration + "ms");
        assertEquals(result, duplicateNumber);

    }

    @Test
    public void findDuplicateTest1_binarySearch() {
        long startTime = System.nanoTime();
        int result = leetCode287_findDuplicate.findDuplicate_binarySearch(input);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("findDuplicate_binarySearch - " + duration + "ms");
        assertEquals(result, duplicateNumber);

    }
}
