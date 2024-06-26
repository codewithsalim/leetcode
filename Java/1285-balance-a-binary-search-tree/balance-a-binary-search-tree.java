/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);
        return balanceBinarySearchTree(root, nodes, 0, nodes.size()-1);
    }

    private void inOrderTraversal(TreeNode root, List<TreeNode> nodes){
        if ( root == null ){
            return;
        }
        inOrderTraversal(root.left, nodes);
        nodes.add(root);
        inOrderTraversal(root.right, nodes);
    }

    private TreeNode balanceBinarySearchTree(TreeNode root, List<TreeNode> nodes, int start, int end){
        if ( start > end ) return null;

        int mid = start + (end-start)/2;
        root = nodes.get(mid);
        root.left = balanceBinarySearchTree(root.left, nodes, start, mid-1);
        root.right = balanceBinarySearchTree(root.right, nodes, mid+1, end);
        return root;
    }
}