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
    int idx=0;
    public TreeNode helper(int []preorder,int st,int end,HashMap<Integer,Integer>map){
        if(st>end)return null;
        int rootVal=preorder[idx++];
        TreeNode node=new TreeNode(rootVal);

        int inorderIdx=map.get(rootVal);
        node.left=helper(preorder, st, inorderIdx - 1, map);
        node.right = helper(preorder, inorderIdx + 1, end, map);

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1,map);
    }
}