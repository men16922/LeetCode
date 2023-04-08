package org.leetcode;

/**
 * packageName    : org.leetcode
 * fileName       : ClimbingStairs
 * author         : men16
 * date           : 2023-04-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-04-08        men16       최초 생성
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1]; // n+1 크기의 배열 dp를 생성합니다.
        dp[0] = 1; // 0번째 계단에서는 한 가지 방법으로 올라갈 수 있습니다.
        dp[1] = 1; // 1번째 계단에서는 한 가지 방법으로 올라갈 수 있습니다.
        for (int i = 2; i <= n; i++) { // 2번째 계단부터 n번째 계단까지 반복합니다.
            dp[i] = dp[i - 1] + dp[i - 2]; // i번째 계단에서는 (i-1)번째 계단에서 한 칸 올라오는 방법과 (i-2)번째 계단에서 두 칸 올라오는 방법의 합으로 올라갈 수 있습니다.
        }
        return dp[n]; // n번째 계단에 도달하는 방법의 수를 반환합니다.
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(3));
    }
}

