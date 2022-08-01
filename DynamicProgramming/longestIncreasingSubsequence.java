package DynamicProgramming;

public class longestIncreasingSubsequence {
    // 1 7 3 5 2 8 10 24 -1 -5 4


    // array: 0 4 5 6 1
    // dp:    1 2 3 4 2
    public static int longestIncreasingSubsequence(int[] array){
        int[] dp = new int[array.length];
        dp[0] = 1;
        int globalMax = 1;
        for(int i =1;i<array.length;i++){
            int localMax = 1;
            for(int j = 0;j<i;j++){
                if(array[i] > array[j] && dp[j] >= localMax){
                    localMax = dp[j] + 1;
                }
            }
            dp[i] = localMax;
            if(dp[i] > globalMax){
                globalMax = dp[i];
            }
        }
        return globalMax;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,7,3,5,2,8,10,24,-1,-5,4};
        int[] array2 = new int[]{0};
         System.out.println(longestIncreasingSubsequence(array2));
    }
}
