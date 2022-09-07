class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        ListNode mid=middleNode(head);
        ListNode rev=reverseList(mid.next);
        ListNode cur=head;
        while(cur!=null && rev!=null){
            if(cur.val!=rev.val)return false;
            if(cur!=null)cur=cur.next;
            if(rev!=null)rev=rev.next;
        }
        return true;
        
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            if(fast.next!=null)fast=fast.next.next;
            if(slow!=null)slow=slow.next;
        }
        return slow;
        
    }
    public ListNode reverseList(ListNode head) {
        if(head==null ||head.next==null)
        {
            return head;
        }
        ListNode cur=head ;
        ListNode itr=null ;
        ListNode f=head ;
        
        while(cur!=null)
        {
            f=cur.next;
            cur.next=itr;
            itr=cur;
            cur=f;
            
        }
        return itr;   
    }
}