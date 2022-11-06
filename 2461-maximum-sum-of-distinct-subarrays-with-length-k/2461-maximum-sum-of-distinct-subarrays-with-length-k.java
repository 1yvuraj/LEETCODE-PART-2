class Solution {

    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        long sum = 0, max = -(int) 1e9;
        while (j < nums.length) {
            if (!set.contains(nums[j])) {
                set.add(nums[j]);
                sum += nums[j];
                if (j - i + 1 == k) {
                    max = Math.max(max, sum);
                    sum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
            } else {
                i = j;
                set = new HashSet<>();
                sum = nums[j];
                set.add(nums[j]);
                
            }
            j++;
        }
        return max == -(int) 1e9 ? 0 : max;
    }
}

// class Solution {

//     public long maximumSubarraySum(int[] arr, int k) {
//         HashSet<Integer> set = new HashSet<>();
//         int i = 0, j = 0;
//         long sum = 0;
//         long maxSum = 0;

//         while (j < arr.length) {
//             if (!set.contains(arr[j])) { // no duplicate element in window
//                 set.add(arr[j]); // add it to set
//                 sum += arr[j]; // add to local sum
//                 if (j - i + 1 == k) { // if window length == K
//                     maxSum = Math.max(maxSum, sum); // take the max sum
//                     sum -= arr[i]; // remove calculation of arr[i]
//                     set.remove(arr[i]); // remove arr[i] from set
//                     i++; // shift the window to the right
//                 }
//             } else { // duplicate element encountered in window, reset everything
//                 i = j; // start window from j
//                 sum = arr[i]; // add first element to window
//                 set = new HashSet<>(); // create a new set or clear the previous one
//                 set.add(arr[j]); // add current element to set
//             }
//             j++; // expand the window
//         }

//         return maxSum;
//     }
// }
