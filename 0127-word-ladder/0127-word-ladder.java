class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        LinkedList<String> q = new LinkedList<>();
        //set.add(endWord);
        q.addLast(beginWord);
        int level = 0;
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                String rem = q.removeFirst();
                if (rem.equals(endWord)) {
                    return level+1;
                }
                for (int i = 0; i < rem.length(); i++) {
                    char[] ch = rem.toCharArray();
                    for (char j = 'a'; j <='z'; j++) {
                        ch[i] = j;
                        String check = new String(ch);
                        if (!rem.equals(check) && set.contains(check)) {
                            q.addLast(check);
                            set.remove(check);
                        }
                    }
                }
                
            }
            level++;
        }
        return 0;
    }
}
// public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
//     wordList.add(endWord);
//     Queue<String> queue = new LinkedList<String>();
//     queue.add(beginWord);
//     int level = 0;
//     while(!queue.isEmpty()){
//         int size = queue.size();
//         for(int i = 0; i < size; i++){
//             String cur = queue.remove();
//             if(cur.equals(endWord)){ return level + 1;}
//             for(int j = 0; j < cur.length(); j++){
//                 char[] word = cur.toCharArray();
//                 for(char ch = 'a'; ch < 'z'; ch++){
//                     word[j] = ch;
//                     String check = new String(word);
//                     if(!check.equals(cur) && wordList.contains(check)){
//                         queue.add(check);
//                         wordList.remove(check);
//                     }
//                 }
//             }
//         }
//         level++;
//     }
//     return 0;
// }
