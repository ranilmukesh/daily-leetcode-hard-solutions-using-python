class Solution {
    static final int mod = (int)1e9 + 7;
    static final int N = 10001;
    static final int[] pow2 = new int[N];    
    public int maxValue(int[] nums1, int[] nums0) {
        
        if(pow2[0] == 0){
            pow2[0] = 1;
            for (int i = 1; i < N; i++) 
                pow2[i] = pow2[i - 1] * 2 % mod;
        }
        
        int n = nums0.length;
        Integer[] indices = new Integer[n];

        int size = 0, count = 0;
        for (int i = 0; i < n; i++){
            if(nums0[i] == 0)
                count += nums1[i];
            else
                indices[size++] = i;
        }
        Arrays.sort(indices, 0, size, (i, j) -> nums1[i] == nums1[j]? nums0[i] - nums0[j] : nums1[j] - nums1[i]);

        long ans = pow(2, count) - 1;
        for (int i = 0; i < size; ++i) {
            int index = indices[i];
            int count1 = nums1[index];
            int count0 = nums0[index];
            
            ans = (ans * pow2[count1] + pow2[count1] - 1) % mod * pow2[count0] % mod;
        }
        
        return (int) ans;                
    }

    long pow(long x, int n){
        long result = 1;
        while(n > 0){
            if(n % 2 == 1)
                result = result * x % mod;
            
            x = x * x % mod;
            n >>= 1;
        }

        return result;
    }
}
