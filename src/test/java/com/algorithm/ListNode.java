package com.algorithm;

/**
 * @ClassName com.algorithm.ListNode
 * @Description TODO
 * @Author wertop
 * @Date 9:48 2022/6/2
 * @Version 1.0
 **/
public class ListNode {
//    数据域
    int val;
//    指针域
    ListNode next;


    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
