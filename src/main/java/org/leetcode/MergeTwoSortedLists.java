package org.leetcode;

/**
 * packageName    : org.leetcode
 * fileName       : MergeTwoSortedLists
 * author         : men16
 * date           : 2023-03-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-03-11        men16       최초 생성
 */
public class MergeTwoSortedLists {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // 병합된 연결 리스트의 머리를 나타내는 더미 노드 생성
        ListNode tail = dummy; // 더미 노드를 기준으로 끝 노드를 찾아내기 위한 tail 포인터 생성

        while (list1 != null && list2 != null) { // 두 연결 리스트가 비어 있지 않은 경우
            if (list1.val <= list2.val) { // list1의 현재 노드가 list2의 현재 노드보다 작거나 같은 경우
                tail.next = list1; // list1의 현재 노드를 병합된 연결 리스트의 끝에 추가
                list1 = list1.next; // list1의 다음 노드로 이동
            } else { // list1의 현재 노드가 list2의 현재 노드보다 큰 경우
                tail.next = list2; // list2의 현재 노드를 병합된 연결 리스트의 끝에 추가
                list2 = list2.next; // list2의 다음 노드로 이동
            }
            tail = tail.next; // tail 포인터를 끝 노드로 이동
        }

        if (list1 != null) { // list1에 노드가 남아 있는 경우
            tail.next = list1; // list1의 남은 노드를 병합된 연결 리스트의 끝에 추가
        } else if (list2 != null) { // list2에 노드가 남아 있는 경우
            tail.next = list2; // list2의 남은 노드를 병합된 연결 리스트의 끝에 추가
        }

        return dummy.next; // 더미 노드의 다음 노드인 병합된 연결 리스트의 머리 반환
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = mergeTwoSortedLists.mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode3.val);
        System.out.println(listNode3.next.val);
    }
}

