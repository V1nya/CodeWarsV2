package com.company.Deque;

public class Main {
    public static void main(String[] args) {
        MyDeque deque = new MyDeque();
        deque.pushFirst(1);
        deque.pushFirst(2);
        deque.pushLast(3);
        System.out.println(deque.popLast());
        System.out.println(deque.popLast());
        System.out.println(deque.popLast());
        System.out.println("S:" + deque.getSize());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

//        2.5
    }
}
