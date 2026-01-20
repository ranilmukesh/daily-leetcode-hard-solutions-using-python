class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        /*
            ans[i] || (ans[i]+1) = nums[i]
            16 8 4 2 1
            5 ->  101
            a = 100
            a+1 = 101

            7 -> 111
            a = 011
            a+1 = 100

            11 -> 1011
            a = 1001
            a+1 = 1010

            13 -> 1101
            a = 1100
            a+1 = 1101

            31 -> 11111
            a = 01111
            a+1 = 10000

            start fron LSB bit. traverse to left while the bit is 1. 
            if there is bit with this value in the end, replace it with 0. this will be a.
            otherwise its -1.
        */
        int n = nums.size();
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            int val = nums.get(i);
            int bitPos = -1;
            for(int j=0; j<32; j++){
                if((val & (1 << j)) != 0){
                    bitPos++;
                }else{
                    break;
                }
            }
            if(bitPos == -1){
                result[i] = -1;
            }else{
                result[i] = val & ~(1 << bitPos);
            }
        }
        return result;
    }
}
