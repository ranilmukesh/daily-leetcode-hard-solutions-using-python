impl Solution {
    pub fn pair_sum(mut head: Option<Box<ListNode>>) -> i32 {
        // Find length of linked list
        let mut len = 0;
        let mut pointer = head.as_ref();
        while let Some(node) = pointer {
            pointer = node.next.as_ref();
            len += 1;
        }

        // Split the linked list in 2 at the mid-point, storing the first half in reversed order
        let mut head_other = None;
        for _ in 0..len / 2 {
            let mut node = head.take().unwrap();

            head = std::mem::replace(&mut node.next, head_other.take());
            head_other = Some(node);
        }

        // Iterate through the split linked lists simultaneously to find the max
        let mut res = 0;
        while let (Some(mut n1), Some(mut n2)) = (head_other.take(), head.take()) {
            head_other = n1.next.take();
            head = n2.next.take();

            res = res.max(n1.val + n2.val);
        }

        res
    }
}
