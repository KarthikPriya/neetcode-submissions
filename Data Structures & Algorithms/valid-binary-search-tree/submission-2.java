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
    boolean result = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        result = dfs(root,null, null);
        return result;
    }
    public boolean dfs(TreeNode root, TreeNode left, TreeNode right)
    {
        if(root == null)
            return true;
        if(left!= null && root.val <= left.val)
            return false;
        if(right!= null && root.val >= right.val)
            return false;
        return dfs(root.left,left,root) && dfs(root.right,root,right);
        
    }
}
/*
   2

2.    2

2, null, null
2, null, 2
2, 2, null




10, null, null
5,null, 10
25, 10, null
1,null, 5
8,5,10


        10

     5        25

   1    8   15    30


*/

