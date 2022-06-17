package com.company.Deque;

public class MyDeque<T> {

    private MyNode<T> head ;
    private MyNode<T> tail ;
    private int size = 0;

    public MyDeque() {
    }

    public MyDeque(T t) {
        MyNode<T> node = new MyNode<>(t);
        head = node;
        tail = node;
    }

    public void pushFirst(T t) {
        MyNode<T> node = new MyNode<>(t);
        if (head != null) {
            head.setPrev(node);
            node.setNext(head);
            head = node;
        } else {
            head = node;
            tail = node;
        }
        size++;
    }

    public void pushLast(T t) {
        MyNode<T> node = new MyNode<>(t);
        if (tail != null) {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }else {
            head=node;
            tail=node;
        }
        size++;

    }

    public T peekFirst() {

        return head!=null? head.getValue() : null;
    }

    public T peekLast() {
        return tail!=null? tail.getValue() : null;
    }

    public T popFirst(){
        if (head!=null){
            var node = head;
            head = node.getNext()!=null?node.getNext():null;
            if (head==null)
                tail=null;
            size--;
            return node.getValue();
        }
        return null;
    }
    public T popLast(){
        if (tail!=null){
            var node = tail;
            tail=node.getPrev()!=null?node.getPrev():null;
            if (tail==null)
                head=null;
            size--;
            return node.getValue();
        }
        return null;
    }

    public int getSize() {
        return size;
    }
}
