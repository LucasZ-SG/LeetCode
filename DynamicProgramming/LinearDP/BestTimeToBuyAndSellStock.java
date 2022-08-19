package DynamicProgramming.LinearDP;

public class BestTimeToBuyAndSellStock {

    // 17 11 15 3 16 14
    // 0  0  4  0 13 11
    // 0  -6 4 -12 13 -2
    // dp[i] = prices[i] - prices[localMin]
    public int  maxProfit(int[] prices){
        // Array dp stores max profit if sell on that day
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int localMinIndex = 0;
        int max = 0;
        if (prices.length == 1) return 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] > prices[localMinIndex]){
                dp[i] = prices[i] - prices[localMinIndex];
                if(dp[i] > max){
                    max = dp[i];
                }
            }else{
                dp[i] = 0;
                localMinIndex = i;
            }
        }
        return max;
    }
}
