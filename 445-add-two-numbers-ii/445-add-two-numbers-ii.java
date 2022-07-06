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
         if(l2==null || l1==null)
         {
             return l1!=null?l1:l2;
         }
        

             ListNode one=reverseList(l1);
             ListNode two=reverseList(l2);
             ListNode dummy=new ListNode(-1);
            
             ListNode itr=dummy;
             ListNode c1=one;
             ListNode c2=two;
              int cr=0;
             while(c1!=null || c2!=null || cr!=0)
             {
                 int sum=cr+(c1!=null?c1.val:0)+(c2!=null?c2.val:0);
                 int id=sum%10;
                 cr=sum/10;
                 itr.next=new ListNode(id);
                 itr=itr.next;
                 if(c1!=null)c1=c1.next;
                 if(c2!=null)c2=c2.next;
                 
             }
           return reverseList(dummy.next);
       
    
    }
     public ListNode reverseList(ListNode head) {
        if(head==null ||head.next==null)
        {
            return head;
        }
        ListNode cur=head ;
        
          ListNode pr=null ;
        ListNode fr=head ; 
        while(cur!=null)
        {
            fr=cur.next ; 
            cur.next=pr;
            pr=cur;
            cur=fr;
           
        }
        return pr;
        
    }
}