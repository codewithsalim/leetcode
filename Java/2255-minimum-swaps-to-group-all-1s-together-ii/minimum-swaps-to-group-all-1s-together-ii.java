class Solution{
	public int minSwaps(int[] nums){
		int minSwaps = Integer.MAX_VALUE;
		int totalOnes = 0;
		
		//calculate total number of ones
		for ( int num: nums ){
			totalOnes += num;
		}
		
		//calculate first window
		int windowSize = totalOnes;
		int oneCount = 0;
		for ( int i = 0; i < windowSize; i++ ){
			oneCount += nums[i];
		}
		minSwaps = totalOnes - oneCount;
		
        //Slide window
		int n = nums.length;
		for ( int i = windowSize; i < n + windowSize - 1; i++ ){
			oneCount += nums[i%n];
			oneCount -= nums[(i - windowSize + n) % n];
			minSwaps = Math.min( minSwaps, totalOnes - oneCount);
		} 
		
		return minSwaps;
	}
}