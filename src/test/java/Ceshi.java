import javax.jnlp.IntegrationService;
import java.util.*;

public class Ceshi {
    public static void main(String[] args) {
        int[] array = {4,6,2,9,7,0,3};
        TreeNode root = new TreeNode(array[0]);
        for(int i=1;i<array.length;i++) {
            build(array[i], root);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
               TreeNode node = queue.poll();
               List<Integer> list = map.getOrDefault(level, new ArrayList<Integer>());
               list.add(node.val);
               map.put(level, list);
               if(node.left != null) {
                   queue.offer(node.left);
               }
               if(node.right != null) {
                   queue.offer(node.right);
               }
            }
            level++;
        }
        int k =1;
        print(root, map, 1, k);

    }
    public static TreeNode build(int value, TreeNode root) {
        if(root == null) {
            root = new TreeNode(value);
        }else if(value < root.val) {
            root.left = build(value, root.left);
        }else{
            root.right = build(value, root.right);
        }
        return root;
    }

    public static void print(TreeNode root, Map<Integer, List<Integer>> map, int level, int k) {
        if(root != null) {
            List<Integer> list = map.get(level);
            System.out.println(list.get(list.indexOf(root.val)-k%list.size() >= 0 ? list.indexOf(root.val)-k%list.size() : list.indexOf(root.val)-k%list.size()+list.size()));
            print(root.left, map, level+1, k);
            print(root.right, map, level+1, k);
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
}
