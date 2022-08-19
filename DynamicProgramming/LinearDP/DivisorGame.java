package DynamicProgramming.LinearDP;

import javax.swing.plaf.TreeUI;

public class DivisorGame {
    public boolean divisorGame(int n){
        int[] dp = new int[n + 1];
        dp[1] = -1;
        if(n == 1) return false;
        return calculate(dp, n) == 1? true :false;
    }
    private static int calculate(int[] dp, int n){
        for(int i = 1; i <= Math.sqrt(n);i++){
            if(n % i == 0){
                if(dp[n - i] == -1){
                    return 1;
                }else if(dp[n - i] == 0){
                    if(calculate(dp, n - i) == -1){
                        dp[n - i] = -1;
                        return 1;
                    }else{
                        dp[n - i] = 1;
                    }
                    
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] dp = new int[100 + 1];
        dp[1] = -1;
        calculate(dp, 100);
        
        for(int i = 0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
    }
}
