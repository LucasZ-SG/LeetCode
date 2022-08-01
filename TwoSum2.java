public class TwoSum2 {
    //Requirements: constant space complexity
    public static int[] twoSum1(int[] numbers, int target) {
        // Attempt 1: Use binary search to replace hashmap
        // O(nlogn)
        for(int i = 0; i < numbers.length;i++){
            if(numbers[i] == target / 2){
                if(numbers[i] == numbers[i+1]){
                    return new int[]{i+1,i+2};
                }
            }
            int searchResult = search(numbers, target - numbers[i], 0, numbers.length-1);
            if(searchResult != -1){
                return new int[]{i + 1, searchResult + 1};
            }
        }
        throw new IllegalArgumentException();
    }

    private static int search(int[] numbers, int target, int start, int end){
        if(end == start){
            if(target == numbers[end]){
                return end;
            }
            return -1;
        }else if(end - start == 1){
            if(target == numbers[start]){
                return start;
            }else if(target == numbers[end]){
                return end;
            }
            return -1;
        }
        int mid = (end + start) / 2;
        if(numbers[mid] == target){
            return mid;
        }
        if(numbers[mid] < target){
            return search(numbers, target, mid + 1, end);
        }else{
            return search(numbers, target, start, mid - 1);
        }
    }

    // Attempt2: Two Pointers (O(n))
    public static int[] twoSum2(int[] numbers, int target){
        int left = 0;
        int right = numbers.length - 1;
        while(left <= right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left + 1, right + 1};
            }
            while(numbers[left] + numbers[right] < target){
                left++;
            }
            while(numbers[left] + numbers[right] > target){
                right--;
            }
        }
        throw new IllegalArgumentException();
    }
    
    public static void main(String[] args){
        int[] array = new int[]{3,24,50,79,88,150,345};
        twoSum2(array,200);
    }
}
