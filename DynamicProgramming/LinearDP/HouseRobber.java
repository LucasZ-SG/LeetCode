package DynamicProgramming.LinearDP;

public class HouseRobber {
    public int rob(int[] nums){
        // 1-indexed
        int[] dp = new int[nums.length  +1];
        int[] localMax = new int[nums.length + 1];

        dp[0] = 0;
        dp[1] = nums[0];
        int max = 0;
        for(int i = 2; i <= nums.length; i++){
            dp[i] = max + nums[i - 1];
            max = Math.max(max,dp[i-1]);
        }
        max = Math.max(dp[nums.length],max);
        return max;
    }
}
