package org.leetcode;

/**
 * packageName    : org.leetcode
 * fileName       : Sqrt
 * author         : men16
 * date           : 2023-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-03-18        men16       최초 생성
 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0) { // x가 0이면 0 반환
            return 0;
        }

        int left = 1, right = x; // 이진 검색을 위한 왼쪽, 오른쪽 인덱스 초기화

        while (left <= right) { // left가 right보다 작거나 같은 동안 반복
            int mid = left + (right - left) / 2; // 중간값 계산
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) { // mid가 제곱근의 정수 부분일 때
                return mid;
            } else if (mid > x / mid) { // mid가 제곱근보다 큰 경우, 오른쪽 인덱스 업데이트
                right = mid - 1;
            } else { // mid가 제곱근보다 작은 경우, 왼쪽 인덱스 업데이트
                left = mid + 1;
            }
        }

        return right; // 반복문에서 찾지 못하면 오른쪽 인덱스 반환
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(8));
    }
}

