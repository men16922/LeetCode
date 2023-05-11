package org.programmers;

public class 자연수뒤집어배열로만들기 {

    public int[] solution(long n) {
        char [] array = Long.toString(n).toCharArray();
        int [] reverse = new int[array.length];
        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            reverse[j] = array[i] - '0';
        }
        return reverse;
    }

    public int[] solution_other(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }

    public static void main(String[] args) {
        long n = 12345;
        자연수뒤집어배열로만들기 자연수뒤집어배열로만들기 = new 자연수뒤집어배열로만들기();
        System.out.println(자연수뒤집어배열로만들기.solution(n));
    }
}
