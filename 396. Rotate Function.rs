impl Solution {
    pub fn max_rotate_function(nums: Vec<i32>) -> i32 {
        // Step 1: Get array length
        let n = nums.len();
        
        // Step 2: Compute total sum of all numbers
        // This sum is used in the recurrence formula
        let mut total_sum = 0;
        
        // Step 3: Compute F(0)
        // F(0) = 0*nums[0] + 1*nums[1] + ... + (n-1)*nums[n-1]
        let mut current = 0;
        
        for i in 0..n {
            total_sum += nums[i];
            current += i as i32 * nums[i];
        }
        
        // Step 4: Initialize answer with F(0)
        let mut answer = current;
        
        // Step 5: Compute F(1), F(2), ..., F(n-1)
        for k in 1..n {
            // Step 6: Apply recurrence:
            // F(k) = F(k-1) + total_sum - n * nums[n-k]
            // nums[n-k] is the element moved from the end to the front
            current = current + total_sum - n as i32 * nums[n - k];
            
            // Step 7: Update maximum value found so far
            answer = answer.max(current);
        }
        
        // Step 8: Return maximum rotate function value
        answer
    }
}
