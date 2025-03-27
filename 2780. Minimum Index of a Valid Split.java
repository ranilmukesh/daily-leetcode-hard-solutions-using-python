class Solution {
    public int minimumIndex(List<Integer> nums) {
       int freq = 1, ele = nums.get(0), n = nums.size();
       for(int i = 1; i < n; i++) {
            if(ele == nums.get(i)) {
                freq++;
            } else{
                freq--;
                if(freq == 0) {
                    freq = 1;
                    ele = nums.get(i);
                }
            }
       }

       int tc = 0;
       for(int i : nums) {
            if(i == ele) tc++;
       }

        int count = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) == ele) {
                count++;
                int fh = (i + 1);
                int sh = (n - i - 1) ;
                int rem = tc- count;
              
                if(count > fh / 2 && rem > sh / 2) return i;
            }
        }

        return -1;
    }
    
}
