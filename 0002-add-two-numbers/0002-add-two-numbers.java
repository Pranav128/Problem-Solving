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
    public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        // Dummy node to help with list construction
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0, sum = 0, digit = 0;

        // Add corresponding digits while both lists have values or there is a carry
        while (num1 != null || num2 != null || carry != 0) {
            // Get values from the two nodes, default to 0 if the node is null
            int v1 = (num1 == null) ? 0 : num1.val;
            int v2 = (num2 == null) ? 0 : num2.val;

            // Calculate the sum and the digit for the current place
            sum = v1 + v2 + carry;
            digit = sum % 10;
            carry = sum / 10;

            // Create a new node for the current digit and link it to the result list
            ListNode newNode = new ListNode(digit);
            temp.next = newNode;
            temp = newNode;

            // Move to the next nodes in the input lists if possible
            if (num1 != null) num1 = num1.next;
            if (num2 != null) num2 = num2.next;
            
        }

        // Return the next node of dummy, as dummy is just a placeholder
        return (dummy.next);
    }
    
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); 
        ListNode temp = dummy; 
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1) {
            int sum = 0; 
            if(l1 != null) {
                sum += l1.val; 
                l1 = l1.next; 
            }
            if(l2 != null) {
                sum += l2.val; 
                l2 = l2.next; 
            }
            sum += carry; 
            carry = sum / 10; 
            ListNode node = new ListNode(sum % 10); 
            temp.next = node; 
            temp = temp.next; 
        }
        return dummy.next;
    }
}