class Solution {
    public int takeCharacters(String s, int k) {
        //count freq of each character
        int[] count = new int[3];
        for ( char c: s.toCharArray()){
            count[c-'a']++;
        }
        if ( minimum(count) < k ) return -1;

        //sliding window
        int result = Integer.MAX_VALUE;
        int l = 0;
        for ( int r = 0; r < s.length(); r++ ){
            count[s.charAt(r)-'a']--;
            while ( minimum(count)< k ){
                count[s.charAt(l)-'a']++;
                l++;
            }
            result = Math.min(result, s.length()-(r-l+1));
        }
        return result;
    }

    private int minimum(int[] arr){
        return Math.min(arr[0], Math.min(arr[1], arr[2]));
    }
}