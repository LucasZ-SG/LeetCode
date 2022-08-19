package DynamicProgramming.LinearDP;

public class ClimbingStairs {
    public int climbStairs(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        if(n == 1) return 1;
        dp[1] = 2;
        if(n == 2) return 2;
        for(int i = 2;i<n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n-1];
    }
    // space complexity
    public int climbStairs2(int n){
        int a, b, c = 0;
        a = 1;
        if(n == 1) return 1;
        b = 2;
        if(n == 2) return 2;
        for(int i = 2;i<n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
