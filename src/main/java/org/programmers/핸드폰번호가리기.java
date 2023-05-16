package org.programmers;

public class 핸드폰번호가리기 {

    public String solution(String phone_number) {
        String first = phone_number.substring(0, phone_number.length() - 4).replaceAll("[\\d]", "*");
        String second = phone_number.substring(phone_number.length() - 4);
        return first + second;
    }

    public String solution_other(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String phone_number = "01033334444";
        핸드폰번호가리기 핸드폰번호가리기 = new 핸드폰번호가리기();
        System.out.println(핸드폰번호가리기.solution(phone_number));
    }
}
