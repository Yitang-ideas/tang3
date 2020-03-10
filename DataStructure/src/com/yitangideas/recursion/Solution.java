package com.yitangideas.recursion;
import com.yitangideas.linkedlist.ListNode;

public class Solution {
    //递归算法
    public ListNode removeElements(ListNode head,int val){
        if(head == null){
            return null;
        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,2,1};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head,2);
        System.out.println(res);
    }
}
