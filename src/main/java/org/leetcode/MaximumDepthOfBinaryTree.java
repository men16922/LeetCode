package org.leetcode;

/**
 * packageName    : org.leetcode
 * fileName       : MaximumDepthOfBinaryTree
 * author         : men16
 * date           : 2023-04-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-04-22        men16       최초 생성
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode cur) {
        if (cur == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(cur.left);
            int rightDepth = maxDepth(cur.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(7, null, null);
        TreeNode treeNode4 = new TreeNode(15, null, null);
        TreeNode treeNode3 = new TreeNode(20, treeNode4, treeNode5);
        TreeNode treeNode2 = new TreeNode(9, null, null);
        TreeNode treeNode1 = new TreeNode(3, treeNode2, treeNode3);
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        System.out.println(maximumDepthOfBinaryTree.maxDepth(treeNode1));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
    }
}

