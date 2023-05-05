package org.leetcode;

/**
 * packageName    : org.leetcode
 * fileName       : BestTimeToBuyAndSellStock
 * author         : men16
 * date           : 2023-05-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-05-05        men16       최초 생성
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            for (int j = i + 1 ; j < prices.length; j++){
//                System.out.format("%s - %s : %s\n", prices[j], cur, prices[j] - cur);
                result = Math.max(result, prices[j] - cur);
            }
        }

        return result;
    }

    public int maxProfit_greedy(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
//        int [] prices = {7,6,4,3,1};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }
}

