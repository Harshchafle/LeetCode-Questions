/**
 * LC_19_RemoveNthNodeFromEndofList
 */
public class LC_19_RemoveNthNodeFromEndofList {  
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        int size = 0;
        ListNode dummy = head;
        while(dummy != null){
            dummy = dummy.next;
            size++;
        }
        if(n == size){
            return head.next;
        }
        int i=1;
        ListNode prev = head;
        while(i < size - n){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
}
}
