package daily;

import sun.awt.image.ImageWatched;

import javax.swing.tree.TreeNode;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TreeSearch {

    /**
     * 1
     * 2     3
     * 4      5  6
     * 7
     */
    public static void main() {
        Btree node1 = new Btree(1);
        Btree node2 = new Btree(2);
        Btree node3 = new Btree(3);
        Btree node4 = new Btree(4);
        Btree node5 = new Btree(5);
        Btree node6 = new Btree(6);
        Btree node7 = new Btree(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node6.right = node7;
        new TreeSearch().preSearchTree(node1);
        System.out.println("----------------------------");
        new TreeSearch().midSearchTree(node1);
        System.out.println("----------------------------");
        new TreeSearch().afterSearchTree(node1);
    }
    /**
     * 先序遍历二叉树非递归
     */
    public void preSearchTree(Btree head) {
        LinkedList<Btree> stack = new LinkedList<>();
        stack.push(head);
        while(!stack.isEmpty()) {
            Btree node = stack.pop();
            System.out.println(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

    }

    /**
     * 中序遍历二叉树非递归
     * @param head
     */
    public void midSearchTree(Btree head) {
        LinkedList<Btree> stack = new LinkedList<>();
        Btree node = head;
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()) {
                Btree tt = stack.pop();
                System.out.println(tt.val);
                node = tt.right;
            }
        }

    }

    /**
     * 后序遍历二叉树非递归
     * @param head
     */
    public void afterSearchTree(Btree head) {
        LinkedList<Btree> stack = new LinkedList<>();
        Btree pre = null;
        stack.push(head);
        while(!stack.isEmpty()) {
            Btree node = stack.peek();
            if((node.left == null && node.right == null) || (pre != null && (pre == node.left || pre == node.right))) {
                pre = stack.pop();
                System.out.println(pre.val);
            }else{
                if(node.right != null) {
                    stack.push(node.right);
                }
                if(node.left != null) {
                    stack.push(node.left);
                }
            }
        }


    }

}
class Btree{
    int val;
    Btree left;
    Btree right;
    public Btree(int val){
        this.val = val;
    }
}
