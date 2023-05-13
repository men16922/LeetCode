package org.programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : org.programmers
 * fileName       : CheckLevel2
 * author         : men16
 * date           : 2023-05-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-11        men16       최초 생성
 */
public class CheckLevel2 {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> nums = new ArrayList<>();

        // 1부터 n까지의 수를 리스트에 저장
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // k를 (k-1)로 변환하여 0-based 인덱스로 사용
        k--;

        // 팩토리얼 계산
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        // k번째 순열 생성
        for (int i = 0; i < n; i++) {
            factorial /= (n - i);
            int index = (int) (k / factorial);
            answer[i] = nums.get(index);
            nums.remove(index);
            k %= factorial;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        CheckLevel2 checkLevel2 = new CheckLevel2();
        System.out.println(checkLevel2.solution(n, k));
    }
}

