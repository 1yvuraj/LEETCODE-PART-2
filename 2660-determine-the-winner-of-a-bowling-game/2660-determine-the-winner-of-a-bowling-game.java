class Solution {
    public int isWinner(int[] nums1, int[] nums2) {
        int val=0,sum1=nums1[0],sum2=nums2[0];
        for(int i=1;i<nums1.length;i++){
            
            if(i==1 && nums1[i-1]==10)sum1+=2*nums1[i];
            else if(i>1 && (nums1[i-1]==10 || nums1[i-2]==10)) sum1+=2*nums1[i];
            else sum1+=nums1[i];
           
        }
        val=0;
        for(int i=1;i<nums2.length;i++){
             if(i==1 && nums2[i-1]==10)sum2+=2*nums2[i];
             else if(i>1 &&(nums2[i-1]==10 || nums2[i-2]==10)) sum2+=2*nums2[i];
             else sum2+=nums2[i];
        }
        int ans=0;
        if(sum1==sum2)return 0;
        ans=sum1>sum2?1:2;
        
        return ans;
        
    }
}