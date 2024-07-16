class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int left_max = 0, right_max = 0;
        
        int rain_water = 0;

        while ( left <= right ){
            if ( height[left] <= height[right] ){
                if ( height[left] > left_max ){
                    left_max = height[left];
                }else{
                    rain_water += left_max - height[left];
                }
                left++;
            }else{
                if ( height[right] > right_max ){
                    right_max = height[right];
                }else{
                    rain_water += right_max - height[right];
                }
                right--;
            }
        }
        return rain_water;
    }
}