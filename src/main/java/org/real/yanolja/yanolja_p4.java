package org.real.yanolja;

/**
 * 주어진 문제는 두 개의 문자열 L1과 L2가 주어지고, 각각 첫 번째와 두 번째 차선을 나타내며, 각 차선은 동일한 길이의 N개 세그먼트로 구성되어 있는 상황입니다.
 *
 * 각 차선의 K번째 세그먼트는 L1[K]와 L2[K]로 표현되며, '.'는 평탄한 도로 세그먼트를 나타내고 'x'는 포트홀이 있는 세그먼트를 나타냅니다. 자동차는 포트홀이 있는 세그먼트를 통과할 수 있지만 불편합니다. 따라서 가능한 많은 포트홀을 수리하기 위한 프로젝트를 제출하려고 합니다.
 * 각 차선에서 연속된 구간은 한 번에 최대 한 곳씩만 수리될 수 있습니다.
 * 수리 중인 구간은 교통을 통과할 수 없도록 닫혀 있어야 합니다.
 *
 * 길을 완전히 통과할 수 있도록 유지하면서 수리할 수 있는 포트홀 세그먼트의 최대 개수를 반환하는 함수를 작성해야 합니다.
 * L1 = "..xx.x.", L2 = "x.x.x.."이 주어진 경우, 함수는 4를 반환해야 합니다. 첫 번째 차선에서 세 개의 포트홀과 두 번째 차선에서 첫 번째 포트홀을 수리하면서도 도로를 통과할 수 있습니다.
 * L1 = ".xxx...x", L2 = "..x.xxxx"가 주어진 경우, 함수는 6을 반환해야 합니다.
 * L1 = "xxxxx", L2 = ".x..x"가 주어진 경우, 함수는 5를 반환해야 합니다.
 * L1 = "x...x", L2 = "..x.."가 주어진 경우, 함수는 2를 반환해야 합니다.
 */
public class yanolja_p4 {

    public int solution(String L1, String L2) {
        int n = L1.length();
        int maxRepairs = 0; // 최대 포트홀 수리 개수

        for (int i = 0; i < n; i++) {
            char c1 = L1.charAt(i);
            char c2 = L2.charAt(i);

            if (c1 == '.' && c2 == '.') {
                // 두 차선 모두 평탄한 도로인 경우
                maxRepairs++;
                L1 = replaceCharAt(L1, i, 'x');
                L2 = replaceCharAt(L2, i, 'x');
            } else if (c1 == '.' || c2 == '.') {
                // 한 차선만 평탄한 도로인 경우
                maxRepairs++;
                if (c1 == '.')
                    L1 = replaceCharAt(L1, i, 'x');
                else
                    L2 = replaceCharAt(L2, i, 'x');
            }
        }

        return maxRepairs;
    }

    // 문자열 str에서 idx 위치의 문자를 newChar로 대체하여 반환하는 메소드
    private String replaceCharAt(String str, int idx, char newChar) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(idx, newChar);
        return sb.toString();
    }


    public static void main(String[] args) {
        yanolja_p4 yanolja_p4 = new yanolja_p4();
        String L1 = ".xxx...x";
        String L2 = "..x.xxxx";
        System.out.println(yanolja_p4.solution(L1, L2));
    }
}
