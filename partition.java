// leetcode :86. Partition List
// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        ListNode temp = head;

        while (temp != null) {

            if (temp.val < x) {
                less.next = temp;
                less = less.next;
            } else {
                greater.next = temp;
                greater = greater.next;
            }

            temp = temp.next;
        }

      
        greater.next = null;

        less.next = greaterDummy.next;

        return lessDummy.next;
    }
}
