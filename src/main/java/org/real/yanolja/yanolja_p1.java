package org.real.yanolja;

import java.util.HashMap;
import java.util.Map;

/**
 * Franco wants to surprise Giovanni by using a very simple strategy: he will make the same gesture in every turn throughout the game. What is the maximum number of points he can score using this strategy?
 * Write a function:
 * class Solution { public int solution(String G); }
 * that, given a string G representing the sequence of Giovanni's turns ('R' represents a rock, 'P' represents paper and 'S' represents scissors), returns the maximum number of points Franco can score using his strategy.
 * For example:
 * • Given "RSPRS", the function should return 6 (with the chosen gesture being rock).
 * Franco will gain 6 points (he will win in the second and fifth turns and tie in the first and fourth turn).
 * • Given "SRR" the function should return 4 (chosen gesture: rock; he will win in the first turn and tie in the second and third turns).
 * Given "PRPRRPP" the function should return 10 (chosen gesture: paper).
 * Given "PPPPRRSSSSS" the function should return 13 (chosen gesture: scissors).
 * Assume that:
 * the length of string G is within the range [1..100]; string G consists only of letters 'R', 'P', and 'S'.
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class yanolja_p1 {

    public int solution(String G) {
        int length = G.length();
        int rocksPoint = 0;
        int scissorsPoint = 0;
        int papersPoint = 0;

        for (int i = 0; i < length; i++) {
            char opponentGesture = G.charAt(i);
            if (opponentGesture == 'S') { // 가위
                rocksPoint += 2;
                scissorsPoint += 1;
            } else if (opponentGesture == 'R') { // 바위
                papersPoint += 2;
                rocksPoint += 1;
            } else { // 보
                scissorsPoint += 2;
                papersPoint += 1;
            }
        }

        return Math.max(Math.max(rocksPoint, scissorsPoint), papersPoint);
    }

    public static void main(String[] args) {
        yanolja_p1 yanolja_p1 = new yanolja_p1();
        String G = "RSPRS";
        System.out.println(yanolja_p1.solution(G));
    }
}
