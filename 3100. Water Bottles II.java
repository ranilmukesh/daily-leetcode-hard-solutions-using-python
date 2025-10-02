class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty=numBottles;
        int total=numBottles;
        while(empty>=numExchange){
            empty -= numExchange;
            total++;
            numExchange++;
            empty++;
        }
        return total;
    }
}
