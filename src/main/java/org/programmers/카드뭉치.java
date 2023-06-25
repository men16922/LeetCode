package org.programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * packageName    : org.programmers
 * fileName       : 카드뭉치
 * author         : men16
 * date           : 2023-06-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-25        men16       최초 생성
 */
public class 카드뭉치 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        Stack<String> cards1Stack = new Stack<>();
        Stack<String> cards2Stack = new Stack<>();

        Arrays.stream(cards1)
                .sorted((a, b) -> -1)
                .forEach(item -> cards1Stack.push(item));

        Arrays.stream(cards2)
                .sorted((a, b) -> -1)
                .forEach(item -> cards2Stack.push(item));

        for (String word : goal) {
            if (!cards1Stack.isEmpty() && cards1Stack.peek().equals(word)) {
                cards1Stack.pop();
            } else if (!cards2Stack.isEmpty() && cards2Stack.peek().equals(word)) {
                cards2Stack.pop();
            } else {
                return answer;
            }
        }
        answer = "Yes";
        return answer;
    }

    public static void main(String[] args) {
        카드뭉치 카드뭉치 = new 카드뭉치();
        String [] cards1 = {"i", "drink", "water"};
        String [] cards2 = {"want", "to"};
        String [] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(카드뭉치.solution(cards1, cards2, goal));
    }
}

