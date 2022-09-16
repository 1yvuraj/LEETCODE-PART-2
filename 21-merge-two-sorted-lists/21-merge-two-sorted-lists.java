class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1000);
        ListNode pre=dummy;
        ListNode cur1=list1;
        ListNode cur2=list2;
        while(cur1!=null && cur2!=null){
            if(cur1.val<cur2.val){
                pre.next=cur1;
                cur1=cur1.next;
                
            }else{
                 pre.next=cur2;
                 cur2=cur2.next;
                 
            }
            if(pre!=null)pre=pre.next;
        }
        if(cur1!=null)pre.next=cur1;
        if(cur2!=null)pre.next=cur2;
        return dummy.next;
        
    }
}