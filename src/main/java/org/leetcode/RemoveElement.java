package org.leetcode;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.sort;

/**
 * packageName    : org.leetcode
 * fileName       : RemoveElement
 * author         : men16
 * date           : 2023-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-03-25        men16       최초 생성
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int k = 0; // 배열 nums의 인덱스를 의미하는 변수 k 초기화

        // 배열 nums의 모든 요소에 대해서 반복문을 실행
        for (int i = 0; i < nums.length; i++) {
            // nums[i]가 val과 같으면 해당 요소를 제거하기 위해 인덱스 i를 건너뛰고 다음 요소로 진행
            if (nums[i] == val) {
                continue;
            }
            // nums[i]가 val과 다르면 해당 요소를 배열 nums의 앞쪽으로 이동시키기 위해 nums[k]와 교환
            nums[k] = nums[i];
            k++; // 인덱스 k 증가
        }

        return k; // 최종적으로 배열 nums의 길이를 의미하는 k 반환
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = removeElement.removeElement(nums, val);
        System.out.println(k);

    }
}

