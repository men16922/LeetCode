package org.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : org.leetcode
 * fileName       : PascalTriangle
 * author         : men16
 * date           : 2023-05-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-05        men16       최초 생성
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }

        // 첫 번째 행을 추가합니다.
        result.add(new ArrayList<>());
        result.get(0).add(1);

        // 각 행을 계산하여 리스트에 추가합니다.
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = result.get(i - 1);

            // 각 행의 처음과 끝은 1입니다.
            row.add(1);

            // 각 내부 값은 바로 위 행에서 왼쪽과 오른쪽 값의 합과 같습니다.
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // 각 행의 끝은 1입니다.
            row.add(1);
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        int numRows = 5;
        System.out.println(pascalTriangle.generate(numRows));
    }
}

