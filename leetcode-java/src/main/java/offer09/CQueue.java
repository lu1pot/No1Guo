package offer09;

import java.util.Stack;

class CQueue {
    private static Stack<Integer> stack_1;
    private static Stack<Integer> stack_2;
    public CQueue() {
        stack_1 = new Stack<>();
        stack_2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack_1.push(value);
    }

    public int deleteHead() {
        if(stack_2.isEmpty()){
            while (!stack_1.isEmpty()){
                stack_2.push(stack_1.pop());
            }
        }

        int res = -1;
        if(!stack_2.isEmpty()){
            res =  stack_2.pop();
        }
        return res;
    }
}
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */