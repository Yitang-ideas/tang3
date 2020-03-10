package com.yitangideas.recursion;

/**
 * @ClassName $(NAME)
 * @Author $(USER)
 * @Date $(DATE) $(TIME)
 * @Version 1.0
 **/
public class Sum {
    public static int sum(int[] arr){
        return _sum(arr,0);
    }

    //计算arr[l...n)这个区间所有数字的和
    private static int _sum(int[] arr,int l){
        //当l和length相等时，是空数组
        if(l == arr.length){
            return 0;
        }
        return arr[l] + _sum(arr,l+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(sum(arr));
    }
}
