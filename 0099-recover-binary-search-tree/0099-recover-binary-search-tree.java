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
    public void recoverTree(TreeNode root) {
        TreeNode first=null;
        TreeNode second=null;
        TreeNode node=null;
        
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                if(node!=null && node.val>curr.val){
                    if(first==null)first=node;
                    second=curr;
                }
                node=curr;
                curr=curr.right;
            }else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }else{
                    prev.right=null;
                    if(node!=null && node.val>curr.val){
                        if(first==null)first=node;
                        second=curr;
                    }
                    node=curr;
                    curr=curr.right;
                }
            }
        }
        if(first!=null && second!=null){
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
        }

    }
}