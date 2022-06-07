/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       int fi=0;
        int si=0;
        ListNode first=headA;
        ListNode second=headB;
        
        for(ListNode node=headA;node!=null;node=node.next)fi++;
        for(ListNode node=headB;node!=null;node=node.next)si++;
        int gap=Math.abs(si-fi);
        if(fi>si)
        {
           for(int i=0;i<gap;i++)first=first.next; 
        }else{
           for(int i=0;i<gap;i++)second=second.next;  
        }
        ListNode cur=fi>si?first:second;
        while(cur!=null && first!=second)
        {
            if(second!=null)second=second.next;
             if(first!=null)first=first.next;
            if(cur!=null)cur=cur.next;
            
        }
        return cur==null?null:second;
        
    }
}