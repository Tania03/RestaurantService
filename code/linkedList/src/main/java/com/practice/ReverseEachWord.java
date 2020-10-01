package com.practice;

/**
 * @author tania.gupta
 * @date 30/06/20
 */


public class ReverseEachWord {

    public static void main(String[] args) {

        CharListNode tail1 = new CharListNode('u', null);
        CharListNode tail2 = new CharListNode('o', tail1);
        CharListNode tail3 = new CharListNode('y', tail2);
        CharListNode tail4 = new CharListNode(' ', tail3);
        CharListNode tail5 = new CharListNode('e', tail4);
        CharListNode tail6 = new CharListNode('r', tail5);
        CharListNode tail7 = new CharListNode('a', tail6);
        CharListNode tail8 = new CharListNode(' ', tail7);
        CharListNode tail9 = new CharListNode('w', tail8);
        CharListNode tail10 = new CharListNode('o', tail9);
        CharListNode head = new CharListNode('h', tail10);

        ReverseEachWord reverseEachWord = new ReverseEachWord();
        CharListNode newHead = reverseEachWord.getReversedLinkedList(head);

        reverseEachWord.printReversedList(newHead);
    }

    public void printReversedList(CharListNode newHead) {

        CharListNode current = newHead;

        while (current != null) {
            System.out.print(current.val);
            current = current.next;
        }

    }


    public CharListNode getReversedLinkedList(CharListNode head) {

        CharListNode newHead = null;

        CharListNode previous = head;
        CharListNode tail = head;

        CharListNode previousHead = null;

        while (true) {

            if (tail == null)
                break;

            tail = findWord(tail);

            CharListNode currentHead = reverseWord(previous, tail);

            if (newHead == null)
                newHead = currentHead;
            else
                previousHead.next = currentHead;

            previousHead = tail;

            if (tail != null) {
                previous = tail.next;
                tail = tail.next;
            }

        }

        return newHead;

    }

    private CharListNode reverseWord(CharListNode previous, CharListNode tail) {

        CharListNode currentHead = previous;

        while (previous.next != tail) {

            //find current head
            CharListNode temp = previous.next;
            // link previous to next
            previous.next = temp.next;

            //assign currentHead
            temp.next = currentHead;

            //update currentHead
            currentHead = temp;

        }

        return currentHead;

    }

    private CharListNode findWord(CharListNode tail) {

        while (tail != null && tail.val != ' ') {
            tail = tail.next;
        }
        return tail;
    }

}

