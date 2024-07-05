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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> criticalPoints = getCriticalPoints(head);
        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }

        int maxDistance = criticalPoints.get(criticalPoints.size()-1)-criticalPoints.get(0);
        int minDistance = Integer.MAX_VALUE;
        for ( int i = 1; i < criticalPoints.size(); i++ ){
            minDistance = Math.min(minDistance, criticalPoints.get(i)-criticalPoints.get(i-1));
        }
        
        return new int[]{minDistance, maxDistance};
        
    }

    public List<Integer> getCriticalPoints(ListNode head) {
        List<Integer> criticalPoints = new ArrayList<>();
        if (head == null || head.next == null || head.next.next == null) {
            return criticalPoints;
        }

        int position = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                criticalPoints.add(position);
            }
            prev = curr;
            curr = next;
            next = next.next;
            position++;
        }

        return criticalPoints;
    }
}