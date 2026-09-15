class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null)
            return new int[0];
        int left = 0, right = numbers.length-1;
        while(left <right)
        {
            if(numbers[left]+numbers[right] >target)
                right--;
            if(numbers[left]+numbers[right] <target)
                left++;
            if(numbers[left]+numbers[right] == target)
                return new int[]{left+1, right+1};
        }
        return new int[]{};
    }
}
/*

[1,2,3,4]
 l. r   
target = 3

*/