package org.programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * packageName    : org.programmers
 * fileName       : CheckLevel2_2
 * author         : men16
 * date           : 2023-05-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-11        men16       최초 생성
 */
public class CheckLevel2_2 {

    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = order.length - 1; i >= 0; i--) {
            stack.push(order[i]); // 컨테이너 벨트에 상자 추가
        }

        for (int box : order) {
            if (!stack.isEmpty()) {
                if (stack.pop() == box) { // 상자를 트럭에 싣고 동시에 비교
                    answer++; // 상자 개수 증가
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CheckLevel2_2 checkLevel2_2 = new CheckLevel2_2();
        int [] order = {4, 3, 1, 2, 5};
        System.out.println(checkLevel2_2.solution(order));
    }
}

