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
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            n++;
        }

        int arr[] = new int[n];
        temp = head;
        for(int i = 0; i < n; i++){
            arr[i] = temp.val;
            temp = temp.next;
        }

        int sum = 0;
        for(int i = 0; i <= (n/2)-1; i++){
            sum = Math.max(sum, arr[i]+arr[n-i-1]);
        }
        return sum;
    }
}