class Solution {
    public int maxFrequency(int[] nums, int k, int nos) {
        Arrays.sort(nums);
        return Math.max(helper1(nums , k , nos) , helper2(nums , k , nos));
    }

    private int helper1(int[] nums , int k , int nos){
        int n = nums.length , res = 0;
        int l = 0 , r = 0 , c = 0;
        while(r < n){
            c++;
            while(nums[l] < nums[r] - k - k && l++ != r && c-- != 0);
            res = Math.max(res , Math.min(c , nos));
            r++;
        }
        return res;
    }

    private int helper2(int[] nums , int  k , int nos){
        int l = 0 , r = 0 , c = 0 , n = nums.length , res = 0;
        int last = -1 , wind = 0;
        for(int num : nums){
            if(last != num){
                last = num;
                c = 1;
            } else c++;
            while(r < n && nums[r] - k <= num) {
                r++;
                wind++;
            }
            while(nums[l] < num - k){
                wind--;
                l++;
            }
            res = Math.max(res , c + Math.min(wind - c , nos));
        }
        return res;
    }
}
