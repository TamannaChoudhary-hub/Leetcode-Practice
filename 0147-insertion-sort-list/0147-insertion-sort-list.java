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
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode sorted = null;

        while (head != null) {

            ListNode curr = head;
            head = head.next;

            // Beginning mein insert
            if (sorted == null || curr.val < sorted.val) {
                curr.next = sorted;
                sorted = curr;
            }
            else {
                ListNode temp = sorted;

                // Correct position find karo
                while (temp.next != null && temp.next.val <= curr.val) {
                    temp = temp.next;
                }

                curr.next = temp.next;
                temp.next = curr;
            }
        }

        return sorted;
    }
}