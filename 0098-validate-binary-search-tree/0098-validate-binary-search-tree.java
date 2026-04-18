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
    public boolean helper(TreeNode root,Long min,Long max){
        if (root==null)return true;
        if((min!=null && root.val<=min)||(max!=null && root.val>=max)){
            return false;
        }else{
            return helper(root.left,min,(long)root.val)&& helper(root.right,(long)root.val,max);
        }
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
}