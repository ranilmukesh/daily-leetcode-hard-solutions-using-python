impl Solution {
    pub fn sortable_integers(nums: Vec<i32>) -> i32 {
        let n = nums.len();

        let descents: Vec<bool> = (0..n - 1)
            .map(|i| nums[i] > nums[i + 1])
            .collect();

        let mut accumulated_descents = vec![0; n];
        for i in 0..n - 1 {
            accumulated_descents[i + 1] = accumulated_descents[i] + descents[i] as usize;
        }

        let mut next_descent = vec![n; n];
        let mut last = n;

        for i in (0..n - 1).rev() {
            if descents[i] {
                last = i;
            }
            next_descent[i] = last;
        }

        let is_sortable = |k: usize| {
            (0..n)
                .step_by(k)
                .try_fold(0, |previous_maximum, l| {
                    let r = l + k - 1;

                    let (minimum, maximum) = match accumulated_descents[r] - accumulated_descents[l] {
                        0 => (nums[l], nums[r]),
                        1 => {
                            if nums[r] > nums[l] { return None; }
                            let descent = next_descent[l];
                            (nums[descent + 1], nums[descent])
                        }
                        _ => return None,
                    };
                    (previous_maximum <= minimum).then_some(maximum)
                })
                .is_some()
        };
        (1..=n).filter(|&k| n % k == 0 && is_sortable(k)).sum::<usize>() as i32
    }
}
