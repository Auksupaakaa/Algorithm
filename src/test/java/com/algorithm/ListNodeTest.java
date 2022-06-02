package com.algorithm;

import com.algorithm.ListNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName com.algorithm.ListNodeTest
 * @Description TODO
 * @Author wertop
 * @Date 9:48 2022/6/2
 * @Version 1.0
 **/
//测试路径要与包路径一致
@SpringBootTest
public class ListNodeTest {
    @Test
    public void createListNode(){
        ListNode Listnode = new ListNode(0);    //创建首节点，节点的val是0.
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode=Listnode;                      //指向首节点

        //创建链表
        for(int i=1;i<10;i++){
            ListNode node = new ListNode(i);  //生成新的节点
            nextNode.next=node;               //把新节点连起来
            nextNode=nextNode.next;           //当前节点往后移动
        }       //当for循环完成之后 nextNode指向最后一个节点，

        nextNode=Listnode;                     //重新赋值让它指向首节点
        print(nextNode);                      //打印输出

    }
    //打印输出方法
    static void print(ListNode listNoed){
        //创建链表节点
        while(listNoed!=null){
            System.out.println("节点:"+listNoed.val);
            listNoed=listNoed.next;
        }
        System.out.println();
    }

}