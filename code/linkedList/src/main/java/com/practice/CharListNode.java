package com.practice;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @author tania.gupta
 * @date 01/07/20
 */

public class CharListNode {

    Character val;
    CharListNode next;

    public CharListNode(Character val, CharListNode next) {
        this.val = val;
        this.next = next;
    }

    public Character getVal() {
        return val;
    }

    public void setVal(Character val) {
        this.val = val;
    }
}
