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

    public ListNode mergeNodes(ListNode head) {
        // Create a pointer for traversing the list, starting from the node after head.
        ListNode current = head.next;
        // Create a pointer to accumulate sums in place.
        ListNode accumulator = current;

        // Traverse the list.
        while (current != null) {
            int sum = 0;
            // Accumulate values until reaching a zero node.
            while (current.val != 0) {
                sum += current.val;
                current = current.next;
            }

            // Store the accumulated sum in the accumulator node.
            accumulator.val = sum;
            // Skip the zero node and move to the next block.
            current = current.next;
            // Move the accumulator to the next node.
            accumulator.next = current;
            accumulator = current;
        }
        // Return the modified list, starting from the first modified node.
        return head.next;
    }
}
