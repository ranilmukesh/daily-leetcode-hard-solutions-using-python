use std::collections::BTreeMap;
use std::collections::BTreeSet;

impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
      let mut _arr = arr.clone();
      _arr.sort_unstable();
      _arr.dedup();
      let mut out: Vec<i32> = Vec::with_capacity(arr.len());
      // println!("{:?}", map);

      for a in &arr {
        out.push((_arr.binary_search(a).unwrap()+1) as i32);
      }

      return out;
    }
}
