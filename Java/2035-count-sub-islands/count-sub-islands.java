class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int subIslandsCount = 0;

        for ( int i = 0; i < m; i++ ){
            for ( int j = 0; j < n; j++ ){
                if ( grid2[i][j] == 1 )
                    if ( dfs(i, j, grid1, grid2) ){
                        subIslandsCount++;
                    }
            }
        }
        return subIslandsCount;
    }

    private boolean dfs(int i, int j, int[][] grid1, int[][] grid2){
        if ( i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || grid2[i][j] == 0 ){
            return true;
        }

        if ( grid1[i][j] == 0 ){
            return false;
        }

        grid2[i][j] = 0;
        boolean isSubIsland = true;

        isSubIsland &= dfs(i-1, j, grid1, grid2);
        isSubIsland &= dfs(i+1, j, grid1, grid2);
        isSubIsland &= dfs(i, j-1, grid1, grid2);
        isSubIsland &= dfs(i, j+1, grid1, grid2);
        
        return isSubIsland;
    }
}