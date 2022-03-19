package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
*
* 创建最小堆
* 解题思路：需要一个辅助栈帮助同步保存最小元素，并且每次pop时，要同stack一起
*
* 思路：栈里面存放二元数组元素
* */
public class Main155 {
    private Stack<Integer> stack;
    private Stack<Integer> stack_min;
    public Main155() {
        this.stack = new Stack<>();
        this.stack_min = new Stack<>();
    }

    /*入栈*/
    public void push(int val) {
        stack.push(val);
        if (stack_min.isEmpty()){
            stack_min.push(val);
        }else{
            stack_min.push(Math.min(stack_min.peek(),val));
        }
    }

    /*
    * 出栈*/
    public void pop() {
        stack.pop();
        stack_min.pop();
    }

    /*
    * 查看栈顶元素*/
    public int top() {
        return stack.peek();
    }

    /*获得最小栈元素
    * */
    public int getMin() {
        return stack_min.peek();
    }
}
