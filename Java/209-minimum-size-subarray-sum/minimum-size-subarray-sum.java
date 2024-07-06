class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        LinkedList<Integer> q = new LinkedList<>();
        
        int currSum = 0;
        
        for ( int i = 0; i < nums.length; i++ ){
        	q.offer(nums[i]);
        	currSum += nums[i];
        	while ( currSum >= target && !q.isEmpty() ){
        		min = Math.min(min, q.size());
        		int firstElement = q.pop();
        		currSum -= firstElement;
        	}
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}