package com.yitangideas.tree.binaryserchtree;

/**
 * @ClassName $(NAME)
 * @Author $(USER)
 * @Date $(DATE) $(TIME)
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(5);
        binarySearchTree.add(1);
        binarySearchTree.add(7);
        binarySearchTree.add(3);
        binarySearchTree.add(6);
        binarySearchTree.add(9);
        System.out.println(binarySearchTree.maximum());
    }
}
