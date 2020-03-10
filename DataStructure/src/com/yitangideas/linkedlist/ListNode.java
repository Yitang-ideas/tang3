package com.yitangideas.linkedlist;


public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int[] arr){
        if(arr == null && arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty.");

        this.val = arr[0];
        ListNode current = this;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current.next!=null){
            sb.append(current.val + "->");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
