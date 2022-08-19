package DynamicProgramming.LinearDP;

public class UniqueBinarySearchTrees {
    public static int numTrees(int n){
        // 1-indexed
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n;i++){
            for(int j = 1; j <= i/2; j++){
                dp[i] += 2 * (dp[j - 1] * dp[i-j]);
            }
            if(i % 2 == 1){
                dp[i] += dp[i/2] * dp[i/2];
            }
        }
        for(int i : dp) System.out.println(i+" ");
        return dp[n];
    }
    public static void main(String[] args){
        numTrees(10);
    }
}
