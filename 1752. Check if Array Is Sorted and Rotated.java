import java.util.*;
class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        if(n<1 || n>100)
        System.exit(0);
        for(int i=0;i<n;i++)
        {
            if(nums[i]<1 || nums[i]>100)
            System.exit(0);
        }
        int pivot=0;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                pivot=i+1;
                break;
            }
        }
        if(pivot==0)
        return true;
        else 
        {
            for(int i=0;i<n-1;i++)
            {
                if(nums[(i+pivot)%n]>nums[(i+pivot+1)%n])
                return false;
            }
            return true;
        }
    }
}
