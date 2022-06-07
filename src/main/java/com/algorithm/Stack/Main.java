package com.algorithm.Stack;

/*
* @Description:
* 请你实现一个栈。
操作：
push x:将 加x入栈，保证 x为 int 型整数。
pop:输出栈顶，并让栈顶出栈
top:输出栈顶，栈顶不出栈
* 输入描述：
第一行为一个正整数 n，代表操作次数。(1≤n≤100000)
接下来的 n ，每行为一个字符串，代表一个操作。保证操作是题目描述中三种中的一种。
* 输出描述：
如果操作为push，则不输出任何东西。
如果为另外两种，若栈为空，则输出 "error“
否则按对应操作输出。
*输入: 6
push 1
pop
top
push 2
push 3
pop
* 输出:
* 1
error
3
* @Param:
* @return:
* @Author: wertop
* @Date: 2022/6/7
*/
import java.util.* ;
class Stack1 {
    int[] data ;//保存数据
    int size = 0 ;//栈中元素个数
    int maxSize ;//栈的最大容量
    int top = 0 ;//栈顶指针（栈顶元素索引+1）
    public Stack1(int maxSize) {//构造器
        this.maxSize = maxSize ;
        this.data = new int[maxSize] ;
    }
    public void push(int val) {//压栈操作
        if(this.size == this.maxSize) {//元素的个数已经达到栈的最大容量，不允许存储，报错
            System.out.println("error") ;
        } else {
            data[top++] = val ;//在栈顶指针的位置增加新元素，栈顶指针更新+1
            this.size++ ;//栈中元素个数更新+1
        }
    }
    public void top() {//查看栈顶元素
        if(this.size == 0) {//栈中没有元素，不允许查看，报错
            System.out.println("error") ;
        } else {
            System.out.println(data[top-1]) ;//打印栈顶的元素（注意top永远指向栈顶元素的下一个，因此top-1为栈顶元素的位置）
        }
    }
    public void pop() {//弹栈操作
        if(this.size == 0) {//栈中没有元素，不允许弹栈,报错
            System.out.println("error") ;
        } else {
            System.out.println(data[--top]) ;//打印栈顶元素，top指针更新-1
            this.size-- ;//栈中元素个数更新-1
        }
    }
}
 public class Main {
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in) ;
        int n = Integer.parseInt(scan.nextLine()) ;//获取总的操作次数
        Stack1 s = new Stack1(n) ;//因为压栈操作的次数一定小于总的操作次数，因此将栈的容量大小设置为 n 一定保险
        while(scan.hasNextLine()) {//获取每一次操作
            String str = scan.nextLine() ;
            String arr[] = str.split(" ") ;
            if(arr[0].equals("push")) {
                s.push(Integer.parseInt(arr[1])) ;
            } else if(arr[0].equals("pop")) {
                s.pop() ;
            } else {
                s.top() ;
            }
        }
    }
}
