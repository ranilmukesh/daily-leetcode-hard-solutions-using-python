class Solution {
    public double averageWaitingTime(int[][] customers) {
        double wait =0;
        int currTime =0;
        for(int[] custom: customers){
            int start = custom[0];
            int duration = custom[1];
            if(currTime==0 || currTime<start){
                currTime= start;
            }
            wait+=currTime+duration-start;
            currTime+=duration;
        }
        
        return wait/(double)customers.length;

    }
}
