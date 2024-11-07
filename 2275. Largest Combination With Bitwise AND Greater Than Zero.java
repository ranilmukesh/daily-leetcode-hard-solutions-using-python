class Solution {
    public int largestCombination(int[] candidates) {
        int[] hash = new int[24];

        for(int num : candidates){
            int j = 23;
            while(num > 0){
                hash[j--] += (num & 1);
                num >>= 1;
            }
        }

        int major = 0;
        for(int value: hash){
            major = Integer.max(major, value);
        }

        return major;
    }
}
