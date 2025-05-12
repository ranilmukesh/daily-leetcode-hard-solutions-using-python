class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] hash = new int[10];

        for(int num: digits) {
            hash[num]++;
        }

        List<Integer> result = new ArrayList<>();
        for(int num=100; num<1000; num++) {
            if(num%2==0 && canMake(num,hash))
                result.add(num);
        }

        int[] nums = new int[result.size()];
        for(int i=0; i<result.size(); i++)
            nums[i] = result.get(i);
        
        return nums;
    }

    boolean canMake(int num, int[] hash) {
        int copy = num;
        boolean ans = true;
        while(copy>0) {
            if(hash[copy%10]<=0)
                ans = false;
            hash[copy%10]--;
            copy = copy/10;
        }
        while(num>0) {
            hash[num%10]++;
            num = num/10;
        }
        return ans;
    }
}
