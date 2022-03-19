package 二叉树;

import java.util.ArrayList;

/*
二叉树中和为某一值的路径
* */
//public class Main4 {
//    public boolean hasPathSum (TreeNode root, int sum) {
//        if (root == null)
//            return false;
//        return dfs(root,sum,0);
//    }

//    private boolean dfs(TreeNode root, int sum, int target) {
//        target+=root.val;
//        if (target == sum && root.left == null && root.right == null)
//            return true;
//        boolean left = false;
//        boolean right = false;
//        if (root.left!=null)
//            left = dfs(root.left,sum,target);
//        if (root.right!= null)
//            right = dfs(root.right,sum,target);
//        return left || right;
//    }
//}
