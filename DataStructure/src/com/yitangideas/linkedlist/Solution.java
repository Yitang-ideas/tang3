package com.yitangideas.linkedlist;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while(prev.next!=null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }
}
