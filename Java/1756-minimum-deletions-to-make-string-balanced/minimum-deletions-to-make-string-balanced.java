class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        int minDeletions = 0;
        int bCount = 0;

        // minDeletions variable represents dp[i]
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else {
                // Two cases: remove 'a' or keep 'a'
                minDeletions = Math.min(minDeletions + 1, bCount);
            }
        }

        return minDeletions;
    }
}