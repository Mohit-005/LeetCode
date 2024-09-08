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
    public ListNode[] splitListToParts(ListNode head, int k) {
       
        ListNode temp=head;
        ListNode[] result=new ListNode[k];
         if(head==null) return result;
        int len=1;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        ListNode curr=head;
        ListNode prev=null;
        int i=0;
        int remainingN=len%k;
        while(curr!=null){
            int eachBucket=len/k;
          

            result[i]=curr;
            i++;
            while(eachBucket!=0){
                prev=curr;
                curr=curr.next;
                eachBucket--;
            }
            if(remainingN!=0){
                prev=curr;
                curr=curr.next;
                remainingN--;
            }
            prev.next=null;
        }
       return result;
    }
}