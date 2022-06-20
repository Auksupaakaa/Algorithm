package com.algorithm.ListTest;

import com.algorithm.ListNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName ListTest
 * @Description TODO
 * @Author wertop
 * @Date 16:09 2022/6/20
 * @Version 1.0
 **/
@SpringBootTest
public class ListTest {


    /*
    * @Description: 一个节点的创建
    * @Author: wertop
    * @Date: 2022/6/20
    */
    public ListNode createList() {
//        创建首节点
        ListNode head = new ListNode(null);
//        创建指针指向首届点
        ListNode listNode;
        listNode = head;

        for (int i = 0; i < 10; i++) {
//        生成随机数
            int v = (int) (Math.random() * 10);
            ListNode node = new ListNode(v);  //生成新的节点
            listNode.next = node;   //连接新建的节点
//            指针后移
            listNode = node;
        }
        listNode = head;
        printfNode(listNode);
        return listNode;
    }
    public void printfNode(ListNode listNode){
        int count = 0;
        while (listNode.next!=null){
            count++;
            System.out.println(count+"号节点的值为: "+listNode.val);
            listNode = listNode.next;
        }
    }


    @Test
    public void ListReserve(){
//        反转前链表的内容
        ListNode list = createList();
        printfNode(list);
        ListNode cur;
        ListNode pre;
        pre = null;
        cur = list;
        while (cur!=null){
            ListNode temp = list.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        printfNode(cur);


    }
}
