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
/*
preorder - root, left, right - [1,2,3,4]
inorder - left, root, right - [2,1,3,4]
                               0,1 2 3
post - left, right, root

root - [1, ]
*/

class Solution {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, inorder, 0, inorder.length-1, map);
        return root;
    }
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end, HashMap<Integer, Integer> map)
    {
        if(index == inorder.length || start > end)
            return null;
        TreeNode root = new TreeNode(preorder[index]);
        int rootIndex = map.get(preorder[index]);
        index++;

        root.left = helper(preorder, inorder, start, rootIndex-1, map);
        root.right = helper(preorder, inorder,rootIndex+1, end, map);
        return root;
    }
}


/*
        3
    9        
null null
preorder = [3,9,20,15,7]
                i
inorder = [9,3,15,20,7]

map :
9 - 0
3 - 1
15 - 2           
20 - 3
7 - 4

helper(preorder, inorder,0,4, map ) - root = 3, rootidx = 1, root.left = (0,0) root.right = (2,4)
helper(preorder, inorder,0,0, map ) - root = 9, rootidx = 0, root.left = (0,-1) root.right = (1,0)
helper(preorder, inorder,2,4, map ) - root = 20, rootidx = 3, root.left = (0,2) root.right = (4,4)



*/
