impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let mn_idx = find_min(&nums);
        if let Some(idx) = bs(&nums, 0, mn_idx - 1, target) {
            return idx as i32;
        }
        if let Some(idx) = bs(&nums, mn_idx, nums.len() - 1, target) {
            return idx as i32;
        }
        -1
    }
}

fn bs(nums: &Vec<i32>, mut i: usize, mut j: usize, target: i32) -> Option<usize> {
    if ((i as i32) < 0) || ((j as i32) < 0 )|| (i >= nums.len()) || (j >= nums.len()) {
        return None;
    }
    let mut mid = (i+j)>>1;
    while i as i32 <= j as i32 {
        mid = (i+j)>>1;
        if target < nums[mid] {
            j = mid - 1;
        }
        else if target == nums[mid] {
            return Some(mid);
        }
        else {
            i = mid + 1;
        }
    }
    None
}

fn find_min(nums: &Vec<i32>) -> usize {
    let mut i = 0;
    let mut j = nums.len()-1;
    let mut mid = 0;
    let mut ans = 0;

    while i <= j {
        mid = (i+j)/2;
        if nums[mid] < nums[j] {
            ans = mid;
            j = mid;
        }
        
        else if i == j {
            ans = mid;
            break;
        }
        else {
            i = mid + 1;
        }
    }
    ans
}
