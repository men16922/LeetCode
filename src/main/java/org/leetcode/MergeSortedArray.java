package org.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * packageName    : org.leetcode
 * fileName       : MergeSortedArray
 * author         : men16
 * date           : 2023-04-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-04-08        men16       최초 생성
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] result = IntStream.concat(Arrays.stream(nums1).limit(m), Arrays.stream(nums2).limit(n)).sorted().toArray();
        System.arraycopy(result, 0, nums1, 0, result.length);
    }
    public void merge_chatgpt(int[] nums1, int m, int[] nums2, int n) {
        // nums1 배열의 끝 인덱스
        int i = m - 1;
        // nums2 배열의 끝 인덱스
        int j = n - 1;
        // nums1 배열과 nums2 배열을 합친 결과 배열의 끝 인덱스
        int k = m + n - 1;

        // nums1과 nums2를 뒤에서부터 비교하면서 nums1과 nums2 중 큰 값을 결과 배열의 끝에서부터 채워나감
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // nums2에 남은 값들이 있으면 nums1의 앞쪽에 채워넣음
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        mergeSortedArray.merge_chatgpt(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(item -> System.out.println(item));
    }
}

