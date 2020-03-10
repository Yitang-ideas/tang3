package com.yitangideas.queue;

import com.yitangideas.array.Array;

/**
 * @ClassName $(NAME)
 * @Author $(USER)
 * @Date $(DATE) $(TIME)
 * @Version 1.0
 **/
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: "));
        sb.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if(i != array.getSize()-1)
                sb.append(",");
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
        }
        arrayQueue.enqueue(100);
        arrayQueue.enqueue(101);
        arrayQueue.enqueue(102);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.getCapacity());
        System.out.println(arrayQueue.getSize());
    }
}
