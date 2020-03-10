package com.yitangideas.linkedlist;

import com.yitangideas.queue.Queue;

/**
 * 链表头作为 队首进行出队，链表尾作为 队尾进行入队
 * 因为head端比较好删除，tail端比较好添加
 *  队首                       队尾
 *   0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null
 * head                      tail
 * 由于操作都在 head 和 tail，所以不适用虚拟头节点 dummyHead
 **/
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        //如果tail为空,队列一定为空
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Can't dequeue from empty queue.");
        }
        Node result = head;
        head = head.next;
        result.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return result.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Can't dequeue from empty queue.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue : front ");
        Node current = head;
        while(current!=null){
            sb.append(current + "->");
            current = current.next;
        }
        sb.append("Null tail");
        return sb.toString();
    }
}
