public class Solution {

    public ListNode mergeNodes(ListNode head) {
        ListNode current = head.next;
        ListNode sumNode = current;

        while (current != null) {
            int sum = 0;
            while (current.val != 0) {
                sum += current.val;
                current = current.next;
            }
            sumNode.val = sum;
            current = current.next;
            sumNode.next = current;
            sumNode = current;
        }

        return head.next;
    }
}
