package Solutions;

/**
 * Created by IntelliJ IDEA.
 * File Name: LeetCode287_FindDuplicate.java
 * User: Ratchapong T.
 * Date: 05-Apr-2016
 * Time: 8:00 PM
 */
public class LeetCode287_FindDuplicate {
    public int findDuplicate_linkedList(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return fast;
        }
        return -1;
    }

    public int findDuplicate_binarySearch(int[] nums) {
        int low = 1;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int n : nums) {
                if (n <= mid) {
                    count++;
                }

            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
