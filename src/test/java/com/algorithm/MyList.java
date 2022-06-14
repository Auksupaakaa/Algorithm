package com.algorithm;

import lombok.Data;

/**
 * @ClassName MyList
 * @Description TODO
 * @Author wertop
 * @Date 16:21 2022/6/14
 * @Version 1.0
 **/
@Data
public class MyList {

//    头节点
    private ListNode head;
//    临时节点
    private ListNode temp;
//    节点个数
    private int size;

    public MyList() {
    }

    public MyList(ListNode head) {
        this.head = head;
    }
}
