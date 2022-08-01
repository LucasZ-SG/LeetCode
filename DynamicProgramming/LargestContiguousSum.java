package DynamicProgramming;

// -1 2 -1 4 -3 1 3
public class LargestContiguousSum {
    public static int largestContiguousSum(int[] array){
        int[] memo = new int[array.length];
        memo[0] = array[0] > 0? array[0] : 0; 
        for(int i = 1;i < array.length; i++){
            if(array[i] + memo[i-1] > 0){
                memo[i] = memo[i - 1] + array[i];
            }else {
                memo[i] = 0;
            }
        }
        int max = 0;
        for(int i = 0;i < array.length;i++){
            if (memo[i] > max){
                max = memo[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] array = new int[]{-1,2,-1,4,-3,1,3};
        System.out.println(largestContiguousSum(array));
    }
}
