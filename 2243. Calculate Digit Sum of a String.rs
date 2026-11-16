impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        let max_size = k as usize;

        if s.len() <= max_size {
            return s;
        }

        let mut result = s;
        let mut buffer = String::with_capacity(result.len());

        while result.len() > max_size {
            for group in result.as_bytes().chunks(max_size) {
                Solution::append_as_digits(&mut buffer, Solution::get_sum_of_digits(group));
            }

            std::mem::swap(&mut result, &mut buffer);
            buffer.clear();
        }

        result
    }

    fn get_sum_of_digits(group: &[u8]) -> u32 {
        let mut sum = 0u32;

        for digit in group {
            sum += (digit - b'0') as u32;
        }

        sum
    }

    fn append_as_digits(buffer: &mut String, number: u32) {
        if number == 0 {
            buffer.push('0');
            return;
        }

        let mut number = number;
        let mut divisor = Solution::get_divisor(number);

        while divisor > 0 {
            buffer.push(((number / divisor + (b'0' as u32)) as u8) as char);
            number %= divisor;
            divisor /= 10;
        }
    }

    fn get_divisor(number: u32) -> u32 {
        let mut divisor = 1;

        while divisor * 10 <= number {
            divisor *= 10;
        }

        divisor
    }
}
