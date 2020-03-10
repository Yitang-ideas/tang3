package com.yitangideas.maxheap;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * leetcode
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 **/

//Java中默认的PriorityQueue是最小堆
public class Solution1 {
    private class Frequency implements Comparable<Frequency>{
        int e;
        int freq;
        public Frequency(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        //本题中，出现频次越低，优先级越高
        @Override
        public int compareTo(Frequency o) {
            if (this.freq < o.freq)
                return -1;
            else if (this.freq > o.freq)
                return 1;
            else
                return 0;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int num : nums){
            if(treeMap.containsKey(num)){
                treeMap.put(num,treeMap.get(num) + 1);
            }else{
                treeMap.put(num,1);
            }
        }
        PriorityQueue<Frequency> priorityQueue = new PriorityQueue<>();
        for (int key : treeMap.keySet()){
            if (priorityQueue.size() < k)
                priorityQueue.add(new Frequency(key,treeMap.get(key)));
            else if (treeMap.get(key) > priorityQueue.peek().freq){
                priorityQueue.remove();
                priorityQueue.add(new Frequency(key,treeMap.get(key)));
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        while (!priorityQueue.isEmpty()){
            result.add(priorityQueue.remove().e);
        }
        return result;
    }
}
