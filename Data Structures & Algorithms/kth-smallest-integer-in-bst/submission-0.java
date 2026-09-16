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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //left,root,right
        TreeNode node = null;
        int counter = 0;
        while(!stack.isEmpty() || root!= null)
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            node = stack.pop();
            counter++;
            if(counter == k)
                return node.val;
            root = node;
            root = root.right;
        }
        return 0;
    }
}
