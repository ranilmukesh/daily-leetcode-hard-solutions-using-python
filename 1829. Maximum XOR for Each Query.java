class Solution {
         public int[] getMaximumXor(int[] nums, int maximumBit) {
        int max = (1 << maximumBit) - 1;
        int lenght = nums.length - 1;
        int[] array = new int[nums.length];
        int result = 0;
        
        for(int x : nums){
            result ^= x;
            array[lenght--] = max-result;
        }

        return array;
    }
}
