impl Solution {
    pub fn rotate_right(mut head: Option<Box<ListNode>>, k: i32) -> Option<Box<ListNode>> {
        if head.is_none() || k == 0 {
            return head;
        }

        let mut len = 0;
        let mut curr = &head;

        while let Some(node) = curr {
            curr = &node.next;
            len += 1;
        }

        let k = k % len;
        if k == 0 {
            return head;
        }

        let steps = len - k;
        let mut curr = head.as_mut().unwrap();
        for _ in 1..steps {
            curr = curr.next.as_mut().unwrap();
        }

        let mut new_head = curr.next.take();

        let mut tail = new_head.as_mut().unwrap();
        while let Some(ref mut next_node) = tail.next {
            tail = next_node
        }
        tail.next = head;

        new_head
    }
}
