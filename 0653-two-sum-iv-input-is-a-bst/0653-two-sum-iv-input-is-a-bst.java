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
    public void inorder(TreeNode node,List<Integer>list){
        if(node==null)return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);

    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer>nums=new ArrayList<>();
        inorder(root,nums);
        for(int i=0,j=nums.size()-1;i<j;){
            if(nums.get(i)+nums.get(j)==k)return true;
            if(nums.get(i)+nums.get(j)<k)i++;
            else j--;
        }
        return false;
    }
}