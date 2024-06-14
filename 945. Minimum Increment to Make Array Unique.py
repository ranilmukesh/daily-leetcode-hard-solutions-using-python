class Solution {
    public int minIncrementForUnique(int[] nums) {
        int result=0;
        if(nums.length==1)
        {
            return result;
        }
        Arrays.sort(nums);
        int currpoint=nums[0]+1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<currpoint)
            {
                result+=(currpoint-nums[i]);
                currpoint++;
                continue;
            }
            if(currpoint<=nums[i])
            {
                currpoint=nums[i]+1;
            }
        }
        return result;
    }
}
