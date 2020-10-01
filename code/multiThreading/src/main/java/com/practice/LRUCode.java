package com.practice;

import java.util.*;

/**
 * @author tania.gupta
 * @date 23/07/20
 */
public class LRUCode {

    //["LRUCache","put","put","get","put","get","put","get","get","get"]
//        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
    }
}

class LRUCache {

    class Node {

        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

    List<Integer> list;
    Map<Integer, Node> map;
    Node front;
    Node rear;
    int capacity;

    public LRUCache(int capacity) {

        this.list = new LinkedList<>();
        this.map = new HashMap<>();
        this.front = null;
        this.rear = null;
        this.capacity = capacity;

    }

    public int get(int key) {

        if (!map.containsKey(key))
            return -1;

        Node current = map.get(key);

        remove(current);
        offer(current);

        return current.value;

    }

    public void put(int key, int value) {

        if (!map.containsKey(key)) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);

            if (map.size() == capacity) {
                map.remove(rear.key);
                remove(rear);

            }

            offer(newNode);

        } else {
            Node currentNode = map.get(key);
            currentNode.value = value;

            remove(currentNode);
            offer(currentNode);
        }

    }

    public void offer(Node node) {

        if (front != null)
            front.prev = node;

        node.next = front;
        node.prev = null;
        front = node;

        if (rear == null)
            rear = node;

    }

    public void remove(Node node) {

        if (node.prev != null)
            node.prev.next = node.next;
        else
            front = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            rear = node.prev;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */