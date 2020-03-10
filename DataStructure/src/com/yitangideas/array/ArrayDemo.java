package com.yitangideas.array;

/**
 * @ClassName $(NAME)
 * @Author $(USER)
 * @Date $(DATE) $(TIME)
 * @Version 1.0
 **/
public class ArrayDemo {
    public static void main(String[] args) {
        Array<Integer> arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1,100);
        arr.addFirst(101);
        arr.addLast(102);
        arr.remove(0);
        System.out.println(arr);

    }
}
