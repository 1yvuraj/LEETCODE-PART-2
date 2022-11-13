class Solution {

    public class pair implements Comparable<pair>{
        int val;
        int idx;
        pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        public int compareTo(pair o){
            return this.val-o.val;
        }
    }

    public int minimumOperations(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int count = 0;
        while (q.size() > 0) {
            int size = q.size();
            int[] arr = new int[size];
            int idx = 0;
            while (size-- > 0) {
                TreeNode rem = q.removeFirst();
                arr[idx] = rem.val;
                idx++;
                if (rem.left != null) q.addLast(rem.left);
                if (rem.right != null) q.addLast(rem.right);
            }
            count += minSwaps(arr);
        }
        return count;
    }

    public int minSwaps(int nums[]) {
        pair[] arr = new pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new pair(nums[i], i);
        }
        Arrays.sort(arr);
        boolean[] visit = new boolean[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == true || arr[i].idx == i) {
                continue;
            }
            int j = i;
            int len = 0;

            while (visit[j] == false) {
                visit[j] = true;
                j = arr[j].idx;
                len++;
            }
            ans += len - 1;
        }
        return ans;
    }
}
