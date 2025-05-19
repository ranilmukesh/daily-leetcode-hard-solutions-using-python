class Solution {
    public String triangleType(int[] nums){
        int sum0=nums[0]+nums[1];
        int sum1=nums[1]+nums[2];
        int sum2=nums[0]+nums[2];
        if (nums[0]==nums[1] && nums[1]==nums[2]){
            return "equilateral";
        }else if ((nums[0]==nums[1] || nums[1]==nums[2] || nums[0]==nums[2]) && (sum0>nums[2] && sum1>nums[0] && sum2>nums[1])){
            return "isosceles";
        }else{
            if (sum0>nums[2] && sum1>nums[0] && sum2>nums[1]){
                return "scalene";
            }
        }
        return "none";

    }
}
