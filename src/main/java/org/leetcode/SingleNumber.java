package org.leetcode;

import java.util.*;

/**
 * packageName    : org.leetcode
 * fileName       : SingleNumber
 * author         : men16
 * date           : 2023-05-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-06        men16       최초 생성
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        Map<Integer, Boolean> tempMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (tempMap.containsKey(nums[i])) {
                tempMap.put(nums[i], false);
            } else {
                tempMap.put(nums[i], true);
            }
        }

        for (int num : tempMap.keySet()) {
            if (tempMap.get((num)) == true) {
                result = num;
                break;
            }
        }
        return result;
    }

    public static int findSingleNumber_chatGPT(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int [] nums = {2,2,1};
        System.out.println(singleNumber.singleNumber(nums));
    }
}

