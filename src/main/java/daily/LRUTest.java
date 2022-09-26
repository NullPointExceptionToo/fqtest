package daily;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUTest {
    public static void main(String[] args) {

    }

}
class LRUCache1<K, V>{
    private LinkedList<K> list;
    private Map<K, V> map;
    private int capital;
    public LRUCache1(int capital){
        list = new LinkedList<>();
        map = new HashMap<>();
        this.capital = capital;
    }
    public V get(K k){
        if(!map.containsKey(k)) {
            return null;
        }else{
            list.remove(k);
            list.addLast(k);
            return map.get(k);
        }
    }
    public void put(K k ,V v) {
        if(!map.containsKey(k)) {
            if(capital == map.size()) {
                K key = list.removeFirst();
                map.remove(key);
            }
            map.put(k, v);
            list.addLast(k);
        }else{
            map.put(k, v);
            list.remove(k);
            list.addLast(k);
        }

    }
}

class LRUCache2<K, V> extends LinkedHashMap<K, V> {
    private int capital;
    public LRUCache2(int capital){
        super(16, 0.75f, true);
        this.capital = capital;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capital;
    }
}


class LRUCache{
    private int maxSize = 0;
    private int count = 0;
    private Map<Integer,Node> map = null;
    private DefinedLinkList list = null;

    public LRUCache(int maxSize){
        this.maxSize = maxSize;
        map = new HashMap<>();
        list = new DefinedLinkList();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        list.moveToLast(node);
        return node.v;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(count >= maxSize){
                int k = list.removeHead();
                map.remove(k);
                count--;
            }
            Node node = new Node(key, value);
            list.addLast(node);
            map.put(key, node);
            count++;
        }else{
            Node node = map.get(key);
            node.v = value;
            list.moveToLast(node);
        }

    }




    class DefinedLinkList{

        private Node head = null;
        private Node tail = null;

        public DefinedLinkList(){
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        // 添加结点
        public void addLast(Node node){
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
        }
        //删除结点
        public void removeNode(Node node){
            if(node != null){
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
        }

        //移动某结点到尾部
        public void moveToLast(Node node){
            this.removeNode(node);
            this.addLast(node);
        }

        //删除头结点
        public int removeHead(){
            Node node = head.next;
            head.next = node.next;
            node.next.pre = head;
            return node.k;
        }

    }


    class Node{
        Node pre;
        Node next;
        int k;
        int v;
        public Node(){}

        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }

}


