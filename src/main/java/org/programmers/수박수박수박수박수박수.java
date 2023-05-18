package org.programmers;

public class 수박수박수박수박수박수 {

    public String solution(int n) {
        String answer = "";
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) answer += "박";
            else answer += "수";
        }
        return answer;
    }

    public static void main(String[] args) {
        수박수박수박수박수박수 수박수박수박수박수박수 = new 수박수박수박수박수박수();
        System.out.println(수박수박수박수박수박수.solution(3));
    }
}
