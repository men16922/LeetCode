package org.real.yanolja;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 주어진 문제는 배열 A가 주어졌을 때, 배열의 모든 요소가 서로 중복되지 않도록 만들기 위해 필요한 최소 이동 횟수를 구하는 것입니다. 이동은 각 요소의 값을 1씩 증가시키거나 감소시킬 수 있으며, 이동 후에도 모든 숫자는 범위 [1..N] 안에 있어야 합니다.
 *
 * 함수 solution은 배열 A를 매개변수로 받아 배열의 요소들이 중복되지 않도록 만들기 위해 필요한 최소 이동 횟수를 반환해야 합니다. 결과 값이 1,000,000,000을 초과하는 경우 -1을 반환해야 합니다.
 *
 * 예시:
 *
 * A = [1, 2, 1]이 주어진 경우, 함수는 2를 반환해야 합니다. A[2]를 두 번 증가시켜서 [1, 2, 1] -> [1, 2, 2] -> [1, 2, 3]으로 만들 수 있습니다. 이 예시에서는 두 번의 이동으로 배열을 다음과 같이 변경할 수도 있습니다: [3, 2, 1], [1, 3, 2], [2, 3, 1].
 * A = [2, 1, 4, 4]가 주어진 경우, 함수는 1을 반환해야 합니다. A[2] 또는 A[3]을 1 감소시켜서 [2, 1, 3, 4] 또는 [2, 1, 4, 3]으로 만들 수 있습니다.
 * A = [6, 2, 3, 5, 6, 3]이 주어진 경우, 함수는 4를 반환해야 합니다. 네 번의 이동으로 배열을 다음과 같이 변경할 수 있습니다: [6, 2, 1, 5, 4, 3].
 * 주어진 문제에 따라 배열 A의 길이인 N은 [1..200,000] 범위 내의 정수이며, 배열 A의 각 요소는 [1..N] 범위 내의 정수입니다.
 *
 * 위의 조건에 맞는 효율적인 알고리즘을 작성해야 합니다.
 */
public class yanolja_p3 {

    public int solution(int[] A) {
        int N = A.length;
        int moves = 0;
        HashSet<Integer> set = new HashSet<>();
        int originSum = Arrays.stream(A).sum();
        for (int i = 0; i < N; i++) {
            if (set.contains(A[i])) {
                int num = A[i];
                int newNum = findUniqueNum(set, num, N);
                int diff = Math.abs(newNum - num);
                moves += Math.min(diff, N - diff);
                A[i] = newNum;
            }
            set.add(A[i]);
        }
        int changeSum = set.stream().mapToInt(Integer::intValue).sum();

        return Math.abs(originSum - changeSum);
    }

    private int findUniqueNum(HashSet<Integer> set, int num, int N) {
        while (set.contains(num)) {
            num = (num % N) + 1;
        }
        return num;
    }

    public static void main(String[] args) {
        yanolja_p3 yanolja_p3 = new yanolja_p3();
        int [] A = {6, 2, 3, 5, 6, 3};
        System.out.println(yanolja_p3.solution(A));
    }
}
