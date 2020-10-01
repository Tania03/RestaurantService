package com.practice;

/**
 * @author tania.gupta
 * @date 02/08/20
 */
class MyHashSet {

    public static void main(String[] args) {

        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        System.out.println(obj.contains(3));
        System.out.println(obj.contains(2));
        obj.remove(2);
        System.out.println(obj.contains(2));


    }

    private Node[] bucket;
    int size = 1000001;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {

        bucket = new Node[size];

    }

    public int hash(int key) {

        return key % size;

    }

    public void add(int key) {

        Node newNode = new Node(key);

        int index = hash(key);

        if (bucket[index] != null) {
            Node currentNode = bucket[index];
            Node previous = currentNode;

            while (currentNode != null) {

                if (currentNode.value == key)
                    return;

                previous = currentNode;
                currentNode = currentNode.next;
            }

            previous.next = newNode;

        } else {
            bucket[index] = newNode;
        }

    }

    public void remove(int key) {

        int index = hash(key);

        if (bucket[index] != null) {

            Node currentNode = bucket[index];
            Node previous = currentNode;

            while (currentNode.next != null && currentNode.value != key) {
                previous = currentNode;
                currentNode = currentNode.next;
            }

            if (previous == currentNode)
                currentNode = null;
            else
                previous.next = currentNode.next;

        }

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {

        int index = hash(key);

        if (bucket[index] != null) {

            Node currentNode = bucket[index];
            Node previous = currentNode;

            while (currentNode.next != null && currentNode.value != key) {
                previous = currentNode;
                currentNode = currentNode.next;
            }

            if (currentNode.value == key)
                return true;

        }

        return false;

    }
}

class Node {

    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
