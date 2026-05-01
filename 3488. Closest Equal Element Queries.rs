#[cfg(target_arch = "x86_64")]
#[target_feature(enable = "f16c,sse,sse2,sse3,ssse3,popcnt,avx,avx2")]
#[allow(static_mut_refs)]
pub unsafe fn solve_queries2(nums: &mut [i32], queries: &mut [i32]) {
    VERSION += 1;
    let current_version = VERSION;
    for i in 0..nums.len() {
        let val = *nums.get_unchecked(i) as usize;
        let entry = GLOBAL_MAP.get_unchecked_mut(val);
        if entry.version == current_version {
            let distance_1 = i as i32 - entry.last;
            let distance_2 = entry.first + nums.len() as i32 - i as i32;
            *nums.get_unchecked_mut(entry.last as usize) = (*nums.get_unchecked(entry.last as usize)).min(distance_1);
            *nums.get_unchecked_mut(entry.first as usize) = (*nums.get_unchecked(entry.first as usize)).min(distance_2);
            *nums.get_unchecked_mut(i) = distance_1.min(distance_2);
            entry.last = i as i32;
        } else {
            entry.version = current_version;
            entry.first = i as i32;
            entry.last = i as i32;
            *nums.get_unchecked_mut(i) = i32::MAX;
        }
    }
    for q in queries.iter_mut() {
        let res = *nums.get_unchecked(*q as usize);
        *q = if res == i32::MAX { -1 } else { res };
    }
}

#[derive(Copy, Clone)]
struct Entry {
    first: i32,
    last: i32,
    version: i32,
}

const MAX_VAL: usize = 1_000_001;
static mut GLOBAL_MAP: [Entry; MAX_VAL] = [Entry { first: 0, last: 0, version: 0 }; MAX_VAL];
static mut VERSION: i32 = 0;

impl Solution {
    pub fn solve_queries(mut nums: Vec<i32>, mut queries: Vec<i32>) -> Vec<i32> {
        unsafe { solve_queries2(nums.as_mut_slice(), queries.as_mut_slice()) };
        queries
    }
}
