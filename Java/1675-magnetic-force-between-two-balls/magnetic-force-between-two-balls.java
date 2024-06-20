class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int min = 1;
        int max = position[n-1] - position[0];
        int maxDistance = 0;

        while ( min <= max ){
            int mid = min + ( max - min )/2;
            if ( canPlaceBalls(position, mid, m) ){
                maxDistance = mid;
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        return maxDistance;
    }

    public boolean canPlaceBalls(int[] position, int minDistance, int m ){
        int countBallsPlaced = 1;
        int lastPosition = position[0];

        for ( int i = 1; i < position.length; i++ ){
            if ( position[i] - lastPosition >= minDistance){
                countBallsPlaced++;
                lastPosition = position[i];
                if ( countBallsPlaced == m ) return true;
            }
        }
        return false;
    }
}
