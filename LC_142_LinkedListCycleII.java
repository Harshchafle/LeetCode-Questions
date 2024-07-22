/**
 * LC_142_LinkedListCycleII
 */
public class LC_142_LinkedListCycleII {
    
    // ListNode Class
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next == null){
            return null;
        }

        ListNode oneX,twoX;
        oneX = twoX = head;
        
        while(twoX != null && twoX.next != null){
            // Update
            twoX = twoX.next.next;
            oneX = oneX.next;

            if(oneX == twoX){
                oneX = head;
                while(oneX != twoX){
                    oneX = oneX.next;
                    twoX = twoX.next;
                }
                return oneX;
            }
        }
        return null;
    }

    // Nodes are being Passed by LeetCode itsef in main 
}