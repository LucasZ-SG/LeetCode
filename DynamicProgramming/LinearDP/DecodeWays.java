package DynamicProgramming.LinearDP;

public class DecodeWays {
    public int numDecodings(String s){
        // check can be decoded or not
        for(int i = 0; i< s.length();i++){
            if(s.charAt(i) == '0'){
                if(i == 0) return 0;
                if(s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2' ){
                    return 0;
                }
            }
        }
        if(s.length() == 1){
            return 1;
        }
        int len = s.length();
        int[] dp = new int[len];
        // calculate dp[0]
        dp[0] = 1;
        
        // calculate dp[1]
        if(s.charAt(1) =='0'){
            dp[1] = 1;
        }else if(isValid(s, 1)){
            dp[1] = 2;
        }else{
            dp[1] = 1;
        }
        
        for(int i = 2;i<len;i++){
            if(s.charAt(i) == '0'){
                dp[i-1] = dp[i-2];
                dp[i] = dp[i -2];
            }else if(isValid(s, i)){
                dp[i] = dp[i-2] + dp[i - 1];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[len-1];
    }

    private boolean isValid(String s, int i){
        if(s.charAt(i-1) == '0') return false;
        int n = Integer.parseInt(s.substring(i -1,i+1));
        if(1 <= n && n <= 26){
            return true;
        }else{
            return false;
        }
    }
}
