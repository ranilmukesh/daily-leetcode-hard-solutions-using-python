impl Solution {
    pub fn maximum_sale_items(items: Vec<Vec<i32>>, budget: i32) -> i32 {
        let mut offers = Vec::with_capacity(items.len());

        let (max, min) = items.iter().fold((0, i32::MAX), |(max, min), item| {
            (max.max(item[0] as usize), min.min(item[1]))
        });
        let mut counters = vec![0; max + 1];

        for item in items.iter() {
            counters[item[0] as usize] += 1;
        }

        for item in items.iter() {
            let count = (item[0] as usize..max + 1)
                .step_by(item[0] as usize)
                .fold(0, |acc, j| acc + counters[j]) as i32
                - 1;

            if count > 0 && item[1] < min << 1 {
                offers.push((item[1], count));
            }
        }

        offers.sort_unstable();

        let mut result = 0;
        let mut left = budget;

        for (price, limit) in offers {
            if left < price {
                continue;
            }

            let count = limit.min(left / price);
            result += count << 1;
            left -= count * price;
        }

        result + left / min
    }
}
