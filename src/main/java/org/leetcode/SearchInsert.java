package org.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * packageName    : org.leetcode
 * fileName       : SearchInsert
 * author         : men16
 * date           : 2023-04-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-04-08        men16       최초 생성
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int index = IntStream.range(0, nums.length)
                .filter(i -> target == nums[i])
                .findFirst()
                .orElse(-1);
        if(index == -1) {
            int abs = Integer.MAX_VALUE;
            int linearIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(target - nums[i]) < abs) {
                    abs = Math.abs(target - nums[i]);
                    if (nums[i] >= target) {
                        linearIndex = i;
                    } else {
                        linearIndex = i+ 1;
                    }
                }
            }
            return linearIndex;
        }
        return index;
    }

    public int searchInsert_chatgpt(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int [] nums = {1,3,5,6};
        int target = 0;
        System.out.println(searchInsert.searchInsert_chatgpt(nums, target));
    }
}

