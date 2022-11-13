class Solution {

    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i <= arr.length - 3; i++) {
            if (i != 0 && arr[i - 1] == arr[i]) continue;
            int v = arr[i];
            int target = 0 - v;
            List<List<Integer>> two = twoSum(arr, target, i + 1, arr.length - 1);
            for (List<Integer> val : two) {
                val.add(v);
                res.add(val);
            }
        }
        return res;
    }

    public  List<List<Integer>> twoSum(int[] arr, int target, int s, int l) {
        List<List<Integer>> res = new ArrayList<>();
        int left = s;
        int right = l;
        Arrays.sort(arr);
        while (left < right) {
            if (left !=s && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if (sum == target) {
                ArrayList<Integer> ans = new ArrayList<>();

                ans.add(arr[left]);
                ans.add(arr[right]);
                res.add(ans);
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
