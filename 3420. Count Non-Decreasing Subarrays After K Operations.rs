use std::collections::VecDeque;

#[derive(Default, Debug)]
pub struct Segment {
	st_ind: usize,
	end_ind: usize,
	cost: i64
}

impl Solution {
	fn find_border(ind: usize, k: i64, nums: &[i64], nlm: &[usize], pref_arr: &[i64]) -> usize {
		let mut l: usize = ind;
		let mut r: usize = nlm[ind] - 1;
		while l < r {
			let mid = (l + r) >> 1;
			let dist = mid - ind;
			let targ_pref = dist as i64 * nums[ind];
			let cur_pref = pref_arr[mid] - pref_arr[ind];
			if k >= targ_pref - cur_pref {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		l
	}

    pub fn count_non_decreasing_subarrays(nums: Vec<i32>, k: i32) -> i64 {
		let nums: Vec<i64> = nums.into_iter().map(|x| x as i64).collect();
		let mut k = k as i64;
        let n = nums.len();
		let mut total: usize = n * (n + 1) / 2;

		let mut next_larger_map: Vec<usize> = vec![n; n];
		for i in (0..n).rev() {
			let mut next_i = i + 1;
			while next_i < n && nums[next_i] <= nums[i] {
				next_i = next_larger_map[next_i];
			}
			next_larger_map[i] = next_i;
		}

		let mut pref_arr: Vec<i64> = nums.clone();

		for i in 1..n { pref_arr[i] += pref_arr[i - 1];}

		let mut que: VecDeque<Segment> = VecDeque::new();
		let mut prev_r = n;

		for i in (0..n - 1).rev() {
			if nums[i] <= nums[i + 1] {
				total -= n - prev_r;
				continue;
			}
			let end_ind = next_larger_map[i] - 1;
			let dist = end_ind - i;
			let targ_pref = nums[i] * dist as i64;
			let cur_pref = pref_arr[end_ind] - pref_arr[i];
			let cost = targ_pref - cur_pref;
			let segment = Segment{st_ind: i, end_ind, cost};
			while let Some(l_seg) = que.pop_front() {
				if l_seg.end_ind <= end_ind {
					k += l_seg.cost;
				} else {
					que.push_front(l_seg);
					break;
				}
			}
			k -= cost;
			que.push_front(segment);

			if k >= 0 {
				continue;
			}

			while let Some(r_segm) = que.pop_back() {
				if k + r_segm.cost < 0 { 
					k += r_segm.cost;
					continue;
				} else {
					let ind = Self::find_border(r_segm.st_ind, k + r_segm.cost, &nums, &next_larger_map, &pref_arr);
					que.push_back(r_segm);
					total -= n - ind;
					prev_r = ind;
					break;
				}
			}
		}
		total as i64
    }
}
