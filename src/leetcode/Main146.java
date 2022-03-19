package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
* LRU缓存
* 可以通过一个队列来实现
*
* 基于哈希和链表实现
* */
public class Main146 {
//    容量
    private int capacity;
//    Map
    Map<Integer,Node> map;
    Node head;
    Node tail;

    static class Node {
        Integer key;
        Integer value;
        Node next;
        Node pre;

        Node(){}
        Node(Node next,Node pre){
            this.next = next;
            this.pre = pre;
        }
        Node(int  key,int value){
            this.key = key;
            this.value = value;
        }
        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

    }

//    队列
    private Deque<Integer> deque;
    public Main146(int capacity) {
        this.map = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    /*时间复杂度  O（1）*/
    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        delete(node);
        addFirst(node);
        return node.getValue();
    }

    /*时间复杂度  O（1）*/
    public void put(int key, int value) {
        Node node1 = map.get(key);
        if (node1 != null) {
            delete(node1);
            node1.setValue(value);
            addFirst(node1);
        }else {
            Node node = new Node(key, value);
            if (map.size() == capacity){
//                删掉尾部 LRU
                deleteTail();
            }
            map.put(key,node);
            addFirst(node);
        }
    }

    /*队尾删除*/
    private void deleteTail() {
        Node delete = tail.getPre();
        Node current = delete.getPre();
        current.setNext(tail);
        tail.setPre(current);
        map.remove(delete.key);
    }

    /*队头插入
    * 1
    * */
    private void addFirst(Node node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    /*
* 删除指定节点 时间复杂度   1*/
    private void delete(Node node1) {
        Node pre = node1.getPre();
        pre.next = node1.next;
        node1.next.pre = pre;
    }

    public static void main(String[] args) {
        Main146 lRUCache = new Main146(2);
        lRUCache.put(1, 0); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
}
