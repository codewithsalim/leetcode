class Solution {
    private int n;
    private int[][] cache;

    public int minSteps(int n) {
        if (n == 1) return 0;
        this.n = n;
        this.cache = new int[n + 1][n / 2 + 1];
        return 1 + calculateMinOps(1, 1);
    }

    private int calculateMinOps(int currentLength, int clipboardLength) {
        if (currentLength == n) return 0;
        if (currentLength > n) return Integer.MAX_VALUE / 2; 

        if (cache[currentLength][clipboardLength] != 0) {
            return cache[currentLength][clipboardLength];
        }

        int pasteOption = 1 + calculateMinOps(currentLength + clipboardLength, clipboardLength);
        int copyPasteOption = 2 + calculateMinOps(currentLength * 2, currentLength);

        int result = Math.min(pasteOption, copyPasteOption);
        cache[currentLength][clipboardLength] = result;

        return result;
    }
}