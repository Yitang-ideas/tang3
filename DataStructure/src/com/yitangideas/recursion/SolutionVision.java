package com.yitangideas.recursion;

import com.yitangideas.linkedlist.ListNode;

/**
 * 递归过程可视化实现
 **/
public class SolutionVision {

    public ListNode removeElements(ListNode head, int val, int depth){
        String depthString = generateDepthString(depth);
        System.out.println(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: "+ null);
            return null;
        }
        ListNode res = removeElements(head.next,val,depth+1);
        System.out.println(depthString);
        System.out.println("After remove "+val+":"+res);
        ListNode ret;
        if(head.val == val){
            ret = res;
        }else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: "+ret);
        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,2,1};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new SolutionVision()).removeElements(head,2,0);
        System.out.println(res);
    }
}
