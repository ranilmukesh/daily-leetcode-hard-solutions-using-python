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
    pub fn delete_middle(mut head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut curr = &mut head;
        let mut n = 0;
        let mut i = 0;

        // Get the length (n) of the linked list.
        while let Some(node) = curr {
            n += 1;
            curr = &mut node.next;    
        }


        curr = &mut head;
        while curr.is_some() {
            if i == (n / 2) {

                if let Some(node) = curr.take() {

                    *curr = node.next;
                }

                break;
            }

            // Continue in the list.
            if let Some(node) = curr {
                curr = &mut node.next;
            }

            i += 1;
        }

        head
    }
}
