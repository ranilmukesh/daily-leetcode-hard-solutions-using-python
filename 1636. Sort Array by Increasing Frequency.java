class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        int[] freqList = new int[201];
        
        for (int k : nums) {
            freqList[k + 100] += 1;
        }
        
        int frequency = 1;
        int seated = 0;
        
        while (seated < n) {
            for (int i = 200; i >= 0; i -= 1) {
                if (freqList[i] == frequency) {
                    for (int j = 0; j < frequency; j += 1) {
                        nums[seated] = i - 100;
                        seated += 1;
                    }
                }
            }
            frequency += 1;
        }
        return nums;
    }
}
