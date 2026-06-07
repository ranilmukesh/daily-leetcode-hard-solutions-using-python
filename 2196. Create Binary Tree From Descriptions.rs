use std::cell::RefCell;
use std::collections::{HashMap, HashSet};
use std::rc::Rc;

impl Solution {
    pub fn create_binary_tree(descriptions: Vec<Vec<i32>>) -> Option<Rc<RefCell<TreeNode>>> {
        let mut node_map = HashMap::with_capacity(descriptions.len() * 2);
        let mut children = HashSet::with_capacity(descriptions.len());

        for desc in descriptions {
            let parent_value = desc[0];
            let child_value = desc[1];
            let is_left = desc[2] == 1;

            let child_node = node_map
                .entry(child_value)
                .or_insert_with(|| Rc::new(RefCell::new(TreeNode::new(child_value))))
                .clone();
            
            let parent_node = node_map
                .entry(parent_value)
                .or_insert_with(|| Rc::new(RefCell::new(TreeNode::new(parent_value))));

            if is_left {
                parent_node.borrow_mut().left = Some(child_node);
            } else {
                parent_node.borrow_mut().right = Some(child_node);
            }

            children.insert(child_value);
        }

        node_map
            .iter()
            .find(|(value, _) | !children.contains(value))
            .map(|(_, node)| node.clone())
    }
}
