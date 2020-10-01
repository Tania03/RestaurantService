package com.practice;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
public class ReverseKNodes {

    public static void main(String[] args) {

        Solution solution = new Solution();

        ListNode tail = new ListNode(5);
        ListNode fourth = new ListNode(4, tail);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(2, third);
        ListNode head = new ListNode(1, second);

        solution.reverseKGroup(head, 2);
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k < 2)
            return head;

        ListNode newHead = null;

        ListNode tail = head;
        ListNode actualHead = head;
        ListNode previousHead = null;

        while (true) {

            int i = 0;
            while (i < k && tail.next != null) {
                tail = tail.next;
                i++;
            }

            if (tail.next == null)
                break;

            ListNode currentHead = actualHead;

            while (actualHead.next != tail) {

                ListNode temp = actualHead.next;
                actualHead.next = temp.next;

                temp.next = currentHead;
                currentHead = temp;
            }

            if (newHead == null)
                newHead = currentHead;
            else
                previousHead.next = currentHead;

            previousHead = actualHead;
            actualHead = tail;

        }

        return newHead;
    }
}