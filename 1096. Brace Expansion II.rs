use std::collections::BTreeSet;

impl Solution {
    pub fn brace_expansion_ii(expression: String) -> Vec<String> {
        let mut op: Vec<char> = Vec::new();  // Operator stack
        let mut stk: Vec<BTreeSet<String>> = Vec::new();  // Set stack

        // Pop the operator at the top of the stack and perform the calculation
        let ope = |op: &mut Vec<char>, stk: &mut Vec<BTreeSet<String>>| {
            let l = stk.len() - 2;
            let r = stk.len() - 1;
            if op[op.len() - 1] == '+' {
                // Union operation - manual merging is required
                let right = stk.pop().unwrap();
                let left = &mut stk[l];
                for item in right {
                    left.insert(item);
                }
            } else {
                // Cartesian product operation
                let right = stk.pop().unwrap();
                let left = &stk[l];
                let mut tmp = BTreeSet::new();
                for l_item in left {
                    for r_item in &right {
                        tmp.insert(format!("{}{}", l_item, r_item));
                    }
                }
                stk[l] = tmp;
            }
            op.pop();
        };

        let chars: Vec<char> = expression.chars().collect();
        for i in 0..chars.len() {
            if chars[i] == ',' {
                // Keep popping operators from the top of the stack until the stack is empty or its top is not a multiplication sign
                while !op.is_empty() && op[op.len() - 1] == '*' {
                    ope(&mut op, &mut stk);
                }
                op.push('+');
            } else if chars[i] == '{' {
                // First determine whether a multiplication sign needs to be added, then push { onto the operator stack
                if i > 0 && (chars[i-1] == '}' || chars[i-1].is_alphabetic()) {
                    op.push('*');
                }
                op.push('{');
            } else if chars[i] == '}' {
                // Keep popping operators from the top of the stack until its top is {
                while !op.is_empty() && op[op.len() - 1] != '{' {
                    ope(&mut op, &mut stk);
                }
                op.pop(); // Pop '{'
            } else {
                // First determine whether a multiplication sign needs to be added, then push the newly constructed set onto the set stack
                if i > 0 && (chars[i-1] == '}' || chars[i-1].is_alphabetic()) {
                    op.push('*');
                }
                let mut set = BTreeSet::new();
                set.insert(chars[i].to_string());
                stk.push(set);
            }
        }

        while !op.is_empty() {
            ope(&mut op, &mut stk);
        }

        stk.pop().unwrap().into_iter().collect()
    }
}
