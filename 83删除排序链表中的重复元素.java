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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h=new ListNode(-200,head);
        ListNode slow=h,fast=h;
        while(fast!=null){
            if(slow.val!=fast.val){
                slow.next=fast;
                slow=slow.next;
            }
            fast=fast.next;
        }
        slow.next=null;
        return h.next;
    }
}