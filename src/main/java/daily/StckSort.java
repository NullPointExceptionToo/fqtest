package daily;

import java.util.Stack;

/**
 * 不借助其他数据结构给栈内数据进行排序
 */
public class StckSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 22, 77, 5, 56, 555, 1, 3, 55, 23};
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<array.length;i++) {
            stack.push(array[i]);
        }
        Stack<Integer> res = stacksort(stack);
        System.out.print("");
    }
    public static Stack<Integer> stacksort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            //以下操作把辅助栈中比temp大的元素全部移入源栈中
            while(!help.isEmpty() && temp < help.peek()) {
                stack.push(help.pop());
            }
            //把元素temp放入合适的位置，使得temp下面的元素都比它小
            help.push(temp);
        }
        return help;
    }
}
