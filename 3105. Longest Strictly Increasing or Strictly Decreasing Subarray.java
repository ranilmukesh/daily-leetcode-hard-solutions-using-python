class Solution
{
    public int longestMonotonicSubarray(int[] nums)
    {
        int im = 1;
        int dm = 1;

        for(int i=1, l=nums.length, ti=1, td=1; i<l; i++)
        {
            if(nums[i]>nums[i-1])
                ti++;

            else
                ti=1;

            im = Math.max(im,ti);

            if(nums[i]<nums[i-1])
                td++;

            else
                td=1;

            dm = Math.max(dm,td);
        }

        return Math.max(im,dm);
    }
}
