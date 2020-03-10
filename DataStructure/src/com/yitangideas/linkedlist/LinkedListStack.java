package com.yitangideas.linkedlist;

import com.yitangideas.stack.Stack;

/**
 * @ClassName $(NAME)
 * @Author $(USER)
 * @Date $(DATE) $(TIME)
 * @Version 1.0
 **/
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addLast(e);
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public E peek() {
        return list.getLast();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListStack:");
        sb.append(String.format("size = %d\r\n",list.getSize()));
        for (int i = 0; i < list.getSize(); i++) {
            sb.append(list.get(i));
            if(i!=list.getSize()-1){
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
