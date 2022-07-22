class Solution {
    public int[] sortArrayByParity(int[] inputArr) {
        int[] arr1 = new int[inputArr.length];
        int[] arr2 = new int[inputArr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = -1;
        }
        int k=0,j=0;
        for (int i = 0; i < inputArr.length; i++) {
            if(inputArr[i]%2==0){
                arr1[k]=inputArr[i];
                k++;
            }else{
                 arr2[j]=inputArr[i];
                j++;
            }
        }
        k=0;
        for(int i=0;i<arr1.length;i++){
             if(arr1[i]!=-1){
            inputArr[k]=arr1[i];
            k++;
             }
        }
        
        for(int i=0;i<arr2.length;i++){
            if(k<inputArr.length && arr2[i]!=-1){
            inputArr[k]=arr2[i];
            k++;
            }
        }
        return inputArr;
    }
}
