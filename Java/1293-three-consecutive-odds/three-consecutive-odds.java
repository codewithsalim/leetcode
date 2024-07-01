class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int oddCount = 0;
        for ( int num : arr ){
            if ( num%2 == 0 ){
                oddCount = 0;
            }else{
                oddCount++;
                if ( oddCount == 3 ) return true;
            }
        }
        return false;
    }
}