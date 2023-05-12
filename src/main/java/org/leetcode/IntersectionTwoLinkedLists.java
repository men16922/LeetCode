package org.leetcode;

public class IntersectionTwoLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 연결 리스트의 길이를 구합니다.
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        // headA를 headB보다 긴 연결 리스트로 맞춥니다.
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }

        // headB를 headA보다 긴 연결 리스트로 맞춥니다.
        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }

        // 두 연결 리스트를 동시에 탐색하면서 교차 지점을 찾습니다.
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        // 교차 지점 노드를 반환합니다.
        return headA;
    }

    // 연결 리스트의 길이를 계산하는 메소드입니다.
    private int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void main(String[] args) {
        IntersectionTwoLinkedLists intersectionTwoLinkedLists = new IntersectionTwoLinkedLists();
//        ListNode intersect_3 = new ListNode(5);
//        ListNode intersect_2 = new ListNode(4, intersect_3);
//        ListNode intersect_1 = new ListNode(8, intersect_2);
//        ListNode listNodeA_2 = new ListNode(1, intersect_1);
//        ListNode listNodeA_1 = new ListNode(4, listNodeA_2);
//        ListNode listNodeB_3 = new ListNode(1, intersect_1);
//        ListNode listNodeB_2 = new ListNode(6, listNodeB_3);
//        ListNode listNodeB_1 = new ListNode(5, listNodeB_2);

        ListNode listNodeA_1 = new ListNode(4, null);
        ListNode listNodeB_1 = new ListNode(4, null);


        System.out.println(intersectionTwoLinkedLists.getIntersectionNode(listNodeA_1, listNodeB_1));
    }
}
