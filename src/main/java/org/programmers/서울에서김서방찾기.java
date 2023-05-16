package org.programmers;

public class 서울에서김서방찾기 {

    public String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = String.format("김서방은 %s에 있다", i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        서울에서김서방찾기 서울에서김서방찾기 = new 서울에서김서방찾기();
        String[] seoul = {"Jane", "Kim"};
        System.out.println(서울에서김서방찾기.solution(seoul));
    }
}
