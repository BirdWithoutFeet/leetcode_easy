package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
/*前、中、后便利
* */
public class Main1 {

     public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
         this.val = val;
        }
      }

    public int[] postorderTraversal (TreeNode root) {
        int []  ans;
         if (root == null)
             return (ans = new int[0]);
        ArrayList<Integer> arrayList = new ArrayList();
        dfs(arrayList,root);
        ans = new int [arrayList.size()];
        int i = 0;
        for (Integer o : arrayList) {
            ans[i++] = o;
        }
        return ans;
    }

    private void dfs(ArrayList<Integer> arrayList, TreeNode root) {
        if (root.left != null)
            dfs(arrayList,root.left);
        if (root.right != null)
            dfs(arrayList,root.right);
        arrayList.add(root.val);
    }
}
