class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int c=0;
        int y=0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while(c<players.length && y<trainers.length){
            if(players[c]<=trainers[y]){
                c++;
                y++;
            }else{
                y++;
            }
        }
        return c;
        
    }
}