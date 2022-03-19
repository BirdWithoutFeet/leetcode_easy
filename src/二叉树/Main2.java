package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*层序遍历
* */
public class Main2 {
    public class TreeNode {
        int val = 0;
        Main1.TreeNode left = null;
        Main1.TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int toBeAddCount = 1;
        int nextLine = 0;
        ArrayList<Integer> path = new ArrayList<>();
        while(deque.size() != 0){
            TreeNode temp = deque.pop();
            path.add(temp.val);
            toBeAddCount--;
            if (temp.left != null){
//                deque.add(temp.left);
                nextLine++;
            }
            if (temp.right != null){
//                deque.add(temp.right);
                nextLine++;
            }
            if (toBeAddCount == 0){
                toBeAddCount = nextLine;
                nextLine = 0;
                res.add(path);
                path = new ArrayList<>();
            }
        }
        return res;
    }
}
