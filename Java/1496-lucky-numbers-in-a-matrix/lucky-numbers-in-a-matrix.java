class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int rowMinMax = Integer.MIN_VALUE;
        // Find the maximum among the minimum values of each row
        for (int i = 0; i < numRows; i++) {
            int rowMin = Integer.MAX_VALUE;
            for (int j = 0; j < numCols; j++) {
                rowMin = Math.min(rowMin, matrix[i][j]);
            }
            rowMinMax = Math.max(rowMinMax, rowMin);
        }

        int colMaxMin = Integer.MAX_VALUE;
        // Find the minimum among the maximum values of each column
        for (int i = 0; i < numCols; i++) {
            int colMax = Integer.MIN_VALUE;
            for (int j = 0; j < numRows; j++) {
                colMax = Math.max(colMax, matrix[j][i]);
            }
            colMaxMin = Math.min(colMaxMin, colMax);
        }

        // Check if the found values are equal
        if (rowMinMax == colMaxMin) {
            return new ArrayList<>(Arrays.asList(rowMinMax));
        }

        return new ArrayList<>();
    }
}
