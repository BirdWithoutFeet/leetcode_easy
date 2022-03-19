package 二叉树;

import java.util.ArrayList;
import java.util.Stack;

public class Main3 {
//    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        if (pRoot == null)
//            return res;
//        Stack<TreeNode> [] stacks = new Stack[2];
//        stacks[0] = new Stack<>();
//        stacks[1] = new Stack<>();
//        int current = 0;
//        int next = 1;
//        ArrayList<Integer> path = new ArrayList<>();
//        stacks[current].add(pRoot);
//        while(stacks[current].size()!=0 || stacks[next].size()!=0){
//            TreeNode tree = stacks[current].pop();
//            path.add(tree.val);
//            if (current == 0){
//                if (tree.left != null)
//                    stacks[next].add(tree.left);
//                if (tree.right != null)
//                    stacks[next].add(tree.right);
//            }else {
//                if (tree.right != null)
//                    stacks[next].add(tree.right);
//                if (tree.left != null)
//                    stacks[next].add(tree.left);
//            }
//            if (stacks[current].size() == 0){
//                current = 1-current;
//                next = 1-next;
//                res.add(path);
//                path = new ArrayList<Integer>();
//            }
//        }
//        return res;
//
//    }
}
