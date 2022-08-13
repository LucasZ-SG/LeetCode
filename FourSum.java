import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    // Hashset slow
    public List<List<Integer>> fourSum(int[] nums, int target) {
        final long MAX_VALUE = 2 ^ 31 -1;
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        for(int i = 1; i < nums.length; i++){
            for(int j = 0;j<i;j++){
                int left = i+1;
                int right = nums.length-1;
                while(left < right){
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > MAX_VALUE) continue;
                    if(sum == target){
                        list.add(Arrays.asList(nums[i] , nums[j] , nums[left] , nums[right]));
                        left++;
                        right--;
                    }else if(sum > target) right --;
                    else left++;
                }
            }
        }
        return new ArrayList<>(list);
    }
}
