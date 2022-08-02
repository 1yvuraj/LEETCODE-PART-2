class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[rooms.size()];
        q.add(0);
        int count = 0;

        while (q.size() > 0) {
            int size = q.size();

            while (size-- > 0) {
                int rem = q.removeFirst();
                if (visit[rem]) continue;
                count++;
                visit[rem] = true;
                for (int nbr : rooms.get(rem)) {
                    if (!visit[nbr]) {
                        q.addLast(nbr);
                    }
                }
            }
        }
        return count == rooms.size();
    }
}
