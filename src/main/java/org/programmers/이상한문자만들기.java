package org.programmers;

public class 이상한문자만들기 {

    public String solution(String s) {
        String answer = "";
        String [] temp = s.split(" ", - 1);
        for (String a : temp) {
            if (a.equals("")) answer += " ";
            else {
                for (int i = 0; i < a.length(); i++) {
                    if (i % 2 == 0) answer += Character.toUpperCase(a.charAt(i));
                    else answer += Character.toLowerCase(a.charAt(i));
                }
                answer += " ";
            }
        }
        return answer.substring(0, answer.length() - 1);
    }

    public String solution_other(String s) {

        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "try hello  world";
        이상한문자만들기 이상한문자만들기 = new 이상한문자만들기();
        System.out.println(이상한문자만들기.solution(s));
    }
}
