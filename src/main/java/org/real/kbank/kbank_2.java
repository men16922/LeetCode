package org.real.kbank;

import java.util.*;

/**
 * 당신은 보이스 피싱에 가담했다고 의심되는 계좌를 일부 발견했습니다.
 * 당신은 거래내역을 분석하여 모든 의심되는 계좌를 찾아내려고 합니다.
 * 의심되는 계좌의 조건은 다음과 같습니다.
 * 의심되는 계좌와 거래 횟수가 n회 이상이면서 거래금액 합이 m 이상인 계좌
 * 당신은 모든 의심되는 계좌를 찾아내려고 합니다.
 *
 * 정수 n, m 과 초기에 발견한 의심되는 계좌 목록을 담은 1차원 문자열 배열 suspects, 거래내역을 담은 1차원 문자열 배열 transactions 가 매개변수로 주어집니다.
 * 모든 의심되는 계좌를 찾아 계좌 이름이 사전 순으로 앞서는 순서대로 문자열 배열에 담아 return 하도록 solution함수를 작성해주세요.
 *
 * 제한사항
 * 1 <= n <= 1000
 * 1 <= m <= 1000000000
 * 1 <= suspects의 길이 <= 1000
 * suspects의 원소는 알파벳 소문자로 이루어진 문자열입니다.
 * 1 <= suspects 원소의 길이 <= 10
 * 같은 원소가 반복되어 나오지 않습니다.
 *
 * 1 <= transactions의 길이 <= 300000
 * transactions의 원소는 "계좌1 계좌2 거래 금액" 형태로 계좌1, 계좌2, 거래 금액이 띄어쓰기 하나로 구분되는 형태입니다.
 * 계좌1과 계좌2 사이에 거래 금액 만큼의 거래가 있었다는 것을 의미합니다.
 * 계좌1과 계좌2는 알파벳 소문자로 이루어진 길이 10 이하의 문자열입니다.
 * 1 <= 거래 금액 <= 100000000
 * 거래 금액은 정수입니다.
 *
 * 입출력 예
 * n : 1
 * m : 1000000
 * suspects : ["a","b"]
 * transactions : ["c d 1000000", "a c 1000000", "b d 1000000"]
 * result : ["a", "b", "c", "d"]
 *
 * "c e 1000000", "d e 1000000"
 */
public class kbank_2 {

    public String[] solution(int n, int m, String[] suspects, String[] transactions) {
        Set<String> strAccountSet = new TreeSet<>(); // 알파벳순 정렬
        Arrays.stream(suspects).forEach(strAccountSet::add); // 의심 계좌 추가

        boolean addSuspicious;
        do {
            addSuspicious = false;
            Map<String, int[]> accountInfoMap = new HashMap<>(); // 계좌 정보 초기화

            // 새로운 거래 내역을 처리하면서 계좌 정보를 누적시킴
            for (String transaction : transactions) {
                String[] temp = transaction.split(" ");
                String sender = temp[0];
                String receiver = temp[1];
                int amount = Integer.parseInt(temp[2]);

                // 의심 계좌인지 확인
                if (strAccountSet.contains(sender) || strAccountSet.contains(receiver)) {
                    accountInfoMap.computeIfAbsent(sender, k -> new int[2])[0]++;
                    accountInfoMap.computeIfAbsent(receiver, k -> new int[2])[0]++;
                    accountInfoMap.computeIfAbsent(sender, k -> new int[2])[1] += amount;
                    accountInfoMap.computeIfAbsent(receiver, k -> new int[2])[1] += amount;
                }
            }

            Set<String> newSuspiciousAccounts = new HashSet<>();

            // 의심 계좌 조건 검사
            for (Map.Entry<String, int[]> entry : accountInfoMap.entrySet()) {
                String account = entry.getKey();
                int[] accountInfo = entry.getValue();
                int count = accountInfo[0];
                int amount = accountInfo[1];

                if (count >= n && amount >= m && !strAccountSet.contains(account)) {
                    newSuspiciousAccounts.add(account);
                    addSuspicious = true;
                }
            }

            // 새로운 의심 계좌 추가
            strAccountSet.addAll(newSuspiciousAccounts);

        } while (addSuspicious);

        return strAccountSet.toArray(new String[0]);
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 1000000;
        String[] suspects = {"a", "b"};
        String[] transactions = {"a c 1000000", "c b 1000000", "c d 1000000", "c e 1000000", "d e 1000000"};
        kbank_2 kbank_2 = new kbank_2();
        for (String word : kbank_2.solution(n, m, suspects, transactions)) {
            System.out.println(word);
        }
    }

}
