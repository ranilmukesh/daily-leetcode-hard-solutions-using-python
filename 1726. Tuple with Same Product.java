class Solution {
    public int tupleSameProduct(int[] nums) {
        int count = 0;
        int n = nums.length;
        Map<Integer, Integer> productCount = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                int curCount = productCount.getOrDefault(product, 0);
                count += curCount * 8;
                productCount.put(product, curCount + 1);
            }
        }
        
        return count;
    }
}
