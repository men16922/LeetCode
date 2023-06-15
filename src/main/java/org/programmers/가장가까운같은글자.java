package org.programmers;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운같은글자 {

    public int[] solution(String s) {
        int[] answer = new int [s.length()];
        Map<Character, Integer> alphabetIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            int index = s.indexOf(s.charAt(i));
            index = alphabetIndexMap.getOrDefault(s.charAt(i), i);
            if (index == i) {
                answer[i] = -1;
            } else {
                answer[i] = i - index;
            }
            alphabetIndexMap.put(s.charAt(i), i);
        }
        return answer;
    }

    public int[] solution_other(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            answer[i] = i-map.getOrDefault(ch,i+1);
            map.put(ch,i);
        }
        return answer;
    }

    public static void main(String[] args) {
        가장가까운같은글자 가장가까운같은글자 = new 가장가까운같은글자();
        String s = "banana";
        for (int n : 가장가까운같은글자.solution(s)) {
            System.out.println(n);
        }
    }
}
