
Sum Root to Leaf Numbers Feb 195355 / 15250
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return 0;
        return helpFun(root, 0);
    }
    
    public int helpFun(TreeNode n,  int c){
        if(n == null){
            return 0;
        }
        
        int sum = c*10 + n.val;
        
        if(n.left == null && n.right == null){
            return sum;
        }else{
            return helpFun(n.left, sum) + helpFun(n.right, sum);
        }
    }  
}
