/**
 * LC_141_LinkedListCycle
 */
public class LC_141_LinkedListCycle {

    // ListNode class
    class ListNode {
        ListNode next;
        ListNode(int x) {
            int val = x;
            next = null;
        }
    }

    // Cycle Detection Method(Floyd's Cycle Finding Algorithm)
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode oneX = head;
        ListNode twoX = head;
        while(twoX != null && twoX.next != null){
           
            // Update
            twoX = twoX.next.next;
            oneX = oneX.next;

             if(twoX == oneX){
                return true;
            }
        }
        return false;
    }

    // on LeetCode
    // Main method automatically passes Nodes
}

