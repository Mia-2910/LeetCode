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
 import java.util.LinkedList;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode sum = dummy;
        /*start NEVER moves → always points to start
          sum moves → builds the list */
        int i = 0;
        int remainder = 0;
        while ( l1 != null || l2 != null || remainder != 0){
            int value1 = 0;
            int value2 = 0;
            if (l1 != null){
                value1 = l1.val;
            }

            if (l2!= null){
                value2 = l2.val;
            }

            int total = value1 + value2 + remainder;
            
            remainder = total / 10;
            total = total % 10;

            sum.next = new ListNode (total);
            sum = sum.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            
        }
        return start.next;
    }   
}