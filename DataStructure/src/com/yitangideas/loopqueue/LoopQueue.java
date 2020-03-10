package com.yitangideas.loopqueue;

import com.yitangideas.queue.Queue;

/**
 * @ClassName $(NAME)
 * @Author $(USER)
 * @Date $(DATE) $(TIME)
 * @Version 1.0
 **/
@SuppressWarnings("unchecked")
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front,tail;
    private int size;

    /**
     * front == tail 队列空
     * (tail+1) % size == front 队列满
     * 浪费一个空间实现队列满判定 capacity+1
     */
    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if((tail+1) % data.length == front){
            resize( 2 * getCapacity());
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()){
           throw new IllegalArgumentException("Queue is empty.");
        }
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return result;
    }

    @Override
    public E getFront() {
        if (this.isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("LoopQueue:size = %d, capacity = %d\n",this.size,this.getCapacity()));
        stringBuilder.append("front [");
        for (int i = front; i != tail; i = (i+1) % data.length) {
            stringBuilder.append(data[i]);
            if((i+1)%data.length != tail){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front+i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}
