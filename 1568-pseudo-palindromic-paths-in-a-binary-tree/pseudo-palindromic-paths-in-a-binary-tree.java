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
    int result;
    public void palindromeCheck(HashMap<Integer, Integer> path){
        int odd_count = 0;
        for(int freq : path.values()){
            if(freq % 2 != 0){
                odd_count++;
            }
        }
        if(odd_count <= 1){
            result++;
        }
    }
    public void rootToLeafPath(TreeNode root, HashMap<Integer, Integer> path){
        if(root == null)
            return;
        path.put(root.val, path.getOrDefault(root.val, 0) + 1);
        if(root.left == null && root.right == null){
            palindromeCheck(path);
        }
        rootToLeafPath(root.left, new HashMap<>(path));
        rootToLeafPath(root.right, new HashMap<>(path));
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        result = 0;
        rootToLeafPath(root, new HashMap<>());
        return result;
    }    
}