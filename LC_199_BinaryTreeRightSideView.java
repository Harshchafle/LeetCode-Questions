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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int levels = getLevel(root);
        for(int i = 0; i < levels; i++){
            list.add(0);
        }
        postOrder(root, list, 0);
        return list;
    }

    public int getLevel(TreeNode root){
        if(root == null) return 0;
        return 1+Math.max(getLevel(root.left), getLevel(root.right));
    }

    // PreOrder
    public void preOrder(TreeNode root, List<Integer> list, int level){
        if(root == null)return;
        list.set(level, root.val);
        preOrder(root.left, list, level+1);
        preOrder(root.right, list, level+1);
        return;
    }

    // Inorder
    public void inOrder(TreeNode root, List<Integer> list, int level){
        if(root == null)return;
        inOrder(root.left, list, level+1);
        list.set(level, root.val);
        inOrder(root.right, list, level+1);
        return;
    }

    // PostOrder
    public void postOrder(TreeNode root, List<Integer> list, int level){
        if(root == null)return;
        postOrder(root.left, list, level+1);
        postOrder(root.right, list, level+1);
        list.set(level, root.val);
        return;
    }

    // Level Order
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     int levels = getLevel(root);
    //     boolean done[] = new boolean[levels];
    //     bfs(root, list, levels, 0, done);
    //     return list;
    // }

    // public int getLevel(TreeNode root){
    //     if(root == null) return 0;
    //     return 1+Math.max(getLevel(root.left), getLevel(root.right));
    // }

    // public void bfs(TreeNode root, List<Integer> list, int levels, int currLevel, boolean[] done){
    //     if(root == null) return;
    //     for(int i = 0; i < levels; i++){
    //         if(!done[currLevel]){
    //             done[currLevel] = true;
    //             list.add(root.val);
    //         }
    //     }
    //     bfs(root.right, list, levels, currLevel+1, done);
    //     bfs(root.left, list, levels, currLevel+1, done);
    // }
}