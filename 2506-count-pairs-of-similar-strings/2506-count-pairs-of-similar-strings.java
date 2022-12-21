class Solution {

    public int similarPairs(String[] word) {
        int ans = 0;
        for (int i = 0; i < word.length; i++) {
            for (int j = i + 1; j < word.length; j++) {
                ans += help(word[i], word[j]);
            }
        }
        return ans;
    }

    public int help(String word1,String word2) {
        HashSet<Character>set1=new HashSet<>();
        HashSet<Character>set2=new HashSet<>();
        for(int i=0;i<word1.length();i++){
            set1.add(word1.charAt(i));
        }
        for(int i=0;i<word2.length();i++){
            set2.add(word2.charAt(i));
        }
        
        
        return set1.equals(set2)==true?1:0;
    }
}
