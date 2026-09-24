impl Solution {
    pub fn smallest_index(nums: Vec<i32>) -> i32 {
        let mut ind = 0;

        for mut i in nums {
            let mut sm = 0;

            while i > 0 && sm <= ind {
                sm += i % 10;
                i /= 10;
            }

            if sm == ind {
                return sm;
            }
            ind += 1;
        }

        -1
    }
}
