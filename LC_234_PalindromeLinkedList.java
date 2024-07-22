/**
 * LC_234_PalindromeLinkedList
 */
public class LC_234_PalindromeLinkedList {  
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

class Solution {
    public ListNode getMiddle(ListNode head){
        ListNode oneX, twoX;
        oneX = twoX = head;
        while(twoX.next != null && twoX.next.next != null){
            oneX = oneX.next;
            twoX = twoX.next.next;
        }
        return oneX;
    }

    public ListNode reverse(ListNode mid ){
        ListNode prev = null;
        ListNode curr = mid;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            // Updete 
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        if(head.next.next == null){
            if(head.val == head.next.val) return true;
            else return false;
        }

        ListNode middle = getMiddle(head);
        ListNode startOfSecHalf = reverse(middle.next);
        ListNode startOfFirstHalf = head;
        while(startOfSecHalf != null){
            if(startOfFirstHalf.val != startOfSecHalf.val){
                return false;
            }
            startOfFirstHalf = startOfFirstHalf.next;
            startOfSecHalf = startOfSecHalf.next;
        }
        return true;
    }
}
}