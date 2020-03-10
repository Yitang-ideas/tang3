package com.yitangideas.linkedlist;

public class LinkedList<E> {
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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //优雅的写法
        //prev.next = new Node(e,prev.next);
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void addFirst(E e) {
        add(0,e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal.");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(int index,E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal.");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    public boolean contains(E e){
        Node current = dummyHead.next;
        while(current != null){
            if(e.equals(current.e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node removeElement = prev.next;
        prev.next = removeElement.next;
        E result = removeElement.e;
        removeElement.next = null;
        size--;
        return result;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        if(!this.contains(e))
            return;

        Node prev = dummyHead;
        while(!prev.next.e.equals(e)){
            prev = prev.next;
        }
        Node removeElement = prev.next;
        prev.next = removeElement.next;
        removeElement.next = null;
        size--;

//        Node prev = dummyHead;
//        while(prev.next != null){
//            if (prev.next.e.equals(e))
//                break;
//            prev = prev.next;
//        }
//        if (prev.next != null){
//            Node removeElement = prev.next;
//            prev.next = removeElement.next;
//            removeElement.next = null;
//            size--;
//        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node current = dummyHead.next;
        while(current != null){
            sb.append(current + "->");
            current = current.next;
        }
        sb.append("Null");
        return sb.toString();
    }
}
