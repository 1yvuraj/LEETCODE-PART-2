class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int[] arr = new int[26];
        ArrayList<Integer>list=new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(i+p.length()-1<s.length()){
            String ans = s.substring(i, i + p.length());
            int[] subarr = new int[26];
            for (int j = 0; j < ans.length(); j++) {
                subarr[ans.charAt(j) - 'a']++;
            }
            if(Arrays.equals(arr, subarr))list.add(i);
            }
        }
        return list;
    }
}
