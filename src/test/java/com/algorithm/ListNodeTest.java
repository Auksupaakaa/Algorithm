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
    //    标识头部
    public ListNode head;

    @Test
    /*
     * @Description:   新建一个链表
     * 1、创建一个节点的对象信息，将0的值传入，设定其为头节点
     * 2、创建一个节点的引用类型指向这个头节点，作用相当于指针
     * 3、循环创建新的节点，同时将循环次数的值传入新建的节点中
     * 4、连接新创建的节点:指针(节点的引用类型变量).next = new node
     * 5、指针(节点的引用类型变量)后移，指向新建立的节点
     * 6、循环结束后指针指向头节点
     * @Param: []
     * @return: void
     * @Author: wertop
     * @Date: 2022/6/7
     */
    public void createListNode() {
        ListNode Listnode = new ListNode(0);    //创建首节点，节点的val是0.
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点,指向首节点，它只代表一个指向的变量
        nextNode = Listnode;                      //指向首节点

        //创建链表
        for (int i = 1; i < 10; i++) {
            ListNode node = new ListNode(i);  //生成新的节点
            nextNode.next = node;               //把新节点连起来
            nextNode = nextNode.next;           //当前节点往后移动
        }
        //当for循环完成之后 nextNode指向最后一个节点，

        nextNode = Listnode;                     //重新赋值让它指向首节点
        print(nextNode);                      //打印输出

    }

    @Test
    /*
     * @Description: 反转链表并输出头节点
     * @Param: []
     * @return: void
     * @Author: wertop
     * @Date: 2022/6/7
     */
    public void reverseList() {
        ListNode head = new ListNode(null);
        ListNode pointer = head;
        int num = 0;
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode(i);
            pointer.next = node;
            pointer = node;
            num++;
        }
//        链表创建完成后将指针指向头节点
        pointer = head;
//        链表的遍历操作
        while (pointer != null) {
            System.out.println("当前节点为:" + pointer.getVal());
            pointer = pointer.next;
        }
        ListNode node = ReverseList(head);
        print(node);


    }

    @Test
    public void createSingleLinkedList() {
//        创建头节点
        ListNode listNode = new ListNode(null);
//        创建指针指向头节点
        ListNode pointer = listNode;
//        创建新的节点
        for (int i = 0; i < 10; i++) {
//            创建新的节点
            ListNode node = new ListNode(i);
//            用指针连接新的节点
            pointer.next = node;
//            指针后移
            pointer = node;
        }
//        将指针指向头节点
        print(listNode);
    }

    public ListNode ReverseList(ListNode head) {
//        空链表情况的判别
        if (head == null) {
            return null;
        }
//        当前指针指向头节点
        ListNode current = head;
//        前驱指针先指向null
        ListNode pre = null;
        while (current != null) {
//            临时节点指向赋值为当前指针节点
            ListNode temp = current.next;
//            当前指针节点的下一个节点设为前驱指针节点
            current.next = pre;
//            前驱指针指向当前指针指向节点
            pre = current;
//            当前指针节点指向临时节点
            current = temp;
        }
        return pre;
    }

    //打印输出方法
    static void print(ListNode listNoed) {
        //创建链表节点
        while (listNoed != null) {
            System.out.println("节点:" + listNoed.val);
            listNoed = listNoed.next;
        }
        System.out.println();
    }

    /*
    * 单链表的增删改查操作
    * 单链表的遍历操作
    * 增：头插法、尾插法和在指定索引位置插入
    增：有序链表
    删：删除指定索引节点和删除所有指定值的节点
    改：修改指定索引位置节点的值
    查：查询链表中是否包含指定值的节点*/
    @Test
    public void testList() {
//        头插法演示
        for (int i = 0; i < 10; i++) {
            int v = (int) (Math.random() * 10);
            addFirst(v);
        }
        while (head.next != null) {
            System.out.println(head.getVal());
            head = head.next;
        }
    }

    //    单链表不带头结点头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    @Test
    public void addNodeFinal() {
        //        尾插法演示
        for (int i = 0; i < 10; i++) {
            int v = (int) (Math.random() * 10);
            addFinally(v);
        }
        int size = size();
        System.out.println(size);
        while (head.next != null) {
            System.out.println(head.getVal());
            head = head.next;
        }
    }

    //    单链表不带头结点尾插法
    public void addFinally(int data) {
        ListNode node = new ListNode(data);
        ListNode pointer = this.head;
        if (head == null) {
            this.head = node;
        } else {
//            指针后移到最后
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = node;
        }

    }

    @Test
    /*
     * @Description: 单链表的遍历
     * @Author: wertop
     * @Date: 2022/6/15
     */
    public void getLinkedListCount() {
//        遍历链表
        for (int i = 0; i < 20; i++) {
            int v = (int) (Math.random() * 10);
            addFinally(v);
        }
        int size = size();
        System.out.println(size);
    }

    public int size() {
        int count = 0;
        ListNode pointer = this.head;
        while (pointer != null) {
            pointer = pointer.next;
            count++;
        }
        return count;
    }

    @Test
    /*
     * @Description: 向指定的位置插入一个节点
     * @Author: wertop
     * @Date: 2022/6/15
     */
    public void insertNode() {

    }

    public ListNode findIndex(int index) {
        //        先让指针后移index-1位,找到相应得插入位
        int count = 0;
        ListNode pointer = this.head;
        while (count != index - 1) {
            pointer = pointer.next;
            count++;
        }
        return pointer;
    }

    //    在任意位置插入，第一个数据节点为0号下标
    public void addIndex(int index, int data) {
//        相应节点的合法性判断
        if (index < 0 || index > size()) {
            System.out.println("index得位置不合法");
            return;
        }
        if (index == 0) {
            this.addFirst(data);
        }
        if (index == size()) {
            this.addFinally(data);
        }
//        中间的随机未知节点
        ListNode pointer = findIndex(index);
        ListNode node = new ListNode(data);
        node.next = pointer.next;
        pointer.next = node;
    }




}
