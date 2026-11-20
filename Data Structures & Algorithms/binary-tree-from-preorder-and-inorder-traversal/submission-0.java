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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null)
            return new TreeNode();
        //creating a map of elements and their indexes for O(1) get
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, inorder, 0, inorder.length-1, map);
        return root;
    }
    public TreeNode helper(int[] preorder, int[] inorder,int start,int end,HashMap<Integer, Integer> map)
    {
        if(index == preorder.length || start > end)
            return null;
        TreeNode root = new TreeNode(preorder[index]);
        int rootIndex = map.get(preorder[index]);
        index++;
        root.left = helper(preorder, inorder, start, rootIndex-1, map);
        root.right = helper(preorder, inorder, rootIndex+1, end, map);
        return root;
    }

}
