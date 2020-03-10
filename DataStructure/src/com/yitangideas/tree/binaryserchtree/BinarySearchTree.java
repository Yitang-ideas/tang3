package com.yitangideas.tree.binaryserchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 **/
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = _add(root, e);
    }

    //向以node为根的二分搜索树中插入元素e，递归算法
    //返回插入新节点后二分搜索树的根
    private Node _add(Node node, E e) {

        //递归终止条件
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = _add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = _add(node.right, e);
        }
        return node;
    }

    //看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return _contains(root, e);
    }

    //看以node为根的二分搜索树中是否包含元素e
    private boolean _contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.equals(node.e)) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return _contains(node.left, e);
        } else {
            return _contains(node.right, e);
        }
    }

    //前序遍历
    public void preOrder() {
        _preOrder(root);
    }

    //前序遍历以node为根的二分搜索树
    private void _preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        _preOrder(node.left);
        _preOrder(node.right);
    }

    //前序遍历非递归写法
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.e);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    //中序遍历
    public void inOrder() {
        _inOrder(root);
    }

    private void _inOrder(Node node) {
        if (node == null) {
            return;
        }
        _inOrder(node.left);
        System.out.println(node.e);
        _inOrder(node.right);
    }

    //后序遍历
    public void postOrder() {
        _postOrder(root);
    }

    private void _postOrder(Node node) {
        if (node == null) {
            return;
        }
        _postOrder(node.left);
        _postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的层序遍历（广度优先遍历)
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.e);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is empty.");
        }
        return _minimum(root).e;
    }

    private Node _minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return _minimum(node.left);
    }

    //寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BinarySearchTree is empty.");
        return _maximum(root).e;
    }

    private Node _maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return _maximum(node.right);
    }

    //删除二分搜索树的最小值所在的节点，并且返回最小值
    public E removeMin() {
        E result = minimum();
        _removeMin(root);
        return result;
    }

    //删除以node为根的二分搜索树的最小节点
    //返回删除后的二分搜索树的根
    private Node _removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = _removeMin(node.left);
        return node;
    }

    //删除二分搜索树的最大值所在的节点，并且返回最大值
    public E removeMax() {
        E result = maximum();
        _removeMax(root);
        return result;
    }

    //删除以node为根的二分搜索树的最大节点
    //返回删除后的二分搜索树的根
    private Node _removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = _removeMin(node.right);
        return node;
    }

    //从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = _remove(root,e);
    }

    //返回删除节点后新的二分搜索树的根
    private Node _remove(Node node,E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e) < 0){
            node.left = _remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = _remove(node.right,e);
            return node;
        }else{
            //待删除节点左子树为空的情况
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = _minimum(node.right);
            successor.right = _removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        //前序遍历的toString
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
















