import java.util.Stack;

public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            Stack<Integer> stack = new Stack<>();

            while(fast != null && fast.next != null) {
                stack.push(slow.val);
                slow = slow.next;
                fast = fast.next.next;
            }

            // odd number of elements
            if(fast != null) {
                slow = slow.next;
            }

            while(slow != null) {
                int top = stack.pop();
                if(top != slow.val) {
                    return false;
                }
                slow = slow.next;
            }
            return true;
        }
    }
}
