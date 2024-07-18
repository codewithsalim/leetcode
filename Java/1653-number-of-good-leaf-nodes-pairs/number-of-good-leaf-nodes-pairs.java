class Solution {
    private int pairCount = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return pairCount;
    }

    private int[] dfs(TreeNode node, int distance) {
        // Base case: if the node is null, return an array filled with zeros
        if (node == null) {
            return new int[distance + 1];
        }

        // If the node is a leaf node, create an array with 1 at distance 1
        if (node.left == null && node.right == null) {
            int[] leafDistances = new int[distance + 1];
            leafDistances[1] = 1;
            return leafDistances;
        }

        // Recursive DFS on left and right children
        int[] leftDistances = dfs(node.left, distance);
        int[] rightDistances = dfs(node.right, distance);

        // Count pairs between left and right subtrees within the given distance
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j + i <= distance; j++) {
                pairCount += leftDistances[i] * rightDistances[j];
            }
        }

        // Aggregate distances for the current node
        int[] currentDistances = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentDistances[i + 1] = leftDistances[i] + rightDistances[i];
        }
        return currentDistances;
    }
}
