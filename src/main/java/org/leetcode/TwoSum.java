package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : org.example
 * fileName       : ${NAME}
 * author         : ${USER}
 * date           : ${DATE}
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * ${DATE}        ${USER}       최초 생성
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int [] {i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum_chatGPT(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int [] nums = {3, 2, 4};
        int target = 6;
        for(int n : twoSum.twoSum_chatGPT(nums, target)) {
            System.out.println(n);
        }
    }
}