class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int[] bitCount = new int[32];
        int left=0;
        int min=Integer.MAX_VALUE;
        int or=0;

        for(int right=0;right<n;right++){
            or=addOrRemoveBits(bitCount, nums[right], true, or);
            while(left<=right && or>=k){
                min=Math.min(min, right-left+1);
                or=addOrRemoveBits(bitCount, nums[left], false, or);
                left++;
            }
        }

        return min==Integer.MAX_VALUE?-1:min;
    }

    int addOrRemoveBits(int[] bitCount, int num, boolean add, int or){
        int count=0;
        while(num>0){
            if((num&1)==1) {
                if(add) {
                    bitCount[count]++;
                    or=(or | (1<<count));
                }
                else {
                    bitCount[count]--;
                    if(bitCount[count]==0){
                        or=(or ^ (1<<count));
                    }
                }
            }
            count++;
            num=num>>>1;
        }

        return or;
    }
}
