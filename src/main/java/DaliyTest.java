

import java.util.*;


public class DaliyTest {

}
class LRUCache{
    private Map<Integer, Node> map;
    private DefineLinkedList list;
    private int count = 0;
    private int capital;
    public LRUCache(int capital){
        this.capital = capital;
    }
    public int get(int key) {
        if(!map.containsKey(key)) {
            return  -1;
        }else{
            Node node = map.get(key);
            list.mvToEnd(node);
            return node.v;
        }
    }
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(count >= capital) {
                int k = list.removeHead();
                map.remove(k);
                count--;
            }
            Node node = new Node(key, value);
            map.put(key, node);
            list.addLast(node);
            count++;
        }else{
            Node node = map.get(key);
            node.v = value;
            list.mvToEnd(node);
        }
    }

    public static void main(String[] args) {
        String[] str = ",2,4,5,null,6".split(",");
        System.out.println();
    }

}
class DefineLinkedList{
    Node head;
    Node tail;
    public DefineLinkedList(){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    public void addLast(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }
    public void removeNode(Node node) {
         node.pre.next = node.next;
         node.next.pre = node.pre;
    }
    public int removeHead(){
        Node node = head.next;
        head.next = node.next;
        node.next.pre = head;
        return node.k;
    }
    public void mvToEnd(Node node){
        removeNode(node);
        addLast(node);
    }

}
class Node{
    Node pre;
    Node next;
    int k;
    int v;
    public Node(){

    }
    public Node(int k, int v){
        this.k = k;
        this.v = v;
    }
}


