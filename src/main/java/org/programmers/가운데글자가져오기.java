package org.programmers;

public class 가운데글자가져오기 {

    public String solution(String s) {
        String answer = "";
        int length = s.length();
        if (length % 2 == 0) {
            answer = s.substring((length - 1) / 2, (length - 1) / 2 + 2);
        } else {
            answer = s.substring((length - 1) / 2, (length - 1) / 2 + 1);
        }
        return answer;
    }

    String getMiddle(String word){
        return word.substring((word.length()-1)/2, word.length()/2 + 1);
    }

    public static void main(String[] args) {
        String s = "abcde";
        가운데글자가져오기 가운데글자가져오기 = new 가운데글자가져오기();
        System.out.println(가운데글자가져오기.solution(s));
    }
}
