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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add=0;
        ListNode root=new ListNode();
        ListNode walk=root;
        while(l1!=null||l2!=null){
            walk.next=new ListNode();
            walk=walk.next;
            int val=0;
            if(l1!=null&&l2!=null){
                val=l1.val+l2.val+add;
                l1=l1.next;
                l2=l2.next;
            }else if(l1!=null){
                val=l1.val+add;
                l1=l1.next;
            }else{
                val=l2.val+add;
                l2=l2.next;
            }
            add=val/10;
            val=val%10;
            walk.val=val;
        }
        if(add!=0)
        walk.next=new ListNode(add);
        return root.next;
    }
}