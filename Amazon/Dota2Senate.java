class Solution {
    // Two Queues Solution
    // Two queues to store the R index and D index.
    // If the senate can execute his right, the senate is alive and can execute in the next round.
    // Then we can add the senate back to the queue and process in the next round (idx + N).
    public String predictPartyVictory(String senate) {
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qd = new LinkedList<>();

        int len = senate.length();
        for(int i=0; i<len; i++){
            if(senate.charAt(i) == 'R') qr.add(i);
            else qd.add(i);
        }

        while(!qr.isEmpty() && !qd.isEmpty()){
            int r_index = qr.poll();
            int d_index = qd.poll();
            
            if(r_index < d_index) qr.add(r_index + len); // R is alive in the next round
            else qd.add(d_index + len); // D is alive in the next round
        }

        return qr.size() > qd.size() ? "Radiant" : "Dire";
    }
}