package org.leetcode;

/**
 * packageName    : org.leetcode
 * fileName       : RemoveDuplicatesFromSortedArray
 * author         : men16
 * date           : 2023-03-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-03-11        men16       최초 생성
 */
public class RemoveDuplicatesFromSortedArray {

    int cur = 0;

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0; // slow pointer
        for (int j = 1; j < nums.length; j++) { // fast pointer
            if (nums[j] != nums[i]) { // found a new unique element
                i++; // move slow pointer
                nums[i] = nums[j]; // overwrite the duplicate with a new unique element
            }
        }

        return i + 1; // return the length of the new array with unique elements
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2};
        int[] expectedNums = {1, 2};
        int k = removeDuplicatesFromSortedArray.removeDuplicates(nums);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}

