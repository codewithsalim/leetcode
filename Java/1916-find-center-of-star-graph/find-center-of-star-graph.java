class Solution {
    public int findCenter(int[][] edges) {
        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];

        if ( secondEdge[0] == firstEdge[0] || secondEdge[0] == firstEdge[1] ){
            return secondEdge[0];
        }else{
            return secondEdge[1];
        }
        
    }
}