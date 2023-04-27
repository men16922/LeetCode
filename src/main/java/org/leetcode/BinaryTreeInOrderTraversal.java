package org.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * packageName    : org.leetcode
 * fileName       : BInaryTreeInOrderTraversal
 * author         : men16
 * date           : 2023-04-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-04-15        men16       최초 생성
 */
public class BinaryTreeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 왼쪽 서브 트리를 모두 스택에 넣음
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // 스택에서 노드를 꺼내서 값 저장 및 오른쪽 서브 트리를 탐색
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeInOrderTraversal binaryTreeInOrderTraversal = new BinaryTreeInOrderTraversal();

        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, null, node2);

        System.out.println(binaryTreeInOrderTraversal.inorderTraversal(root));

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

