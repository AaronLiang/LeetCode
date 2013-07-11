
Binary Tree Level Order Traversal Sep 29 '123685 / 9429
Given a binary tree, return the level order traversal of 
its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        ArrayList<Integer> c = new ArrayList<Integer>();

        while(queue.size() != 0){
            TreeNode n = queue.poll();
            if(n != null){
                c.add(n.val);
                if(n.left != null)
                    queue.add(n.left);
                if(n.right != null)
                    queue.add(n.right);
                    
            }else{
                lists.add(c);
                c = new ArrayList<Integer>();
                if(queue.peek() != null)
                    queue.add(null);
            }
            
        }
        if(c.size() != 0)
            lists.add(c);
        return lists;
    }
}
