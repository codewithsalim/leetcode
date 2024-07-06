class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;     
        int currSum = 0;
        int left = 0;
        
        for ( int i = 0; i < nums.length; i++ ){
        	currSum += nums[i];
        	while ( currSum >= target ){
        		min = Math.min(min, i-left+1);
        		currSum -= nums[left];
                left++;
        	}
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}