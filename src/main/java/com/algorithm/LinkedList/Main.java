package com.algorithm.LinkedList;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author wertop
 * @Date 9:47 2022/6/2
 * @Version 1.0
 **/
import java.util.Scanner;
/*
* @Description:
* 描述
请你实现一个链表。
操作：
insert x y:将y加入链表，插入在第一个值为x的结点之前。若链表中不存在值为x的结点，则插入在链表末尾。保证x,y为int型整数。
delete x:  删除链表中第一个值为xx的结点。若不存在值为xx的结点，则不删除。
输入描述：
第一行输入一个整数nn (1<= n<= 10^4)，表示操作次数。
接下来的n行，每行一个字符串，表示一个操作。保证操作是题目描述中的一种。
输出描述：
输出一行，将链表中所有结点的值按顺序输出。若链表为空，输出"NULL"(不含引号)
*
* 输出示例:
* 输入:5
insert 0 1
insert 0 3
insert 1 2
insert 3 4
delete 4
* 输出:2 1 3
*
* @Param:
* @return:
* @Author: wertop
* @Date: 2022/6/7
*/
 public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        MyLinked linked = new MyLinked();
        for(int i=0;i<n;i++){
            String[] tempData = sc.nextLine().split(" ");
            switch(tempData[0]){
                case "insert":
                    linked.insert(Integer.parseInt(tempData[1]),Integer.parseInt(tempData[2]));
                    break;
                case "delete":
                    linked.delete(Integer.parseInt(tempData[1]));
                    break;
            }
        }
        linked.output();
        sc.close();
    }
}

class MyLinked{
    private Node head;//头节点

    private int length;//链表的长度

    //创建一个单链表
    public MyLinked(){
        this.length = 0;
        head = new Node(null);
    }

    //向链表中添加数据
    public void insert(int value,int data){
        Node p = this.head;//前指针
        Node q = this.head.getNext();//后指针
        while(q!=null && q.getData()!=value){//加上q!=null,防止找到最后节点不结束而出现空指针错误(放前面)
            p = q;
            q = q.getNext();
        }
        if(q==null){//链表中没有所查找的数据,新数据插入末尾
            p.setNext(new Node(data,null));
            this.length++;
        }
        else{//找到目标数据
            p.setNext(new Node(data,q));
            this.length++;
        }
    }

    //删除链表中的数据
    public void delete(int data){
        if(isEmpty()){
            return;
        }
        Node p = this.head;
        Node q = this.head.getNext();
        while(q!=null && q.getData()!=data){
            p = q;
            q = q.getNext();
        }
        if(q==null){//所要删除的数据不存在
            return;
        }
        else{//找到，删除
            p.setNext(q.getNext());
            this.length--;
        }
    }

    //判空
    public boolean isEmpty(){
        if(this.length==0){
            return true;
        }
        return false;
    }

    //链表中的数据输出
    public void output(){
        if(isEmpty()){
            System.out.println("NULL");
            return;
        }
        Node temp = this.head.getNext();
        for(int i=0;i<this.length;i++) {
            if (i==this.length-1) {
                System.out.print(temp.getData());
                break;
            }
            else {
                System.out.print(temp.getData()+" ");
                temp = temp.getNext();
            }
        }
    }
}

class Node{
    private int data;//数据域

    private Node next;//指针域

    //创建一个头节点
    public Node(Node next){
        this.next = next;
    }

    //创建一个实际节点
    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node next){
        this.next = next;
    }
}

