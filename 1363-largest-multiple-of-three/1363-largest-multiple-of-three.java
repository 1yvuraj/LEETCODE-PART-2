class Solution {
    public String largestMultipleOfThree(int[] arr) {
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        String ans = "";
        if (sum % 3 == 0) {
            if(arr[arr.length-1]==0) return "0";
            for (int i = arr.length - 1; i >= 0; i--) {
                ans += arr[i];
            }
            return ans;
        } else if (sum % 3 == 1) {
            boolean e = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 3 == 1) {
                    arr[i] = -1;
                    e = true;
                    break;
                }
            }
            if (!e) {
                int[] a = new int[2];
                a[0] = -1;
                a[1] = -1;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] % 3 == 2) {
                        if (a[0] == -1) {
                            a[0] = i;
                        } else {
                            a[1] = i;
                            break;
                        }
                    }
                }
                if (a[0] != -1) {
                    arr[a[0]] = -1;
                    arr[a[1]] = -1;
                }else{
                    return "";
                }
            }
        }else if(sum % 3 == 2){
            boolean e = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 3 == 2) {
                    arr[i] = -1;
                    e = true;
                    break;
                }
            }
            if (!e) {
                int[] a = new int[2];
                a[0] = -1;
                a[1] = -1;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] % 3 == 1) {
                        if (a[0] == -1) {
                            a[0] = i;
                        } else {
                            a[1] = i;
                            break;
                        }
                    }
                }
                if (a[0] != -1) {
                    arr[a[0]] = -1;
                    arr[a[1]] = -1;
                }else{
                    return "";
                }
            }
        }
         ans="";
        for(int i=arr.length-1;i>=0;i--){
             if(arr[i]!=-1)ans+=arr[i];
        }
        if(ans.length()>0 && ans.charAt(0)=='0')return "0";
        return ans;
    
}
}
