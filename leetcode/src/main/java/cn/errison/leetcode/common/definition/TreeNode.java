package cn.errison.leetcode.common.definition;

import java.util.*;

/**
 * 二叉树定义
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode genTreeFromList(List<Integer> nums) {
        if (nums.isEmpty() || nums.get(0) == null) {
            return null;
        }

        TreeNode rootNode = new TreeNode(nums.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        boolean isLeft = true;
        for (int i = 1; i < nums.size(); i++) {
            TreeNode node = queue.peek();
            Integer cur = nums.get(i);
            if (isLeft) {
                if (cur != null) {
                    node.left = new TreeNode(nums.get(i));
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (cur != null) {
                    node.right = new TreeNode(nums.get(i));
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return rootNode;
    }

//    public static List<Integer> genListFromTree(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        Deque<TreeNode> curLevel = new LinkedList<>();
//        while (!curLevel.isEmpty()) {
//            TreeNode node = curLevel.poll();
//            if (node.left != null){
//                curLevel.add(node.left);
//            }else {
//                curLevel.offer(null);
//            }
//            if (node.right != null){
//                curLevel.offer(null);
//            }
//
//
//        }
//    }

}
