package org.leetcode;

/**
 * packageName    : org.leetcode
 * fileName       : ConvertSortedArrayToBinarySearchTree
 * author         : men16
 * date           : 2023-04-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-04-22        men16       최초 생성
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2; // 중간 인덱스 계산
        TreeNode root = new TreeNode(nums[mid]); // 중간 값을 루트 노드로 생성
        root.left = buildTree(nums, left, mid - 1); // 왼쪽 서브 배열 탐색
        root.right = buildTree(nums, mid + 1, right); // 오른쪽 서브 배열 탐색
        return root;
    }

    public static void main(String[] args) {
        int [] nums = {-10,-3,0,5,9};
        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        System.out.println(convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums));
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

