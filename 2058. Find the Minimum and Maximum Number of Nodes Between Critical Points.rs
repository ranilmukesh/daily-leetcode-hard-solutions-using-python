// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
// 
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
impl Solution {
    pub fn nodes_between_critical_points(head: Option<Box<ListNode>>) -> Vec<i32> {
        let mut prev = match head.as_ref() {
            Some(val) => val,
            None => return vec![-1, 1]
        };
        let mut curr = prev.next.as_ref();

        let mut i = 0;
        let mut first = None;
        let mut last = None;
        let mut min_distance = None;
        while let Some(c) = curr {
            i += 1;
            let Some(next) = c.next.as_ref() else {
                break
            };
            if (c.val > prev.val && c.val > next.val) || 
                (c.val < prev.val && c.val < next.val) {
                first.get_or_insert(i);
                if let Some(last) = last {
                    let distance = Some(i - last);
                    min_distance = min_distance.or(distance).min(distance);
                }
                last = Some(i);
            }
            prev = c;
            curr = Some(next);
        }
        
        match (min_distance, last, first) {
            (Some(min_distance), Some(last), Some(first)) => vec!(min_distance, last-first),
            _ => vec![-1,-1]
        }
    }
}
