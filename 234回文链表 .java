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
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        if(fast!=null)
            slow=slow.next;

        ListNode left=head;
        ListNode right=reverse(slow);

        while(right!=null){
            if(right.val!=left.val)
                return false;
            left=left.next;
            right=right.next;
        }
        return true;
    }

    ListNode reverse(ListNode head){
        ListNode pre=null,cur=head;
        while(cur!=null){
            ListNode tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;            
        }
        return pre;
    }
}