class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        for(int[] road: roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }        
        
        Arrays.sort(degree);

        long importance = 1;
        long maximumTotal = 0;
        for( long value: degree){
            maximumTotal += (importance*value);
            importance++;
        }
        return maximumTotal;
    }
}