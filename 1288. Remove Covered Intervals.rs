impl Solution {
  pub fn remove_covered_intervals(intervals: Vec<Vec<i32>>) -> i32 {
    if intervals.len() == 1 { return 1; }

    let mut sorted_intervals: Vec<Vec<i32>> = intervals.iter().cloned().collect();
    sorted_intervals.sort_unstable();
    
    //println!("{:?}", sorted_intervals);
    
    sorted_intervals.iter()
      .fold((0, vec![-1, -1]), |(uncovered_count, iv), interval| {
          if interval[0] > iv[0] && interval[1] > iv[1] {
            (uncovered_count + 1, interval.to_vec())
          } else { (uncovered_count, vec![iv[0], std::cmp::max(iv[1], interval[1])] ) }
      }).0      

  }
}

/* test cases:
[[1,4],[3,6],[2,8]]
[[1,4],[2,3]]
[[66672,75156],[59890,65654],[92950,95965],[9103,31953],[54869,69855],[33272,92693],[52631,65356],[43332,89722],[4218,57729],[20993,92876]]
[[1,2],[1,4],[3,4]]
*/
