class Solution {

    public boolean equalFrequency(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            arr[i]--;
            if (Frequency(arr, word)) return true;
            arr[i]++;
        }
        return false;
    }

    public boolean Frequency(int[] arr, String word) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) set.add(arr[i]);
        }
        return set.size() ==1;
    }
}
