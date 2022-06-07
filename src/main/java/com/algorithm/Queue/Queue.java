package com.algorithm.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* @Description:
请你实现一个队列。
操作：
push x：将 x加入队尾，保证 x 为 int 型整数。
pop：输出队首，并让队首出队
front：输出队首：队首不出队
输入描述：
第一行为一个正整数 n ，代表操作次数。(1≤n≤100000)
接下来的 n ，每行为一个字符串，代表一个操作。保证操作是题目描述中三种中的一种
输出描述：
如果操作为push，则不输出任何东西。
如果为另外两种，若队列为空，则输出 "error“
否则按对应操作输出
*输入:6
push 1
pop
front
push 2
push 3
pop
输出:1
error
2
* @Param:
* @return:
* @Author: wertop
* @Date: 2022/6/7
*/
public class Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = Integer.parseInt(sc.nextLine());  //这里得是nextLine，若是nextInt,下面for循环就得小于time+1
        String[] arr;
        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            arr = sc.nextLine().split(" ");
            switch (arr[0]) {
                case "push":
                    push(queue,arr);
                    break;
                case "pop":
                    System.out.println( pop(queue));
                    break;
                case "front":
                    System.out.println( front(queue));
                    break;
            }
        }
        sc.close();
    }
    //向queue里添加数据
    public static void push(List<Integer> queue,String[] arr) {
        queue.add(Integer.parseInt(arr[1]));
    }
    public static int index=0;

    //输出队首，并让队首出队
    public static String  pop(List<Integer> queue) {
        return index == queue.size()?"error":queue.get(index++).toString();
    }
    //输出队首：队首不出队
    public static String front(List<Integer> queue) {
        return index == queue.size()?"error":queue.get(index).toString();
    }

}

