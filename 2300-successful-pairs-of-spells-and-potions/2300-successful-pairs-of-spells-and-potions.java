class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] arr = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            arr[i]=bs(spells,potions,success,i);
        }
        return arr;
    }

    public int bs(int[] spells, int[] potions, long success,int i) {
        int l = 0;
        int h = potions.length - 1;
        int num = 0;
        while (l <= h) {
            int mid=(l+h)/2;
            long a = (long) spells[i] * (long) potions[mid];
            
            if (a >= success) {
                num=potions.length-mid;
                h=mid-1;
            }else if(a<success){
                l=mid+1;
            }
        }
        return num;
    }
}
