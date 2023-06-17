package org.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * packageName    : org.programmers
 * fileName       : 추억점수
 * author         : men16
 * date           : 2023-06-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-17        men16       최초 생성
 */
public class 추억점수 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        int [] answer = new int[photo.length];
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String temp = photo[i][j];
                score += map.get(temp) != null ? map.get(temp) : 0;
            }
            answer[i] = score;
        }
        return answer;
    }

    public int[] solution_other(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = IntStream.range(0, name.length)
                .mapToObj(operand -> Map.entry(name[operand], yearning[operand]))
                .collect(Collectors.toSet()).stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return Arrays.stream(photo).mapToInt(strings -> Arrays.stream(strings)
                .mapToInt(value -> map.getOrDefault(value, 0)).sum()).toArray();
    }


    public static void main(String[] args) {
        String [] name = {"may", "kein", "kain", "radi"};
        int [] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};
        추억점수 추억점수 = new 추억점수();
        for (int n : 추억점수.solution(name, yearning, photo)) {
            System.out.println(n);
        }
    }
}

